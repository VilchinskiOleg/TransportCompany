package org.teachmeskills.project.services;

import org.teachmeskills.project.entitiy.City;
import org.teachmeskills.project.entitiy.QueryOptimalTransport;
import org.teachmeskills.project.entitiy.Transport;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class CreateStoryLogXMLService implements Runnable {
    private QueryOptimalTransportWrapper wrapper;
    private static final String PATH = "queries_responses_log_story.xml";

    @XmlRootElement(name = "queries")
    private static class QueryOptimalTransportWrapper{
        List<QueryOptimalTransport<City>> queries;

        public QueryOptimalTransportWrapper(List<QueryOptimalTransport<City>> queries) {
            this.queries = queries;
        }

        public QueryOptimalTransportWrapper() { }

        @XmlElement(name = "query")
        public List<QueryOptimalTransport<City>> getQueries() { return queries; }

        public void setQueries(List<QueryOptimalTransport<City>> queries) { this.queries = queries; }
    }

    public CreateStoryLogXMLService(List<QueryOptimalTransport<City>> queries) {
        this.wrapper = new QueryOptimalTransportWrapper(queries);
    }

    @Override
    public void run() {
        try {
            JAXBContext context = JAXBContext.newInstance(
                    QueryOptimalTransportWrapper.class,
                    QueryOptimalTransport.class,
                    City.class,
                    Transport.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

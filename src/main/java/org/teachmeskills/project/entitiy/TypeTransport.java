package org.teachmeskills.project.entitiy;

import javax.xml.bind.annotation.XmlElement;

public enum TypeTransport {
    LAND_TRANSPORT{

        @Override
        public String getType() { return "наземный"; }

        @Override
        public int getIdType() {
            return 1;
        }
    },

    AIR_TRANSPORT{

        @Override
        public String getType() {
            return "воздушный";
        }

        @Override
        public int getIdType() {
            return 2;
        }
    },

    SEA_TRANSPORT{

        @Override
        public String getType() {
            return "морской";
        }

        @Override
        public int getIdType() {
            return 3;
        }
    };

    public abstract String getType();
    public abstract int getIdType();
}

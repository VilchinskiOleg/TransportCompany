package org.teachmeskills.project.application.utils;

import org.teachmeskills.project.entitiy.TypeTransport;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        }
        System.out.println(scanner.nextLine() + " - это не целое число. Поаторите ввод.");
        return getInt();
    }

    public static int getInt(String massage) {
        System.out.println(massage);
        return getInt();
    }

    public static double getDouble() {
        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            scanner.nextLine();
            return number;
        }
        System.out.println(scanner.nextLine() + " - это не число с плавающей точкой. Поаторите ввод.");
        return getDouble();
    }

    public static double getDouble(String massage) {
        System.out.println(massage);
        return getDouble();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static String getString(String massage) {
        System.out.println(massage);
        return getString();
    }

    public static boolean getBoolean() {
        String answer = scanner.nextLine().trim();
        if (!(answer.equals("Yes") || answer.equals("No"))) {
            System.out.println("Не корректный ответ. Повторите ввод.");
            return getBoolean();
        }
        return answer.equals("Yes");
    }

    public static boolean getBoolean(String massage) {
        System.out.println(massage + "Yes/No");
        return getBoolean();
    }

    public static TypeTransport getTypeTransport() {
        System.out.println("Выберите тип транспорта:");
        showTypes();
        return getType();
    }

    private static void showTypes() {
        for (TypeTransport type : TypeTransport.values())
            System.out.println(type.getIdType() + " - " + type.getType());
    }

    private static TypeTransport getType() {
        int result = getInt();
        if (result <= 0 || result > TypeTransport.values().length) {
            System.out.println("Не корректный ответ. Повторите ввод.");
            return getType();
        }
        return TypeTransport.values()[result - 1];
    }
}

package vichmat.util;

public  class Printer {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void printMessage(String message){
        System.out.println(ANSI_PURPLE + message);
    }

    public static void printSuccessMessage(String message){
        System.out.println(ANSI_GREEN + message);
    }

    public static void printErrorMessage(String message){
        System.out.println(ANSI_RED + message);
    }

}

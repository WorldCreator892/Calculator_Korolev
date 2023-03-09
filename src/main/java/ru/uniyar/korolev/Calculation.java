package ru.uniyar.korolev;

import java.util.Arrays;
import java.util.Scanner;

public class Calculation {
    private static String[] operations = {"+", "-", "*", "/"};
    public static void PrintStartingMessage() {
        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Для использования калькулятора введите два числа и требуемую операцию из списка +, -, *, / между ними, разделив ввод пробелами");
    }
    public static void PerformStandartCalculation(String[] args) {
        int[] trueNumbers = new int[4];
        trueNumbers[1] = 1;
        trueNumbers[3] = 1;
        String result = "";
        int counter = 0;
        for(int i = 0; i < 3; i+=2) {
            if(args[i].contains("/")) {
                String[] numbers = args[i].split("/");
                trueNumbers[i] = Integer.parseInt(numbers[0]);
                trueNumbers[i + 1] = Integer.parseInt(numbers[1]);
            } else {
                trueNumbers[i] = Integer.parseInt(args[i]);
            }
        }
        if(trueNumbers[1] == 1 && trueNumbers[3] == 1) {
            switch (args[1]) {
                case "+":
                    result = String.valueOf(trueNumbers[0] + trueNumbers[2]) ;
                    break;
                case "-":
                    result = String.valueOf(trueNumbers[0] - trueNumbers[2]) ;
                    break;
                case "*":
                    result = String.valueOf(trueNumbers[0] * trueNumbers[2]) ;
                    break;
                case "/":
                    result = String.valueOf(trueNumbers[0] / trueNumbers[2]) ;
                    break;
            }
        } else {
            int top = 0;
            int bottom = 0;
            switch (args[1]) {
                case "+":
                    top = trueNumbers[0] * trueNumbers[3] + trueNumbers[1] * trueNumbers[2];
                    bottom = trueNumbers[1] * trueNumbers[3];
                    break;
                case "-":
                    top = trueNumbers[0] * trueNumbers[3] - trueNumbers[1] * trueNumbers[2];
                    bottom = trueNumbers[1] * trueNumbers[3];
                    break;
                case "*":
                    top = trueNumbers[0] * trueNumbers[2];
                    bottom = trueNumbers[1] * trueNumbers[3];
                    break;
                case "/":
                    top = trueNumbers[0] * trueNumbers[3];
                    bottom = trueNumbers[1] * trueNumbers[2];
                    break;
            }
            result = String.valueOf(top) + "/" + String.valueOf(bottom) ;
        }
        System.out.println(result);
    }
    public static boolean SetCalculationArguments(String[] args) {
        boolean successful = true;
        Scanner in = new Scanner (System.in);
        String str = in.nextLine();
        String[] strings = str.split(" ");
        if(strings.length != 3) {
            System.out.println("Введенные числа не соответствуют требуемому формату, пожалуйста, повторите попытку ввода!");
            successful = false;
            return  successful;
        }
        for(int i = 0; i < 3; i++) {
            args[i] = strings[i];
        }


        for(int i = 0; i < 3; i+=2) {
            if(args[i].contains("/")) {
                String[] numbers = args[i].split("/");
                try {
                    Integer.parseInt(numbers[0]);
                    if (Integer.parseInt(numbers[1]) == 0) {
                        System.out.println("Деление на ноль не поддерживается, пожалуйста, повторите попытку ввода!");
                        successful = false;
                    }
                } catch (Exception ex) {
                    System.out.println("Введенные числа не соответствуют требуемому формату, пожалуйста, повторите попытку ввода!");
                    successful = false;
                }
            } else {
                try {
                    Integer.parseInt(args[i]);
                } catch (Exception ex) {
                    System.out.println("Введенные числа не соответствуют требуемому формату, пожалуйста, повторите попытку ввода!");
                    successful = false;
                }
            }
        }
        String operation = args[1];
        if(!Arrays.asList(operations).contains(operation)) {
            successful = false;
        }
        return  successful;
    }
}

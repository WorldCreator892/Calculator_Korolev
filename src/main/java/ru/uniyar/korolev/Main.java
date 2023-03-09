package ru.uniyar.korolev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculation.PrintStartingMessage();
        if(args.length == 0) {
            args = new String[3];
            boolean successful = Calculation.SetCalculationArguments(args);
            if(successful) {
                Calculation.PerformStandartCalculation(args);
            }
        } else {
            Calculation.PerformStandartCalculation(args);
        }
    }
}
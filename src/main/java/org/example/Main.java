package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    private static final int[] denominations = {1,2,5,10,20,50,100};

    public static void main(String[] args) {
        ATMDispenser atmDispenser = new ATMDispenser();
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> currency = new HashMap<>();

        for (int denomination : denominations) {
            System.out.println("Enter amount of denomination for " + denomination + ":");
            String denomInput = scanner.nextLine();
            currency.put(denomination, Integer.valueOf(denomInput));
        }
        atmDispenser.initializeCurrency(currency);

        System.out.println("Please read the README for possible commands, \"exit\" to exit.");

        boolean running = true;

        while(running) {
            String input = scanner.nextLine();

            String[] parts = input.split("\\s+");
            try {
                switch (parts[0]) {
                    case "exit":
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    case "addCurrency":
                        validateCurrencyInput(parts);
                        HashMap<Integer, Integer> currencyToAdd = new HashMap<>();
                        currencyToAdd.put(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                        atmDispenser.addCurrency(currencyToAdd);
                        break;
                    case "removeCurrency":
                        validateCurrencyInput(parts);
                        HashMap<Integer, Integer> currencyToRemove = new HashMap<>();
                        currencyToRemove.put(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                        atmDispenser.removeCurrency(currencyToRemove);
                        break;
                    case "withdraw":
                        if (parts[1] == null || Integer.parseInt(parts[1]) < 0) {
                            throw new IllegalArgumentException("Amount of cash must be positive.");
                        }
                        atmDispenser.withdraw(Integer.parseInt(parts[1]));
                        break;
                    case "reportTotalCashAmount":
                        atmDispenser.reportTotalCashAmount();
                        break;
                    case "reportAvailableCurrency":
                        atmDispenser.reportAvailableCurrency();
                        break;
                    default:
                        System.out.println("Unknown command - please review the README for available commands.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }


    private static void validateCurrencyInput(String[] parts) {
        if (parts.length != 3) {
            throw new IllegalArgumentException("Must provide valid currency inputs");
        }
        if (parts[1] == null || Arrays.stream(denominations).noneMatch(x -> x == Integer.parseInt(parts[1]))) {
            throw new IllegalArgumentException("Denomination not valid.");
        }
        if (parts[2] == null || Integer.parseInt(parts[2]) < 0) {
            throw new IllegalArgumentException("Amount of denomination must be positive.");
        }
    }
}
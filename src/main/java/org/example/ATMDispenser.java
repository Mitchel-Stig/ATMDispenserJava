package org.example;

import java.util.*;

public class ATMDispenser {
    public Map<Integer, Integer> availableCurrency = new HashMap<>();

    public ATMDispenser() {
        availableCurrency.put(1, 0);
        availableCurrency.put(2, 0);
        availableCurrency.put(5, 0);
        availableCurrency.put(10, 0);
        availableCurrency.put(20, 0);
        availableCurrency.put(50, 0);
        availableCurrency.put(100, 0);
    }

    public void initializeCurrency(Map<Integer, Integer> currency) {
        availableCurrency = new HashMap<>(currency);
    }

    // Admin usage to add currency
    public void addCurrency(Map<Integer, Integer> currency) {
        currency.forEach((denomination, count) -> availableCurrency.merge(denomination, count, Integer::sum));
        reportAvailableCurrency();
    }

    // Admin usage to remove currency
    public void removeCurrency(Map<Integer, Integer> currency) {
        currency.forEach((denomination, count) -> availableCurrency.computeIfPresent(denomination, (k, v) -> {
            if (v < count) {
                throw new IllegalArgumentException("Cannot remove more currency than available");
            }
            return v - count;
        }));
        reportAvailableCurrency();
    }

    public void reportTotalCashAmount() {
        int total = getDistributionTotal(availableCurrency);
        System.out.println("Total Cash Amount: " + total);
    }

    public void reportAvailableCurrency() {
        TreeMap<Integer, Integer> orderedCurrency = new TreeMap<>(Collections.reverseOrder());
        orderedCurrency.putAll(availableCurrency);
        System.out.println("Total Currency Counts: " + orderedCurrency);
    }

    public void withdraw(int amount) throws AmountNotPossibleException, NotEnoughCashException {
        Map<Integer, Integer> dist = calculateWithdraw(amount);
        System.out.println("Withdrawing the following currency amounts: " + dist);
        removeCurrency(dist);
    }

    private Map<Integer, Integer> calculateWithdraw(int amount) throws NotEnoughCashException, AmountNotPossibleException {
        Map<Integer, Integer> dist = new HashMap<>();
        TreeMap<Integer, Integer> denoms = new TreeMap<>(Collections.reverseOrder());
        denoms.putAll(availableCurrency);

        for (int i = 0; i < denoms.size(); i++) {
            dist = calculateDist(i, denoms, amount);
            if (hasFundsAvailable(dist)) {
                break;
            }
        }

        if (!hasFundsAvailable(dist)) {
            throw new NotEnoughCashException("Not enough Currency in ATM");
        }

        if (getDistributionTotal(dist) != amount) {
            throw new AmountNotPossibleException("Amount not possible with current Denominations");
        }
        return dist;
    }

    private Map<Integer, Integer> calculateDist(int position, TreeMap<Integer, Integer> denoms, int amount) {
        Map<Integer, Integer> withdrawDist = new HashMap<>();
        for (int iteration = 0; iteration < getTotalDenomCount(); iteration++) {
            withdrawDist.clear();
            int currentAmount = amount;
            int currentIteration = iteration;
            List<Integer> denomValues = new ArrayList<>(denoms.keySet());
            for (int i = position; i < denomValues.size(); i++) {
                if (denoms.get(denomValues.get(i)) == 0) {
                    continue;
                }
                int denomValue = denomValues.get(i);
                if (denomValue <= currentAmount) {
                    int tryDenomCount = (currentAmount / denomValue) - currentIteration;
                    int actionDenomCount = (int) Math.min((double) tryDenomCount, denoms.get(denomValue));
                    withdrawDist.put(denomValue, actionDenomCount);
                    currentAmount -= denomValue * actionDenomCount;
                    currentIteration = 0;
                    if (currentAmount == 0) {
                        return withdrawDist;
                    }
                }
            }
        }
        return withdrawDist;
    }

    private boolean hasFundsAvailable(Map<Integer, Integer> dist) {
        return dist.keySet().stream().allMatch(denom -> availableCurrency.getOrDefault(denom, 0) >= dist.get(denom));
    }

    private int getDistributionTotal(Map<Integer, Integer> dist) {
        return dist.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
    }

    private int getTotalDenomCount() {
        return availableCurrency.values().stream().mapToInt(Integer::intValue).sum();
    }
}
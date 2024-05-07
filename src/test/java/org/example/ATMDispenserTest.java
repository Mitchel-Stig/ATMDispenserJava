package org.example;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ATMDispenserTest {

    private ATMDispenser atmDispenser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        atmDispenser = new ATMDispenser();
    }

    @org.junit.jupiter.api.Test
    void test_20() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(20);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 9);
        expectedCurrency.put(50, 10);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_40() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(40);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 8);
        expectedCurrency.put(50, 10);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_50() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(50);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 10);
        expectedCurrency.put(50, 9);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_70() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(70);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 9);
        expectedCurrency.put(50, 9);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_80() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(80);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 6);
        expectedCurrency.put(50, 10);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_100() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(100);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 10);
        expectedCurrency.put(50, 8);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_150() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(150);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 10);
        expectedCurrency.put(50, 7);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_60() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(60);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 7);
        expectedCurrency.put(50, 10);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_110() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(110);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 7);
        expectedCurrency.put(50, 9);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_200() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(200);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 10);
        expectedCurrency.put(50, 6);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void test_0() throws AmountNotPossibleException, NotEnoughCashException {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        atmDispenser.withdraw(0);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 10);
        expectedCurrency.put(50, 10);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void addCurrency() {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        HashMap<Integer, Integer> addedCurrency = new HashMap<>();
        addedCurrency.put(20, 1);
        addedCurrency.put(50, 2);
        atmDispenser.addCurrency(addedCurrency);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 11);
        expectedCurrency.put(50, 12);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }

    @org.junit.jupiter.api.Test
    void removeCurrency() {
        HashMap<Integer, Integer> initialCurrency = new HashMap<>();
        initialCurrency.put(20, 10);
        initialCurrency.put(50, 10);
        atmDispenser.initializeCurrency(initialCurrency);

        HashMap<Integer, Integer> removedCurrency = new HashMap<>();
        removedCurrency.put(20, 1);
        removedCurrency.put(50, 2);
        atmDispenser.removeCurrency(removedCurrency);

        HashMap<Integer, Integer> expectedCurrency = new HashMap<>();
        expectedCurrency.put(20, 9);
        expectedCurrency.put(50, 8);

        assertEquals(atmDispenser.availableCurrency, expectedCurrency);
    }
}
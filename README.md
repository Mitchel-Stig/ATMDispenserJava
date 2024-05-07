# ATMDispenser
Java code test to dispense Australian denomination amounts from an ATM

## Installation and running

Download and install Java and Maven.

Navigate to the directory and compile:

`mvn compile`

Run the code using java:

`mvn exec:java -Dexec.mainClass="com.example.Main"`

On Startup, the application requests input in the form of integers for number of each denomination.

Run the following commands to operate (with examples):

Withdraw cash amount:

`withdraw <amount>`

Add specified amount of currency:

`addCurrency <denomination> <amount>`

Remove specified amount of currency:

`removeCurrency <denomination> <amount>`

Report the total amount of cash value in the machine:

`reportTotalCashAmount`

Report the total available denomination counts:

`reportAvailableCurrency`

## Tests

Tests are located in the ATMDispenserTest file and cover a number of cases.

To run the tests, run the following:
`mvn test`

## Features

- Knowledge stored in memory of total count of all Australian cash denominations.
- Ability to initialise and set the total amount of each denomination
- Ability to manually add/remove denomination counts
- Ability to withdraw specified cash amounts
- Ability to notify when impossible to withdraw due to lack of notes
- Test Suite to cover all required test cases and some additional cases

## Further Possible Improvements

- Further unit tests to handle more denominations, add/remove currency usage and exception expectations
- Addition of Front-end
- Addition of Database to store denomination counts
- Addition of threshold identification for denomination counts
- Addition of managing cash withdrawal options to distribute denomination usage
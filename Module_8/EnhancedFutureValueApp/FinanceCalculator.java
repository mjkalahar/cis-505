/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package EnhancedFutureValueApp;

/**
 * This class calculates future value
 */

public class FinanceCalculator {
    //Declare constant for months in a year
    private final static int MONTHS_IN_YEAR = 12;

    /**
     * This method calculates the future value of an investment
     *
     * @param monthlyPayment double The monthly payment amount.
     * @param rate double The annual interest rate.
     * @param years int The number of years.
     * @return Double The future value of the investment.
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double interestRate = 1+rate/100;
        double presentValue = monthlyPayment * months;
        double futureValue = presentValue * (Math.pow(interestRate, months));
        return futureValue;
    }
}

package eu.lundegaard.assignment.loancalculator.utils;

import eu.lundegaard.assignment.loancalculator.models.CalculatedLoan;
import eu.lundegaard.assignment.loancalculator.models.Loan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

    public static final double ANNUAL_INTEREST_RATE_PERCENTAGE = 6.9;

    /**
     * Calculates monthly payment for loan and returns it.
     *
     * @param loan
     * @return loan with calculated monthly payment.
     */
    public static CalculatedLoan calculateLoan(Loan loan) {
        CalculatedLoan calculated = new CalculatedLoan(loan);
        calculated.setAnnualInterestRate(ANNUAL_INTEREST_RATE_PERCENTAGE);
        calculated.setMonthlyPayment(calculateMonthlyPayment(loan));

        return calculated;
    }

    /**
     * Calculates monthly payment for loan, by multiplying total loan amount by monthly interests.
     *
     * @param loan
     * @return total amount that needs to be paid each month
     * */
    private static BigDecimal calculateMonthlyPayment(Loan loan) {
        return loan.getAmount().multiply(calculateInterests(loan));
    }

    /**
     * Calculate monthly interests.
     * The formula is as follows (MI - monthly interest, MIR - monthly interest rate, LP - loan period):
     *
     * MI = MIR + MIR / ((MIR + 1) ^ LP - 1)
     *
     * @param loan
     * @return monthly interest (percents)
     * */
    private static BigDecimal calculateInterests(Loan loan) {
        BigDecimal mir = getMonthlyInterestRate();

        return mir.add(
                mir.divide(
                        mir.add(BigDecimal.ONE).pow(loan.getNumberOfMonths()).subtract(BigDecimal.ONE),
                        RoundingMode.HALF_EVEN
                )
        );
    }

    /**
     * Calculates monthly interest rate from percentage annual interest rate by dividing it by 12 (number of months)
     * and 100 (to convert percents to decimal).
     *
     * @return monthly interest rate as decimal number with 6 digits precision.
     * */
    private static BigDecimal getMonthlyInterestRate() {
        return BigDecimal.valueOf(ANNUAL_INTEREST_RATE_PERCENTAGE).setScale(6, RoundingMode.HALF_EVEN)
                .divide(BigDecimal.valueOf(12 * 100), RoundingMode.HALF_EVEN);
    }

}

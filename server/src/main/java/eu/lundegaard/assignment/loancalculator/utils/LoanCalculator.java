package eu.lundegaard.assignment.loancalculator.utils;

import eu.lundegaard.assignment.loancalculator.models.CalculatedLoan;
import eu.lundegaard.assignment.loancalculator.models.Loan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

    public static final double ANNUAL_INTEREST_RATE_PERCENTAGE = 6.9;

    public static CalculatedLoan calculateLoan(Loan loan) {
        CalculatedLoan calculated = new CalculatedLoan(loan);
        calculated.setAnnualInterestRate(ANNUAL_INTEREST_RATE_PERCENTAGE);
        calculated.setMonthlyPayment(calculateMonthlyPayment(loan));

        return calculated;
    }

    private static BigDecimal calculateMonthlyPayment(Loan loan) {
        return loan.getAmount().multiply(calculateInterests(loan));
    }

    private static BigDecimal calculateInterests(Loan loan) {
        BigDecimal mir = getMonthlyInterestRate();

        return mir.add(
                mir.divide(
                        mir.add(BigDecimal.ONE).pow(loan.getNumberOfMonths()).subtract(BigDecimal.ONE),
                        RoundingMode.HALF_EVEN
                )
        );
    }

    private static BigDecimal getMonthlyInterestRate() {
        return BigDecimal.valueOf(ANNUAL_INTEREST_RATE_PERCENTAGE).setScale(6, RoundingMode.HALF_EVEN)
                .divide(BigDecimal.valueOf(12 * 100), RoundingMode.HALF_EVEN);
    }

}

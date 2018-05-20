package eu.lundegaard.assignment.loancalculator.models;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CalculatedLoan {

    @NotNull
    private Loan loan;
    private double annualInterestRate;
    private BigDecimal monthlyPayment;

    public CalculatedLoan(@NotNull Loan loan) {
        this.loan = loan;
    }

    public CalculatedLoan() {
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "CalculatedLoan{" +
                "loan=" + loan +
                ", annualInterestRate=" + annualInterestRate +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}

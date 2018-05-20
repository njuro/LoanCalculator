package eu.lundegaard.assignment.loancalculator.models;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Loan {


    @NotNull
    private BigDecimal amount;
    private int numberOfMonths;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", numberOfMonths=" + numberOfMonths +
                '}';
    }
}

package eu.lundegaard.assignment.loancalculator.controllers;

import eu.lundegaard.assignment.loancalculator.models.CalculatedLoan;
import eu.lundegaard.assignment.loancalculator.models.Loan;
import eu.lundegaard.assignment.loancalculator.utils.LoanCalculator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping(value = "/calculate-loan")
    public CalculatedLoan calculateLoan(@ModelAttribute Loan loan) {
        return LoanCalculator.calculateLoan(loan);
    }

}

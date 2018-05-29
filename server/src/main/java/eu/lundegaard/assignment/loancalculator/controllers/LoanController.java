package eu.lundegaard.assignment.loancalculator.controllers;

import eu.lundegaard.assignment.loancalculator.models.CalculatedLoan;
import eu.lundegaard.assignment.loancalculator.models.Loan;
import eu.lundegaard.assignment.loancalculator.utils.LoanCalculator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping(value = "/calculate-loan")
    @CrossOrigin
    public CalculatedLoan calculateLoan(@RequestBody Loan loan) {
        return LoanCalculator.calculateLoan(loan);
    }

}

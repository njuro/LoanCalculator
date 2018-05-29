import {Component, OnInit} from '@angular/core';
import {LoanService} from '../loan.service';
import {Loan} from '../loan';
import {CalculatedLoan} from '../calculated-loan';

@Component({
  selector: 'app-loan-calculator',
  templateUrl: './loan-calculator.component.html',
  styleUrls: ['./loan-calculator.component.css']
})
export class LoanCalculatorComponent implements OnInit {

  loan: Loan = new Loan();

  calculatedLoan: CalculatedLoan;

  constructor(private loanService: LoanService) {
  }

  ngOnInit() {
    this.loan.amount = 120000;
    this.loan.numberOfMonths = 60;
    this.calculateLoan(this.loan);
  }

  calculateLoan(loan: Loan) {
    this.loanService.calculateLoan(loan).subscribe(l => this.calculatedLoan = l);
  }

}

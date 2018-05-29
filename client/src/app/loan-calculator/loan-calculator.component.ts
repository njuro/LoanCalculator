import {Component, OnInit} from '@angular/core';
import {LoanService} from '../loan.service';
import {Loan} from '../loan';
import {CalculatedLoan} from '../calculated-loan';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-loan-calculator',
  templateUrl: './loan-calculator.component.html',
  styleUrls: ['./loan-calculator.component.css']
})
export class LoanCalculatorComponent implements OnInit {

  loan: Loan = new Loan();

  calculatedLoan: CalculatedLoan;

  constructor(private titleService: Title, private loanService: LoanService) {
  }

  ngOnInit() {
    this.titleService.setTitle('Loan Calculator');
    this.loan.amount = 100000;
    this.loan.numberOfMonths = 96;
    this.calculateLoan(this.loan);
  }

  calculateLoan(loan: Loan) {
    this.loanService.calculateLoan(loan).subscribe(l => this.calculatedLoan = l);
  }

}

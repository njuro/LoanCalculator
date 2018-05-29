import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Loan} from './loan';
import {Observable} from 'rxjs';
import {CalculatedLoan} from './calculated-loan';
import {tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  private apiUrl = 'http://212.47.234.160:8080/calculate-loan';


  constructor(private http: HttpClient) {
  }

  calculateLoan(loan: Loan): Observable<CalculatedLoan> {
    console.log('Calculating loan...');
    console.log(loan);
    if (loan.numberOfMonths > 0 && loan.amount > 0) {
      return this.http.post<CalculatedLoan>(this.apiUrl, loan, httpOptions).pipe(
        tap(l => {
          console.log('Received calculated loan');
          console.log(l);
        })
      );
    }
  }
}

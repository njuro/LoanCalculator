import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Loan} from './loan';
import {Observable} from 'rxjs';
import {CalculatedLoan} from './calculated-loan';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  private apiUrl = 'http://localhost:8080/calculate-loan';


  constructor(private http: HttpClient) {
  }

  calculateLoan(loan: Loan): Observable<CalculatedLoan> {
    console.log('Posting loan');
    console.log(loan);
    return this.http.post<CalculatedLoan>(this.apiUrl, loan, httpOptions);
  }
}

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoanCalculatorComponent} from './loan-calculator/loan-calculator.component';
import {HttpClientModule} from '@angular/common/http';
import {MatSliderModule} from '@angular/material/slider';
import {FormsModule} from '@angular/forms';
import {MatCardModule, MatCheckboxModule, MatDividerModule, MatInputModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule, Routes} from '@angular/router';


const appRoutes: Routes = [
  {path: 'loan-calculator', component: LoanCalculatorComponent, data: {title: 'Loan Calculator'}},
  {path: '', redirectTo: '/loan-calculator', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    LoanCalculatorComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSliderModule,
    MatInputModule,
    MatCardModule,
    MatDividerModule,
    MatCheckboxModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

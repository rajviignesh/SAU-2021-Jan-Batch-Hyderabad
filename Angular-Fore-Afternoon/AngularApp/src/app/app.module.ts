import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormTestComponent } from './form-test/form-test.component';
import { HttpTestComponent } from './http-test/http-test.component';

import { HttpClientModule } from '@angular/common/http';
import { CalulatorCompComponent } from './calulator-comp/calulator-comp.component';
import { HomeCompComponent } from './home-comp/home-comp.component';



@NgModule({
  declarations: [
    AppComponent,
    FormTestComponent,
    HttpTestComponent,
    CalulatorCompComponent,
    HomeCompComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

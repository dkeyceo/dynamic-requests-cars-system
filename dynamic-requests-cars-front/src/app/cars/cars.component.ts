import { Component, OnInit } from '@angular/core';
import { SearchRequest } from '../models/SearchRequest';
import { CarsService } from './cars.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: any[] = [];
  brands: any[] = [];
  brandSelected: any = null;

  searchRequest: SearchRequest = {
    brand: '',
    model: '',
    version: '',
    changed: '',
    color: '',
    kmFrom: null,
    kmTo: null
  };

  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.getBrands();
    this.getCars();
  }

  getBrands(){
    this.carsService.getBrands().subscribe(data => {
      this.brands = data;
    }, err => {
       console.log(err);
    });
  }

  getCars(){
    this.carsService.getCars(this.searchRequest).subscribe(data => {
      this.cars = data;
    }, err => {
      console.log(err);
    });
  }
  onChangeBrand(){
    if(this.brandSelected){
      this.searchRequest.brand = this.brandSelected.name;
    }else{
      this.searchRequest.brand = '';
      this.searchRequest.model = '';
    }
    this.getCars();
  }
}

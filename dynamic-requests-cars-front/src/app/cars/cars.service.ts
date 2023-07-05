import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SearchRequest } from '../models/SearchRequest';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  carsURL = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getBrands(){
    return this.http.get<any[]>(this.carsURL + 'brands/list');
  }

  getCars(searchRequest: SearchRequest){
    return this.http.post<any[]>(this.carsURL + 'cars/list', searchRequest);
  }

}

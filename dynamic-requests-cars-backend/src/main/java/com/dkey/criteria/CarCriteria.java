package com.dkey.criteria;

import com.dkey.enums.Color;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

public class CarCriteria {
	
	public static class ColorFilter extends Filter<Color>{}
	
	private StringFilter brand;
	private StringFilter model;
	private StringFilter version;
	private BooleanFilter changed;
	private ColorFilter color;
	private IntegerFilter km;
	public StringFilter getBrand() {
		return brand;
	}
	public void setBrand(StringFilter brand) {
		this.brand = brand;
	}
	public StringFilter getModel() {
		return model;
	}
	public void setModel(StringFilter model) {
		this.model = model;
	}
	public StringFilter getVersion() {
		return version;
	}
	public void setVersion(StringFilter version) {
		this.version = version;
	}
	public BooleanFilter getChanged() {
		return changed;
	}
	public void setChanged(BooleanFilter changed) {
		this.changed = changed;
	}
	public ColorFilter getColor() {
		return color;
	}
	public void setColor(ColorFilter color) {
		this.color = color;
	}
	public IntegerFilter getKm() {
		return km;
	}
	public void setKm(IntegerFilter km) {
		this.km = km;
	}
	
	

}

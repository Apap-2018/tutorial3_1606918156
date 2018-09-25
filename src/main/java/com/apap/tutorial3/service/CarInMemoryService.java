package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.CarModel;

@Service
public class CarInMemoryService implements CarService {
	private List<com.apap.tutorial3.CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		archiveCar.add(car);
	}
	
	@Override 
	public List<CarModel> getCarList(){
		return archiveCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
		CarModel car = null;
		
		for(int i=0; i < archiveCar.size(); i++) {
			if(archiveCar.get(i).getId().equalsIgnoreCase(id)) {
				car = archiveCar.get(i);
			}
		}
		return car;
	}
	
	@Override
	public void deleteCar(String id) {
		archiveCar.removeIf(car -> car.getId().equals(id));
	}
}

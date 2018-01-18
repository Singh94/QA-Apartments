package com.qa.apartment.business;
//
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import com.qa.apartment.persistance.Apartment;
import com.qa.apartment.util.JSONUtil;


public class ApartmentServiceMapImpl implements ApartmentService{
	
	private final int INITIAL_COUNT = 1;
	private Map<Integer, Apartment> apartmentMap;
	private int ID;
	
	@Inject
	JSONUtil util;
	
	public ApartmentServiceMapImpl() {
		this.apartmentMap = new HashMap<Integer, Apartment>();
		ID = INITIAL_COUNT;
	}

	@Override
	public Apartment findApartment(long id) {
		return apartmentMap.get(id);

	}

	@Override
	public String findAllApartments() {
		return util.getJSONForObject(apartmentMap);
	}

	@Override
	public String createApartment(String apartment) {
		Apartment newApartment = util.getObjectForJSON(apartment, Apartment.class);
		apartmentMap.put(ID, newApartment);
		return newApartment.getAddress();
	}

	@Override
	public String deleteApartment(long id) {
		apartmentMap.remove(id);
		return null;
	}

	@Override
	public String updateApartment(long id, String newApartmentInfo) {
		Apartment newApartment = util.getObjectForJSON(newApartmentInfo, Apartment.class);
		int originalApartmentID = (int) id;
		apartmentMap.put(originalApartmentID, newApartment);
		return apartmentMap.get(originalApartmentID).getAddress();
	}
	

}
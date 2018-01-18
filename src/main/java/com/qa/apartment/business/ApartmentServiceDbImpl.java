package com.qa.apartment.business;
//
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.apartment.persistance.Apartment;
import com.qa.apartment.util.JSONUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class ApartmentServiceDbImpl implements ApartmentService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public Apartment findApartment(long id) {
		return em.find(Apartment.class, id);
	}

	public String findAllApartments() {
		TypedQuery<Apartment> query = em.createQuery("SELECT a FROM Apartment a ORDER BY a.id", Apartment.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String createApartment(String apartment) {
		Apartment newApartment = util.getObjectForJSON(apartment, Apartment.class);
		em.persist(newApartment);
		return "{\"message\": \"Apartment sucessfully Added\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String deleteApartment(long id) {
		Apartment apartment = findApartment(new Long(id));
		if (apartment != null) {
			em.remove(apartment);
		}
		return "{\"message\": \"Apartment sucessfully removed\"}";
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public String updateApartment(long id, String newApartment) {
		Apartment apartment = util.getObjectForJSON(newApartment, Apartment.class);
		Apartment selectedApartment = findApartment(id);
		if (selectedApartment != null) {
			selectedApartment = apartment;
			em.merge(apartment);
			return "{\"message\": \"Apartment sucessfully updated\"}";
		}
		return "{\"message\": \"Apartment failed to update\"}";
	}
}
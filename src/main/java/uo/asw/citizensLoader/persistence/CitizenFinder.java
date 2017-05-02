package uo.asw.citizensLoader.persistence;

import java.util.List;

import uo.asw.citizensLoader.persistence.util.Jpa;
import uo.asw.dbmanagement.model.Citizen;



public class CitizenFinder {

	public static boolean isInDatabase(Citizen citizen) {
		List<Citizen> lista = Jpa
				.getManager()
				.createQuery("select c from Citizen c where c.email = ?1",
						Citizen.class).setParameter(1, citizen.getEmail())
				.getResultList();
		if (lista.size() > 0) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}

	public static List<Citizen> findAll() {
		return Jpa.getManager()
				.createQuery("select c from Citizen c", Citizen.class)
				.getResultList();
	}
}

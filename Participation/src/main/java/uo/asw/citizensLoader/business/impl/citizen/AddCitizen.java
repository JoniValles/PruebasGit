package uo.asw.citizensLoader.business.impl.citizen;

import uo.asw.citizensLoader.business.impl.Command;
import uo.asw.citizensLoader.persistence.util.Jpa;
import uo.asw.dbmanagement.model.Citizen;

public class AddCitizen implements Command {

	private Citizen citizen;

	public AddCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Object execute() {
		
		Jpa.getManager().persist(citizen);
		
		return citizen;
	}

}

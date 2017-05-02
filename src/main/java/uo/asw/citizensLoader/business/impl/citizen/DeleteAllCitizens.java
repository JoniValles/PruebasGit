package uo.asw.citizensLoader.business.impl.citizen;

import java.util.List;

import uo.asw.citizensLoader.business.impl.Command;
import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.citizensLoader.persistence.util.Jpa;
import uo.asw.dbmanagement.model.Citizen;



public class DeleteAllCitizens implements Command {
	
	List<Citizen> citizens;

	public DeleteAllCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	@Override
	public Object execute() throws BusinessException {
		
		for(Citizen citizen : citizens) {
			Citizen citizenPersistent = Jpa.getManager().find(Citizen.class, citizen.getDni());
			Jpa.getManager().remove(citizenPersistent);
		}
		
		return null;
	}
	
}

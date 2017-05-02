package uo.asw.citizensLoader.business.impl.citizen;

import java.util.List;

import uo.asw.citizensLoader.business.impl.Command;
import uo.asw.citizensLoader.persistence.CitizenFinder;
import uo.asw.dbmanagement.model.Citizen;



public class FindAllCitizens implements Command {
	
	public List<Citizen> execute() {
		return CitizenFinder.findAll();	
	}
}

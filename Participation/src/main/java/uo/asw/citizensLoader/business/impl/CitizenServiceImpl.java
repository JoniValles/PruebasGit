package uo.asw.citizensLoader.business.impl;

import java.util.List;

import uo.asw.citizensLoader.business.CitizenService;
import uo.asw.citizensLoader.business.impl.citizen.AddCitizen;
import uo.asw.citizensLoader.business.impl.citizen.DeleteAllCitizens;
import uo.asw.citizensLoader.business.impl.citizen.FindAllCitizens;
import uo.asw.citizensLoader.business.impl.citizen.IsCitizenInDatabase;
import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.dbmanagement.model.Citizen;


public class CitizenServiceImpl implements CitizenService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertCitizen(Citizen citizen) throws BusinessException {
		executor.execute(new AddCitizen( citizen ));
	}
	
	@Override
	public boolean isCitizenInDatabase(Citizen citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsCitizenInDatabase( citizen ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Citizen> findAllCitizens() throws BusinessException {
		return (List<Citizen>) executor.execute(new FindAllCitizens());
	}

	@Override
	public void deleteAllCitizens(List<Citizen> citizens) throws BusinessException {
		executor.execute(new DeleteAllCitizens(citizens));
	}
}

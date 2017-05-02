package uo.asw.citizensLoader.business;

import java.util.List;

import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.dbmanagement.model.Citizen;


public interface CitizenService {

	void insertCitizen(Citizen citizen) throws BusinessException;

	boolean isCitizenInDatabase(Citizen citizen) throws BusinessException;
	
	List<Citizen> findAllCitizens() throws BusinessException;

	void deleteAllCitizens(List<Citizen> citizens) throws BusinessException;
	
}

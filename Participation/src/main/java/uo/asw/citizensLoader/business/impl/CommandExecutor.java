package uo.asw.citizensLoader.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.citizensLoader.persistence.util.Jpa;



public class CommandExecutor {
	
	public Object execute(Command cmd) throws BusinessException {
		
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		try {
			Object result = cmd.execute();
			
			trx.commit();
			return result;
			
		} catch (BusinessException be) {
			if (trx.isActive())
				trx.rollback();
			throw be;
		} catch (PersistenceException p) {
			if (trx.isActive())
				trx.rollback();
			throw p;
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
	}

}

package uo.asw.citizensLoader.business.impl;

import uo.asw.citizensLoader.model.exception.BusinessException;

public interface Command {
	Object execute() throws BusinessException;
}

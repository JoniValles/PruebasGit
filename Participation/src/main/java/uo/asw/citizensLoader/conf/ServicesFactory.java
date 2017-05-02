package uo.asw.citizensLoader.conf;

import uo.asw.citizensLoader.business.CitizenService;
import uo.asw.citizensLoader.business.impl.CitizenServiceImpl;

public class ServicesFactory {

	public static CitizenService getCitizenService() {
		return new CitizenServiceImpl();
	}
}

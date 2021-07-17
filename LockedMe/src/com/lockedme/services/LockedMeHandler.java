package com.lockedme.services;

import com.lockedme.dao.FileDaoImpl;
import com.lockedme.dao.LockedMeDao;

public class LockedMeHandler {
	
	private LockedMeDao dao;
	private static LockedMeHandler fileHandler;
	
	private LockedMeHandler() {
		dao = new FileDaoImpl();
	}
	
	public static LockedMeHandler getInstance() {
		if (fileHandler == null) {
			fileHandler = new LockedMeHandler();
		}
		return fileHandler;
		
	}
	
	public LockedMeDao getDao() {
		return dao;
	}
}

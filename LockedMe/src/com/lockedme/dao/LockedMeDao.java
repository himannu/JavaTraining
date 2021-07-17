package com.lockedme.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface LockedMeDao {

	public List<String> getAll() ;
	public boolean add(String name) throws FileAlreadyExistsException, IOException;
	public boolean delete(String name) throws FileNotFoundException;
	public boolean searchBy(String name);
		
		

}

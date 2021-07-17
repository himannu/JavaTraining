package com.lockedme.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDaoImpl implements LockedMeDao {
	
	private static final String DIRECTORY_PATH = "./src/com/lockedme/resources";
	File directory;

	
	public FileDaoImpl() {

		directory = new File(DIRECTORY_PATH);
		//textFileFilter = (File file) -> file.isFile()?true:false;
		
	}
	
	@Override
	public List<String> getAll() {
		
		List<String> fileNames = new ArrayList<>();
		//File[] files = directory.listFiles(textFileFilter);
		File[] files = directory.listFiles();
		if (files == null || files.length == 0) return fileNames;
		fileNames = Stream.of(files).filter(file-> file.isFile()).map(file->file.getName()).sorted().collect(Collectors.toList());
		return fileNames;
		
	}
	
	@Override
	public boolean add(String fileName) throws IOException, FileAlreadyExistsException {
		
		File file = new File(DIRECTORY_PATH,fileName);
		
		if (file.exists())
		{
			throw new FileAlreadyExistsException("File already exists!");
		}
	
		return file.createNewFile();		
		
	}
	
	@Override
	public boolean delete(String fileName) throws FileNotFoundException {

		File file = new File(DIRECTORY_PATH,fileName);
		
		if (!file.exists()) {
			throw new FileNotFoundException("File does not exist !");
		}
	
		return file.delete();		
	
	}

	@Override
	public boolean searchBy(String fileName) {

		File file = new File(DIRECTORY_PATH,fileName);
		return file.exists();		
	
	}

}

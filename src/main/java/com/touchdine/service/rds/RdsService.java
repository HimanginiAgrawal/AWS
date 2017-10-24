package com.touchdine.service.rds;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectListing;
import com.touchdine.service.api.DataService;

public class RdsService implements  DataService{

	
	public Object add(String name, MultipartFile mfile) {
		return null;
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object read(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listObjects(String bucketname) {
		return null;
		// TODO Auto-generated method stub
		
	}

}

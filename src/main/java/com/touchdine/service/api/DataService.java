package com.touchdine.service.api;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectListing;
import com.touchdine.model.User;

public interface DataService {
	

	public Object add(String name, MultipartFile mfile);

	public void delete(String fileName);

	public void update();

	public Object read(String fileName);

	public String listObjects(String bucketname);

}



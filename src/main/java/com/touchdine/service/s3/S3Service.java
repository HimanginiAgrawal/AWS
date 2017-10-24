package com.touchdine.service.s3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.mockito.stubbing.Answer;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.touchdine.service.api.DataService;

public class S3Service implements DataService {
		
	AWSCredentials Credentials = new BasicAWSCredentials("", "");
	
	AmazonS3 myS3 = new AmazonS3Client(Credentials);
	
	String bucketName = "himanginiaws";

	public Object add(String name, MultipartFile mFile) {
		System.out.println("Adding the s3 service...");
		InputStream inputStream = null;
		File fileToUpload = null;
		try {
			fileToUpload = 	convertFromMultiPart(mFile);
			System.out.println(fileToUpload);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String key = Instant.now().getEpochSecond() + "_" + fileToUpload.getName();
		try {
			inputStream = mFile.getInputStream();
		} catch (IOException e) {
			System.out.println("Exception while getting the stream...");
			e.printStackTrace();
		}		
		System.out.println("Got the stream...Trying to push to the bucket...");
		System.out.println("");
		try {
			myS3.putObject(new PutObjectRequest(bucketName, name, fileToUpload));
		}catch(Exception exception) {
			exception.printStackTrace();
			System.out.println("Printing the exception..."+exception);
		}
		System.out.println("Pushed to the bucket.....");
		return null;
	}
	
	/**
	 * Convert MultiPartFile to ordinary File
	 * 
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	 
	/**
	private File convertFromMultiPart(MultipartFile multipartFile) throws IOException {

		File file = new File(multipartFile.getOriginalFilename());
		file.createNewFile(); 
		FileOutputStream fos = new FileOutputStream(file); 
		fos.write(multipartFile.getBytes());
		fos.close(); 

		return file;
	}
	*/
	
	private File convertFromMultiPart(MultipartFile multipartFile) throws IOException {
		String temporaryFolder = System.getProperty("java.io.tmpdir");
		System.out.println(temporaryFolder);
		File file = new File(temporaryFolder + "/" + multipartFile.getOriginalFilename());
		System.out.println(file);
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(multipartFile.getBytes());
		fos.close();
		return file;
	}
	
	
	
	
	
	@Override
	public void delete(String fileName) {
		System.out.println("Start: Deleted the file..");
		myS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));	
		System.out.println("End: Deleted the file..");


	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object read(String fileName) {
	System.out.println("Entered object read......."+fileName);	
	 S3Object s3Object = myS3.getObject(new GetObjectRequest(bucketName,fileName));
	 String path = s3Object.getObjectContent().getHttpRequest().getURI().toString();
	return path;			

	}
	

	public String listObjects(String bucketName) {
		String name = null;
		System.out.println("inside object listing..");
		ObjectListing objectListing = myS3.listObjects(bucketName);
		for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
			name = os.getKey();
			
		}
        //return myS3.listObjects(bucketName);
		return name;
    }
	
	
	public void bucketlist() {
		System.out.println("inside bucket list .................");
		List<Bucket> buckets = myS3.listBuckets();
		
		        for (Bucket bucket : buckets) {
		
		            System.out.println(bucket.getName() + ": " + bucket.getCreationDate());
		
		        }

	}
	
	
	
	
	
	
	

}

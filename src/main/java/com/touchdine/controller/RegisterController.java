package com.touchdine.controller;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.touchdine.repo.UserRepository;
import com.touchdine.service.api.DataService;
import com.touchdine.service.rds.RdsService;
import com.touchdine.service.s3.S3Service;
import com.touchdine.model.User;

@Controller
public class RegisterController {

	private DataService s3Service = new S3Service();
	private DataService rdsService = new RdsService();
	
	
	@Autowired
    private UserRepository userRepository;
	
	
	
	@GetMapping("/")
	    public String getIndex() {
	        //return "index";
		  return "index";
	    }

	@PostMapping("/list")
	public String list(@RequestParam("bucketname")String bucketname, ModelMap modelMap) {
		System.out.println("inside controller list");
		s3Service.listObjects(bucketname);
		modelMap.put("FileName", s3Service.listObjects(bucketname));
		return "viewFiles";
		
	}
	
	 @RequestMapping("/login")  
		public String login(@RequestParam("username")String username, @RequestParam("password") String password, ModelMap modelMap) {
		 	 System.out.println("inside method loginmenu..running the changes");
		 	 User inputUser = new User();
		 	 System.out.println("User Name:"+inputUser.getFirstName());
		 	 inputUser.setUsername(username);
		 	 inputUser.setPassword(password);
		 	 User userFromDB = userRepository.findOne(Example.<User>of(inputUser, ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.ignoreCase())));
			 System.out.println(userFromDB);
		 	 System.out.println(userFromDB.getFirstName());
		 	 
		 	 if(null != userFromDB && userFromDB.getPassword().equals(userFromDB.getPassword())) {
		 		// modelMap.put("username", userFromDB.getId());
		 		modelMap.put("userFName", userFromDB.getFirstName());
				modelMap.put("userLName", userFromDB.getLastName());
		 		 return "welcome";
		 	 } else {
		 		 modelMap.put("loginstatus", "Recheck your credentials");
		 		 return "login";
		 	 }
	    }
	 
	/**
	 * Used for adding the menu
	 * @param name
	 * @param file
	 * @param redirectAttributes
	 */
	@PostMapping("/upload")   
	public String addMenu(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,
			ModelMap modelMap) {
		 System.out.println("calling s3 service..");
		User inputUser = new User();
		s3Service.add(name, file);
		rdsService.add(name, file);
		modelMap.put("userFName", "himangini");
		modelMap.put("userLName", "agrawal");
		User userFromDB = userRepository.findOne(Example.<User>of(inputUser, ExampleMatcher.matching().withMatcher("username", ExampleMatcher.GenericPropertyMatchers.ignoreCase())));
		System.out.println("printing time");
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Timestamp(System.currentTimeMillis()));
		String time = new SimpleDateFormat("HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		System.out.println(date);
		modelMap.put("date", date);
		modelMap.put("time", time);
	        return "viewDetails";       
		 
	} 
	 
	@PostMapping("/saveDetails")                     // it only support port method
	    public String saveDetails(@RequestParam("userFName") String userFName,
	                              @RequestParam("userLName") String userLName,
	                              ModelMap modelMap) {

	        // write your code to save details
	        modelMap.put("userFName", userFName);
	        modelMap.put("userLName", userLName);
	        //modelMap.put("employeeEmail", employeeEmail);
	        return "viewDetails";           // welcome is view name. It will call userFrom.jsp
	    }

	@PostMapping("/delete")  
	public String deleteMenu(@RequestParam("filename")String fileName,ModelMap modelMap) {
		 System.out.println("Trying to delete  s3 ..");
		 System.out.println("Trying to get the data from RDS.."+ userRepository.findOne(1l).getFirstName());
		
		 s3Service.delete(fileName);
		 String date = new SimpleDateFormat("dd-MM-yyyy").format(new Timestamp(System.currentTimeMillis()));
			String time = new SimpleDateFormat("HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			System.out.println(date);
			modelMap.put("date", date);
			modelMap.put("time", time);
		 modelMap.put("userFName", "himangini");
		    modelMap.put("userLName", "agrawal");
		        return "viewDetails"; 
	}

	public void updatMenu() {

	}

	@PostMapping("/read")  
	public String readMenu(@RequestParam("name")String fileName,ModelMap modelMap) {
		 System.out.println("Trying to read  s3 ..");
		 String path = (String)s3Service.read(fileName);
		 System.out.println(path);
		 String date = new SimpleDateFormat("dd-MM-yyyy").format(new Timestamp(System.currentTimeMillis()));
			String time = new SimpleDateFormat("HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			System.out.println(date);
			modelMap.put("date", date);
			modelMap.put("time", time);
			modelMap.put("userFName", "himangini");
		    modelMap.put("userLName", "agrawal");
		    modelMap.put("Filelink", path);
		        return "viewDownload";  
	}
	
}

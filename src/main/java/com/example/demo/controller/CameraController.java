package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aop.CheckAccess;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.model.Camera;
import com.example.demo.model.JwtRequest;
import com.example.demo.repository.CameraRepository;
import com.example.demo.service.CameraService;
import com.example.demo.service.JwtGeneratorInterface;
import com.example.demo.service.JwtService;
import com.example.demo.utility.ResponseEntityGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
//@CrossOrigin("*")
//http://localhost:4200
//@CrossOrigin(maxAge = 3600)
public class CameraController {
	@Autowired
	private JwtService jwtGenerator;
	@Autowired
	CameraRepository cameraRepository;
	@Autowired
	CameraService cameraService;
	//@CrossOrigin(origins = "http://localhost:4200")
	@Autowired
	ResponseEntityGenerator responseEntityGenerator;
	@CheckAccess
	 @PostMapping("/v1/auth/camera")
	  public ResponseEntity<OutputResponseDto> addCamera(HttpServletRequest req,@RequestBody Camera camera) {
	    try {
	    	OutputResponseDto outputResponseDto=cameraService.addCameraDetails(camera);
	    //  Camera camera_ = cameraRepository.save(camera);
	      ///return new ResponseEntity<>(camera_, HttpStatus.CREATED);
	      return responseEntityGenerator.getResponseEntity(outputResponseDto);
	    } catch (Exception e) {
	     // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      throw e;
	    }
	  }
	 @CheckAccess
	 @GetMapping("/v1/auth/camera")
	 public ResponseEntity<List<Camera>> getAllCamera(HttpServletRequest req){
		 try {
			 System.out.println("req : "+req.getHeader("Authorization"));
			// HttpServletRequest req
			 List<Camera> cameraList=cameraRepository.findAll();
			 return new ResponseEntity<>(cameraList,HttpStatus.OK);
			 //return new ResponseEntity<>(cameraList,null);
			 
		      
		   
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		 }
	 }
	 @CheckAccess
	 @GetMapping("/v1/auth/camera/{id}")
	 public ResponseEntity<Camera> getCamera(HttpServletRequest req,@PathVariable("id") long id){
		 try {
		 Optional<Camera> camera=cameraRepository.findById(id);
		 if(camera.isPresent())
		 return new ResponseEntity<>(camera.get(),HttpStatus.OK);
		 else
		 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		
	 }
	 @CheckAccess
	 @PutMapping("/v1/auth/camera/{id}")
	 public ResponseEntity<Camera> getCamera(HttpServletRequest req,@PathVariable("id") long id, @RequestBody Camera camera){
		 try {
			 Optional<Camera> cameraData=cameraRepository.findById(id);
			 if(cameraData.isPresent()) {
				Camera camera_=cameraData.get();
				camera_.setCameraName(camera.getCameraName());
				camera_.setLat(camera.getLat());
				camera_.setLongit(camera.getLongit());
				camera_.setCreatedOn(camera.getCreatedOn());
				camera_.setModifiedOn(camera.getModifiedOn());
				camera_.setPoleId(camera.getPoleId());
				
				
				return new ResponseEntity<>(cameraRepository.save(camera_),HttpStatus.OK);
			 }else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 } 
				 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	 }
	 @CheckAccess
	 @DeleteMapping("/v1/auth/camera/{id}")
	 public ResponseEntity<HttpStatus> deleteCamera(HttpServletRequest req,@PathVariable("id") long id){
		 try {
			 cameraRepository.deleteById(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
		 @DeleteMapping("/v1/auth/camera1")
		 public ResponseEntity<HttpStatus> deleteCamera1(HttpServletRequest req,@RequestParam("id") long id, @RequestHeader("token") String token){
			 try {
				 System.out.println("token "+token);
				 cameraRepository.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			 }catch(Exception e) {
				 e.printStackTrace();
				 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			 }
		
	 }
		 
//		 @PostMapping("/v1/auth/authentication")
//		  public ResponseEntity<String> getJwtToken(@RequestBody JwtRequest jwtRequest) {
//		    try {
//		    	System.out.println("hi dear"+jwtRequest.getPassword());
//		    	String token =jwtGenerator.generateToken(jwtRequest.getUsername());
//		    System.out.println("jwtGenerator.generateToken(user)"+token);
//		      return new ResponseEntity<>(token, HttpStatus.CREATED);
//		    } catch (Exception e) {
//		    	e.printStackTrace();
//		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//		  }

}

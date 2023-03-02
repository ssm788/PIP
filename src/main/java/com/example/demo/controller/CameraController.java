package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Camera;
import com.example.demo.repository.CameraRepository;

@RestController
@RequestMapping("/api")
public class CameraController {
	
	@Autowired
	CameraRepository cameraRepository;
	 @PostMapping("/camera")
	  public ResponseEntity<Camera> addCamera(@RequestBody Camera camera) {
	    try {
	      Camera camera_ = cameraRepository.save(camera);
	      return new ResponseEntity<>(camera_, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 @GetMapping("/camera")
	 public ResponseEntity<List<Camera>> getAllCamera(){
		 try {
			 List<Camera> cameraList=cameraRepository.findAll();
			 return new ResponseEntity<>(cameraList,HttpStatus.OK);
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 
	 @GetMapping("/camera/{id}")
	 public ResponseEntity<Camera> getCamera(@PathVariable("id") long id){
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
	 @PutMapping("/camera/{id}")
	 public ResponseEntity<Camera> getCamera(@PathVariable("id") long id, @RequestBody Camera camera){
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
	 
	 @DeleteMapping("/camera/{id}")
	 public ResponseEntity<HttpStatus> deleteCamera(@PathVariable("id") long id){
		 try {
			 cameraRepository.deleteById(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 }catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		
	 }

}

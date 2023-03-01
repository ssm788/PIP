package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OutputResponseDto;
import com.example.demo.exception.CustomException;
import com.example.demo.messages.Messages;
import com.example.demo.model.Camera;
import com.example.demo.repository.CameraRepository;
import com.example.demo.utility.ResponseEntityGenerator;

@Service
public class CameraService {

	@Autowired
	CameraRepository cameraRepository;
	@Autowired 
	Messages messages;
	@Autowired
	ResponseEntityGenerator responseEntityGenerator;
	public OutputResponseDto  addCameraDetails(Camera camera){
		
		try {
			 Camera camera_ = cameraRepository.save(camera);
			 if(camera_==null) {
				 return new OutputResponseDto(false, null, messages.get("camera.add.failure.message"),
							messages.getStatusCode("camera.add.failure.message.id"), null);	 
			 }else {
				 return new OutputResponseDto(true, null, messages.get("camera.add.success.message"),
							messages.getStatusCode("camera.add.success.message.id"), null); 
			 }
			
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), false, messages.getStatusCode("camera.add.failure.message.id"),
					messages.getStatusCode("camera.add.failure.message"), responseEntityGenerator
							.getSCodeFromStatusCode(messages.getStatusCode("camera.add.failure.message.id")));

		}
		
	}
}

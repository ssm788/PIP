
package com.example.demo.utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OutputResponseDto;



@Component
public class ResponseEntityGenerator {

	
	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Response Entity
		public ResponseEntity<OutputResponseDto> getResponseEntity(OutputResponseDto outputResponseDto) {
			HttpStatus st = null;
			String sCode = "";
			String sAppCode = "-";
			try {
				sAppCode = outputResponseDto.getStatusCode().toString();
				logger.info("sAppCode", outputResponseDto.getStatusCode().toString());
				sCode = sAppCode.split("-")[1].toString();
				logger.info("sAppCode", sAppCode);
				logger.info("sCode", sCode);
				st = HttpStatus.valueOf(Integer.parseInt(sCode));
				logger.info("st", st);
			} catch (Exception e) {
				st = HttpStatus.I_AM_A_TEAPOT;
				logger.error("Incorrect Http Header set | sAppCode:" + sAppCode + " | HttpCode:" + sCode);
			}
			return new ResponseEntity<OutputResponseDto>(outputResponseDto, st);
		}
		
		/*
		 * Extract sCode from StatusCode
		 * dms-401-3001 => 401
		 * 
		 * */
		public String getSCodeFromStatusCode(String statusCode) {
			HttpStatus st = null;
			String sCode = "";
			String sAppCode = "-";
			sAppCode =statusCode;
			logger.info("sappCode " + sAppCode);
			sCode = sAppCode.split("-")[1].toString();
			logger.info("sAppCode", sAppCode);
			logger.info("sCode " + sCode);

			return sCode;
			
		}

}

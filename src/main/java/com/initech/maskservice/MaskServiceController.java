package com.initech.maskservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaskServiceController {
	
	@PostMapping("/maskemail")
	public ResponseEntity<String> maskEmail(@RequestBody String email) {
		//TODO: store masked email in DB
		return new ResponseEntity<>(maskEmailService(email), HttpStatus.OK);
	}
	
	@PostMapping("/maskphone")
	public ResponseEntity<String> maskPhoneNumber(@RequestBody String number) {
		//TODO:store masked number in DB
		return new ResponseEntity<>(maskPhoneNumberService(number), HttpStatus.OK);
	}
	
	/**
	 * Mask email.
	 * homer@homedepot.com will mask as h***r@homedepot.com
	 * Assuming that email format is already validated in another function. 
	 * @param s
	 * @return
	 */
	String maskEmailService(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		String toReplace = s.substring(1,s.indexOf("@") - 1);
		StringBuilder starChars = new StringBuilder();
		for(int i = 0; i < toReplace.length(); i++) {
			starChars.append("*");
		}
		sb.append(s.charAt(0));
		sb.append(starChars);
		sb.append(s.substring(s.indexOf("@") - 1));
		
		return sb.toString();
	}
	
	/**
	 * Masks phone number.
	 * given a phone number (404)443-8211 masks as (404)*** - 8211 (middle 3 digits)
	 * Assuming that phone number format is already validated in another function.
	 * @param s
	 * @return
	 */
	String maskPhoneNumberService(String s) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0,5));
		sb.append("***");
		sb.append(s.substring(8));
		
		return sb.toString();	
	}

}

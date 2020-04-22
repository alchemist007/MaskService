package com.initech.maskservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MaskServiceTest {
	
	
	MaskServiceController msc;

	@Test
	void testMaskEmail() {
		msc = new MaskServiceController();
		
		String s = msc.maskEmailService("homer@homedepot.com");
		String result = "h***r@homedepot.com";
		
		assertEquals(s,result);
	}
	
	@Test
	void testMaskPhoneNumber() {
		msc = new MaskServiceController();
		
		String s = msc.maskPhoneNumberService("(404)234-9088");
		String result = "(404)***-9088";
		
		assertEquals(s,result);
	}

}

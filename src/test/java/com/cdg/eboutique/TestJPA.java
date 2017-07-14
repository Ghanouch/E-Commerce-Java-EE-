package com.cdg.eboutique;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Test
	public void test() {
		
		try{
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
		assertTrue(true);
		}catch(Exception e)
		{
			assertTrue(e.getMessage() , false);
		}
	}

}

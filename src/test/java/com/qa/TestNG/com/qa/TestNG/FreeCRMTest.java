package com.qa.TestNG.com.qa.TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class FreeCRMTest {
	
	@BeforeClass
	
	public void setup()
	{
		TestBase.initialization();
		
	}
	
	
	@Test
	
	public void titletest()
	{
		TestBase.driver.getTitle();	
	}
	
	

}

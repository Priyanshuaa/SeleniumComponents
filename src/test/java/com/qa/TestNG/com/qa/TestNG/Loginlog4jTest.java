0//package com.qa.TestNG.com.qa.TestNG;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeMethod;
//
//public class Loginlog4jTest {
//	//What is log? : capturing info/activities at the time of program execution. 
//		// types of logs:
//			//1. info
//			//2. warn
//			//3. debug
//			//4. fatal		
//		//how to generate the logs? : use Apache log4j API (log4j jar)
//		//How it works? : it reads log 4j configuration from log4j.properties file
//		//where to create: create inside resources folder
//	   //will give you the calls and processes running at the background
//	WebDriver driver;
//	@BeforeMethod
//	public void setup(){
//		log.info("****************************** Starting test cases execution  *****************************************");
//
//		System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");	
//		driver = new ChromeDriver(); 
//		log.info("launching chrome broswer");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get("https://www.freecrm.com/");
//		log.info("entering application URL");
//		log.warn("Hey this just a warning message");
//		log.fatal("hey this is just fatal error message");
//		log.debug("this is debug message");
//	}
//	
//	
//	@Test(priority=1)
//	public void freeCrmTitleTest(){
//		log.info("****************************** starting test case *****************************************");
//		log.info("****************************** freeCrmTitleTest *****************************************");
//		String title = driver.getTitle();
//		System.out.println(title);
//		log.info("login page title is--->"+title);
//		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
//		
//		log.info("****************************** ending test case *****************************************");
//		log.info("****************************** freeCrmTitleTest *****************************************");
//
//	}
//	
//	@Test(priority=2)
//	public void freemCRMLogoTest(){
//		log.info("****************************** starting test case *****************************************");
//		log.info("****************************** freemCRMLogoTest *****************************************");
//
//		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
//		Assert.assertTrue(b);
//		
//		log.info("****************************** ending test case *****************************************");
//		log.info("****************************** freemCRMLogoTest *****************************************");
//
//	}
//	
//	
//
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//		log.info("****************************** Browser is closed *****************************************");
//
//		
//	}
//	
//	
//	
//	
//	
//	
//
//}

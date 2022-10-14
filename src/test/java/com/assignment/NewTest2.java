package com.assignment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest2 {

	
	
	NewTest2(){
		System.out.println("This is constructor");
	}
	
	
	@BeforeClass(groups= {"regression","sanity"})
	public void beforeClass() {
		System.out.println("This is before class");
	} 
	@Test(priority=1)
	public void test1 () {
		System.out.println("This is test1");
	}
	@Test (priority=2)
	public void test2()  {
		System.out.println("This is test2");
	}
	
	@AfterClass
	public void afterlass() {
		System.out.println("This is afterclass");
	}
  
}


		
	
	
	
	
	
	
	

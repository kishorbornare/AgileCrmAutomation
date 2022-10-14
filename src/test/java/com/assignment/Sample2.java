package com.assignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample2 {
	  @DataProvider (name = "data-provider")
	    public Object[][] getData(){
		  Object[][] data={{"1,2"}, {"3,4"}};
		  return data;
	    }
		
	   @Test (dataProvider = "data-provider")
	   public void myTest (String val) {
	       System.out.println("Passed Parameter Is : " + val);}
	   
@DataProvider(name= "abc")
public Object[][] data() {
Object[][] data1= {{"vishal,jadhav"},{"mahesh,bhanage"},{"vijay,korsegaonkar"}};
return data1;}

@Test(dataProvider="bcd")
public void gett(String s) {
	System.out.println(s);}

@DataProvider(name="bcd")
public Object[] aa() {
	Object[] s= {"vishal"};
	return s;
}
}


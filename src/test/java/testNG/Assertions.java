package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {


	@Test
	public void hardAssertions()
	{
		Assert.assertEquals(false, false);  
		Assert.assertEquals(true, true);
		Assert.assertNotEquals(true,false);
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		String at="selenium";
		String et="selenium";
		
		String obj=new String("selenium");
		Assert.assertSame(at,et);
		
		Assert.assertNotSame(at,obj);
		
	}
	
	@Test
	public void softAssertions()
	{
		SoftAssert	sa= new SoftAssert();  //object for soft assertions
		
		sa.assertEquals(false, false);  
		sa.assertEquals(true, true);
		sa.assertNotEquals(true,false);
		
		sa.assertTrue(true);
		sa.assertFalse(false);
		
		sa.assertEquals(1, 2); // it will fail the test cases even though executing the next lines will not stop
		
		System.out.println("Continuing the execution of next line...");
		String at="selenium";
		String et="selenium";
		
		String obj=new String("selenium");
		sa.assertSame(at,et);
		
		sa.assertNotSame(at,obj);
		
		sa.assertAll();  //mandatory line
	}
	
	@Test
	public void hardVsSoft()
	{
		System.out.println("Hard assertion stops the execution when "
				+ "\n assertion fails while soft asseertion executes all "
				+ "\n the lines even though assert fails");
	}

}

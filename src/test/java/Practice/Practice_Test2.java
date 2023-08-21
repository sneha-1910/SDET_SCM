package Practice;

import org.testng.annotations.Test;

public class Practice_Test2 {
 
	@Test(groups="smoke")
	public void category()
	{
		System.out.println("category updated");
	}
	
	@Test(groups="regression")
	public void Area()
	{
		System.out.println("area");
	}
	
	@Test
	public void rectangle()
	{
		System.out.println("--rectangle--");
	}
	
}

package Practice;

import org.testng.annotations.Test;

public class Practice_Test1 {

	@Test(groups="smoke")
	public void Manuf()
	{
		System.out.println("manuf created");
	}
	
	
	@Test(groups="smoke")
	public void retial()
	{
		System.out.println("reatiler added ");
	}
	
	@Test(groups="regression")
	public void manage_area()
	{
		System.out.println("stock updated");
	}
}

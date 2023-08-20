package selinum;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestA {
	
	@Test(groups="database")
	public void testA1() throws Exception
	{
		System.out.println("Test A1 start");
		Thread.sleep(3000);
		System.out.println("Test A1 end");
	}
	
	@BeforeGroups("automation")
	public void setupDriver()
	{
		System.out.println("setting drivers for automation tools");
	}
	
	@BeforeGroups("database")
	public void setupForDB()
	{
		System.out.println("setting database");
	}
	
	@AfterGroups("database")
	public void teardownDB()
	{
		System.out.println("closing the DB connections");
	}
	
	
	@Test(groups={"automation","database"})
	public void testA2() throws Exception
	{
		System.out.println("Test A2 start");
		Thread.sleep(3000);
		System.out.println("Test A2 end");
	}
	
	
	@Test(dependsOnGroups={"automation","database"})
	public void runFinal()
	{
		System.out.println("Final code of my project");
	}

}


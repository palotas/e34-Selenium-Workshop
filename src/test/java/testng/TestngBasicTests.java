package testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngBasicTests {
	
	
	@Test
	public void test1() {
		int a = 3;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertEquals(c, 5);
	}

	@Test(dependsOnMethods={"test1"})
	public void mytest2() {

		String lastname = "Palotas";
		String firstname = "Michael";

		String fullname = firstname + lastname;
		Assert.assertEquals(fullname.length(), 14);
	}

}

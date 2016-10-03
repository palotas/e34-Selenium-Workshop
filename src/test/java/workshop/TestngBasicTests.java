package testng;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasicTests {
	
	@BeforeTest
	public void setup() {
		System.out.println("setting up the system");
	}


	@Test
	public void test1() {
		int a = 3;
		int b = 2;
		int c;
		c = a + b;
		Assert.assertTrue(c==5);
	}

	@Test(dependsOnMethods={"test1"})
	public void test2() {

		String lastname = "Palotas";
		String firstname = "Michael";

		String fullname = firstname + lastname;
		Assert.assertEquals(fullname.length(), 14);
	}


	@Test(dependsOnMethods={"test1"})
	public void mtest3() {

		String lastname = "Palotas";
		String firstname = "Tulip";

		String fullname = firstname + lastname;
		Assert.assertEquals(fullname.length(), 12);
	}
}

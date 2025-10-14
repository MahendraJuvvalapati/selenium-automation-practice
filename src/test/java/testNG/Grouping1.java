package testNG;

import org.testng.annotations.Test;

public class Grouping1 {

	@Test(groups = { "smoke", "regression" })
	public void loginTest() {
		System.out.println("✅ Running Login Test");
	}

	@Test(groups = { "regression" })
	public void addEmployeeTest() {
		System.out.println("✅ Running Add Employee Test");
	}

	@Test(groups = { "sanity" })
	public void searchEmployeeTest() {
		System.out.println("✅ Running Search Employee Test");
	}

	@Test(groups = { "smoke" })
	public void logoutTest() {
		System.out.println("✅ Running Logout Test");
	}
}

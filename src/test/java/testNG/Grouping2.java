package testNG;

import org.testng.annotations.Test;

public class Grouping2 {

	@Test(groups = { "smoke" })
	public void openUserPage() {
		System.out.println("✅ Opening User Management Page");
	}

	@Test(groups = { "sanity", "regression" })
	public void createUser() {
		System.out.println("✅ Creating New User");
	}

	@Test(groups = { "regression" })
	public void deleteUser() {
		System.out.println("✅ Deleting Existing User");
	}
}

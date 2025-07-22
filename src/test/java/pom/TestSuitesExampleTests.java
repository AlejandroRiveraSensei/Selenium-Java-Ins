package pom;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class TestSuitesExampleTests extends BaseTest{

    @Parameters({"username", "password"})
    @Test
    public void testSuiteParameters(String user, String pass) {
        login.login(user, pass);
        Assert.assertEquals(inventory.getTitleText(), "Products");
    }

    @DataProvider(name = "users", parallel = true)
    public Object[][] users() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
        };
    }

    @Test(dataProvider = "users") // Cuando ejecutes ese quitar la herencia de BaseTest
    public void testSuiteDataProvider(String user, String pass) {
        System.out.println("USER: " + user + "PASSWORD: " +pass);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSuiteRetry() {
        System.out.println("Trying...");
        Assert.assertTrue(false);
    }
}


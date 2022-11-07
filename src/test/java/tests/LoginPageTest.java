package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void initialize() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        homePage = loginPage.loginToApp(user, pass);
        Assert.assertTrue(homePage.isSidePanelDisplayed());
    }


}

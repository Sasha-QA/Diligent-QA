import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FrontPage;
import pages.InfoPage;

public class Tests extends BaseTest{

    @Test(priority = 0) // TC003 - log in using already made account
    public void logIn(){
        FrontPage fp = new FrontPage(createWebDriver());
        fp.clickSignIn();
        fp.enterExsistingEmail();
        fp.clickContinue();
        fp.signInPassword();
        fp.clickRememberMeButton();
        fp.signInForExistingAcc();
        fp.clickMyProfileIcon();

        String actual = driver.findElement(fp.myProfileName).getText();
        Assert.assertTrue(actual.contains(InfoPage.PROFILE_NAME), "Non-existing!");

    }

    @Test (priority = 1) // TC005 - Using wrong password
    public void useWrongPassword(){
        FrontPage fp = new FrontPage(createWebDriver());
        fp.clickSignIn();
        fp.enterExsistingEmail();
        fp.clickContinue();
        fp.signInWrongPassword();
        fp.signInForExistingAcc();

        String actual = driver.findElement(fp.wrongPassMessage).getText();
        Assert.assertTrue(actual.contains(InfoPage.WRONG_PASSWORD_MESSAGE), "Non-existing!");
    }

     @Test (priority = 2) // TC001 - register with new email
    public void register(){
         FrontPage fp = new FrontPage(createWebDriver());
         fp.clickSignIn();
         fp.enterNewEmail();
         fp.clickContinue();
         fp.clickFirstName();
         fp.makePassword();
         fp.showPassword();
         fp.clickRegister();

         String actual = driver.getCurrentUrl();
         String expected = "https://www.etsy.com/";

         Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3) // TC007 - choose a category from a header
    public void chooseJewelry(){
        FrontPage fp = new FrontPage(createWebDriver());
        fp.clickSignIn();
        fp.enterExsistingEmail();
        fp.clickContinue();
        fp.signInPassword();
        fp.signInForExistingAcc();
        fp.hoverJewelry();

        String actual = driver.getCurrentUrl();
        String expected = "https://www.etsy.com/c/jewelry/necklaces/chokers?ref=catnav-10855";

        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 4) //TC006 - Search for a specific item
    public void searchBioshock(){
        FrontPage fp = new FrontPage(createWebDriver());
        fp.clickSignIn();
        fp.enterExsistingEmail();
        fp.clickContinue();
        fp.signInPassword();
        fp.signInForExistingAcc();
        fp.searchProduct();

        String actual = driver.getCurrentUrl();
        String expected = "https://www.etsy.com/search?q=Bioshock";

        Assert.assertEquals(actual, expected);

    }
}

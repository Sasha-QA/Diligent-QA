package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;
import java.util.UUID;

public class FrontPage {

    public WebDriver driver;

    public By signInButton = By.cssSelector(".wt-btn.wt-btn--small.wt-btn--transparent.wt-mr-xs-1.inline-overlay-trigger.signin-header-action.select-signin");
    public By searchField = By.cssSelector("#global-enhancements-search-query");
    public By emailAddressField = By.cssSelector("#join_neu_email_field");
    public By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    public By firstNameField = By.cssSelector("#join_neu_first_name_field");
    public By makePasswordField = By.xpath("//input[@id='join_neu_password_field']");
    public By showPasswordButton = By.cssSelector("#showHidePassword");
    public By registerButton = By.name("submit_attempt");
    public By passwordField = By.xpath("/html[1]/body[1]/div[8]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]");
    public By signInAccountButton = By.name("submit_attempt");
    public By rememberMe = By.cssSelector("label[for='persisent']");
    public By jewelry = By.id("catnav-primary-link-10855");
    public By necklases = By.id("side-nav-category-link-10873");
    public By choker = By.partialLinkText("Choke");
    public By magnifyingGlass = By.cssSelector("button[value='Search']");
    public By wrongPassMessage = By.id("join-neu-overlay-title");
    public By profileIcon = By.cssSelector("body > div:nth-child(6) > header:nth-child(1) > div:nth-child(5) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1) > img:nth-child(1)");
    public By myProfileName = By.className("wt-text-title-01 wt-m-xs-0");

    public FrontPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignIn (){
        driver.findElement(signInButton).click();
    }

    public void enterExsistingEmail(){
        driver.findElement(emailAddressField).sendKeys(InfoPage.EXSISTING_EMAIL);
    }
    public void enterNewEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(emailAddressField).sendKeys("username"+ randomInt +"@gmail.com");
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void clickFirstName(){
        String uuid = UUID.randomUUID().toString();
       WebElement fname =  driver.findElement(firstNameField);
       fname.click();
       fname.sendKeys(uuid);

    }

    public void makePassword(){
        WebElement pswd = driver.findElement(makePasswordField);
        pswd.click();
        pswd.sendKeys("Abc123!@#");
    }

    public void showPassword(){
        driver.findElement(showPasswordButton).click();
    }

    public void clickRegister(){
        driver.findElement(registerButton).click();
    }

    public void signInPassword(){
       WebElement pass = driver.findElement(passwordField);
        pass.click();
        pass.sendKeys(InfoPage.PASSWORD);
    }

    public void signInWrongPassword(){
        driver.findElement(passwordField).sendKeys(InfoPage.WRONG_PASSWORD);
    }

    public void signInForExistingAcc(){
        driver.findElement(signInAccountButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickRememberMeButton(){
        driver.findElement(rememberMe).click();
    }
    public void hoverJewelry(){
        Actions action = new Actions(driver);
        WebElement jwlry = driver.findElement(jewelry);
        WebElement nckls = driver.findElement(necklases);
        action.moveToElement(jwlry);
        action.moveToElement(nckls);
        action.moveToElement(driver.findElement(choker)).click().build().perform();
    }

    public void clickMyProfileIcon(){ driver.findElement(profileIcon).click();}
    public void searchProduct (){
        driver.findElement(searchField).sendKeys("Bioshock");
        driver.findElement(magnifyingGlass).click();
    }
}

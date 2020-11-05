package PageObjects;

import Utils.Helpers;
import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignUpPage {
    private static WebElement element = null;

    public static WebElement signUpBtn(WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[1]/div/a[1]/div/span/span"));
        return element;
    }

    public static WebElement accountName (WebDriver driver){
        element = driver.findElement(By.name("name"));
        return element;
    }

    public static WebElement useEmailLink (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[4]/span"));
        return element;
    }

    public static WebElement accountEmail (WebDriver driver){
        element = driver.findElement(By.name("email"));
        return element;
    }

    public static Select monthSelection (WebDriver driver){
        Select month = new Select(driver.findElement(By.xpath("//*/div[1]/div[2]/select")));
        return month;
    }

    public static Select daySelection (WebDriver driver){
        Select day = new Select(driver.findElement(By.xpath("//*/div[2]/div[2]/select")));
        return day;
    }

    public static Select yearSelection (WebDriver driver){
        Select year = new Select(driver.findElement(By.xpath("//*/div[3]/div[2]/select")));
        return year;
    }

    public static WebElement nextBtn (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[3]/div/div/span/span"));
        return element;
    }

    public static WebElement signUpBtn2 (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[5]/div/span/span"));
        return element;
    }

    public static WebElement verificationCodeField (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[2]/label/div/div[2]/div/input"));
        return element;
    }

    public static WebElement accountPassword (WebDriver driver){
        element = driver.findElement(By.name("password"));
        return element;
    }

    public static WebElement skipForNowBtn (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[3]/div/div/span/span"));
        return element;
    }

    public static WebElement accountBio (WebDriver driver){
        element = driver.findElement(By.name("text"));
        return element;
    }

    public static WebElement skipForNowBtn2 (WebDriver driver){
        element = driver.findElement(By.xpath("//*/div[2]/div/div[2]/div[2]/div"));
        return element;
    }

    public static void signUpProcess(WebDriver driver) throws InterruptedException {
        SignUpPage.signUpBtn(driver).click();
        Thread.sleep(2000);

        SignUpPage.accountName(driver).sendKeys(Helpers.ACCOUNT_NAME);
        Thread.sleep(1000);

        SignUpPage.useEmailLink(driver).click();
        Thread.sleep(1000);

        SignUpPage.accountEmail(driver).sendKeys(Utilities.generateEmail(driver));
        Thread.sleep(1000);

        SignUpPage.monthSelection(driver).selectByVisibleText(Helpers.ACCOUNT_MONTH);
        Thread.sleep(1000);

        SignUpPage.daySelection(driver).selectByVisibleText(Helpers.ACCOUNT_DAY);
        Thread.sleep(1000);

        SignUpPage.yearSelection(driver).selectByVisibleText(Helpers.ACCOUNT_YEAR);
        Thread.sleep(1000);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(500);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(500);

        SignUpPage.signUpBtn2(driver).click();
        Thread.sleep(500);

        SignUpPage.verificationCodeField(driver).sendKeys(Utilities.verificationCode(driver));
        Thread.sleep(500);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(1000);

        try{
            SignUpPage.accountPassword(driver).sendKeys(Helpers.ACCOUNT_PASSWORD);
       }catch (NoSuchElementException e){
           System.out.println("Please reset your router to avoid twitter anti-bot mechanisms");
           Thread.sleep(2000);
       }
        Thread.sleep(500);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(1000);

        SignUpPage.skipForNowBtn(driver).click();
        Thread.sleep(3000);

        SignUpPage.skipForNowBtn(driver).click();
        Thread.sleep(3000);

        SignUpPage.accountBio(driver).sendKeys(Helpers.ACCOUNT_BIO);
        Thread.sleep(500);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(1000);

        SignUpPage.skipForNowBtn(driver).click();
        Thread.sleep(1000);

        SignUpPage.nextBtn(driver).click();
        Thread.sleep(1000);

        SignUpPage.skipForNowBtn2(driver).click();
        Thread.sleep(1000);
    }

    public static Boolean isAccountCreated(WebDriver driver) throws InterruptedException {
        return (HomePage.twitterAccountCreated(driver).getAttribute("href").contains(Helpers.ACCOUNT_NAME.toUpperCase().substring(0,Helpers.NAME_LENGTH - 3))
                || HomePage.twitterAccountCreated(driver).getAttribute("href").contains(Helpers.ACCOUNT_NAME.toLowerCase().substring(0,Helpers.NAME_LENGTH - 3)));
    }

}

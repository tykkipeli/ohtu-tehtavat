package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        epaoonistunutKirjautuminen(element,driver);
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        uudenKayttajatunnuksenLuominen(element,driver);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        System.out.println(driver.getPageSource());
        sleep(2);
        

        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
    
    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while( trials++<5 ) {
            try{
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;           
            } catch(Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    private static void epaoonistunutKirjautuminen(WebElement element, WebDriver driver) {
        element = driver.findElement(By.linkText("login"));
        element.click();
        
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("erkki");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        System.out.println(driver.getPageSource());
        sleep(2);
    }

    private static void uudenKayttajatunnuksenLuominen(WebElement element, WebDriver driver) {
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());

        sleep(2);
        
        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("erkki" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        System.out.println(driver.getPageSource());
        sleep(2);
    }
}

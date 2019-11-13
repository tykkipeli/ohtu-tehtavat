package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }   
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userSuccesfullyCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
        createAccountWith(username,password,password);
        pageHasContent("Welcome to Ohtu Application!");
        element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();
        element = driver.findElement(By.linkText("logout"));       
        element.click();
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void invalidUserTryingToBeCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
        createAccountWith(username,password,password);
        pageHasContent("Create username and give password");
        element = driver.findElement(By.linkText("back to home"));       
        element.click();
    } 
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }   
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndMathcingPasswordConfirmationAreEntered(String username, String password) {
        createAccountWith(username,password,password);
    }
    
    @When("a valid username {string} and password {string} and not matching password {string} confirmation are entered")
    public void validUsernameAndNotMathcingPasswordConfirmationAreEntered(String username, String password, String confirmation) {
        createAccountWith(username,password,confirmation);
    }
    
    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void validUsernameAndTooShortPasswordWithMathcingPasswordConfirmationAreEntered(String username, String password) {
        createAccountWith(username,password,password);
    } 
    
    @When("too short username {string} and valid password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndValidPasswordWithMathcingPasswordConfirmationAreEntered(String username, String password) {
        createAccountWith(username,password,password);
    } 
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String errorMessage) {
        pageHasContent(errorMessage);
        pageHasContent("Create username and give password");
    }

      
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void createAccountWith(String username, String password, String confPassword) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confPassword);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
}

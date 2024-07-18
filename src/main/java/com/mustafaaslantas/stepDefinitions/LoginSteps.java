package com.mustafaaslantas.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private By errorMessage = By.className("ky-form-messages");
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Given("Go to KitapYurdu Website")
    public void go_to_kitap_yurdu_website() {
        driver.get("https://www.kitapyurdu.com");

    }
    @Given("Press the login button")
    public void press_the_login_button() {
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Giriş Yap')]")));
        loginLink.click();

    }
    @Given("Enter email and password")
    public void enter_email_and_password(String email, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-email")));
        WebElement passwordField = driver.findElement(By.id("login-password"));

        usernameField.sendKeys(email);
        passwordField.sendKeys(password);


    }
    @When("Pressed the submit button")
    public void pressed_the_submit_button() {
        WebElement submitButton = driver.findElement(By.className("ky-btn ky-btn-orange w-100 ky-login-btn"));
        submitButton.click();

    }
    @Then("Verify the success and error message")
    public void verify_the_success_and_error_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        if (driver.findElements(errorMessage).size() > 0) {
            System.out.println("Hata mesajı başarıyla gösterildi");
        }
        else System.out.println("Hata mesajı gösterilemedi");

    }
}

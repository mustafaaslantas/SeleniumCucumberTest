package com.mustafaaslantas.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {
    private By emptyMessage = By.xpath("//div[@class='content' and contains(text(), 'Sepetiniz boş')]");
    private WebDriver driver;
    private WebDriverWait wait;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Given("Remove the item")
    public void remove_the_item() {
        WebElement removeButton = driver.findElement(By.xpath("//i[@class='fa fa-times red-icon']"));
        removeButton.click();
    }

    @Then("Verify the cart is empty")
    public void verify_the_cart_is_empty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMessage)).isDisplayed();
        if (driver.findElement(By.xpath("//div[@class='content']")).isDisplayed()) {
            System.out.println("Sepet başarıyla boşaltıldı");
        }

    }

}

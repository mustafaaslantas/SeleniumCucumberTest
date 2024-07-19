package com.mustafaaslantas.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement searchBox;

    public SearchSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Given("Find and press the search bar")
    public void findAndPressTheSearchBar() {
        driver.get("https://www.kitapyurdu.com");
        searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input")));


    }
    @Given("Type Orhan Pamuk and search")
    public void type_Orhan_Pamuk_and_search() {
        searchBox.sendKeys("Orhan Pamuk");
        searchBox.sendKeys(Keys.RETURN);

    }
    @Given("Verify the results")
    public void verify_the_results() {
        String searchTerm = "Orhan Pamuk";
        List<WebElement> productNames = driver.findElements(By.cssSelector("mg-b-10"));

        boolean allProductsRelated = true;
        for (WebElement productName : productNames) {
            String nameText = productName.getText();
            System.out.println("Ürün İsmi: " + nameText);
            if (!nameText.toLowerCase().contains(searchTerm.toLowerCase())) {
                allProductsRelated = false;
                break;
            }
        }
        if (allProductsRelated) {
            System.out.println("Tüm ürünler arama terimi ile ilgili.");
        } else {
            System.out.println("Bazı ürünler arama terimi ile ilgili değil.");
        }

    }



}

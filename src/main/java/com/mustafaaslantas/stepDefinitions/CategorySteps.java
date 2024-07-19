package com.mustafaaslantas.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CategorySteps {
    private By bookItems = By.cssSelector("mg-b-10");
    private WebDriver driver;
    private WebDriverWait wait;
    WebElement selectedBook;
    public CategorySteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @Given("Find and press the All Categories button")
    public void find_and_press_the_all_categories_button() {
        driver.get("https://www.kitapyurdu.com");
        WebElement categoriesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Tüm Kategoriler')]")));
        categoriesLink.click();
    }

    @Given("Find and press the edebiyat")
    public void find_and_press_the_edebiyat() {
        WebElement edebiyat = driver.findElement(By.xpath("//h2[.='Edebiyat']"));
        edebiyat.click();

    }

    @Given("Select a random item from list")
    public void select_a_random_item_from_list() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookItems));
        List<WebElement> books = driver.findElements(bookItems);
        Random rand = new Random();
        int randomIndex = rand.nextInt(books.size());
        selectedBook = books.get(randomIndex);
        selectedBook.click();

    }

    @Given("Add the item to the cart")
    public void add_the_item_to_the_cart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
        addToCartButton.click();
    }

    @Given("Go to the cart")
    public void go_to_the_cart() {

        WebElement cartButton = driver.findElement(By.xpath("//h4[@class='common-sprite']"));
        cartButton.click();
        WebElement cartLink = driver.findElement(By.xpath("//a[@id='js-cart']"));
        cartLink.click();
    }
    @Given("Verify that its the same item in the cart")
    public void verify_that_its_the_same_item_in_the_cart() {
        WebElement item = driver.findElement(By.className("alt"));
        if (item.getText().equals(selectedBook.getText())) {
            System.out.println("Sepetteki ürünle seçilen ürün aynı.");
        }
        else System.out.println("Sepetteki ürünle seçilen ürün aynı değil.");


    }
}

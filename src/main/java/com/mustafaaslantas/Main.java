package com.mustafaaslantas;

import com.mustafaaslantas.tests.TestRunner;
import org.checkerframework.checker.units.qual.C;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println("Testler çalıştırılıyor...");
        driver.get("https://www.kitapyurdu.com");
        // TestRunner sınıfını çalıştır
        Result result = JUnitCore.runClasses(TestRunner.class);

        // Test sonuçlarını yazdır
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Testlerin başarılı olup olmadığını yazdır
        System.out.println("Başarılı: " + result.wasSuccessful());


        }
    }

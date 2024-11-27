package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Set;

public class GetChannelMemberQRCode extends AppTestWeb {
    public void setQRImage() throws Exception {
        chromeDriver.get("https://ooqa.salespoint.live/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

        // Wait for the email input to be visible and enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        chromeDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("admin");

        // Wait for the password input to be visible and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        chromeDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");

        // Wait for the login button to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));
        chromeDriver.findElement(By.xpath("//button[@type='button']")).click();

        // Wait for the element with id "309" to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.id("309")));
        chromeDriver.findElement(By.id("309")).click();

        // Wait for the menu link to be clickable and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='InDirect']")));
        chromeDriver.findElement(By.xpath("//div[normalize-space()='InDirect']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dealer (EVD/SIM)']")));
        chromeDriver.findElement(By.xpath("//span[normalize-space()='Dealer (EVD/SIM)']")).click();

        // Wait for the search input to be visible and enter search text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
        chromeDriver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Tamer Ahmad");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(Keys.ENTER);
        // Wait for the group name header to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Tamer Ahmad']")));
        chromeDriver.findElement(By.xpath("//td[@title='Tamer Ahmad']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-wrapper.o_loading_indicator.o_loading")));
        // Wait for the settings button to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Settings And Miscellaneous']")));
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Settings And Miscellaneous']")).click();

        // Wait for the QR button to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='QR']")));
        chromeDriver.findElement(By.xpath("//button[normalize-space()='QR']")).click();

        Thread.sleep(10000);
        // Wait for the QR image to be visible and get the image URL

        //wait.until(ExpectedConditions.attributeToBeNotEmpty(qrImageElement, "src"));
        WebElement qrImageElement = chromeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[13]/div[1]/div[4]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/img[1]"));
        String imageUrl = qrImageElement.getAttribute("src");
        // Download the image
        downloadImage(imageUrl, "/Users/leadingpoint/IdeaProjects/AppiumPoc/image.png");
        CommonActions.setVirtualImage(Paths.get("/Users/leadingpoint/IdeaProjects/AppiumPoc/"), "image.png");
    }

    public void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println(connection);
        // Build the cookies string
        Set<Cookie> cookies = chromeDriver.manage().getCookies();
        StringBuilder cookieHeader = new StringBuilder();
        for (Cookie cookie : cookies) {
            cookieHeader.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
        }
        // Remove the last semicolon and space
        if (cookieHeader.length() > 0) {
            cookieHeader.setLength(cookieHeader.length() - 2);
        }
        // Set the cookies in the request
        connection.setRequestProperty("Cookie", cookieHeader.toString());
        InputStream in = connection.getInputStream();
        Files.copy(in, Paths.get(destinationFile), StandardCopyOption.REPLACE_EXISTING);
        in.close();
    }
}

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class LoginTest {
    private WebDriver driver;
    /*
     * STEP TO ARCHIVE THE TASK
     * Open the Konga website.
     * Sign in to Konga with valid credentials voxaja1374@rencr.com AND voxaja1374@
     * https://temp-mail.org/en/view/663be0998848d004b582808e
     * Navigate to the "Computers and Accessories" category.
     * Click on the "Laptops" subcategory.
     * Click on the "Apple MacBooks" product category.
     * Add a MacBook product to the cart.
     * Proceed to checkout.
     * Select an address and continue to payment.
     * Choose the card payment method.
     * Input invalid card details (e.g., invalid card number, expiry date, and CVV).
     * test data: 4187 4515 0349 9115 - 10/26 - 122 - 8725
     * Attempt to submit the payment.
     * Verify that an error message is displayed indicating "Invalid card number".
     * Close the iFrame containing the card input modal.
     * Quit the browser.
     * */

    //public LoginTest() {}
    @Test(priority = 0)
    public void login() throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Initialize ChromeDriver
        this.driver = new ChromeDriver();
        // Maximize the window
        this.driver.manage().window().maximize();
        // Navigate to Konga website and wait for 5 Seconds
        this.driver.get("https://www.konga.com/");
        Thread.sleep(5000L);

        // Click on the sign-in button and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(5000L);

        // Enter an existing Email address and wait for 5 seconds
        this.driver.findElement(By.name("username")).sendKeys("voxaja1374@rencr.com");
        Thread.sleep(5000L);

        //Enter Password for the Email above and wait for 5 seconds
        this.driver.findElement(By.name("password")).sendKeys("voxaja1374@");
        Thread.sleep(5000L);

        // Click on the login button and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(9000L);
    }

    @Test(priority =1)
    public void verifyLogin() throws InterruptedException {
        // capture error message and store in a variable actual_msg1 and wait for 9seconds
        String actual_msg1 = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).getText();
        Thread.sleep(9000L);
        // Store message in a variable and wait 9 seconds
        String expect1 = "My Account";
        Thread.sleep(9000L);


        // Verify error message
        Assert.assertEquals(actual_msg1, expect1);
        // Display on console the message below and wait 9 seconds
        System.out.println("The user is login successfully: " + actual_msg1 + " is displayed on his Dashboard");
        Thread.sleep(9000L);
    }

    @Test(priority = 2)
    public void OrderFlow() throws InterruptedException {
        // Navigate to Computers and Accessories category and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(7000L);

        // Click on Laptops subcategory and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        Thread.sleep(5000L);

        // Click on Apple MacBooks product category and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000L);

        // Add a MacBook product to the cart and wait for 5 seconds
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000L);

        // Click on the checkout button and wait for 50 seconds
        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(50000L);


        // // Click on the second checkout button which picks the address as there is only one as the default and wait for 50 seconds
        this.driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]")).click();
        Thread.sleep(50000L);

        // click on the PAY NOW and wait for 80 seconds
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span")).click();
        Thread.sleep(80000L);

        // click on the Continue TO PAYMENT and wait for 80 seconds
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(80000L);


        // click on the card option pay iframe and wait for 80 seconds
        driver.switchTo().frame("kpg-frame-component");
        this.driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div")).click();
        Thread.sleep(80000L);
    }

        @Test(priority = 3)
        public void PaymentFlow() throws InterruptedException {
            // Card Details into iframe
            //Input Card number and wait for 5 seconds
            this.driver.findElement(By.id("card-number")).sendKeys("4187451503099115");
            Thread.sleep(5000L);
            //Input Card Expiry and wait for 5 seconds
            this.driver.findElement(By.id("expiry")).sendKeys("10/27");
            Thread.sleep(5000L);
            //Input Card cvv and wait for 5 seconds
            this.driver.findElement(By.id("cvv")).sendKeys("122");
            Thread.sleep(50000L);


            // Attempt to submit the payment and wait for 5 seconds
            this.driver.findElement(By.id("validateCardForm")).click();
            Thread.sleep(5000L);


            // capture error message and store in a variable actual_msg and wait for 10 seconds
            String actual_msg = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]")).getText();
            Thread.sleep(10000L);
            // Store message in a variable and wait 9 seconds
            String expect = "Invalid card number";
            Thread.sleep(9000L);

            // Verify error message
            Assert.assertEquals(actual_msg, expect);
            // Display on console the message below and wait 9 seconds
            System.out.println("Error message is: " + actual_msg);
            Thread.sleep(9000L);

            // Press Escape to close the card input modal and wait 10 seconds
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
            Thread.sleep(10000L);

            // Click somewhere outside the modal to close it
            this.driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
            Thread.sleep(5000L);
        }



    // Method to close the WebDriver after the test
    @AfterTest
    public void teardown() {
        this.driver.quit();
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

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
* Attempt to submit the payment.
* Verify that an error message is displayed indicating "Invalid card number".
* Close the iFrame containing the card input modal.
* Quit the browser.
      * */

    //public LoginTest() {}
    @Test
    public void login() throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://www.konga.com/");
        Thread.sleep(50L);


        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(50L);


        this.driver.findElement(By.name("username")).sendKeys("voxaja1374@rencr.com");
        Thread.sleep(50L);


        this.driver.findElement(By.name("password")).sendKeys("voxaja1374@");
        Thread.sleep(50L);


        this.driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000L);


        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000L);


        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        Thread.sleep(5000L);

        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000L);

        //add to Cart
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000L);

        // click on the cart
      // this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]")).click();
      // Thread.sleep(5000L);


        // click on the checkout
        this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(5000L);


        // click on the second checkout
        this.driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]")).click();
        Thread.sleep(50000L);




        // click on the PAY NOW
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span")).click();
        Thread.sleep(90000L);



        // click on the Continue TO PAYMENT
        this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(90000L);




        // click on the card option
        driver.switchTo().frame("kpg-frame-component");
        this.driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div")).click();
        Thread.sleep(500000L);


// click on the seselct paymewnt
    //    this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
    //    Thread.sleep(50000L);





    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }
}

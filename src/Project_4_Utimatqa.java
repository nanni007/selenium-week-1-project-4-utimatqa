import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Project_4_Utimatqa {
   static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Safari")){
            driver=new SafariDriver();
        }else if (browser.equalsIgnoreCase("Internet Explorer")){
            driver =new InternetExplorerDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else {
            System.out.println("Enter correct browser name.");
        }
        driver.get(baseUrl); //opening the Url
        driver.manage().window().maximize(); //maxi maximizing  the browser
        Thread.sleep(2000);

        System.out.println("Title of the page is: " + driver.getTitle()); //Printing the title of page
        System.out.println("Current url is: " + driver.getCurrentUrl());  //Printing the current url
        System.out.println("Page source is: " + driver.getPageSource());  //Printing the page source
        WebElement signinClick = driver.findElement(By.className("header__nav-sign-in"));
        signinClick.click();
        System.out.println("sign in url" +driver.getCurrentUrl() ); //Printing the current url
        WebElement emailField = driver.findElement(By.name("user[email]"));
        Thread.sleep(2000);

        emailField.sendKeys("admin123@gmail.com");
        WebElement passwordfield = driver.findElement(By.id("user[password]"));
        Thread.sleep(2000);

        passwordfield.sendKeys("admin123");
        Thread.sleep(2000);

        WebElement loginClick = driver.findElement(By.className("g-recaptcha"));
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();

    }
}

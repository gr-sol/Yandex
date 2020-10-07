import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Mainclass {
    static public WebDriver driver;

    public static void setUp() throws InterruptedException {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\great\\IdeaProjects\\drivers\\geckodriver.exe");
       // WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\great\\IdeaProjects\\drivers2\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
    }
    public  static  void catalog () {
        driver.findElement(By.xpath("//button[@class=\"_2EPSjI-GdM _2s55WErgIp BCVQlNQsVv _3WgR56k47x\"]")).click();

    }
    public static void productsForCats(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"SyJTASPsrT _3mU1ofltUh _17n6su90-I\"]//a[@href=\"/catalog--tovary-dlia-zhivotnykh/54496\"]"))).build().perform();
        driver.findElement(By.xpath("//div[@class=\"_3TgKYgt0rc\"]//ul[@class=\"_3xCDQkqvAp\"]//a[@href=\"/catalog--lakomstva-dlia-sobak/62813/list?hid=12718332\"]")).click();
    }
    public static void filters () throws InterruptedException {
        driver.findElement(By.xpath("//p[@class=\"_1idia0vVNM\" ]/input[@name=\"Цена от\"]")).sendKeys("50");
        driver.findElement(By.xpath("//p[@class=\"_1idia0vVNM\" ]/input[@name=\"Цена до\"]")).sendKeys("150");
        driver.findElement(By.xpath("//fieldset[@class=\"_3qCPFU4W42\"]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"search-prepack\"]/div/div[3]/div/div/div[2]/div[2]/div/div/fieldset/footer/button")).click();
        driver.findElement(By.xpath("//fieldset[@data-autotest-id=\"7893318\"]/div/nav/input[@name=\"Поле поиска\"]")).sendKeys("Whimzees");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"_16hsbhrgAf\"]//label[@for=\"7893318_16881896\"]//div")).click();

    }
    public static void addcompare() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[3]/div/div[1]/div/div/div[2]/div[2]/div[2]/div"));
        driver.findElement(By.xpath("//article[@class=\"_1_IxNTwqll cia-vs cia-cs\"]//a[@title=\"Лакомство для собак Whimzees Зубная щетка M\"]")).click();
        Thread.sleep(2000);
        actions.moveToElement(element).build().perform();


    }

    public static void main(String[] args) throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        catalog();
        productsForCats();
        Thread.sleep(1000);
        filters();
        Thread.sleep(1000);
        addcompare();
        Thread.sleep(1000);
       // driver.quit();

    }
}
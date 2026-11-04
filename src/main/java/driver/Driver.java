package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;

import java.time.Duration;


public class Driver {

    public static WebDriver driver;

    /** Blocks Google ad hosts so ads/vignettes don't cover elements. */
    private static final String BLOCK_ADS_RULES =
            "--host-resolver-rules=MAP *.googlesyndication.com 127.0.0.1, "
                    + "MAP *.doubleclick.net 127.0.0.1, "
                    + "MAP *.googleadservices.com 127.0.0.1, "
                    + "MAP adservice.google.com 127.0.0.1";

    private Driver() {
    }

    public static void setupDriver() {
        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        switch (browser) {
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                if (headless) options.addArguments("-headless");
                driver = new FirefoxDriver(options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments(BLOCK_ADS_RULES);
                if (headless) options.addArguments("--headless=new", "--window-size=1920,1080");
                driver = new EdgeDriver(options);
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                // keep alerts open until the test handles them (Contact Us confirm box)
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
                // don't wait for slow ads/images; explicit waits handle the elements
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments(BLOCK_ADS_RULES);
                if (headless) options.addArguments("--headless=new", "--window-size=1920,1080");
                driver = new ChromeDriver(options);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

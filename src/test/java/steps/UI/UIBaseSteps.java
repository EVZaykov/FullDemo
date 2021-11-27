package steps.UI;

import com.gitHub.pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static helpers.CheckVariable.check_variable_in_string;

public class UIBaseSteps {

    private SignInPage signInPage;
    private WebDriver driver;

    @Given("User opens browser {string}")
    public void user_opens_browser(String string) {
        signInPage = new SignInPage(driver);
        System.out.println("Я хочу" +  "https://github.com/" + check_variable_in_string(string));
        signInPage.goTo("https://github.com/" + check_variable_in_string(string));
        System.out.println("Я открыл" +  "https://github.com/" + check_variable_in_string(string));
    }

    @Before
    public void setDriver() throws MalformedURLException {
       String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            dc = DesiredCapabilities.chrome().merge(options);
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

        //System.setProperty("webdriver.chrome.driver", "C:\\projects\\DemoCucumber-master\\src\\test\\java\\resources\\other\\chromedriver.exe");
        //this.driver = new ChromeDriver();
    }

    @After
    public void closeDriver(Scenario scenario) {
        this.driver.quit();
    }
}

package StepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import cucumber.api.java.en.When;
import org.json.simple.parser.ParseException;
import pageobjects.BasePage;
import pageobjects.HomePage;
import utils.JsonParser;

import java.io.IOException;

public class ExampleStepDef {

    BasePage basePage;
    BrowserContext browserContext;
    HomePage homePage = new HomePage();

    @When("^Setup the environment$")
    public void setUpEnvironment() throws IOException, ParseException {
        String url = new JsonParser().getProperty("url");
        Browser browser = utils.Browser.getBrowser(utils.Browser.CHROME,false);
        browserContext = utils.Context.setTracingContext(browser);
        Page page = browserContext.newPage();
        basePage = new BasePage(page);
        basePage.navigate(url);
    }

    @When("^Login to \"([^\"]*)\"$")
    public void login(String applicationName){

        System.out.println("Logging in application : " + applicationName);

        basePage.click(homePage.linkGetStarted);
        basePage.click(homePage.linkTestGenerator);
        basePage.click(homePage.linkPlaywrightTest);
        basePage.click(homePage.linkInspector);
        basePage.click(homePage.linkDebuggingTools);

        basePage.click(homePage.buttonSearch);
        basePage.enter(homePage.inputSearchDocs,"asserstions");
    }
}

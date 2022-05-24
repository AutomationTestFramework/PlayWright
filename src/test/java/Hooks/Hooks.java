package Hooks;

import com.microsoft.playwright.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setup(){
        System.out.println("Executing Before Step");
    }

    @After
    public void tearDown(){
        System.out.println("Executing After Step");
        utils.Context.stopTracingContext();
        utils.Browser.closeBrowser();
    }
}

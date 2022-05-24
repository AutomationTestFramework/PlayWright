package utils;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class Browser {

    public static final String CHROME = "chrome";
    static Playwright playwright;

    public static com.microsoft.playwright.Browser getBrowser(String browserType, boolean flagHeadlessExecutionMode){
        playwright = Playwright.create();
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(flagHeadlessExecutionMode).setChannel(browserType).setSlowMo(50));
    }

    public static void closeBrowser(){
        playwright.close();
    }
}

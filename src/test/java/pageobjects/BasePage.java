package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    private final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void click(String locator){
      page.locator(locator).click();
    }

    public void select(String locator, String value){
        page.locator(locator).selectOption(value);
    }

    public void enter(String locator, String value){
        page.locator(locator).fill(value);
        page.locator(locator).press("Enter");
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public Locator getLocator(String locator){
        return page.locator(locator);
    }

    public String getAttribute(String locator, String attributeName){
        return page.locator(locator).getAttribute(attributeName);
    }

    public boolean isEnabled(String locator){
        return page.locator(locator).isEnabled();
    }
}

package fspotcloud.taskqueuedispatch.integration.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.inject.Provider;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverProviderFactory {

    public Provider<WebDriver> firefoxProvider() {
        return new Provider<WebDriver>() {

            @Override
            public WebDriver get() {
                return new FirefoxDriver();
            }
        };
    }

    public Provider<WebDriver> chromeProvider() {
        return new Provider<WebDriver>() {

            @Override
            public WebDriver get() {
                return new ChromeDriver();
            }
        };
    }

    public Provider<WebDriver> htmlUnitProvider() {
        return new Provider<WebDriver>() {

            @Override
            public WebDriver get() {
                final HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
                htmlUnitDriver.setJavascriptEnabled(true);
                return htmlUnitDriver;
            }
        };
    }
}

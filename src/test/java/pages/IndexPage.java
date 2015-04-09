package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URI;

public class IndexPage {

    private final WebDriver driver;
    private final URI homepage;

    @FindBy(css = "a[href='create-order.jsp']")
    private WebElement createOrderLink;


    public IndexPage(WebDriver driver, URI homepage) {
        if (!isAtIndexPage(driver, homepage)) {
            throw new IllegalStateException();
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.homepage = homepage;
    }

    public CreateOrderPage createOrder() {
        createOrderLink.click();
        return new CreateOrderPage(driver, homepage);
    }

    /**
     * @param driver   A web driver.
     * @param homepage The root URI of a the expected site.
     * @return Whether or not the driver is at the index page of the site.
     */
    public static boolean isAtIndexPage(WebDriver driver, URI homepage) {
        return driver.getCurrentUrl().equals(homepage.toString());
    }


}

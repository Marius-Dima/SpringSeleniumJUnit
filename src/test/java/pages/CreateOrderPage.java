package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URI;

public class CreateOrderPage {

    private final WebDriver driver;
    private final URI homepage;

    @FindBy(css = "form[name='create-order'] input[name='item']")
    private WebElement itemInput;

    @FindBy(css = "form[name='create-order'] input[name='amount']")
    private WebElement amountInput;

    @FindBy(css = "form[name='create-order'] input[type='submit']")
    private WebElement submit;

    public CreateOrderPage(WebDriver driver, URI homepage) {
        if (!isAtCreateOrderPage(driver, homepage)) { throw new IllegalStateException(); }

        PageFactory.initElements(driver, this);

        this.driver = driver;
        this.homepage = homepage;
    }

    public CreateOrderPage submit(String item, String amount) {
        itemInput.sendKeys(item);
        amountInput.sendKeys(amount);
        submit.click();
        return new CreateOrderPage(driver, homepage);
    }

    /**
     *
     * @param driver a WebDriver
     * @param homepage a homepage address
     * @return Whether or not the driver is at the index page of the site.
     */
    public static boolean isAtCreateOrderPage(WebDriver driver, URI homepage){
        return driver.getCurrentUrl().equals(homepage.toString() + "create-order.jsp");
    }


}

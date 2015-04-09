package tests;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pages.CreateOrderPage;
import pages.IndexPage;


import java.net.URI;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class IndexPageIT extends AbstractIT {


    @Test
    public void testWeSeeHelloWorld() {
        getDriver().get(getHomepage().toString());

        new IndexPage(getDriver(), getHomepage()).createOrder();

        assertTrue(CreateOrderPage.isAtCreateOrderPage(getDriver(),getHomepage()));
    }
}
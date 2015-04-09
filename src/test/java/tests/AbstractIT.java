package tests;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public abstract class AbstractIT {

    @Autowired
    private URI homepage;

    @Autowired
    private WebDriver driver;

    public URI getHomepage() {
        return homepage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().get(homepage.toString());
    }

}

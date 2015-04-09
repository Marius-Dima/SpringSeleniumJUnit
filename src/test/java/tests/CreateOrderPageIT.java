package tests;

import org.junit.Test;
import pages.IndexPage;

public class CreateOrderPageIT extends AbstractIT {

    @Test
    public void testSubmit(){
        new IndexPage(getDriver(), getHomepage()).createOrder().submit("myitem", "5.0");
    }
}

package kirubhakaran.nopcommerce.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import kirubhakaran.nopcommerce.pageobject.Register;
import kirubhakaran.nopcommerce.utils.BrowserFactory;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class VerifyRegisterTest{
	
	WebDriver driver;
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
		driver = BrowserFactory.LaunchBrowser();
	}
	
	@Test
    public void Test_Register_Success(ITestContext context) {
        // Create a New User
        Register obj_register = new Register(driver);
        obj_register.register();
        
        context.setAttribute("userEmail", obj_register.registedEmail);
        
        // Verify the cart has the product
        assertEquals(obj_register.isConsumerRegistered(), true);
    }
	
}

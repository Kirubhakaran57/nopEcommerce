package kirubhakaran.nopcommerce.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kirubhakaran.nopcommerce.pageobject.Home;
import kirubhakaran.nopcommerce.utils.BrowserFactory;

public class VerifyHomePageTest {

	WebDriver driver;
	Home obj_HomePage;

	@DataProvider(name = "searchdata-provider")
	public Object[][] SearchData() {
		return new Object[][] { { "Lenovo IdeaCentre 600 All-in-One PC" } };
	}

	@BeforeMethod
	public void StartBrowser() throws IOException {
		driver = BrowserFactory.LaunchBrowser();
		obj_HomePage = new Home(driver);
	}

	@Test(dataProvider = "searchdata-provider", priority = 1)
	public void Test_ProductSearch_Success(String Search, ITestContext context) {

		// Search the Product in HomePage
		assertTrue(obj_HomePage.SearchProduct(Search));
	}

	@Test(dependsOnMethods = { "Test_ProductSearch_Success" })
	public void AddProductToCartAndCheckOut() {

		// Search the Product in HomePage
		assertTrue(obj_HomePage.AddProductToCartAndCheckOut());
	}
}

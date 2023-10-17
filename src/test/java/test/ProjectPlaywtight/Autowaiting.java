package test.ProjectPlaywtight;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Autowaiting {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright =Playwright.create();
     	Browser browser  = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context1 = browser.newContext(new Browser.NewContextOptions()
				  .setGeolocation(41.890221, 12.492348)
				  .setPermissions(Arrays.asList("geolocation")));
		Page p1 =context1.newPage();
		PlaywrightAssertions.setDefaultAssertionTimeout(7000);
		p1.setDefaultTimeout(5000);
		
		p1.navigate("https://yahoo.com/");
		//Thread.sleep(30000);
		p1.locator("//input[@type='text']").first().click();
		//assertThat(p1.locator("//input[@type='text']").first()).hasText("ssf");
		 
	   p1.locator("//input[@type='text']").first().fill("mobile");
	   //p1.waitForSelector("(//div[@type='normal']/li//span[1])[1]",new WaitForSelectorOptions().setTimeout(3000));
	   assertThat(p1.locator("(//div[@type='normal']//li//span[1])[1]").first()).isVisible();
       
		
	   int c = p1.locator("//div[@type='normal']//li/span[1]").count();
		System.out.println(c);
	  	}
	
}

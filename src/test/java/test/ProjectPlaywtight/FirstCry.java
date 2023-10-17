package test.ProjectPlaywtight;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstCry {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright =Playwright.create();
     	Browser browser  = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context1 = browser.newContext(new Browser.NewContextOptions()
				  .setGeolocation(41.890221, 12.492348)
				  .setPermissions(Arrays.asList("geolocation")));
		Page p1 =context1.newPage();
		p1.navigate("https://firstcry.com/");
		p1.locator("#search_box").click();
		 for (int i = 0; i < "mobile".length(); i++) {
             char c = "mobile".charAt(i);
             p1.locator("#search_box").pressSequentially(String.valueOf(c));
             //p1.waitForTimeout(2000); // 2-second delay
         }
		
		 
	Locator ele =	 p1.locator("//div[@id='searchlist']//li/span[1]");
//	System.out.println(ele.count());
	for(int i=0;i<ele.count();++i)
	{
		System.out.println("hu");
		String text = ele.nth(i).textContent();
		System.out.println(text);
	}
	System.out.println("hueed");
		 
		
		//playwright.close();
		
		
		
		
	}
	
}

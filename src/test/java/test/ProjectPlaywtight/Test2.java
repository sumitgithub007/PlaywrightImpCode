package test.ProjectPlaywtight;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		
	Playwright playwright =Playwright.create(); //server start
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in");
		Thread.sleep(50000);
		String title = page.title();
		System.out.println(title);
		playwright.close();
		
		
		
		
		
		
		
		
	}
	
}

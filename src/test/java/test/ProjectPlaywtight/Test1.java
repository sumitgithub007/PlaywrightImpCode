package test.ProjectPlaywtight;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {

	public static void main(String[] args) {
		
		
		Playwright playwright =Playwright.create(); //server start
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in");
		
		String title = page.title();
		System.out.println(title);
		playwright.close();
		
		
		
	}
	
}

package test.ProjectPlaywtight;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserContext.WaitForPageOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LambdaTest {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
	
		page.navigate("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
	   	    	WaitForPageOptions w = new WaitForPageOptions();
	   	
	   	Page tabs = context.waitForPage(w.setPredicate(
				p-> p.context().pages().size() == 3),() -> {
	    
					page.getByText("Follow All").click();	
	   		
	   	});
	    	
		List<Page> pages = tabs.context().pages();
		System.out.println(pages.size());
		pages.forEach(tab->{
			
			tab.bringToFront();
		 
			tab.waitForLoadState();
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			System.out.println(tab.title());
		});
	
	   	
 
	   	
	   	
	   	
	   	
	  
}
	
}

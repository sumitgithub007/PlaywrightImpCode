package test.ProjectPlaywtight;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserContext.WaitForPageOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AmazonFiles {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser =playwright.chromium().launch(lp);
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
	
		page.navigate("http://bigbasket.com/");
	   	List<Locator> loc = page.locator("//div[@class='w-1/3 pr-4'] //a").all();

	   	page.keyboard().down("Control");
	   	
	   	WaitForPageOptions w = new WaitForPageOptions();
	   	
	   	Page tabs = context.waitForPage(w.setPredicate(
				p-> p.context().pages().size() == 12),() -> {
	    
          for(Locator lis : loc)
          {
        	  lis.click();
          }
	   		
	   	});
	   	page.keyboard().up("Control");
	   	
		List<Page> pages = tabs.context().pages();
		System.out.println(pages.size());
		pages.forEach(tab->{
			
			tab.bringToFront();
		 
			tab.waitForLoadState();
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			System.out.println(tab.title());
		});
	
	   	
 
	   	
	   	
	   	
	   	
	  
}
	
}

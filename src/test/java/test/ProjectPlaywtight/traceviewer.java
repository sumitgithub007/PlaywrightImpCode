package day10;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.microsoft.playwright.*;

import java.util.HashMap;
import java.util.Map;
 

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class LearnTraceViewer {

	private static final String SRC_DIRS = System.getenv("PLAYWRIGHT_JAVA_SRC") == null ? "src/test/java" : System.getenv("PLAYWRIGHT_JAVA_SRC");
	
	public static void main(String[] args) {
		

		 
		Map<String, String> env = new HashMap<>();
		env.put("PLAYWRIGHT_JAVA_SRC", SRC_DIRS);
 	    Playwright.CreateOptions options =new Playwright.CreateOptions().setEnv(env);
	
	
		
	 Playwright playwright = 	Playwright.create(options);
	 LaunchOptions lp = new LaunchOptions();
	 lp.setChannel("chrome");
	 lp.setHeadless(false);
	 
	 Browser browser = playwright.chromium().launch(lp);
	 BrowserContext context1 = browser.newContext();
	// Start tracing before creating / navigating a page.
	 context1.tracing().start(new Tracing.StartOptions()
	   .setScreenshots(true)
	   .setSnapshots(true)
	   .setSources(true).setTitle("sumit test report"));
		 
	 Page page1 = context1.newPage();
	 page1.navigate("https://edata.ndtv.com/coronavirus/table/india_table.html?shgraph=1&days=7");
  
	 Locator loc = page1.locator("//tbody/tr //td[@class='mid-state']/following-sibling::td[1]/p");
	 int total = loc.count();
	 
	 int sum=0;
	 //int data2=0;
	 for(int i=0;i<total;++i)
	 {
		 String text =loc.nth(i).textContent();
		 String data = text.replaceAll(",", "");
		int data2 = Integer.valueOf(data);
		 System.out.println(data2);
		sum=sum+data2;
		
		 
	 }
	System.out.println(sum);
	page1.navigate("https://www.amazon.in");
	page1.screenshot(new Page.ScreenshotOptions()
		      .setPath(Paths.get("screenshot.png")));
	page1.navigate("https://linkedin.com");
	try
	{
	page1.locator("//dd").click();
	}
	catch (Exception e)
	{
		
	}
	
	// page1.close();
	context1.tracing().stop(new Tracing.StopOptions()
			  .setPath(Paths.get("trace.zip")));
	context1.close();
	
	 
	
	
playwright.close();	
	
	
	
	
	
	
	
	
	
	
	
	}
		
		
		
 
	
	
	
	
	
}

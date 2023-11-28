package day10;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Day1 {

	
	public static void main(String[] args) {
		
			
	
	 Playwright playwright = 	Playwright.create();
	 LaunchOptions lp = new LaunchOptions();
	 lp.setChannel("chrome");
	 lp.setHeadless(false);
	 
	 Browser browser = playwright.chromium().launch(lp);
	 BrowserContext context1 = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true)
			  .setRecordVideoDir(Paths.get("videos/"))
			  .setRecordVideoSize(640, 480));
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
	page1.navigate("https://linkedin.com");
	// page1.close();
	context1.close();
	
	 File videoDirectory = new File("videos/");
     File[] videoFiles = videoDirectory.listFiles((dir, name) -> name.length()>25);

     String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yy_SSS"));
     System.out.println("Formatted Date: " + formattedDate);
     
     if (videoFiles != null && videoFiles.length > 0) {
         for (File videoFile : videoFiles) {
             File newVideoFile = new File(videoDirectory, "test"+formattedDate + ".mp4");
             videoFile.renameTo(newVideoFile);
         }

    }
	
	
playwright.close();	
	
	
	
	
	
	
	
	
	
	
	
	}
		
		
		
 
	
	
	
	
	
}

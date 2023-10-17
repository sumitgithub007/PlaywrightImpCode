package test.ProjectPlaywtight; 
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class CodeGen {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      page.navigate("https://formsmarts.com/html-form-example");
      page.pause();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create an Account Now")).click();
      page.getByPlaceholder("First name").click();
      page.getByPlaceholder("First name").fill("sumit");
      page.getByPlaceholder("Last name").click();
      page.getByPlaceholder("Last name").fill("goyal");
      page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).click();
      page.getByPlaceholder("Email", new Page.GetByPlaceholderOptions().setExact(true)).fill("goyalsumit322@gmail.com");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).click();
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("rss1234567");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).click();
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).click();
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("joa");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).press("CapsLock");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("joaM");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).press("CapsLock");
      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("joaM9jeerseeai#!");
      page.getByPlaceholder("Re-enter password").click();
      page.getByPlaceholder("Re-enter password").press("CapsLock");
      page.getByPlaceholder("Re-enter password").fill("J");
      page.getByPlaceholder("Re-enter password").press("CapsLock");
      page.getByPlaceholder("Re-enter password").fill("joa");
      page.getByPlaceholder("Re-enter password").press("CapsLock");
      page.getByPlaceholder("Re-enter password").fill("joaM");
      page.getByPlaceholder("Re-enter password").press("CapsLock");
      page.getByPlaceholder("Re-enter password").fill("joaM9jeerseeai#!");
      page.getByLabel("Select organization type:").selectOption("nonprofit");
      page.getByLabel("I agree to FormSmarts Terms.").check();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Account")).click();
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}
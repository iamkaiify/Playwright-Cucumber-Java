package utilities;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Driver {

    public static Page page;
    public static Browser browser;
    public static BrowserContext context;

    public static boolean isFailure = false;
    public static String path = "";


    public static void setUp() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        browser = chromium.launch(
                new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(500)
        );

//        if(isFailure){
//
//        }
        context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get(path))
                );
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
        );

        page = isFailure ? context.newPage() : browser.newPage();
        page.navigate("https://www.t-mobile.nl/");

        try {
            ElementHandle cookiesAccept = page.waitForSelector("//label[contains(text(), 'Ja')]");
//            page.onDialog(Dialog::accept);
            cookiesAccept.click();
        } catch (Exception e) {
            System.out.println("cookies accept dialog has not displayed");
        }
    }


}

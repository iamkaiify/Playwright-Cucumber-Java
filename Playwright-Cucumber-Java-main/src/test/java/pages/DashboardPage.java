package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import utilities.Driver;

public class DashboardPage {

    Page page;

    public DashboardPage() {
        this.page = Driver.page;
    }

    private String bundleStatus = "//div[@class='bundle-status-unit-value text-error']";
    private String getMbLink = "//a[@href='/my/aanvullers?nav=dashboard']";
    private String priceBundleBtn = "//button[@data-interaction-id='aanvullers_pricebundle']";

    public void renewMBs(int limit) {

        ElementHandle bundleStatusEl = page.waitForSelector(bundleStatus);
        bundleStatusEl.scrollIntoViewIfNeeded();

        int iend = bundleStatusEl.innerText().indexOf("MB");
        String bundleStatusTxt = bundleStatusEl.innerText().substring(0, iend+2).trim();

        if (Integer.parseInt(bundleStatusTxt) < limit) {
            page.click(getMbLink);
            page.click(priceBundleBtn);
        }
    }
}

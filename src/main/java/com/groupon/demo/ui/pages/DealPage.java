package com.groupon.demo.ui.pages;

import com.groupon.demo.ui.test.IUiITBase;
import com.groupon.mostest.mostaf.common.utils.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Deal page base page object
 *
 * @author edelarosaraymun
 */
public class DealPage extends GiftcloudUiBasePage {

    private final String STARS_LOCATOR = ".//span[contains(@class,'icon-star-filled')]";

    @FindBy(css = "#buy-link")
    private WebElement   buyButton;

    @FindBy(xpath = "//hgroup//h3[@class='ugc-star-ratings']")
    private WebElement   ratingsOnSubTitleSection;

    public DealPage(WebDriver driver, IUiITBase test) {
        super(driver, test);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(buyButton);
    }

    public void openNewUrl(String url) {
        navigateTo(url,true);
        getDriver().manage().deleteAllCookies();
    }

    public boolean isBuyButtonEnabled() {
        return buyButton.isEnabled();
    }

    public void clickBuyButton() {
        SystemUtils.sleep(2000);
        buyButton.click();
    }

    public boolean isBuyButtonVisible() {
        return buyButton.isDisplayed();
    }

    public String getBuyButtonText() {
        return buyButton.getText();
    }

    public boolean isRatingPresentOnSubTitleSection() {
        if (ratingsOnSubTitleSection.isDisplayed()) {
            return true;
        }
        return false;
    }

    public WebElement getRatingSectionOnSubtitleSection() {
        return ratingsOnSubTitleSection;
    }

    public boolean isRatingTextPresent(WebElement ratingSection) {
        WebElement ratingText = ratingSection.findElement(By.xpath(".//span[@class='star-rating-text']"));
        final String RATING_TEXT = "Ratings";

        if (ratingText.getText().contains(RATING_TEXT)) {
            return true;
        }
        return false;
    }

    public boolean evaluateRating(WebElement ratingSection, String ratingStars) {
        List<WebElement> listStars = ratingSection.findElements(By.xpath(STARS_LOCATOR));

        int rating = (int) Math.floor(Float.parseFloat(ratingStars));
        int fullStars = 0;
        // int halfStars = 0;
        for (WebElement star : listStars) {
            if (star.getAttribute("class").contains("full-star")) {
                fullStars++;
            } else if (star.getAttribute("class").contains("half-star")) {
                // halfStars++;
            }

        }

        if (rating == fullStars) {
            return true;
        }
        return false;
    }

    public boolean isNoThnxLinkVisible() {
        try {
            WebElement noThxLink = getDriver().findElement(By.id("nothx"));
            if (noThxLink.isEnabled()) {
                return true;
            } else {
                return false;
            }
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

}

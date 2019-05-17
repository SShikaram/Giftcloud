package com.groupon.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.groupon.demo.rest.client.UgcCoreClient;
import com.groupon.demo.rest.dto.SummaryUgcDto;
import com.groupon.demo.ui.pages.DealPage;
import com.groupon.demo.ui.test.UiITBase;
import com.groupon.mostest.mostaf.reporting.models.TestGroup;

public class ArtIT extends UiITBase {
    @Override
    @BeforeMethod(groups = TestGroup.CONFIG)
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test(groups = TestGroup.P0,
                    description = "Demo Test")
    public void test() {
        DealPage dealPage = new DealPage(getDriver(), this);
        dealPage.openNewUrl(getConfig().getArtDealId());
        dealPage.verify();
        dealPage.hidePopup();


        // Underneath the deal sub title there is a 5 star ratings widget
        Assert.assertTrue(dealPage.isRatingPresentOnSubTitleSection());
        // On the right side of the stars the "X ratings" text is available
        Assert.assertTrue(dealPage.isRatingTextPresent(dealPage.getRatingSectionOnSubtitleSection()));

        // The stars are coloured based on total number of stars (based on deal API data)
        UgcCoreClient client = new UgcCoreClient(getConfig().getUgcUrl());
        SummaryUgcDto summaryDto = client.getSummary(getConfig().getArtDealUuid(),
                                                     getConfig().getArtMerchantId());

        Assert.assertTrue(dealPage.evaluateRating(dealPage.getRatingSectionOnSubtitleSection(),
                                                  summaryDto.getRecommendation().getRating()));

    }

}

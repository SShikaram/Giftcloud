package com.groupon.demo.rest.dto;

import com.groupon.mostest.mostaf.rest.dto.RestDto;

/**
 * Dto that holds summary of UGC
 *
 * @author edelarosaraymun
 */
public class SummaryUgcDto extends RestDto {
    private RecommendationDto recommendation;

    public RecommendationDto getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(RecommendationDto recommendation) {
        this.recommendation = recommendation;
    }
}

package com.groupon.demo.rest.dto;

import com.groupon.mostest.mostaf.rest.dto.RestDto;

/**
 * Dto that holds information of recommendation on UGC summary
 *
 * @author edelarosaraymun
 */
public class RecommendationDto extends RestDto {
    private String positive;
    private String negative;
    private String total;
    private String percentage;
    private String prominentDisplay;
    private String rating;
    private String showToUser;

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getProminentDisplay() {
        return prominentDisplay;
    }

    public void setProminentDisplay(String prominentDisplay) {
        this.prominentDisplay = prominentDisplay;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getShowToUser() {
        return showToUser;
    }

    public void setShowToUser(String showToUser) {
        this.showToUser = showToUser;
    }
}

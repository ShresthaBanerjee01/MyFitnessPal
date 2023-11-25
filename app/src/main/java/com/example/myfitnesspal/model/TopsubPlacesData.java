package com.example.myfitnesspal.model;

public class TopsubPlacesData {
    String placeName,BestSeason,PlaceDes;
    Integer imageUrl;

    public TopsubPlacesData(String placeName, Integer imageUrl,String PlaceDes ,String BestSeason) {
        this.BestSeason= BestSeason;
        this.imageUrl = imageUrl;
        this.PlaceDes = PlaceDes;
        this.placeName = placeName;}
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    public String getPlaceDes() {
        return PlaceDes;
    }
    public void setPlaceDes(String PlaceDes) {
        this.PlaceDes =PlaceDes;
    }
    public String getBestSeason() {
        return BestSeason;
    }
    public void setBestSeason(String BestSeason) {
        this.BestSeason= BestSeason;
    }
    public Integer getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}

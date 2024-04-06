package com.example.myfitnesspal.model;

public class Hotel {
    private String placeName;
    private String hotelName;
    private String hotelAddress;
    private String phone;
    private String website;
    public Hotel(String placeName, String hotelName, String hotelAddress,String phone, String website) {
        this.placeName = placeName;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.phone = phone;
        this.website = website;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }
    public String getphone() {
        return phone;
    }
    public String getwebsite() {return website;
    }
}

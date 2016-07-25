package com.test.afedyanov.ntrlabtest.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr on 25.07.2016.
 */
public class Address {
    @SerializedName("additional_information")
    public String info = null;
    @SerializedName("zip")
    public String zip = null;
    @SerializedName("country")
    public String country = null;
    @SerializedName("region")
    public String region = null;
    @SerializedName("area")
    public String area = null;
    @SerializedName("city")
    public String city = null;
    @SerializedName("town")
    public String town = null;
    @SerializedName("street")
    public String street = null;
    @SerializedName("house")
    public String house = null;
    @SerializedName("case")
    public String addresCase = null;
    @SerializedName("apartment")
    public String apartment = null;
    @SerializedName("gps_lat")
    public Double latidude = null;
    @SerializedName("gps_lng")
    public Double longitude = null;
}

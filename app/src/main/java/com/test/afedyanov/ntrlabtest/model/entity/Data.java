package com.test.afedyanov.ntrlabtest.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alexandr on 25.07.2016.
 */
public class Data {
    @SerializedName("id")
    public Integer id = null;
    @SerializedName("name")
    public String name = null;
    @SerializedName("type")
    public String type = null;
    @SerializedName("date_opened")
    public String dateOpened = null;
    @SerializedName("date_closed")
    public String dateClosed = null;
    @SerializedName("phone")
    public String phone = null;
    @SerializedName("status")
    public String status = null;
    @SerializedName("products")
    public List<String> products = null;
    @SerializedName("address")
    public Address address = null;
}

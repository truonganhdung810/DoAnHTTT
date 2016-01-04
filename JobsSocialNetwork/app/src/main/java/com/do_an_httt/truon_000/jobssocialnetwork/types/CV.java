package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class CV {

    @SerializedName("email")
    public String email;

    @SerializedName("name")
    public String name;

    @SerializedName("job")
    public String job;

    @SerializedName("phone")
    public String phone;

    @SerializedName("address")
    public String address;

    @SerializedName("contact")
    public String contact;

    @SerializedName("education")
    public String education;

    @SerializedName("experience")
    public String experience;

    @SerializedName("skill")
    public String skill;
    public String other;

}

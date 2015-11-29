package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 11/25/2015.
 */
public class Job {

    @SerializedName("email")
    public String email;

    @SerializedName("enterprise")
    public String name_enterprise;

    @SerializedName("name")
    public String name;

    @SerializedName("date")
    public String date;

    @SerializedName("end_date")
    public String end_date;

    @SerializedName("domain")
    public String domain;

    @SerializedName("description")
    public String description;

    @SerializedName("requirement")
    public String requirement;

}

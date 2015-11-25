package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 11/25/2015.
 */
public class Enterprise {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("name")
    public String name;

    @SerializedName("established_date")
    public String established_date;

    @SerializedName("domain")
    public String domain;
}

package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 11/25/2015.
 */
public class Employee {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("birthday")
    public String birthday;

    @SerializedName("sex")
    public String sex;

    @SerializedName("name")
    public String name;
}

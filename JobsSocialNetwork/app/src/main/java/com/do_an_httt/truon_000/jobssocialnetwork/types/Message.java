package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 1/5/2016.
 */
public class Message {

    @SerializedName("sender")
    public String sender;

    @SerializedName("name")
    public String name;

    @SerializedName("receiver")
    public String receiver;

    @SerializedName("date")
    public String date;

    @SerializedName("job_info")
    public String job_info;

    public int id;

}

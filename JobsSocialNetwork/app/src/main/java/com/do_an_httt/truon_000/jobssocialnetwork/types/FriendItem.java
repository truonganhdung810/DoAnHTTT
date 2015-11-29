package com.do_an_httt.truon_000.jobssocialnetwork.types;

import com.google.gson.annotations.SerializedName;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class FriendItem {

    @SerializedName("avatar")
    public String urlAvatar;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("state")
    public int state;

}

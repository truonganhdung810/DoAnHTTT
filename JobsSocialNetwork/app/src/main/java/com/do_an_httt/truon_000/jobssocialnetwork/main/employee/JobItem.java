package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

/**
 * Created by truon_000 on 11/20/2015.
 */
public class JobItem {

    public String jobName, enterpriseName, time;
    public boolean isAdded;

    public JobItem(String job, String enterprise, String time, boolean isAdded) {

        jobName = job;
        enterpriseName = enterprise;
        this.time = time;
        this.isAdded = isAdded;

    }
}

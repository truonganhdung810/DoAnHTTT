package com.do_an_httt.truon_000.jobssocialnetwork;

import com.do_an_httt.truon_000.jobssocialnetwork.types.Applier;
import com.do_an_httt.truon_000.jobssocialnetwork.types.CV;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Employee;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Enterprise;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Message;

import java.util.ArrayList;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class ProjectManagement {

    public static final String BASE_URL = "http://167.114.82.228/job_social_network/";
    public static Employee employee;
    public static Enterprise enterprise;
    public static ArrayList<Job> alljobs;
    public static ArrayList<FriendItem> allfriends;
    public static String[] listDomainJobs = {"Bác sĩ", "Nhân viên bán hàng", "Marketing", "Kỹ sư máy tính", "Bất động sản", "Biên/phiên dịch", "Kỹ sư cơ khí",
            "Kỹ sư vận tải", "Chuyên viên tư vấn", "Kỹ sư viễn thông", "Kỹ sư xây dựng", "Nhân viên phục vụ"};
    public static Job jobDetail;
    public static ArrayList<Applier> allApplier;
    public static CV cvContent;
    public static String separator_string = "---";
    public static ArrayList<Message> listMessage;

}

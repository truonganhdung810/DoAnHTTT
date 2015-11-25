package com.example.nguyenhuungoc.connecttophp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nguyen Huu Ngoc on 8/15/2015.
 */
public class ConnectToPHP {
    static StringBuilder builder;

    /**
     * @param url
     * @param keys
     * @param values
     * @return String sent by PHP
     * @throws Exception
     */
    public static String connect(String url, ArrayList<String> keys, ArrayList<String> values) throws Exception {
        builder = new StringBuilder();
        URL urlGetProject = new URL(url);
        URLConnection connection = urlGetProject.openConnection();
        String data = URLEncoder.encode(keys.get(0), "UTF-8") + "=" + URLEncoder.encode(values.get(0), "UTF-8");
        for (int i = 1; i < keys.size(); i++) {
            data += "&" + URLEncoder.encode(keys.get(i), "UTF-8") + "=" + URLEncoder.encode(values.get(i), "UTF-8");
        }
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(data);
        writer.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        String strJson = builder.toString();
        return strJson;
    }

    /**
     * @param url
     * @param keys
     * @param values
     * @return String sent by PHP
     * @throws Exception
     */
    public static String connect(String url, String[] keys, String[] values) throws Exception {
        builder = new StringBuilder();
        URL urlGetProject = new URL(url);
        URLConnection connection = urlGetProject.openConnection();
        String data = URLEncoder.encode(keys[0], "UTF-8") + "=" + URLEncoder.encode(values[0], "UTF-8");
        for (int i = 1; i < keys.length; i++) {
            data += "&" + URLEncoder.encode(keys[i], "UTF-8") + "=" + URLEncoder.encode(values[i], "UTF-8");
        }
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(data);
        writer.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        String strJson = builder.toString();
        return strJson;
    }

    public static String connect(String url) throws Exception {
        builder = new StringBuilder();
        URL urlGetProject = new URL(url);
        URLConnection connection = urlGetProject.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        String strJson = builder.toString();
        return strJson;
    }
}

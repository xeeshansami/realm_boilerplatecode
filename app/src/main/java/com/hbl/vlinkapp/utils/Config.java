package com.hbl.vlinkapp.utils;

import okhttp3.logging.HttpLoggingInterceptor;

public class Config {
    public static final String BASE_URL_MAP = "";
    public static final String LIVE = "https://dob.hbl.com:7000/";
    public static final String RP_TEST = "https://rp.zeuscloudconnect.com:9131/";
    public static final String RP_TEST_BASE = "dapi/api/";
    public static final String RP_TEST_BASE2 = "dapi/api/v2/";
    public static final String LIVE_BASE1 = "api_m/api/";
    public static final String LIVE_BASE2 = "api_m/api/v2/";
    public static final String HOSTPOT = "http://10.9.167.204:9131/";
    public static final long API_CONNECT_TIMEOUT = 60;
    public static final long API_PDF_CONNECT_TIME_OUT = 60;
    public static final HttpLoggingInterceptor.Level LOG_LEVEL_API = HttpLoggingInterceptor.Level.BODY;
}

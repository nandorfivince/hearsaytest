package utils;

public class Config {

    private static final String DEFAULT_BASE_URL = "https://e8ovs90n8e.execute-api.us-west-2.amazonaws.com";

    static boolean isSecuredEnvironment() {
        return DEFAULT_BASE_URL.contains("https");
    }

    public static String getListUrl() {
        return DEFAULT_BASE_URL + "/test/sort";
    }

}

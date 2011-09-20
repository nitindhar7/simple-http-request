package com.simplehttprequest;

import java.util.Map;

import org.json.JSONObject;

public interface SimpleHttpRequest {

    /**
     * [GET] Request response given a url
     * 
     * @param url URL to request
     * @return JSON response
     */
    public JSONObject get(String url);
    /**
     * [GET] Request response given a url and parameter
     * 
     * @param url URL to request
     * @param param parameter to append to url
     * @return JSON response
     */
    public JSONObject get(String url, String param);
    /**
     * [GET] Request response given a url, a replacement string and a parameter
     * 
     * @param url URL to request
     * @param replacement regex to be replaced by param
     * @param param parameter to replace replacement
     * @return JSON response
     */
    public JSONObject get(String url, String replacement, String param);
    /**
     * [GET] Request response given a url and a map of parameters
     * 
     * @param url URL to request
     * @param params map of parameters to be stringified and appended to url
     * @return JSON response
     */
    public JSONObject get(String url, Map<String,String> params);

    /**
     * [POST] Request response given a url and a map of parameters
     * 
     * @param url URL to request
     * @param params map of parameters to be sent as post data
     * @return JSON response
     */
    public JSONObject post(String url, Map<String,String> params);

}

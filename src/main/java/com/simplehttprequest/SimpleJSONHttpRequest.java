package com.simplehttprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleJSONHttpRequest implements SimpleHttpRequest {

    public JSONObject get(String url) {
        return getData(url);
    }

    public JSONObject get(String url, String param) {
        return getData(url + "?" + param);
    }
    
    public JSONObject get(String url, String replacement, String param) {
        return getData(url.replace(replacement, param));
    }

    public JSONObject get(String url, Map<String, String> params) {
        return getData(url + "?" + stringifyArgs(params));
    }

    public JSONObject post(String url, Map<String,String> params) {
        return postData(url, params);
    }
    
    protected JSONObject getData(String requestURI) {
        String jsonResult = "";
        
        JSONObject json = null;

        try {
            URL url = new URL(requestURI);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                jsonResult += responseLine;
            }

            in.close();
            
            json = new JSONObject(jsonResult);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL requested");
        } catch (IOException e) {
            throw new RuntimeException("Could not read from requested stream");
        } catch (JSONException e) {
            throw new RuntimeException("JSON could not be formed");
        }
        
        return json;
    }
    
    protected JSONObject postData(String requestURI, Map<String,String> params) {
        String jsonResult = "";
        
        JSONObject json = null;

        try {
            URL url = new URL(requestURI);
            URLConnection urlConn = url.openConnection();
            urlConn.setDoOutput(true);
            
            OutputStreamWriter osw = new OutputStreamWriter(urlConn.getOutputStream());
            osw.write(stringifyArgs(params));
            osw.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                jsonResult += responseLine;
            }

            osw.close();
            in.close();
            
            json = new JSONObject(jsonResult);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL requested");
        } catch (IOException e) {
            throw new RuntimeException("Could not read from requested stream");
        } catch (JSONException e) {
            throw new RuntimeException("JSON could not be formed");
        }
        
        return json;
    }
    
    protected String stringifyArgs(Map<String,String> params) {
        StringBuilder argString = new StringBuilder();

        for(String key : params.keySet()) {
            argString.append(key);
            argString.append('=');
            argString.append(params.get(key));
            argString.append('&');
        }

        String stringifiedArgs = argString.toString();

        return stringifiedArgs.substring(0, stringifiedArgs.length() - 1);
    }

}

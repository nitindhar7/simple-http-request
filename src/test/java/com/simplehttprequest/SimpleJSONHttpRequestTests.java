package com.simplehttprequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class SimpleJSONHttpRequestTests {
    
    private SimpleHttpRequest http = new SimpleJSONHttpRequest();
    
    @Test (groups={"ready"})
    public void testGet() throws MalformedURLException {
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.get(url.toString());
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"toBeFixed"})
    public void testGetParamAppended() throws MalformedURLException {
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.get(url.toString(), "a=b");
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"toBeFixed"})
    public void testGetParamReplacement() throws MalformedURLException {
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.get(url.toString(), "?", "a");
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"toBeFixed"})
    public void testGetParams() throws MalformedURLException {
        Map<String,String> params = null;
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.get(url.toString(), params);
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"toBeFixed"})
    public void testPost() throws MalformedURLException {
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.post(url.toString(), null);
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"ready"})
    public void testGetData() {
        SimpleJSONHttpRequest http = new SimpleJSONHttpRequest();
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.getData(url.toString());
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"toBeFixed"})
    public void testPostData() {
        SimpleJSONHttpRequest http = new SimpleJSONHttpRequest();
        String sampleJSON = "{\"post\":{\"date\":\"2011/09/04\",\"user\":\"sample\"},\"user\":{\"age\":10,\"name\":\"sample\"}}";
        URL url = getClass().getClassLoader().getResource("sample_data.json");
        JSONObject sampleData = http.postData(url.toString(), null);
        
        TestCase.assertEquals(sampleJSON, sampleData.toString());
    }
    
    @Test (groups={"ready"})
    public void testStringifyArgs() {
        SimpleJSONHttpRequest http = new SimpleJSONHttpRequest();
        Map<String,String> args = new HashMap<String,String>();
        args.put("a", "1");
        args.put("b", "2");
        args.put("c", "3");
        
        TestCase.assertEquals("b=2&c=3&a=1", http.stringifyArgs(args));
    }

}

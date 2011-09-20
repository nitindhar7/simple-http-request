simple-http-request
===================
simple-http-request is a Java library that I use in my personal projects to help me retrieve JSON resources. Currently, I only retrieve responses
in JSON, but I'd like to abstract it enough so that any response is handled. This library is very simple and I'd like to keep it that way. Feel free
to customize the heck out of it in your own forked branch.

Android
-------
Android platform to be tested soon!

Build & Use
-----------
Each http method in this library is heavily commented. To begin, build simple-http-request and import it in your code

    $ ant

    import com.simplehttprequest;

    SimpleHttpRequest http = new SimpleJSONHttpRequest();

    // Request a resource via GET
    http.get("https://forrst.com/api/v2/stats")

    // Request a resource via GET by regex replacement
    http.get("http://api.dribbble.com/shots/?/rebounds", "?", 1);

    // Request a resource via POST
    Map<String,String> params = new HashMap<String,String>();
    params.put("email_or_username", USERNAME);
    params.put("password", PASSWORD);
    http.post("https://forrst.com/api/v2/users/auth", params);

Note that each library API endpoint returns a JSONObject. For more information on JSONObject visit [json.org/java](http://json.org/java/). The dependency json-java jar file is also included in the `lib` folder. Details for the rest of the available http methods are given inline.

Contribute
------------
Submit well documented code with unit tests and I will merge your changes in as long as your code does not break the build. Here are some things that need to be done:

- refactor and remove redundancy
- Return full json 
- add more http methods by functionality
- add more http methods by param type
- Decouple/refactor code
- Add some tests using optional params
- rename properties in buildfile
- "tobeFixed" tests

Authors
-------

My aim is to make ease the integration of JSON responses into Java applications. I have tried my best to provide in-code documentation for each method. Please help me find bugs.

- Nitin Dhar

  - Forrst: https://forrst.com/people/nitindhar7
  - Site: http://coding-sense.blogspot.com
  - Twitter: @nitin_dhar

Copyright
---------
Copyright (c) 2011 Nitin Dhar. See LICENSE for details.
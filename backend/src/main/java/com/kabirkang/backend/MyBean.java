package com.kabirkang.backend;

/**
 * The object model for the com.kabirkang.joketeller.data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}
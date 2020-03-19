
package com.example.hassan.quran.API_Response.Channel_Response;


import com.google.gson.annotations.SerializedName;



public class Radio {

    @SerializedName("Name")
    private String name;
    @SerializedName("URL")
    private String uRL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    @Override
    public String toString() {
        return "name="+name +"  "+ "url="+uRL;
    }
}


package com.example.hassan.quran.API_Response.Channel_Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RadioChannel {

    @SerializedName("Radios")
    private List<Radio> radios;

    public List<Radio> getRadios() {
        return radios;
    }

    public void setRadios(List<Radio> radios) {
        this.radios = radios;
    }

    @Override
    public String toString() {
      return radios.toString();
    }
}

package com.example.myapplication.Domains;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("name")
    private String cityName;

    @SerializedName("main")
    private Main main;

    public String getCityName() {
        return cityName;
    }

    public Main getMain() {
        return main;
    }

    public class Main {
        @SerializedName("temp")
        private float temperature;

        @SerializedName("humidity")
        private float humidity;

        public float getTemperature() {
            return temperature;
        }

        public float getHumidity() {
            return humidity;
        }
    }
}

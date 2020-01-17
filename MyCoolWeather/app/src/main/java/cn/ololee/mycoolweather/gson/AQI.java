package cn.ololee.mycoolweather.gson;

import com.google.gson.annotations.SerializedName;

public class AQI {
    public class AQICity{
        /*aqi*/
        public String aqi;
        /*pm2.5*/
        public String pm25;
        /*
        * AQI质量
        * */
        @SerializedName("qlty")
        public String quality;
    }
    public AQICity city;
}

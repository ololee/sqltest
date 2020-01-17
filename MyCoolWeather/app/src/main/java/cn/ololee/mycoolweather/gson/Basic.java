package cn.ololee.mycoolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {
    /*
    * 城市id*/
    @SerializedName("cid")
    public String cityId;
    /*
    *天气id
    * */
    @SerializedName("id")
    public String weatherId;

    @SerializedName("location")
    public String cityName;

    public Update update;
    /*
    *更新时间
    * */
    public class Update{
        @SerializedName("loc")
        public String localTime;
    }
}

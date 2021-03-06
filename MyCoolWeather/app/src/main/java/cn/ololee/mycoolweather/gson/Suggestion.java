package cn.ololee.mycoolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;
    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;
    /*
    * 舒适度*/
    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    /*
    * 洗车*/
    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    /*
    * 运动
    * */
    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}

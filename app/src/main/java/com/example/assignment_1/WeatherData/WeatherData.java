
package com.example.assignment_1.WeatherData;

import java.util.List;

public class WeatherData {

    private Double lat;
    private Double lon;
    private String timezone;
    private Integer timezoneOffset;
    private List<Daily> daily = null;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

}

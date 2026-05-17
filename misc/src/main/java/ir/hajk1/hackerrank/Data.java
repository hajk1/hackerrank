package ir.hajk1.hackerrank;

public class Data {

    String name;
    String weather;
    String wind;
    String humidity;

    public Data(String name, String weather, String wind, String humidity) {
        this.name = name;
        this.weather = weather;
        this.wind = wind;
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}

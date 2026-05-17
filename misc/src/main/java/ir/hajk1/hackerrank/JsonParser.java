package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static void main(String[] args) throws Exception {
        String json = "{\"page\":1,\"per_page\":10,\"total\":2,\"total_pages\":1,\"data\":[{\"name\":\"Qiongshan\",\"weather\":\"3 degree\",\"status\":[\"Wind: 31Kmph\",\"Humidity: 47%\"]},{\"name\":\"Mt. Everest\",\"weather\":\"-15 degree\",\"status\":[\"Wind: 45Kmph\",\"Humidity: 30%\"]}]}";

        int page = Integer.parseInt(getValue(json, "page"));
        int perPage = Integer.parseInt(getValue(json, "per_page"));
        int total = Integer.parseInt(getValue(json, "total"));
        int totalPages = Integer.parseInt(getValue(json, "total_pages"));

        List<Data> dataList = new ArrayList<>();
        int index = json.indexOf("data");
        int endIndex = json.indexOf("]}", index) + 2;
        String data = json.substring(index + 7, endIndex - 2);
        while (data.length() > 0) {
            String name = getValue(data, "name");
            String weather = getValue(data, "weather");

            String status = getValue(data, "status");
            String wind = status.substring(2, status.indexOf(",") - 1);
            String humidity = status.substring(status.indexOf(",") + 2, status.length() - 2);

            dataList.add(new Data(name, weather, wind, humidity));

            index = endIndex;
            endIndex = json.indexOf("]}", index) + 2;
            if (endIndex == 1) {
                break;
            }
            data = json.substring(index + 7, endIndex - 2);
        }

        System.out.println("Page: " + page);
        System.out.println("Per Page: " + perPage);
        System.out.println("Total: " + total);
        System.out.println("Total Pages: " + totalPages);
        for (Data d : dataList) {
            System.out.println("Name: " + d.getName());
            System.out.println("Weather: " + d.getWeather());
            System.out.println("Wind: " + d.getWind());
            System.out.println("Humidity: " + d.getHumidity());
        }
    }

    private static String getValue(String json, String key) {
        int index = json.indexOf(key) + key.length() + 3;
        int endIndex = json.indexOf(",", index);
        if (endIndex == -1) {
            endIndex = json.indexOf("]}", index) + 1;
        }
        if (json.charAt(index - 1) == '[') {
            return json.substring(index, endIndex);
        }
        endIndex = json.indexOf("\"", index);
        return json.substring(index - 1, endIndex - 1);
    }
}
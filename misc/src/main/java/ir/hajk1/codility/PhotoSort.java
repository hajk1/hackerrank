package ir.hajk1.codility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PhotoSort {

    public static void main(String[] args) throws ParseException {
        String inputFile = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
            + "Jay.png, London, 2015-06-20 15:13:22\n " +
            "myFriends.png, Warsaw, 2013-09-05 14:07:13\n "
            + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n " +
            "pisatower.jpg, Paris, 2015-07-22 23:59:59\n "
            + "BOB.jpg, London, 2015-08-05 00:02:03\n " +
            "notredame.png, Paris, 2015-09-01 12:00:00\n "
            + "me.jpg, Warsaw, 2013-09-06 15:40:22 \n" +
            "a.png, Warsaw, 2016-02-13 13:33:50 \n"
            + "b.jpg,Warsaw, 2016-01-02 15:12:22\n"
            + " c.jpg, Warsaw, 2016-01-02 14:34:30\n "
            + "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
            " e.png, Warsaw, 2016-01-02 09:49:09\n "
            + "f.png, Warsaw, 2016-01-02 10:55:32\n "
            + "g.jpg, Warsaw, 2016-02-29 22:13:11";
        String inputFile2 = "photo.jpg, Tehran, 2022-09-05 14:08:15\n"
            + "Jay.png, Tehran, 2015-06-20 15:13:22\n " +
            "myFriends.png, Tehran, 2013-09-05 14:07:13\n "
            + "Eiffel.jpg, Tehran, 2015-07-23 08:03:02\n " +
            "pisatower.jpg, Tehran, 2015-07-22 23:59:59\n "
            + "BOB.jpg, Rasht, 2015-08-05 00:02:03\n " +
            "notredame.png, Tehran, 2015-09-01 12:00:00\n "
            + "me.jpg, Tehran, 2013-09-06 15:40:22 \n" +
            "a.png, Tehran, 2016-02-13 13:33:50 \n"
            + "b.jpg,Rasht, 2016-01-02 15:12:22\n"
            + " c.jpg, Tehran, 2016-01-02 14:34:30\n "
            + "d.jpg, Tehran, 2016-01-02 15:15:01\n" +
            " e.png, Tehran, 2016-01-02 09:49:09\n "
            + "f.png, Tehran, 2000-01-01 10:55:32\n "
            + "g.jpg, Tehran, 2000-01-01 10:55:31";

        System.out.println(
            "new PhotoSort().solution(input) = " + new PhotoSort().solution(inputFile));
        System.out.println("new PhotoSort().solution(input) = " + new PhotoSort().solution(""));
        System.out.println("new PhotoSort().solution(input) = " + new PhotoSort().solution(null));
        System.out.println(
            "new PhotoSort().solution(input) = " + new PhotoSort().solution(inputFile2));
    }

    String solution(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, SortedSet<Photo>> phMap = new HashMap<>();

        int counter = 0;
        for (String st : input.split(System.lineSeparator())) {
            String[] parts = st.split(",");
            String fullName = parts[0].trim();
            String name = fullName.substring(0, fullName.lastIndexOf('.'));
            String ext = fullName.substring(fullName.lastIndexOf('.'));
            String city = parts[1].trim();
            String dateStr = parts[2].trim();
            Photo photo;
            try {
                photo = new Photo(name, ext, parser.parse(dateStr), counter, city);
                if (phMap.get(city) == null) {
                    phMap.put(city, new TreeSet<>());
                }
                phMap.get(city).add(photo);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        Photo[] list = new Photo[counter];

        for (String key : phMap.keySet()) {
            int counter2 = 1;
            int maxDigit = String.valueOf(phMap.get(key).size()).length();
            for (Photo photo : phMap.get(key)) {
                photo.setNewIndex(String.format("%0" + maxDigit + "d", counter2));
                list[photo.getIndex()] = photo;
                counter2++;
            }
        }
        return Arrays.stream(list).
            peek(n -> System.out.println("n = " + n))
            .map(n -> n.getFinalName())
            .collect(Collectors.joining("\n"));
    }

    class Photo implements Comparable<Photo> {

        String fileName;
        String ext;
        Date date;
        Integer index;
        String newIndex;

        String city;

        public Photo(String fileName, String ext, Date date, Integer index, String city) {
            this.fileName = fileName;
            this.ext = ext;
            this.date = date;
            this.index = index;
            this.city = city;
        }

        public String getFileName() {
            return fileName;
        }

        public String getExt() {
            return ext;
        }

        public Date getDate() {
            return date;
        }

        public Integer getIndex() {
            return index;
        }

        public String getNewIndex() {
            return newIndex;
        }

        public void setNewIndex(String newIndex) {
            this.newIndex = newIndex;
        }

        public String getCity() {
            return city;
        }

        public String getFinalName() {
            return getCity() + getNewIndex() + getExt();
        }

        @Override
        public int compareTo(Photo o) {
            return this.date.compareTo(o.getDate());
        }

        @Override
        public String toString() {
            return getFinalName();
        }
    }
}
    /*
Warsaw02.jpg
London1.png
Warsaw01.png
Paris2.jpg
Paris1.jpg
London2.jpg
Paris3.png
Warsaw03.jpg
Warsaw09.png
Warsaw07.jpg
Warsaw06.jpg
Warsaw08.jpg
Warsaw04.png
Warsaw05.png
Warsaw10.jpg
     */

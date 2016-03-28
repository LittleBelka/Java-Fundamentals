package com.epam.littleBelka.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {

    private StringBuilder str = new StringBuilder();

    public void record(String message) {

        if (message != null && !message.equals("")) {
            long curTime = System.currentTimeMillis();
            String curStringDate = new SimpleDateFormat("dd-MM-YYYY:hh-mm").format(curTime);
            str.append(curStringDate + "-" + message + ";");
        }
    }

    public ArrayList<String> findMessageByDate(String date) {

        if (date != null && !date.equals("")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
            formatter.setLenient(false);
            try {
                ArrayList<String> list = new ArrayList<>();
                formatter.parse(date);
                boolean bol = true;
                StringBuilder str2 = new StringBuilder(str.substring(0, str.length()));
                while (bol) {
                    Pattern pattern = Pattern.compile(date);
                    Matcher mat = pattern.matcher(str2);
                    if (mat.find()) {
                        int index = mat.start();
                        int indexEnd = str2.indexOf(";", index);
                        list.add(str2.substring(index + 17, indexEnd));
                        str2 = str2.delete(index, indexEnd);
                    } else {
                        bol = false;
                    }
                }
                if (list.size() > 0) {
                    return list;
                }
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public ArrayList<String> findMessageByDateTime(String date) {

        if (date != null && !date.equals("")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY:hh-mm");
            formatter.setLenient(false);
            try {
                ArrayList<String> list = new ArrayList<>();
                formatter.parse(date);
                boolean bol = true;
                StringBuilder str2 = new StringBuilder(str.substring(0, str.length()));
                while (bol) {
                    Pattern pattern = Pattern.compile(date);
                    Matcher mat = pattern.matcher(str2);
                    if (mat.find()) {
                        int index = mat.start();
                        int indexEnd = str2.indexOf(";", index);
                        list.add(str2.substring(index + 17, indexEnd));
                        str2 = str2.delete(index, indexEnd);
                    } else {
                        bol = false;
                    }
                }
                if (list.size() > 0) {
                    return list;
                }
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public StringBuilder getStr() {
        return str;
    }

}

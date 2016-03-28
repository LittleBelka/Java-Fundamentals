package com.epam.littleBelka.task3;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingDocument {

    Reader file = null;
    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> findPictures() throws FileNotFoundException, UnsupportedEncodingException {

        file = new InputStreamReader(new FileInputStream("Java.SE.03.Information handling_task_attachment.html"),"Cp1251");
        int i = 0;
        try {
            String str = "";
            boolean bol = false;
            while ((i = file.read()) != -1) {
                char ch = (char) i;
                if (bol && ch != "<".charAt(0)) {
                    str = str + ch;
                }
                if (ch == ">".charAt(0)) {
                    bol = true;
                }
                if (ch == "<".charAt(0)) {
                    if (str.length() > 3) {
                        parseString(str);
                    }
                    str = "";
                    bol = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parseString(String str) {

        boolean b = true;
        while (b) {
            Pattern pattern = Pattern.compile("([Рр]ис\\.)|([Рр]исунк([еа]|ах))");
            Matcher mat = pattern.matcher(str);
            if (mat.find()) {

                int index = mat.start();
                Pair<String, Integer> pairBegin = findBeginSentence(index, str);
                str = pairBegin.getKey();
                index = pairBegin.getValue();

                Pair<Character, Integer> pairEnd = findEndSentence(index, str, false);
                int indexEnd = pairEnd.getValue();
                char ch = pairEnd.getKey();
                if (indexEnd != -1 && str.length() > 7) {
                    int indTmp = indexEnd;
                    boolean inEnd = true;
                    while (inEnd) {
                        if (str.substring(indTmp - 3, indTmp).equals("Рис") || str.substring(indTmp - 3, indTmp).equals("рис")){
                            indexEnd = indTmp;
                            Pair<Character, Integer> pairEnd2 = findEndSentence(indTmp + 1, str , true);
                            indTmp = pairEnd2.getValue();
                            if (indTmp == -1) {
                                inEnd = false;
                            }
                        }else{
                            indexEnd = indTmp;
                            inEnd = false;
                        }
                    }
                }
                if (indexEnd == -1) {
                    indexEnd = str.length() - 1;
                }
                list.add(str.substring(0, indexEnd + 1));
                if (indexEnd != str.length() - 1) {
                    str = str.substring(indexEnd + 2, str.length());
                } else {
                    b = false;
                }
            } else {
                b = false;
            }
        }
    }

    private Pair<String, Integer> findBeginSentence (int index, String str) {

        int indexPointTmp;
        int indexPointTmp1;
        int indexPointTmp2;
        int indexPoint;
        boolean ind = true;
        while (ind) {
            indexPointTmp = str.indexOf(".");
            indexPointTmp1 = str.indexOf("!");;
            indexPointTmp2 = str.indexOf("?");
            if (indexPointTmp < index && indexPointTmp1 < index && indexPointTmp2 <index) {
                indexPointTmp = Math.max(indexPointTmp, Math.max(indexPointTmp1, indexPointTmp2));
            } else if (indexPointTmp < index && indexPointTmp1 < index) {
                indexPointTmp = Math.max(indexPointTmp, indexPointTmp1);
            } else if (indexPointTmp1 < index && indexPointTmp2 <index) {
                indexPointTmp = Math.max(indexPointTmp1, indexPointTmp2);
            } else if (indexPointTmp < index && indexPointTmp2 <index) {
                indexPointTmp = Math.max(indexPointTmp, indexPointTmp2);
            }
            if (indexPointTmp != -1 && indexPointTmp < index) {
                indexPoint = indexPointTmp;
                index = index - indexPoint;
                str = str.substring(indexPointTmp + 1, str.length());
            } else {
                ind = false;
            }
        }
        Pair<String, Integer> pair = new Pair<>(str, index);
        return pair;
    }

    private Pair<Character, Integer> findEndSentence (int index, String str, boolean bol) {

        int indexEnd = str.indexOf(".", index + 4);
        if (bol) { indexEnd = str.indexOf(".", index); }
        int indexEnd1 = str.indexOf("!", index);
        int indexEnd2 = str.indexOf("?", index);
        char ch = '.';
        if (indexEnd != -1 && indexEnd1 != -1 && indexEnd2 != -1) {
            if (indexEnd > indexEnd1 && indexEnd > indexEnd2) {
                ch = '.';
            } else if (indexEnd1 > indexEnd && indexEnd1 > indexEnd2) {ch = '!'; }
            else if (indexEnd2 > indexEnd && indexEnd2 > indexEnd1) {ch = '?'; }
            indexEnd = Math.max(indexEnd, Math.max(indexEnd1, indexEnd2));
        } else if (indexEnd != -1 && indexEnd1 != -1) {
            if (indexEnd > indexEnd1) {
                ch = '.';
            } else ch = '!';
            indexEnd = Math.max(indexEnd, indexEnd1);
        } else if (indexEnd1 != -1 && indexEnd2 != -1) {
            if (indexEnd1 > indexEnd2) {
                ch = '!';
            } else ch = '?';
            indexEnd = Math.max(indexEnd1, indexEnd2);
        } else if (indexEnd != -1 && indexEnd2 != -1) {
            if (indexEnd > indexEnd2) {
                ch = '.';
            } else ch = '?';
            indexEnd = Math.max(indexEnd, indexEnd2);
        } else if (indexEnd1 != -1) {
            ch = '!';
            indexEnd = indexEnd1;
        } else if (indexEnd2 != -1) {
            ch = '?';
            indexEnd = indexEnd2;
        }
        Pair<Character, Integer> pair = new Pair<>(ch, indexEnd);
        return pair;
    }

    public boolean serialLinksToPictures() throws FileNotFoundException, UnsupportedEncodingException {

        file = new InputStreamReader(new FileInputStream("Java.SE.03.Information handling_task_attachment.html"),"Cp1251");
        int i = 0;
        int k = 1;
        boolean link = true;
        int number = -1;
        int numberTmp = -1;
        try {
            String str = "";
            boolean bol = false;
            while ((i = file.read()) != -1) {
                char ch = (char) i;
                if (bol && ch != ">".charAt(0)) {
                    str = str + ch;
                }
                if (ch == ">".charAt(0)) {
                    if (k == 1) {
                        number = parseImg(str);
                    }
                    numberTmp = parseImg(str);
                    if (number != -10 && numberTmp != -10 && numberTmp != number + 1) {
                        link = false;
                    }
                    number = numberTmp;
                    k--;
                    str = "";
                    bol = false;
                }
                if (ch == "<".charAt(0)) {
                    bol = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return link;
    }

    private int parseImg(String str) {

        boolean b = true;
        while (b) {
            Pattern pattern = Pattern.compile("files\\/pic\\d+\\.(jpg)|(JPG)");
            Matcher mat = pattern.matcher(str);
            if (mat.find()) {
                str = mat.group();
                Pattern pattern1 = Pattern.compile("\\d+");
                Matcher mat1 = pattern1.matcher(str);
                if (mat1.find()) {
                    int number = Integer.parseInt(mat1.group());
                    return number;
                }
                return -1;
            } else {
                b = false;
            }
        }
        return -10;
    }

}

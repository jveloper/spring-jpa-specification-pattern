package dev.jveloper.springjavaspecifications.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {


    public static Date stringToDate(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {

            if (dateString == null){
                return null;
            }
            else{
                return sdf.parse(dateString);
            }


        } catch(ParseException e) {
            return null;
        }
    }

}

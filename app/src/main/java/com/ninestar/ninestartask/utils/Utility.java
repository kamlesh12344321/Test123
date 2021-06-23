package com.ninestar.ninestartask.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
 public static String dateFormating(String dateString){
     String dateFormate = "dd MMMM yyyy";

     @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormate);
     Date date = new Date();
     try{
        date = simpleDateFormat.parse(dateString);
     } catch (ParseException e){
         e.printStackTrace();
     }
     return date.toString();
 }
}

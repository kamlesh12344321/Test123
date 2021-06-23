package com.ninestar.ninestartask.utils;

import android.annotation.SuppressLint;

import androidx.room.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ninestar.ninestartask.utils.Constants.DATE_FORMAT;

public class Utility {

 public static final String getDate1(String timeStamp){
     String finalOutPut = "";
     if (timeStamp != null && !timeStamp.isEmpty()){
         String[] partedString = timeStamp.split("T");
         String date = partedString[0];
         final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
         finalOutPut = format.format(Date.parse(date));
     }
     return finalOutPut;
 }
 public static final String getAuthorString(List<String> authorArray){
     String authorString = "";
     for (String author : authorArray){
         authorString = authorString + author + ", ";
     }
     return authorString;
 }
}

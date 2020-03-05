package com.em.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class DateCommonUtils {
    public static void main(String[] args) {
        getEchartTimeList(null,null,"yyyy-MM-dd HH:mm:ss","yyyy Year MM Month dd day HH:mm:ss",5);
    }
    public static List<String> getEchartTimeList(String startTime,String endTime,String format1,String format2,Integer type){
        SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
        Integer diff = 0;
        if(type==1){//Subtraction of years
            diff=7;//Default within 7 years
            }else if(type==2){//Subtraction of months
                diff=30;//Default within 30 days
                }else if(type==3){//Subtraction of days
                    diff=7;//Default within 7 days
                    }else if(type==4){//hours
                        diff=24;//Default within 24 hours
                        }else if(type==5){//mins
                            diff=60;//Default within 60 mins
                        }
                        if(startTime==null||startTime.equals("")){
                            startTime = sdf1.format(getDiffTime( sdf1.format(new Date()), -diff, format1, type));
                        }
                        if(endTime==null||endTime.equals("")){
                            endTime = sdf1.format(getDiffTime(startTime, diff, format1, type));
                        }
                        List<String> rs = new ArrayList<String>();
                        String tmp = startTime;
                        rs.add(castTimeSdf(sdf1,sdf2,tmp));
                        while(true){
                            if(tmp.compareTo(endTime)<0){
                                String tmp2 = castTimeSdf(sdf1,sdf2,tmp);
                                if(checkIsIn(rs,tmp2)==false){
                                    rs.add(tmp2);
                                }
                                tmp =  sdf1.format(getDiffTime( tmp, 1, format1, type));
                                }else{
                                    break;
                                }
                            }
                            if(checkIsIn(rs,endTime)==false){
                                rs.add(castTimeSdf(sdf1,sdf2,endTime));
                            }
                            return rs;
                        }
                        /**
                        * Convert time format
                        * @param sdf1
                        * @param sdf2
                        * @param date
                        * @return
                        */
                        public static String castTimeSdf(SimpleDateFormat sdf1 ,SimpleDateFormat sdf2,String date){
                            Date d = null;
                            try {
                                d=sdf1.parse(date);
                                } catch (ParseException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                if(d==null){
                                    return "";
                                }
                                return sdf2.format(d);
                            }
                            private static boolean checkIsIn(List<String> list,String str){
                                boolean flag=false;
                                for(String s:list){
                                    if(s.equals(str)){
                                        flag=true;
                                        break;
                                    }
                                }
                                return flag;
                            }
                            /**
                           Get the date after a certain date plus such units of time
                            */
                            public static Date getDiffTime(String date,Integer diff,String format1,Integer type){
                                SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
                                Date d = null;
                                try {
                                    d = sdf1.parse(date);
                                    } catch (ParseException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                    if(d==null){
                                        return null;
                                    }
                                    Calendar date2 = Calendar.getInstance();
                                    date2.setTime(d);
                                    if(type==1){//plus or minus of years
                                        date2.add(Calendar.YEAR, diff);
                                        }else if(type==2){//plus or minus of months
                                            date2.add(Calendar.MONTH, diff);
                                            }else if(type==3){//plus or minus of days
                                                date2.add(Calendar.DATE, diff);
                                                }else if(type==4){//plus or minus of hours
                                                    date2.add(Calendar.HOUR_OF_DAY, diff);
                                                    }else if(type==5){//plus or minus of minutes
                                                        date2.add(Calendar.MINUTE, diff);
                                                    }
                                                    return date2.getTime();
                                                }
                                            }

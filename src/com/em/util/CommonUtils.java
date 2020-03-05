package com.em.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class CommonUtils {

	/**
	 * Calculate how many days / minutes / hours / months / years of the event 
	 * plus the time based on the incoming date
	*/
	public static String getDiffDate(String date,int time,SimpleDateFormat df,Integer timeType){
		Date d =null;
		try {
			d=df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar calendar=Calendar.getInstance();   
		calendar.setTime(d); 
		if(timeType==1){//minute
			calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+time);//minute
		}else if(timeType==2){//hour
			calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)+time);//Add dates to days
		}else if(timeType==3){//day
			calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+time);//Add dates to days	
		}else if(timeType==4){//month
			calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+time);//Add dates to days	
		}else if(timeType==5){//year
			calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+time);//Add dates to days	
		}
		   return df.format(calendar.getTime());
	}
	
	
	// shuffle
    public static <T> void shuffle(List<T> list) {
        int size = list.size();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            // Get random locations
            int randomPos = random.nextInt(size);
            // Swap the current element with a random element
            Collections.swap(list, i, randomPos);
        }
    }
    
    /**
    	Check if the data items are the same
    **/
    private boolean  checkIsEqual(String str,String str2){
		if(str==null||str2==null){
			return false;
		}
		String [] split1 = str.split(",");
		String [] split2 = str2.split(",");
		boolean isCompete=true;
		for(String tmp:split2){
			if(str.contains(tmp+",")==false&&str.contains(","+tmp)==false&&str.equals(""+tmp)==false){
				isCompete=false;
				break;
			}
		}
		boolean isCompete2=true;
		for(String tmp:split1){
			if(str2.contains(tmp+",")==false&&str2.contains(","+tmp)==false&&str2.equals(""+tmp)==false){
				isCompete2=false;
				break;
			}
		}	
		return isCompete&&isCompete2;
	}
	  /**
    	Check if str contains all data items of str2
    **/
	private boolean  checkIsContain(String str,String str2){
		if(str==null||str2==null){
			return false;
		}
		String [] split = str2.split(",");
		boolean isCompete=true;
		for(String tmp:split){
			if(str.contains(tmp+",")==false&&str.contains(","+tmp)==false&&str.equals(""+tmp)==false){
				isCompete=false;
				break;
			}
		}
		return isCompete;
	}
	
		/**
     * Transform the properties and values in the Object into a Map object
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value=null;
			try {
				value = field.get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            map.put(fieldName, value);
        }
        return map;
    }
    
    
    public static String coverToShowTime(String timeStr, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date updateTime = null;
		try {
			updateTime = sf.parse(timeStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time = (System.currentTimeMillis() - updateTime.getTime()) / 1000;
		// Less than 60 seconds show "just now"
		String result = sf.format(updateTime);
		long temp = 0;
		if (time < 60) {
			result = "Just Now";
			// Display xxx min ago when less than 60 mins.
		} else if ((temp = time / 60) < 60) {
			result = temp + "minutes ago";
			// Display xxx hours ago when less than 24 hours.
		} else if ((temp = time / (60 * 60)) < 24) {
			result = temp + "hours ago";
			// Display xxx days ago when less than 7 days.
		} else if ((temp = time / (86400)) < 7) {
			result = temp + "days ago";
			// Display xxx weeks ago when less than 14 days but more than 7 days.
		} else if ((temp = time / (86400 * 7)) < 2) {
			result = temp + "weeks ago";
		} else {
			result = timeStr;
		}
		return result;
	}
	
	
	public static String hideStr(String str,Integer preStrNum,Integer laterStrNum,String replaceStr){
		replaceStr = replaceStr+replaceStr+replaceStr+replaceStr+replaceStr+replaceStr;
		return str.replaceAll("([\\s\\S]{"+preStrNum+"})[\\s\\S]+([\\s\\S]{"+laterStrNum+"})","$1"+replaceStr+"$2");
	}
	
	
		private static char [] numlist = new char[]{'0','1','2','3','4','5','6','7','8','9'};
	private static char [] specialWord=new char []{' ',',','.','-','_','+',':','~','/','，','	','(',')',';','：','；','[','【',']','】','、'};
	/**
	 * Check if there is a contact in the characters
	 * @param str
	 * @return
	 */
	public static boolean checkHasConnectMsg(String str){
		char[] chars = str.toCharArray();
		int num=0;
		for(int i=0;i<chars.length;i++){
			boolean isCompete=false;
			for(char str2:numlist){
				if(str2==chars[i]){
					num++;
					isCompete=true;
					break;
				}
			}
			boolean isSpecial=false;
			for(char str2:specialWord){
				if(str2==chars[i]){
					isSpecial=true;
					break;
				}
			}
			if(isCompete==false&&isSpecial==false){
				num=0;
			}
			if(num>5){//Greater than 5 consecutive numbers
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pagination based on the returned list
	 * @param list
	 * @param maxNum
	 * @param perNum
	 * @return
	 */
	public static List<List> splitList(List list,int maxNum,int perNum){
		List<List> list2 = new ArrayList<List>();
		List<Object> list3 = PageUtils.getCurrentPageList(list, 1, maxNum);
		int totalPage =0;
		if(list.size()>0){
			if(list.size()%perNum==0){
				totalPage = list3.size()/perNum;	
			}else{
				totalPage = list3.size()/perNum+1;
			}
		}
		//1页  0~3
		//2  4-7
		//3 8-11
		for(int i=1;i<=totalPage;i++){
			if(list3.size()<((i)*perNum)){
				List<Object> tmp = new ArrayList<Object>();
				tmp.addAll(list3.subList((i-1)*perNum, list3.size()));
				list2.add(tmp);
			}else{
				List<Object> tmp = new ArrayList<Object>();
				tmp.addAll(list3.subList((i-1)*perNum, (i-1)*perNum+(perNum)));
				list2.add(tmp);
			}
		}
		return list2;
	}
}

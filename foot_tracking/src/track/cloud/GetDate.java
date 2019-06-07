package track.cloud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate{
	public static String getDate(String s) throws ParseException{
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0,4));
		sb.append("/");
		sb.append(s.substring(4,6));
		sb.append("/");
		sb.append(s.substring(6,s.length()));
		SimpleDateFormat df = new SimpleDateFormat( "yyyy/MM/dd" );  
		Date d = df.parse(sb.toString());
		df.applyPattern( "EEE" );  
        String day= df.format(d); 
        
        String date = null;
        switch(day){
        case "1":
        	date = "Mon";break;
        case "2":
        	date = "Tue";break;
        case "3":
        	date = "Wed";break;
        case "4":
        	date = "Thu";break;
        case "5":
        	date = "Fri";break;
        case "6":
        	date = "Sat";break;
        case "7":
        	date = "Sun";break;

        }
        
        return date;
	}
}
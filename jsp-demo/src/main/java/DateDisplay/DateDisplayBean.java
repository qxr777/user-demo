package DateDisplay;
import java.util.*;

public class DateDisplayBean {

	private int counter=0;
	private String dateString=null;
	
	public DateDisplayBean(){
	//super();
	dateString=buildDateString(new GregorianCalendar());
	counter=0;
	}

	private String buildDateString(GregorianCalendar gcalendar){
	StringBuffer dateStr=new StringBuffer();
	dateStr.append(gcalendar.get(Calendar.DATE));
	dateStr.append("/");
	dateStr.append(gcalendar.get(Calendar.MONTH)+1);
	dateStr.append("/");
	dateStr.append(gcalendar.get(Calendar.YEAR));
	return(dateStr.toString());
	}


	public int getCounter(){
	return counter;
	}


	public void setCounter(int newCounter){
	counter=newCounter;
	}


	public java.lang.String getDateString(){
	counter++;
	return dateString;
	}
	}


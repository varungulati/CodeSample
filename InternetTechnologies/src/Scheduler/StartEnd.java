package Scheduler;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class StartEnd {
	private String start;
	private String end;
	private Calendar startCal = null;
	private Calendar endCal = null;
	public StartEnd() {
	}
	public void setStart(String start) {
		this.start = start;
		this.startCal = Calendar.getInstance();
		startCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(start.split(":")[0]));
		startCal.set(Calendar.MINUTE, Integer.parseInt(start.split(":")[1]));
		startCal.set(Calendar.SECOND, Integer.parseInt(start.split(":")[2]));
	}
	public void setStartCal(Calendar startCal) {
		this.startCal = startCal;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		this.start = sdf.format(this.startCal.getTime());
	}
	public void setEnd(String end) {
		this.end = end;
		endCal = Calendar.getInstance();
		endCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(end.split(":")[0]));
		endCal.set(Calendar.MINUTE, Integer.parseInt(end.split(":")[1]));
		endCal.set(Calendar.SECOND, Integer.parseInt(end.split(":")[2]));
	}
	public void setEndCal(Calendar endCal) {
		this.endCal = endCal;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		this.end = sdf.format(this.endCal.getTime());
	}
	public String getStart() {
		return this.start;
	}
	public String getEnd() {
		return this.end;
	}
	public Calendar getStartCal() {
		return this.startCal;
	}
	public Calendar getEndCal() {
		return this.endCal;
	}
}

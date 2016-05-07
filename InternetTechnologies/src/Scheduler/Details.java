package Scheduler;
import java.util.ArrayList;


public class Details {
	private String day;
	private ArrayList<StartEnd> startend = new ArrayList<StartEnd>();
	public Details(String day) {
		this.day = day;
	}
	public String getDay() {
		return this.day;
	}
	public void addStartEnd(StartEnd startEnd) {
		startend.add(startEnd);
	}
	public ArrayList<StartEnd> getStartEnd() {
		return this.startend;
	}
}
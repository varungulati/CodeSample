package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.xml.stream.XMLStreamException;

public class Scheduler {
	private URLList xmlUrls;
	private Schedule[] scheduleList;
	private static final String[] DAYS = {
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday",
		"Sunday"
	};
	public Scheduler(String URLListXML) throws Exception {
		this.xmlUrls = new URLList(URLListXML);
		this.scheduleList = new Schedule[xmlUrls.getNumURLs()];
		for(int i = 0; i < scheduleList.length; i++) {
			try {
				scheduleList[i] =  new Schedule(xmlUrls.getURL(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public long getScheduleDuration(StartEnd startEnd) {
		return startEnd.getEndCal().getTimeInMillis()/1000 - startEnd.getStartCal().getTimeInMillis()/1000;
	}
	public void getMeetingTime(long duration) {
		for(String s: Scheduler.DAYS) {
			System.out.println(getMeetingTimeHelper(
					this.scheduleList,
					duration,
					s,
					new StartEnd(),
					"**Group can't meet on " + s + ".**"));
		}
	}
	public String getMeetingTimeHelper(
			Schedule[] scheduleList, long duration, String day, StartEnd possibleSol, String toReturn) {
		if(scheduleList.length == 0) {
			return "**Meeting scheduled for a minimum of  " + duration + " on "+ day + " from " +
					possibleSol.getStart() + " to " + possibleSol.getEnd() + ".**";
		}
		ArrayList<Details> scheduleDetails = scheduleList[0].getScheduleDetails();
		for(int i = 0; i < scheduleDetails.size(); i++) {
			if(!scheduleDetails.get(i).getDay().equals(day)) {
				continue;
			}
			for(StartEnd se: scheduleDetails.get(i).getStartEnd()) {
				if(getScheduleDuration(se) < duration) {
					continue;
				}
				if(possibleSol.getStartCal() == null) {
					possibleSol.setStartCal(se.getStartCal());
				}
				if(possibleSol.getEndCal() == null) {
					possibleSol.setEndCal(se.getEndCal());
				}
				if(possibleSol.getEndCal().getTime().compareTo(se.getStartCal().getTime()) < 0) {
					continue;
				}
				if(possibleSol.getStartCal().getTime().compareTo(se.getEndCal().getTime()) > 0) {
					continue;
				}
				Calendar lo = null, hi = null;

				if(possibleSol.getStartCal().getTime().compareTo(se.getStartCal().getTime()) <= 0) {
					lo = se.getStartCal();
				} else {
					lo = possibleSol.getStartCal();
				}
				if(possibleSol.getEndCal().getTime().compareTo(se.getEndCal().getTime()) >= 0) {
					hi = se.getEndCal();
				} else {
					hi = possibleSol.getEndCal();
				}

				if((hi.getTimeInMillis()/1000 - lo.getTimeInMillis()/1000) < duration) {
					continue;
				}
				toReturn = getMeetingTimeHelper(
						Arrays.copyOfRange(scheduleList, 1, scheduleList.length - 1),
						duration, day, possibleSol, toReturn);
			}
		}
		return toReturn;
	}
	public static String printAllSchedules(String URLListXML) throws Exception {
		URLList xmlUrls = new URLList(URLListXML);
		Schedule[] scheduleList = new Schedule[xmlUrls.getNumURLs()];
		StringBuffer toReturn = new StringBuffer();
		for(int i = 0; i < scheduleList.length; i++) {
			try {
				scheduleList[i] =  new Schedule(xmlUrls.getURL(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toReturn.append(scheduleList[i]);
		}
		return toReturn.toString();
	}
	/**
	 * @param args
	 * @throws Exception 
	 * @throws XMLStreamException 
	 */
	public static void main(String[] args) throws XMLStreamException, Exception {
		// TODO Auto-generated method stub
		String URLListXML = "./Scheduler/urlList.xml";
		if(args.length == 0) {
			System.out.println(Scheduler.printAllSchedules(URLListXML));
		} else {
			Scheduler sc = new Scheduler(URLListXML);
			URLList xmlUrls = new URLList(URLListXML);
			System.out.println("Loading " + xmlUrls.getNumURLs() + " schedules.");
			sc.getMeetingTime(Integer.valueOf(args[0]));
		}
	}

}

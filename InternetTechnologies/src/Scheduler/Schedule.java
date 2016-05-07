package Scheduler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.InputStream;


public class Schedule {
	private ArrayList<Details> details = null;
	public String scheduleName = null;

	public Schedule(String URL) throws XMLStreamException, IOException {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		URL u = new URL(URL);
		InputStream in = (InputStream) u.openStream();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		String tagContent = null;
		details = new ArrayList<>();
		Details temp = new Details("temp");
		StartEnd tempStartEnd = new StartEnd();
		scheduleName = URL.split("/")[URL.split("/").length - 1];

		while(reader.hasNext()){
			int event = reader.next();
			switch(event){
			case XMLStreamConstants.START_ELEMENT: 
				if ("Monday".equals(reader.getLocalName())){
					temp = new Details("Monday");
				}
				if ("Tuesday".equals(reader.getLocalName())){
					temp = new Details("Tuesday");
				}
				if ("Wednesday".equals(reader.getLocalName())){
					temp = new Details("Wednesday");
				}
				if ("Thursday".equals(reader.getLocalName())){
					temp = new Details("Thursday");
				}
				if ("Friday".equals(reader.getLocalName())){
					temp = new Details("Friday");
				}
				if ("Saturday".equals(reader.getLocalName())){
					temp = new Details("Saturday");
				}
				if ("Sunday".equals(reader.getLocalName())){
					temp = new Details("Sunday");
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;
			case XMLStreamConstants.END_ELEMENT:
				switch(reader.getLocalName()) {
				case "Monday":
				case "Tuesday":
				case "Wednesday":
				case "Thursday":
				case "Friday":
				case "Saturday":
				case "Sunday":
					details.add(temp);
					break;
				case "start":
					tempStartEnd = new StartEnd();
					tempStartEnd.setStart(tagContent);
					break;
				case "end":
					tempStartEnd.setEnd(tagContent);
					temp.addStartEnd(tempStartEnd);
					break;
				}
				break;
			}
		}	
	}
	public ArrayList<Details> getScheduleDetails() {
		return this.details;
	}
	@Override
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(scheduleName + "\n");
		for(Details d: this.details) {
			toReturn.append(d.getDay());
			for(StartEnd se: d.getStartEnd()) {
				toReturn.append("\n" + se.getStart() + " - " + se.getEnd());
			}
			toReturn.append('\n');
		}
		return toReturn.toString();
	}
}

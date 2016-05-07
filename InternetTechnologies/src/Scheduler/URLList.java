package Scheduler;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class URLList {
	private ArrayList<String> listURLS;

	public URLList(String URL) throws XMLStreamException {
		// TODO Auto-generated method stub
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = 
				factory.createXMLStreamReader(
						ClassLoader.getSystemResourceAsStream(URL));
		String tagContent = null;
		listURLS = new ArrayList<String>();

		while(reader.hasNext()){
			int event = reader.next();

			switch(event){
			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch(reader.getLocalName()) {
				case "URL":
					listURLS.add(tagContent);
				}
			}
		}
	}
	public int getNumURLs() throws Exception {
		return listURLS.size();
	}
	public String getURL(int i) throws Exception {
		return listURLS.get(i);
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		URLList u = new URLList("urlList.xml");
		System.out.println(u.getNumURLs());
		for(int i=0; i < u.getNumURLs(); i++) {
			System.out.println(u.getURL(i));
		}
	}

}

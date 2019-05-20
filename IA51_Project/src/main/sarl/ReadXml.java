import Schedule.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


class ReadXml{
	
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			 DocumentBuilder db = dbf.newDocumentBuilder();
			 Document document = db.parse("C:\\Users\\15800\\Desktop\\Schedule1.xml");
			 NodeList episodeList = document.getElementsByTagName("Episode");
			 System.out.println("Totally has" + episodeList.getLength() + " Episodes");
			 
			 //create the nodeList of Trip and Activity
			 NodeList tripList = document.getElementsByTagName("Trip");
			 NodeList activityList = document.getElementsByTagName("Activity");
			 int index1=0;
			 int index2=0;
			 
			 //create an array Episodelist
			 Episode[] Episodelist = new Episode[episodeList.getLength()];
			 
			 
			 // Schedule1 totally has 9 episodes
			 for (int i = 0; i < episodeList.getLength(); i++) {
				 System.out.println("=================Start traversing the " + (i + 1) + "th Episode================="+"\n");
				 //get a node named episode and i starting from 0
				 Node episode = episodeList.item(i);
				 
				 
				 
				// ALL attributes of the node episode
				 NamedNodeMap attrs_episode= episode.getAttributes();
				 System.out.println("The " + (i + 1) + "th Episode has " + attrs_episode.getLength() +" attributes"+"\n");
				// Traversing all attributes of Episode
				 for(int j = 0; j < attrs_episode.getLength(); j++) {
					 Node attr_episode = attrs_episode.item(j);
						 System.out.print("The name of attribute: " + attr_episode.getNodeName()+"\n");
					 System.out.println("The value of attribute: " + attr_episode.getNodeValue()+"\n");
				 }
				 
				 // The childNode of episode which including trip and activity
				 NodeList childNodes_episode = episode.getChildNodes();
				 System.out.println("The " + (i+1) + "th Episode has " + childNodes_episode.getLength() + " childNodes"+"\n");
				 
				 // Traversing all childNode of Episode 
				 for (int k = 0; k < childNodes_episode.getLength(); k++) {
					 
					 Trip trip_cur = new Trip(i+1);
					 Activity activity_cur = new Activity(i+1);
					 
					 //TRIP 
					 if(childNodes_episode.item(k).getNodeName()=="Trip") {
						 // Once we get a childNode named Trip, we create a new NodeList named tripList
						 // NodeList tripList = document.getElementsByTagName("Trip");
						 // get a node named trip
						 Node trip = tripList.item(index1++);
						 NamedNodeMap attrs_trip = episode.getAttributes();
						 System.out.println("The " + (i + 1) + "th Trip has " + attrs_trip.getLength() + " attributes"+"\n");
						 //Traversing all childNode of Trip
						 for(int m = 0; m < attrs_trip.getLength(); m++) {
							 Node attr_trip = attrs_trip.item(m);
							 System.out.print("The name of attribute: " + attr_trip.getNodeName()+"\n");
							 System.out.println("The value of attribute: " + attr_trip.getNodeValue()+"\n");
							
						 }
						 //Traversing all childNode of Trip
						 NodeList childNodes_trip = trip.getChildNodes();
						 System.out.println("The " + (i + 1) + "th Trip has " + childNodes_trip.getLength() + " childNodes"+"\n");
						 for(int n = 0; n < childNodes_trip.getLength(); n++) {
							 if(childNodes_trip.item(n).getNodeType() == Node.ELEMENT_NODE) {
								 System.out.print("The name of " + (n + 1) + "chileNode is: " + childNodes_trip.item(n).getNodeName()+"\n");
								 System.out.println("The value of childNode is: " + childNodes_trip.item(n).getFirstChild().getNodeValue()+"\n");
							 }
							 switch(n){
						        case 2:
						        	Location origin_name = new Location(childNodes_trip.item(n).getFirstChild().getNodeValue());
						        	trip_cur. origin_name = origin_name;break;
						        case 4:
						            	trip_cur.start_time = Integer.parseInt(childNodes_trip.item(n).getFirstChild().getNodeValue()); break;
						        case 6:
						        	trip_cur.duration = Integer.parseInt(childNodes_trip.item(n).getFirstChild().getNodeValue());break;
						        case 8:
						        	Location destination = new Location(childNodes_trip.item(n).getFirstChild().getNodeValue());
						        	trip_cur.destination = destination;break;
						        case 10:
								
						        	trip_cur.mode = mode;break;
						        }

							 
						 }
						 
					 }
					 
					 //ACTIVITY
					 if(childNodes_episode.item(k).getNodeName()=="Activity") {
						 Node activity = activityList.item(index2++);
						 NamedNodeMap attrs_activity = episode.getAttributes();
						 System.out.println("The " + (i + 1) + "th Activity has " + attrs_activity.getLength() + " attributes"+"\n");
						 //Traversing all child_node of Trip
						 for(int m = 0; m < attrs_activity.getLength(); m++) {
							 Node attr_activity = attrs_activity.item(m);
							 System.out.print("The name of attribute: " + attr_activity.getNodeName()+"\n");
							 System.out.print(getType(attr_activity.getNodeName()));
							 System.out.println("The value of attribute: " + attr_activity.getNodeValue()+"\n");
							 
							 
						 }
						 //Traversing all child_node of Trip
						 NodeList childNodes_activity = activity.getChildNodes();
						 System.out.println("The " + (i + 1) + "th Activity has " + childNodes_activity.getLength() + " childNodes"+"\n");
						 for(int n = 0; n < childNodes_activity.getLength(); n++) {
							 if(childNodes_activity.item(n).getNodeType() == Node.ELEMENT_NODE) {
								 System.out.print("The name of " + (n + 1) + "chileNode is: " + childNodes_activity.item(n).getNodeName()+"\n");
								 System.out.println("The value of childNode is: " + childNodes_activity.item(n).getFirstChild().getNodeValue()+"\n");
							 }
						 }
						 
					 }
					 
				 }
				 System.out.println("======================Finish traversing the" + (i + 1) + "th Episode=================");
			 }
			 
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getType(Object o){ 
		return o.getClass().toString(); 
	}

}

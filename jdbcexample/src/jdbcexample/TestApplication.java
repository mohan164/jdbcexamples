package jdbcexample;
import java.util.*;
 class Query {
	 
public class DataSet{
private String theatreId;
private String theatreName;
private String location;
private int noOfScreen;
private double ticketCost;
public String getTheatreId() {
return theatreId;
}
public void setTheatreId(String theatreId) {
this.theatreId = theatreId;
}
public String getTheatreName() {
return theatreName;
}
public void setTheatreName(String theatreName) {
this.theatreName = theatreName;
}
public String getLocation() {
return location;
}
public void setLocation(String location) {
this.location = location;
}
public int getNoOfScreen() {
return noOfScreen;
}
public void setNoOfScreen(int noOfScreen) {
this.noOfScreen = noOfScreen;
}
public double getTicketCost() {
return ticketCost;
}
public void setTicketCost(double ticketCost) {
this.ticketCost = ticketCost;
}
@Override
public String toString() {
return "Theatre id: " + theatreId + "\nTheatre name: " + theatreName + "\nLocation: " + location
+ "\nNo of Screen: " + noOfScreen + "\nTicket Cost: " + ticketCost+"\n";
}


}


 private String queryId;
 private String queryCategory;
 private DataSet primaryDataset;
 private DataSet secondaryDataSet;
public String getQueryId() {
return queryId;
}
public void setQueryId(String queryId) {
this.queryId = queryId;
}
public String getQueryCategory() {
return queryCategory;
}
public void setQueryCategory(String queryCategory) {
this.queryCategory = queryCategory;
}
public DataSet getPrimaryDataset() {
return primaryDataset;
}
public void setPrimaryDataset(DataSet primaryDataset) {
this.primaryDataset = primaryDataset;
}
public DataSet getSecondaryDataSet() {
return secondaryDataSet;
}
public void setSecondaryDataSet(DataSet secondaryDataSet) {
this.secondaryDataSet = secondaryDataSet;
}
@Override
public String toString() {
return "Primary data set\n" + primaryDataset
+ "Secondary data set\n" + secondaryDataSet +"Query id: "+ queryId + "\nQuery category=" + queryCategory;
}
 
 
}


public class TestApplication {
 public static void main(String[] args) {
Query query = new Query();
Scanner sc = new Scanner(System.in);
Query.DataSet primary = query.new DataSet();
Query.DataSet secondary = query.new DataSet();
System.out.println("Enter the Details of primary data set");
System.out.println("Enter the theatre id");
String theatreid = sc.next();
primary.setTheatreId(theatreid);
sc.nextLine();
System.out.println("Enter the theatre name");
String theatrename = sc.next();
primary.setTheatreName(theatrename);
sc.nextLine();
System.out.println("Enter the location");
String location = sc.next();
primary.setLocation(location);
sc.nextLine();
System.out.println("Entrer the no of screens");
int screens = sc.nextInt();
primary.setNoOfScreen(screens);
System.out.println("Ente the ticket cost");
double cost = sc.nextDouble();
primary.setTicketCost(cost);
System.out.println("ENter the details of secondary data set");
System.out.println("Enter the theatre id");
 theatreid = sc.next();
secondary.setTheatreId(theatreid);
sc.nextLine();
System.out.println("Enter the theatre name");
 theatrename = sc.next();
secondary.setTheatreName(theatrename);
sc.nextLine();
System.out.println("Enter the location");
 location = sc.next();
secondary.setLocation(location);
sc.nextLine();
System.out.println("Entrer the no of screens");
 screens = sc.nextInt();
secondary.setNoOfScreen(screens);
System.out.println("Ente the ticket cost");
 cost = sc.nextDouble();
secondary.setTicketCost(cost);
System.out.println("Enter the query id");
String queryid = sc.next();
query.setQueryId(queryid);
sc.nextLine();
System.out.println("Enter the query category");
String querycategory = sc.next();
query.setQueryCategory(querycategory);
sc.nextLine();
query.setPrimaryDataset(primary);
query.setSecondaryDataSet(secondary);

System.out.println(query);
 }
}

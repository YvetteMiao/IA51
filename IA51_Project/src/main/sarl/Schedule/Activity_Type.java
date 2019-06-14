package Schedule;

public enum Activity_Type {
	at_home(0),
	at_work(1),
	at_bringGet(3),
	at_DailyShopping(4),
	at_Education(5),
	at_services(6),
	at_socialVisit(7),
	at_leisure(8),
	at_touring(9),
	at_other(10);
	
	public final int order;
	
	Activity_Type(int o){
		this.order=o;
	}
	

}

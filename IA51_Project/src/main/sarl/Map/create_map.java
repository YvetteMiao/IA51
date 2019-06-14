package Map;
import Road.*;

class create_map {
	
	public static void main(String[] args) {
		Point a = new Point(-100,0);
		Point b = new Point(50,0);
		Point c = new Point(50,-100);
		Point school = new Point(-200,0);
		Point hospital = new Point(-100,-100);
		Point home = new Point(0,0);
		Point supermarket1 = new Point(100,100);
		Point bus_station = new Point(150,0);
		Point train_station = new Point(150,-100);
		Point supermarket2 = new Point(50,-150);
		
		Segment segment1  = new Segment(a,school,0,0,0);
		Segment segment2  = new Segment(a,home,0,0,0);
		Segment segment3  = new Segment(a,hospital,0,0,0);
		Segment segment4  = new Segment(c,hospital,0,0,0);
		Segment segment5  = new Segment(b,home,0,0,0);
		Segment segment6  = new Segment(supermarket1,home,0,0,0);
		Segment segment7  = new Segment(b,bus_station,0,0,0);
		Segment segment8  = new Segment(supermarket1,bus_station,0,0,0);
		Segment segment9  = new Segment(b,c,0,0,0);
		Segment segment10 = new Segment(supermarket2,c,0,0,0);
		Segment segment11 = new Segment(supermarket2,train_station,0,0,0);
		Segment segment12 = new Segment(c,train_station,0,0,0);
		Segment segment13 = new Segment(bus_station,train_station,0,0,0);
		
	
	
	}



}

package Road;

import Road.Point;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

@SarlSpecification("0.9")
@SarlElementType(10)
@SuppressWarnings("all")
public class RoadTest {
  public static void main(final String[] args) {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(6, 8);
    double distance = p1.distanceToOther(p2);
    double speed = 20;
    double time = (distance / speed);
    System.out.println(time);
  }
  
  @SyntheticMember
  public RoadTest() {
    super();
  }
}

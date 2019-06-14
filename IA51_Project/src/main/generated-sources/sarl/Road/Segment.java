package Road;

import Road.Point;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author 15800
 */
@SarlSpecification("0.9")
@SarlElementType(10)
@SuppressWarnings("all")
public class Segment {
  public Point start;
  
  public Point end;
  
  public double c;
  
  public double tf;
  
  public double flow;
  
  public double distance;
  
  public Segment(final Point start, final Point end, final double c, final double tf, final double flow) {
    this.start = start;
    this.end = end;
    this.c = c;
    this.tf = tf;
    this.flow = flow;
    double _x = this.start.getX();
    double _x_1 = this.end.getX();
    double _x_2 = this.start.getX();
    double _x_3 = this.end.getX();
    double _y = this.start.getY();
    double _y_1 = this.end.getY();
    double _y_2 = this.start.getY();
    double _y_3 = this.end.getY();
    this.distance = Math.sqrt((((_x - _x_1) * (_x_2 - _x_3)) + 
      ((_y - _y_1) * (_y_2 - _y_3))));
  }
  
  public void calculate_tf(final double speed) {
    this.tf = (this.distance / speed);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Segment other = (Segment) obj;
    if (Double.doubleToLongBits(other.c) != Double.doubleToLongBits(this.c))
      return false;
    if (Double.doubleToLongBits(other.tf) != Double.doubleToLongBits(this.tf))
      return false;
    if (Double.doubleToLongBits(other.flow) != Double.doubleToLongBits(this.flow))
      return false;
    if (Double.doubleToLongBits(other.distance) != Double.doubleToLongBits(this.distance))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.tf) ^ (Double.doubleToLongBits(this.tf) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.flow) ^ (Double.doubleToLongBits(this.flow) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
    return result;
  }
}

package Schedule;

import Schedule.Activity_Type;
import Schedule.Location;
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
public class Activity {
  /**
   * attributes
   */
  public int id;
  
  public int start_time;
  
  public int duration;
  
  public Location location;
  
  public Activity_Type type;
  
  public double a;
  
  public double b;
  
  public int MinD;
  
  public Activity() {
  }
  
  /**
   * constructor
   */
  public Activity(final int id) {
    this.id = id;
    this.start_time = (-1);
    this.duration = (-1);
    this.location = null;
    this.type = null;
    this.MinD = (-1);
  }
  
  public Activity(final int id, final int st, final int d, final Location l, final int min, final Activity_Type type) {
    this.id = id;
    this.start_time = st;
    this.duration = d;
    this.location = l;
    this.type = type;
    this.MinD = min;
    if ((this.type.order == 1)) {
      this.a = (-41.747);
      this.b = 0.220;
    } else {
      if ((this.type.order == 5)) {
        this.a = (-38.455);
        this.b = 0.200;
      } else {
        if ((this.type.order == 7)) {
          this.a = (-10.107);
          this.b = 0.135;
        } else {
          if ((this.type.order == 3)) {
            this.a = (-6.738);
            this.b = 0.155;
          } else {
            if ((this.type.order == 4)) {
              this.a = (-15.847);
              this.b = 0.146;
            } else {
              if ((this.type.order == 8)) {
                this.a = (-8.056);
                this.b = 0.029;
              } else {
                if ((this.type.order == 6)) {
                  this.a = (-5.829);
                  this.b = 0.089;
                } else {
                  if ((this.type.order == 10)) {
                    this.a = (-4.663);
                    this.b = 0.070;
                  }
                }
              }
            }
          }
        }
      }
    }
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
    Activity other = (Activity) obj;
    if (other.id != this.id)
      return false;
    if (other.start_time != this.start_time)
      return false;
    if (other.duration != this.duration)
      return false;
    if (Double.doubleToLongBits(other.a) != Double.doubleToLongBits(this.a))
      return false;
    if (Double.doubleToLongBits(other.b) != Double.doubleToLongBits(this.b))
      return false;
    if (other.MinD != this.MinD)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.id;
    result = prime * result + this.start_time;
    result = prime * result + this.duration;
    result = prime * result + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
    result = prime * result + this.MinD;
    return result;
  }
}

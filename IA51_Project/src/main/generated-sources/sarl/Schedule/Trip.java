package Schedule;

import Road.Path;
import Schedule.Location;
import Schedule.Transport_Mode;
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
public class Trip {
  public int id;
  
  public Location origin_name;
  
  public int start_time;
  
  public int duration;
  
  public Location destination;
  
  public Transport_Mode mode;
  
  public Path path;
  
  /**
   * constructor
   */
  public Trip(final int id) {
    this.id = id;
    this.origin_name = null;
    this.start_time = (-1);
    this.duration = (-1);
    this.destination = null;
    this.mode = null;
  }
  
  public Trip(final int id, final Location ori, final int st, final int d, final Location des, final Transport_Mode mode) {
    this.id = id;
    this.origin_name = ori;
    this.start_time = st;
    this.duration = d;
    this.destination = des;
    this.mode = mode;
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
    Trip other = (Trip) obj;
    if (other.id != this.id)
      return false;
    if (other.start_time != this.start_time)
      return false;
    if (other.duration != this.duration)
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
    return result;
  }
}

package Schedule;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author 15800
 */
@SarlSpecification("0.9")
@SarlElementType(10)
@SuppressWarnings("all")
public class Location {
  public String name;
  
  public int open_time;
  
  public int close_time;
  
  public double quality;
  
  public double perception;
  
  public Location(final String name) {
    this.name = name;
  }
  
  public Location(final String name, final int open_time, final int close_time) {
    this.name = name;
    this.open_time = open_time;
    this.close_time = close_time;
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
    Location other = (Location) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (other.open_time != this.open_time)
      return false;
    if (other.close_time != this.close_time)
      return false;
    if (Double.doubleToLongBits(other.quality) != Double.doubleToLongBits(this.quality))
      return false;
    if (Double.doubleToLongBits(other.perception) != Double.doubleToLongBits(this.perception))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.name);
    result = prime * result + this.open_time;
    result = prime * result + this.close_time;
    result = prime * result + (int) (Double.doubleToLongBits(this.quality) ^ (Double.doubleToLongBits(this.quality) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.perception) ^ (Double.doubleToLongBits(this.perception) >>> 32));
    return result;
  }
}

package Schedule;

import Schedule.Activity;
import Schedule.Trip;
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
public class Episode {
  /**
   * attributes
   */
  public Trip trip;
  
  public Activity activity;
  
  public int id;
  
  /**
   * constructor
   */
  public Episode() {
  }
  
  public Episode(final int id) {
    this.id = id;
  }
  
  public Episode(final int id, final Trip trip, final Activity activity) {
    this.id = id;
    this.trip = trip;
    this.activity = activity;
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
    Episode other = (Episode) obj;
    if (other.id != this.id)
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
    return result;
  }
}

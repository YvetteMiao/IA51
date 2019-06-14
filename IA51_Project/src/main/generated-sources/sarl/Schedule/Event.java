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
public class Event {
  public int trip_or_activity;
  
  public int type_of_event;
  
  public int time_event;
  
  public int time_start;
  
  public int affect_id;
  
  public Transport_Mode travel_new_mode;
  
  public Path path_non_congested;
  
  public int delta_start_time_trip;
  
  public int delta_start_time_activity;
  
  public int delta_duration_time_activity;
  
  public Location new_location;
  
  public int new_endtime_activity;
  
  /**
   * constructor
   */
  public Event() {
  }
  
  public Event(final int trip_or_activity, final int type_of_event) {
    this.trip_or_activity = trip_or_activity;
    this.type_of_event = type_of_event;
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
    Event other = (Event) obj;
    if (other.trip_or_activity != this.trip_or_activity)
      return false;
    if (other.type_of_event != this.type_of_event)
      return false;
    if (other.time_event != this.time_event)
      return false;
    if (other.time_start != this.time_start)
      return false;
    if (other.affect_id != this.affect_id)
      return false;
    if (other.delta_start_time_trip != this.delta_start_time_trip)
      return false;
    if (other.delta_start_time_activity != this.delta_start_time_activity)
      return false;
    if (other.delta_duration_time_activity != this.delta_duration_time_activity)
      return false;
    if (other.new_endtime_activity != this.new_endtime_activity)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.trip_or_activity;
    result = prime * result + this.type_of_event;
    result = prime * result + this.time_event;
    result = prime * result + this.time_start;
    result = prime * result + this.affect_id;
    result = prime * result + this.delta_start_time_trip;
    result = prime * result + this.delta_start_time_activity;
    result = prime * result + this.delta_duration_time_activity;
    result = prime * result + this.new_endtime_activity;
    return result;
  }
}

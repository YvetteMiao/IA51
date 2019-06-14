package Schedule;
import java.util.*;
import java.lang.Math;
import Road.*;

//input:schedule event
//output:shedule


public class Module{
	
	double alpha = 0.15 ;
	double beta =  4 ;
	int time_window;
	Event event; // origin event
	Schedule schedule;// origin schedule
	Episode episode;//affected episode
	Path path;
	
	// constructor
	public Module(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public Module(Schedule schedule, Event ev) {
		this.schedule= schedule;
		this.event = ev;
		this.episode = schedule.episode_list[ev.affect_id];
		
	}
	
	
	// calculate the time_window
	public int Calculate_time_window() {
	//上个活动的结束时间，和下个trip的开始时间
		this.time_window = (this.schedule.episode_list[this.event.affect_id].trip.start_time)-
							(this.schedule.episode_list[this.event.affect_id-1].activity.start_time +
							this.schedule.episode_list[this.event.affect_id-1].activity.duration);
		return this.time_window;
	}
	
	
	//routing_module((change path not change location)
	public Path routing_module(Point start, Point end){
		double alpha = 0.15;
		double beta = 0.4;

		Path[] path_list = A*(start, end);
		int l = path_list.length;
		double min = 9999;
		int min_index = -1;
		for(int i = 0;i<l;i++) {
			 int j = path_list[i].path.length;
			 double sum=0;
			 for (int k=0;k<j;k++) {
				 sum += (1 + alpha * Math.pow((path_list[i].path[k].flow / p[i].c),beta))*path_list[i].path[k].tf;
				 if (sum<min) {
					 sum = min;
					 min_index =i;
				 }
			 }
		}
		return path_list[min_index];
	}
	
	
	//time_module(((change time not path neither location)
	//output:
	public int time_module(Schedule schedule, Event ev) {
		Schedule new_schedule = schedule;
		int t_activity_end = 0;
		//end time of activity
		int te = schedule.episode_list[ev.affect_id].activity.start_time + schedule.episode_list[ev.affect_id].activity.duration;
		
		if (this.event.time_event > 
			this.schedule.episode_list[ev.affect_id].trip.start_time) {
			
			// t(new start time of trip)
			if (this.event.delta_start_time_trip > this.time_window) {
				new_schedule.episode_list[ev.affect_id].trip.start_time =
						schedule.episode_list[ev.affect_id].trip.start_time - this.time_window;
			}
			else {
				new_schedule.episode_list[ev.affect_id].trip.start_time = 
						schedule.episode_list[ev.affect_id].trip.start_time - ev.delta_start_time_trip;
			}	
			
			//new start time of activity	= new end time of trip	
			int t_trip_end = new_schedule.episode_list[ev.affect_id].trip.start_time - new_schedule.episode_list[ev.affect_id].trip.duration;
			
			//new duration of activity
			if((schedule.episode_list[ev.affect_id].activity.duration - 
					schedule.episode_list[ev.affect_id].activity.MinD) <= 
						(ev.delta_start_time_trip - this.time_window)) {
			
				//new end time of activity
				t_activity_end = te + ev.delta_start_time_trip - this.time_window -(schedule.episode_list[ev.affect_id].activity.duration -
						schedule.episode_list[ev.affect_id].activity.MinD);
						
				new_schedule.episode_list[ev.affect_id].activity.duration = t_activity_end - t_trip_end;
				
			}
			else {
				t_activity_end = te;
				new_schedule.episode_list[ev.affect_id].activity.duration = t_activity_end - t_trip_end;
				
			}
		}
		else {
			int t_trip_end = schedule.episode_list[ev.affect_id].trip.duration + schedule.episode_list[ev.affect_id].trip.start_time;
			if((schedule.episode_list[ev.affect_id].activity.duration -
					schedule.episode_list[ev.affect_id].activity.MinD) <= ev.delta_start_time_trip) {
				
				
				t_activity_end = te + ev.delta_start_time_trip -(schedule.episode_list[ev.affect_id].activity.duration -
						schedule.episode_list[ev.affect_id].activity.MinD);

				

				new_schedule.episode_list[ev.affect_id].activity.duration =  t_activity_end - t_trip_end;
				
			}
			else {
				t_activity_end = te;
				new_schedule.episode_list[ev.affect_id].activity.duration =  t_activity_end - t_trip_end;
			}
			
		}
		
		return t_activity_end;
	}
	

	
	//location_module
	public Location location_module() {
		
		Location new_location ;
		int c =1;int m=1;
		double fu = 0.95;
		int l = schedule.episode_list.length;
		
		// calculate dl
		int[] duration_list = new int[l];
		for (int i=0;i< l;i++) {
			duration_list[i] = schedule.episode_list[i].activity.duration;
		}
		int dl=duration_list[0];
		for(int i=0;i<duration_list.length-1;i++){
			if(dl<duration_list[i]){
			dl=duration_list[i];
			}
		}
		
		//calculate new_duration_trip
		int	new_duration_trip = 
		
		
		//calculate new_duration_activity
		double new_duration= +routing();
		if()
			
		
		double kl = c / dl;
		double alpha_l = -Math.log(1-fu)/dl;
		//double[] alpha_list = new double[l];
		//double[] k_list= new double[l];
		double k = c / schedule.episode_list[ev.affect_id].activity.duration;
		double alpha = (alpha_l*dl-Math.log(kl/k))/new_duration;
		
		
		
		
		return new_location;
		
		
	}
	
		
		
	//
	public int mode_module() {
		return 0;
		
	}
	
	//drop_module
	public Schedule drop_module(Schedule schedule, Event ev) {
		Schedule new_schedule = schedule;
		int l = schedule.episode_list.length;
		int id = ev.affect_id;
		for (int i= id ;i<l;i++) {
			new_schedule.episode_list[i] = schedule.episode_list[i+1];
		}
		
		return new_schedule;
	}
	
	
	
}
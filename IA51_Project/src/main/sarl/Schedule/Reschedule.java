package Schedule;
import Penalty.*;

class Reschedule {

	Schedule schedule ; // origin schedule
	int n_episode ; // the length of origin_schedule
	int length ;//length of schedule list
	Schedule[] schedule_list= new Schedule[length]; //there are many changes
	Event event;//
	
	
	public Reschedule(Schedule schedule,Event ev) {
		this.schedule = schedule;
		this.event = ev;
		this.n_episode = schedule.episode_list.length;
		this.length = 10000;
	}
	
	
	public Event creat_internal_event(Schedule schedule,int id) {
		Event new_event = new Event();
		Module module = new Module(schedule);
		if(schedule.episode_list[id].activity.type.order == 1 || schedule.episode_list[id].activity.type.order == 5) {
			new_event.travel_new_mode.order = module.mode_module();
			new_event.new_endtime_activity = module.time_module(this.schedule, this.event);
			new_event.travel_new_mode = module.routing_module(start, end);
		}
		else if(schedule.episode_list[id].activity.type.order ==3 ||schedule.episode_list[id].activity.type.order ==7) {
			new_event.travel_new_mode.order = module.mode_module();
			new_event.new_endtime_activity = module.time_module(this.schedule, this.event);
			new_event.travel_new_mode = module.routing_module(start, end);
		}
		else if(schedule.episode_list[id].activity.type.order == 4||schedule.episode_list[id].activity.type.order == 6 ||
				schedule.episode_list[id].activity.type.order == 8||schedule.episode_list[id].activity.type.order == 10) {
			new_event.travel_new_mode.order = module.mode_module();
			new_event.new_endtime_activity = module.time_module(this.schedule, this.event);
			new_event.travel_new_mode = module.routing_module(start, end);
			new_event.new_location = module.location_module(this.schedule, this.event);
		}
		
		return new_event;
	}
	
	
	//schedule is origin 
	public Schedule creat_temp_schdule(Schedule schedule, int id) {
		Schedule temp = new Schedule();
		int l = schedule.episode_list.length -id-1;
		for (int i = 0;i<l;i++) {
			temp.episode_list[i] = schedule.episode_list[id+1];
		}
		return temp;
	}
	
	// The main of Reschedule 
	public void Change_Schedule(Schedule schedule, Event ev){
		Event external_event = ev ;
		
		for (int i=0;i<n_episode;i++){
			
			if (ev.affect_id == i){
				if (schedule.episode_list[i].activity.type.order== 1||schedule.episode_list[i].activity.type.order== 5)
				{
					
					// change time	  
					Schedule copy_schedule = schedule;				
					copy_schedule.episode_list[i] = change_time(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();//by using module
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change mode
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_mode(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change path
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_path(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}

				}
				
				
				if (schedule.episode_list[i].activity.type.order== 3||schedule.episode_list[i].activity.type.order== 7)
				{
					// change time
					Schedule copy_schedule = schedule;				
					copy_schedule.episode_list[i] = change_time(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change mode
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_mode(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change path
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_path(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// drop episode
					schedule_list[length++] = drop_episode(schedule.episode_list[i],schedule, i);
					
					
				}
				
				
				if (schedule.episode_list[i].activity.type.order == 4 ||schedule.episode_list[i].activity.type.order== 6 ||
						schedule.episode_list[i].activity.type.order== 8 ||schedule.episode_list[i].activity.type.order== 10)
				{
					// change time
					Schedule copy_schedule = schedule;				
					copy_schedule.episode_list[i] = change_time(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change mode
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_mode(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change path
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_path(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// change location
					copy_schedule = schedule;
					copy_schedule.episode_list[i] = change_path(schedule.episode_list[i],ev);
					if(next_episode_affected(copy_schedule.episode_list[i], copy_schedule.episode_list[i+1] )) {
						internal_ev = creat_internal_event();
						Change_Schedule(copy_schedule,internal_ev);				
					}
					else {
						schedule_list[length++] = copy_schedule;
					}
					
					// drop episode
					schedule_list[length++] = drop_episode(schedule.episode_list[i],schedule,i);
					
					
				}
				
			}
		}
		

	
	}	
	
	public Schedule Change_Schedule() {
		double min = 99999;
		int index=0;
		for(int i=0;i<this.schedule_list.length;i++) {
			if(calculate_penalty(this.schedule,this.schedule_list[i])<min) {
				index = i;
			}
		}
		Schedule new_schedule ;
		new_schedule = this.schedule_list[index];
		return new_schedule;
		
	}
	
	public double calculate_penalty(Schedule schedule_ori, Schedule schedule_changed) {
		double penalty = 0;
		return penalty;
	}
	
	
	//if the event affect the episode
	public boolean event_affect_current_episode(Event ev, Episode ep){
		return ev.time_start >= ep.trip.start_time && 
			   ev.time_start <= time_add(ep.activity.start_time, ep.activity.duration);
	}
	
	
	
	//if the new episode(within event) affect the next episode,ep1=current,ep2=next
	public boolean next_episode_affected(Episode ep1, Episode ep2 ){
		return time_add(ep1.activity.start_time,ep1.activity.duration) > ep2.trip.start_time;
	}
	
	
	

	public Episode change_time(Episode episode, Event ev ){
		// trip change start time
		if (ev.trip_or_activity==0 && ev.type_of_event==1){
			episode.trip.start_time = time_add(ev.delta_start_time_trip,
												episode.trip.start_time);
			//????whether change place or change mode???
			episode.activity.start_time = time_add(ev.delta_start_time_trip,
												episode.activity.start_time);
		}
		// activity change start time
		else if(ev.trip_or_activity==1 && ev.type_of_event==0){
			episode.activity.start_time = time_add(ev.delta_start_time_activity,
												episode.activity.start_time);
		}
		// activity change duration
		else if(ev.trip_or_activity==1 && ev.type_of_event==1){
			episode.activity.duration = time_add(ev.delta_duration_time_activity,
												episode.activity.duration);
		}
		return episode;
	}

	// trip change path
	public Episode change_path(Episode episode, Event ev){
		if (ev.trip_or_activity==0 && ev.type_of_event==0){
			episode.trip.path = ev.path_non_congested;
		}
		return episode;
	}

	// trip change mode
	public Episode change_mode(Episode episode, Event ev){
		if (ev.trip_or_activity==0 && ev.type_of_event==2){
			episode.trip.mode = ev.travel_new_mode;
		}
		return episode;
	}
	
	//trip change location
	public Episode change_location( Episode episode, Event ev){
		if(ev.trip_or_activity==1 && ev.type_of_event==2){
			episode.activity.location = ev.new_location;
		}
		return episode;
	}

	// cancel the episode
	public Schedule drop_episode(Episode episode, Schedule new_schedule , int i ){
		// 判断标准？？？？
		for (int j=i ;j< n_episode-1;j++){
				new_schedule.episode_list[j] = new_schedule.episode_list[j+1];
			}
		return new_schedule;
	}

	
	
	public double Calculate_rs_sum() {
		double sum = 0;
		
		for (int i =0;i<length; i++) {
			Probability p = new Probability(schedule,schedule_list[i]);
			double rs = p.Calculate_euv();
			sum += rs;
		}
		return sum;
	}
	
	public double Calculate_rs(Schedule schedule_origine,Schedule schedule_changed) {
		Probability p = new Probability(schedule_origine,schedule_changed);
		return p.Calculate_euv()/Calculate_rs_sum();
	}
	

	
	public int time_add(int time1, int time2){
		int min1 = time1 % 100;
		int min2 = time2 % 100;
		int add_time ;
	
		if (min1+min2 >= 60){
			add_time = (time1 - min1) + (time1 - min2) + 100 + (min1+min2-60);
		}
		else{
			add_time = time1 + time2;
		}
		return add_time;
	}
	
	
	
}
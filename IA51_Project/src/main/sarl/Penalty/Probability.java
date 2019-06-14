package Penalty;
import Schedule.*;
import java.lang.Math;


public class Probability{
	double RST = 20;
	double TP;
	int TC = 1;
	double sum_rs;

	Event ev;
	Schedule schedule_origin;
	Schedule schedule_changed;
	int n_episode = schedule_origin.episode_list.length ;
	
	double lambda = -0.00745;
	double theta = -3.96;
	double delta = 2.56;
	
	
	public Probability(Schedule schedule_origin,Schedule schedule_changed){
		this.schedule_changed = schedule_changed;
		this.schedule_origin = schedule_origin;
	}
	
	
	public int Calculate_TC() {
		// 计算episode改变的数量
		
		//number of external event and internal event
	}
	
	
	public double Calculate_TP() {
		if (this.ev.time_event >= 
				this.schedule_origin.episode_list[ev.affect_id].trip.start_time) {
			int DT = time_add(this.schedule_origin.episode_list[ev.affect_id].activity.start_time,
					this.schedule_origin.episode_list[ev.affect_id].activity.duration);
			int DTB = time_add(this.schedule_origin.episode_list[ev.affect_id].trip.duration,
					this.schedule_origin.episode_list[ev.affect_id].activity.duration);
			return DT/DTB;
		}
		else if(this.schedule_origin.episode_list[ev.affect_id].trip.start_time-
				this.ev.time_event<=RST) {
			return (this.schedule_origin.episode_list[ev.affect_id].trip.start_time-
					this.ev.time_event)/RST;
		}
		else{
			return 0;
		}
	}
	
	
	public double Calculate_V() {	
		double sum = 0;
		for (int i=0;i<n_episode;i++) {
			double da = schedule_origin.episode_list[i].activity.duration;
			double a = schedule_origin.episode_list[i].activity.a;
			double b = schedule_origin.episode_list[i].activity.b;
			double ua = (10*Math.exp(a+b*da))/(1+Math.exp(a+b*da));
			sum += ua;
		}
		
		return sum;
	}

	
	public double Calculate_u() {
		return Math.exp(this.lambda*this.TC+this.delta*this.TP+this.theta*this.TP*this.TP);
	}
	
	
	public double Calculate_euv() {
		double euv = Math.exp(Calculate_u()*Calculate_V());
		return euv;
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
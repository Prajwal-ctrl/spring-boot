package Timecheck.assignment07._6._4.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scheduler_config")
public class SchedulerConfigModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime scheduleTime;
    private String orderprovider;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(LocalDateTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getOrderprovider() {
		return orderprovider;
	}
	public void setOrderprovider(String orderprovider) {
		this.orderprovider = orderprovider;
	}

}

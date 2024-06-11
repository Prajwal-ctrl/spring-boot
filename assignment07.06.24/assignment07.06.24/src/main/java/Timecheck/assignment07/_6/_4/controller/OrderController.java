package Timecheck.assignment07._6._4.controller;

import java.util.Date;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Timecheck.assignment07._6._4.cutomrepo.OrderInfo;
import Timecheck.assignment07._6._4.cutomrepo.OrderdCustomRepo;
import Timecheck.assignment07._6._4.model.OrderModel;


@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	OrderdCustomRepo customrepo;
	
	
	
	@GetMapping ("/allorders/{orderprovider}")
	public OrderModel getallprovidersController (@PathVariable String orderprovider) {
		return customrepo.getprovider(orderprovider) ; 
	}
	
	@GetMapping("/findOrders/{insurance}")
	public OrderModel findinsurance(@PathVariable String insurance) {
		return customrepo.findorders(insurance) ;
	}
	
	
	@GetMapping("/allorders/{insurance}/{patientname}")
	public OrderModel getinsurancepatientdata (@PathVariable String insurance, @PathVariable String patientname) {
		return customrepo.getinsuranceprovider(insurance, patientname) ;
	}
	
	
	@PutMapping ("/UpdatePractice/{ordercategory}")
	public OrderInfo updatepraticebyprovider (@RequestBody OrderInfo orderinfo) {
		return customrepo.updatepractice(orderinfo.getOrdercategory(),orderinfo.getPracticename()) ;
	}
	
	
	
	
	@GetMapping("/StartScheduler/{flag}/{orderprovider}")
    public OrderModel startScheduler(@PathVariable boolean flag, @PathVariable String orderprovider) {
        if (flag) {
            return customrepo.order_counts(orderprovider) ;
        } else {
        	System.out.println("Schedular Stopped");
        }
        return null ;
    }
	
	
	
//	  @GetMapping("/StartScheduler/{flag}")
//	    public ResponseEntity<String> startScheduler(@PathVariable boolean flag) {
//	        if (flag) {
//	            customrepo.reportCurrentTime();
//	            return ResponseEntity.ok("Scheduler started");
//	        } else {
//	            customrepo.reportCurrentTime();
//	            return ResponseEntity.ok("Scheduler stopped");
//	        }
//	    }
//	  
	
	
	  @GetMapping("/StartScheduler/{flag}")
	    public  OrderModel startSchedulerNewVoid(@PathVariable boolean flag) {
	        if (flag) {
	           return  customrepo.order_counts();
	           // return ResponseEntity.ok("Scheduler started");
	        }else {
				return null; 
	        }
	    }
	
	
	
	
	
	 
	  
	  
//	  @GetMapping("/StartScheduler/{flag}")
//	    public ResponseEntity<String> startSchedulerNew(@PathVariable boolean flag) {
//	        if (flag) {
//	            customrepo.startScheduler();
//	            return ResponseEntity.ok("Scheduler started");
//	        } else {
//	            customrepo.startScheduler();
//	            return ResponseEntity.ok("Scheduler stopped");
//	        }
//	    }
	
	
//	if(flag){
//		public void reportCurrentTime() {
//			System.out.println("The time is now {}"+ dateFormat.format(new Date()));
//		}
//	}else {
//		
//			System.out.println("The time is stopsnow {}")
//	}
	
	
	
	

}

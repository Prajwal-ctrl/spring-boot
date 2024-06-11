package Timecheck.assignment07._6._4.cutomrepo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import Timecheck.assignment07._6._4.model.OrderModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class OrderCustomRepoImpl implements OrderdCustomRepo {
	
	@Autowired
	EntityManager entityManager ;
	

	
	
	

	
	@Override
	public OrderModel getprovider (String orderprovider) {
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getprovider", OrderModel.class) ;
			
			query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN) ;
			
			query.setParameter(1, orderprovider) ; 
			
			return (OrderModel) query.getSingleResult() ; 
		} catch (Exception e) {
			
			System.err.println ("Error in getprovide: " + e.getMessage()) ; 
		}
		
		
	return null ; 	
	}
	
	
	@Override
	public OrderModel getinsuranceprovider (String insurance, String patientname ) {
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getinsuranceprovider", OrderModel.class) ;
			
			query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN) ;
			query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN) ;

			
			query.setParameter(1, insurance) ; 
			query.setParameter(2, patientname) ; 

			
			return (OrderModel) query.getSingleResult() ; 
		} catch (Exception e) {
			
			System.err.println ("Error in getprovide: " + e.getMessage()) ; 
		}
		
		
	return null ; 

		
	}


	@Override
	public OrderInfo updatepractice(String ordercategory, String practicename) {
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updatepractice", OrderInfo.class) ;
			
			query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN) ;
			query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN) ;

			
			query.setParameter(1, ordercategory) ; 
			query.setParameter(2, practicename) ; 

			
			return (OrderInfo) query.getSingleResult() ; 
		} catch (Exception e) {
			
			System.err.println ("Error in getprovide: " + e.getMessage()) ; 
		}
		
				return null;
	}


	@Override
	public OrderModel findorders(String insurance) {
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("findorders", OrderModel.class) ;
			
			query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN) ;

			
			query.setParameter(1, insurance) ; 

			
			return (OrderModel) query.getSingleResult() ; 
		} catch (Exception e) {
			
			System.err.println ("Error in getprovide: " + e.getMessage()) ; 
		}		return null;
	}
	
	
	
	@Override
	@Scheduled(fixedDelay = 3000)
	public OrderModel order_counts() {
		String orderprovider1 = "Provider1" ; 
		
	    try {
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("order_counts", OrderModel.class);
	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.setParameter(1, orderprovider1);
	        
	       	        
	        return (OrderModel) query.getSingleResult() ;
 	        
	        
	    } catch (Exception e) {
	        System.err.println("Error in order counts: " + e.getMessage());
	    }
	    return null  ;
	}
	
	
	
	
	
//	public OrderModel order_counts(String orderprovider) {
//	    try {
//	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("order_counts", OrderModel.class);
//	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
//	        query.setParameter(1, orderprovider);
//	        return (OrderModel) query.getSingleResult();
//	    } catch (Exception e) {
//	        System.err.println("Error in order counts: " + e.getMessage());
//	    }
//	    return null;
//	}


private boolean isSchedulerRunning = false;


 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	    @Scheduled(fixedRate = 2000)
	    public void reportCurrentTime() {
	        if (isSchedulerRunning) {
	            System.out.println("The time is now: " + dateFormat.format(new Date()));
	        } 
	    }


		@Override
		public void startScheduler() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public OrderModel order_counts(String orderprovider) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void scheduledTask() {
			// TODO Auto-generated method stub
			
		}


//		@Override
//		public void startScheduler() {
//			// TODO Auto-generated method stub
////			 Date startTime = sc.scheduletime ;
//		     int interval = 10; // 10 minutes
//					    
//			
//		}


	
		

}

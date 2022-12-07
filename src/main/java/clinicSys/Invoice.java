package clinicSys;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Invoice {
    protected ArrayList<Service> services = new ArrayList<Service>();
    protected Double doctorVisit = 0.0;
    protected Double total = 0.0;

    public Invoice(ArrayList<Service> selectedServices, Double doctorVisit) {
        services = selectedServices;
        for (Service service : selectedServices) {
            this.total += service.getPrice();
        }
        this.doctorVisit = doctorVisit;
        this.total += doctorVisit;
    }

    public boolean printInvoice() {
    	Logger logger
    	=Logger.getLogger(
    	    Invoice.class.getName());
    	if (total == 0.0)
    		return false;
    	
        for (Service service : services) {
            logger.log(Level.INFO,service.toString());
        }
        

        logger.log(Level.SEVERE,"\n {0}");
        logger.log(Level.INFO,"Doctor visit = " + doctorVisit);
        logger.log(Level.INFO,"\n");
        logger.log(Level.INFO,"Total Invoice = " + total + " NIS");
       
        
        return true;

    }
    
}

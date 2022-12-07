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
    	String _service;
        for (Service service : services) {
        	_service=service.toString();
            logger.log(Level.INFO,_service);
        }
      String  doctor="Doctor visit = " + doctorVisit;
      String totalV="Total Invoice = " + total + " NIS";

        logger.log(Level.SEVERE,"\n");
        logger.log(Level.INFO,doctor);
        logger.log(Level.INFO,"\n");
        logger.log(Level.INFO,totalV);
       
        
        return true;

    }
    
}

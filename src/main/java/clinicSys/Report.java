package clinicSys;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Report {

    public boolean numOfVisitsReport(int numOfVisits, String month) {
        if (numOfVisits == 0)
            return false;
        Logger logger
    	=Logger.getLogger(
    	   Invoice.class.getName());
        String nummonth="Number of visits for month " + month + " = " + numOfVisits;
        logger.log(Level.INFO,nummonth);
        return true;
    }

    public boolean availableServicesReport(List<Service> availableServices) {
        if (availableServices.isEmpty())
            return false;

        for (Service service : availableServices) {
            System.out.println(service.printList());
        }
        return true;
    }
    
}

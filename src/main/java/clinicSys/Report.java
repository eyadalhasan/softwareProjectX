package clinicSys;

import java.util.ArrayList;

public class Report {

    public boolean numOfVisitsReport(int numOfVisits, String month) {
        if (numOfVisits == 0)
            return false;

        System.out.println("Number of visits for month " + month + " = " + numOfVisits);
        return true;
    }

    public boolean availableServicesReport(ArrayList<Service> availableServices) {
        if (availableServices.isEmpty())
            return false;

        for (Service service : availableServices) {
            System.out.println(service.printList());
        }
        return true;
    }
    
}

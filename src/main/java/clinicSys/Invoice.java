package clinicSys;

import java.util.ArrayList;

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
    	if (total == 0.0)
    		return false;
    	
        for (Service service : services) {
            System.out.println(service.toString());
        }
        System.out.println();
        System.out.println("Doctor visit = " + doctorVisit);
        System.out.println();
        System.out.println("Total Invoice = " + total + " NIS");
        
        return true;

    }
    
}

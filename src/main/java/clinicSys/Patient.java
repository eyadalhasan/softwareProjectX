package clinicSys;

import java.util.ArrayList;

public class Patient extends Users {
    private ArrayList<Service> selectedServices = new ArrayList<Service>();
    

    public Patient(String userName, String password, String role) {
        super(userName, password, role);        
    }

    public ArrayList<Service> getSelectedServices() {
        return selectedServices;
    }

    public boolean setSelectedServices(ArrayList<Service> selectedServices) {
    	if (selectedServices.isEmpty())
    		return false;
    	
        this.selectedServices = selectedServices;
        return true;
    }

    

    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Patient))
            return false;
            Patient other = (Patient) o;
        return (this == other);
    }
    
}

package clinicSys;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Users {
    private List<Service> selectedServices = new ArrayList<>();
    

    public Patient(String userName, String password, String role) {
        super(userName, password, role);        
    }

    public List<Service> getSelectedServices() {
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
    @Override
  public int hashCode() {
   return 0;
    }

}

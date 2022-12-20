package clinic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class MainInterface {
	static Logger logger = Logger.getLogger(MainInterface.class.getName());
    static int userIndex;
    private static Scanner scan = new Scanner(System.in);
    
	private static ArrayList<Users> users = new ArrayList<>();
	private static String userName, password;
	
	private static Record record = new Record();
	static ArrayList<Service> servicesList = new ArrayList<Service>();
	ArrayList<Service> selectedServices = new ArrayList<Service>();
	
	static String Admin = "Admin";
	static String Doctor = "Doctor";
	static String Patient = "Patient";
	static String Secretary = "Secretary";
	static String Welcome = "\t\t\tWelcome ";
	static String separate = "================================================================================";
	static String separate2 = "------------------------------------";
	static String Done = "Done!\n";
	static String selectOption = "\nPlease select an option:";
	static String logOut = "Logged Out...\n";
	static String invalid = "Invalid selection! Please try again...";
	static String error = "Unsuccessfull Operation!";
	static String appointmentList = "Appointments List:";
	static String timeString = "   Time: ";

	public static void init() {
        users.add(new Admin("Eyad", "eyad123", Admin));
        users.add(new Doctor("Hamza", "hamza123", Doctor));
        users.add(new Patient("Maen", "maen123", Patient));
        users.add(new Patient("Jack", "Jack123", Patient));
        users.add(new Secretary("MNS", "mns123", Secretary));
        
        Patient patient = (Patient)users.get(2);
        record.addAppointment(new Appointment("05", "01", "2022", "11"), patient);
        patient = (Patient)users.get(3);
		record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
		
		record.addAppointment(new Appointment("02", "05", "2022", "9"), patient);
		record.addAppointment(new Appointment("25", "05", "2022", "3"), patient);

		record.addVisit(new Appointment("02", "05", "2022", "9"));
		record.addVisit(new Appointment("25", "05", "2022", "3"));
		
		Service service1 = new Service("Toothbrush", 50, 5.00);
		servicesList.add(service1);
		servicesList.add(new Service("Toothpaste", 0, 10.00));
		servicesList.add(new Service("Painkiller", 50, 15.00));
		
	}
	
	public static int authenticateUser() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkUserName(userName)) {
                if (users.get(i).checkPassword(password)) {
                	users.get(i).signIn(userName, password);
                    return i;
                }
                else
                    return -1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		init();
		
		while (true) {
            System.out.println("Enter Username:");
            userName = scan.nextLine();
            
            if (userName.equalsIgnoreCase("exit"))
            	System.exit(0);

            System.out.println("\nEnter Password:");
            password = scan.nextLine();

            System.out.println();

            userIndex = authenticateUser();

            if (userIndex != -1) {
                if (users.get(userIndex).checkRole(Admin))
                	adminActivities(); 
                else if (users.get(userIndex).checkRole(Doctor))
                	doctorActivities();             
                else if (users.get(userIndex).checkRole(Patient))
                	patientActivities();
                else if (users.get(userIndex).checkRole(Secretary))
                	secretaryActivities();     
            }
            
            else if (userName.equalsIgnoreCase("exit"))
            	break;

            else
            	System.out.println("The username or password is incorrect. Please try again...\n");
        }
		
	}
	
	public static void adminActivities() {
		while (true) {
			int i;
			int index;
			String newUserName;
			String newPassword;
			String newRole;
			
			System.out.println(Welcome + users.get(userIndex).userName);
	        System.out.println(separate);
	        System.out.println("1. Add User");
	        System.out.println("2. Remove User");
	        System.out.println("3. Show Users");
	        System.out.println("4. Sign Out");
	        System.out.println(selectOption);
	        int select = scan.nextInt();
	        System.out.println();
	        
	        switch (select) {
	        case 1:
	        	scan.nextLine();
	        	System.out.println("Enter Username:");
	        	newUserName = scan.nextLine();
				System.out.println("Enter Password:\n");
				newPassword = scan.nextLine();
				System.out.println("Enter Role:\n");
				newRole = scan.nextLine();
				if (newRole.equalsIgnoreCase(Admin))
					users.add(new Admin(newUserName, newPassword, newRole));
				else if (newRole.equalsIgnoreCase(Doctor))
					users.add(new Doctor(newUserName, newPassword, newRole));
				else if (newRole.equalsIgnoreCase(Patient))
					users.add(new Patient(newUserName, newPassword, newRole));
				else if (newRole.equalsIgnoreCase(Secretary))
					users.add(new Secretary(newUserName, newPassword, newRole));
				System.out.println(Done);
				break;
				
	        case 2:
	        	System.out.println("Users List:");
	            System.out.println(separate2);
	            i = 1;
	            for (Users user : users) {
	            	System.out.println(i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.role);
	            }
	            System.out.println();
	            System.out.println("\nPlease select a user:");
	            index = scan.nextInt();
	            if (index > i || index < 1) {
            		System.out.println(invalid);
            		break;
            	}
	            index--;
	            users.remove(index);
	            System.out.println();
	            System.out.println(Done);
	            break;
	                    	
	        case 3:
	        	System.out.println("Users List:");
	            System.out.println(separate2);
	            i = 1;
	            for (Users user : users) {
	            	System.out.println(i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.role);
	            }
	            System.out.println();
	            break;
	            
	        case 4:
	        	System.out.println(logOut);
	            scan.nextLine();
	            return;
	        	
	        default:
	            System.out.println(invalid);
	            System.out.println();	
	        }
		}
	}
	
	public static void doctorActivities() {
		while (true) {
			int i = 1;
			int index;
			ArrayList<Integer> appIndex = new ArrayList<>();
			
	        System.out.println("\t\t\tWelcome Dr. " + users.get(userIndex).userName);
	        System.out.println(separate);
	        System.out.println("1. Show Patients List");
	        System.out.println("2. Sign Out");
	        System.out.println(selectOption);
	        int select = scan.nextInt();
	        System.out.println();
	        
	        switch (select) {
	        case 1:
	            System.out.println("Patients List:");
	            System.out.println(separate2);
	            i = 1;
	            appIndex.clear();
	            for (int j = 0; j < record.getPatients().size(); j++)
	            	if (record.getType().get(j) == 1) {
	            		System.out.println(i++ + ". " + record.getPatients().get(j).userName);
	            		appIndex.add(j);
	            	}
	            if (appIndex.isEmpty()) {
	            	System.out.println("No patients!\n");
	            	break;
	            }
	            System.out.println();
	            System.out.println("\nPlease select a patient:");
	            index = scan.nextInt();
	            if (index > i || index < 1) {
            		System.out.println(invalid);
            		break;
            	}
	            index--;
	            index = appIndex.get(index);
	            System.out.println();
	            System.out.println("\nEnter Examination Fee:");
	            record.getPatients().get(index).setDoctorVisit(scan.nextDouble());
	            record.addVisit(record.getAppointments().get(index));
	            System.out.println("\nDone!\n");        
	            break;

	        case 2:
	        	System.out.println(logOut);
	            scan.nextLine();
	            return;
	            
	        default:
	            System.out.println(invalid);
	            System.out.println();
	        }
		}	
	}
	
	public static void patientActivities() {
		while (true) {
			int i;
			int index;
			Patient patient = (Patient)users.get(userIndex);
			ArrayList<Integer> appIndex = new ArrayList<>();
			
			System.out.println(Welcome + users.get(userIndex).userName);
	        System.out.println(separate);
	        System.out.println("1. Add a Service");
	        System.out.println("2. Show Services");
	        System.out.println("3. Add Appointment");
	        System.out.println("4. Edit Appointment");
	        System.out.println("5. Delete Appointment");
	        System.out.println("6. Show Appointment");
	        System.out.println("7. Sign Out");
	        System.out.println(selectOption);
	        int select = scan.nextInt();
	        System.out.println();
	        
	        switch (select) {
	        case 1:
	        	i = 1;
	        	System.out.println("Services List:");
	            System.out.println(separate2);
	        	for (Service service : servicesList) {
	    			System.out.println(i++ + ". " + service);
	    		}
	        	System.out.println();
	            System.out.println("\nPlease select a service:");
	            index = scan.nextInt();
	            if (index > i || index < 1) {
            		System.out.println(invalid);
            		break;
            	}
	            index--;
	            System.out.println();
	            if (servicesList.get(index).getQuantity() != 0) {
	    			servicesList.get(index).removeQuantity();
	    			patient.getSelectedServices().add(servicesList.get(index));
	    			System.out.println(Done); 
	            }
	            else
	            	System.out.println("This service is not available!\n");
	            
	            break;
	        	
	        case 2:
	        	i = 1;
	        	for (Service service : patient.getSelectedServices()) {
	    			System.out.println(i++ + ". " + service);
	    		}
	        	System.out.println();
	        	break;
	        	
	        case 3:
	        	System.out.println("Choose Day:");
				String day = scan.next();
				System.out.println("Choose Month:");
				String month = scan.next();
				System.out.println("Choose Year:");
				String year = scan.next();
				System.out.println("Choose Time:");
				String time = scan.next();

				boolean validAppointment = record.addAppointment(new Appointment(day, month, year, time), patient);
				if (validAppointment)
					System.out.println("Add Appointment Successfully.\n");
				else
					System.out.print(error);
				break;	
	        	
	        case 4:
	        	i = 1;
	        	appIndex.clear();
	        	System.out.println(appointmentList);
	            System.out.println(separate2);
	        	for (int j = 0; j < record.getAppointments().size(); j++) {
	        		if (record.getPatients().get(j).equals(patient) && record.getType().get(j).equals(1)) {
	        			System.out.println(i++ + ". " + record.getAppointments().get(j).getDay() + "/" +
	        			record.getAppointments().get(j).getMonth() + "/" + record.getAppointments().get(j).getYear() +
	        			timeString + record.getAppointments().get(j).getTime());
	        			appIndex.add(j);
	        		}
	        	}
	        	
	        	System.out.println();
	            System.out.println("\nPlease select an appointment:");
	            index = scan.nextInt();
            	if (index > i || index < 1) {
            		System.out.println(invalid);
            		break;
            	}
	            index--;
	            index = appIndex.get(index);          
	            System.out.println();
	            System.out.println("Choose New Day:");
				String newDay = scan.next();
				System.out.println("Choose New Month:");
				String newMonth = scan.next();
				System.out.println("Choose New Year:");
				String newYear = scan.next();
				System.out.println("Choose New Time:");
				String newTime = scan.next();
				
				validAppointment = record.editAppointment(record.getAppointments().get(index), new Appointment(newDay, newMonth, newYear, newTime));

				if (validAppointment)
					System.out.println("Edit Appointment Successfully.\n");
				else
					System.out.print(error);
				
				break;
	        	
	        	
	        case 5:
	        	i = 1;
	        	appIndex.clear();
	        	System.out.println(appointmentList);
	            System.out.println(separate2);
	        	for (int j = 0; j < record.getAppointments().size(); j++) {
	        		if (record.getPatients().get(j).equals(patient) && record.getType().get(j).equals(1)) {
	        			System.out.println(i++ + ". " + record.getAppointments().get(j).getDay() + "/" +
	        			record.getAppointments().get(j).getMonth() + "/" + record.getAppointments().get(j).getYear() +
	        			timeString + record.getAppointments().get(j).getTime());
	        			appIndex.add(j);
	        		}
	        	}
	        	
	        	System.out.println();
	            System.out.println("\nPlease select an appointment:");
	            index = scan.nextInt();
	            if (index > i || index < 1) {
            		System.out.println(invalid);
            		break;
            	}	
	            index--;
	            index = appIndex.get(index);          
	            System.out.println();
	            			
				validAppointment = record.deleteAppointment(record.getAppointments().get(index));

				if (validAppointment)
					System.out.println("Delete Appointment Successfully.\n");
				else
					System.out.print(error);
				
				break;
	        	
	        case 6:
	        	i = 1;
	        	appIndex.clear();
	        	System.out.println(appointmentList);
	            System.out.println(separate2);
	        	for (int j = 0; j < record.getAppointments().size(); j++) {
	        		if (record.getPatients().get(j).equals(patient) && record.getType().get(j).equals(1)) {
	        			System.out.println(i++ + ". " + record.getAppointments().get(j).getDay() + "/" +
	        			record.getAppointments().get(j).getMonth() + "/" + record.getAppointments().get(j).getYear() +
	        			timeString + record.getAppointments().get(j).getTime());
	        			appIndex.add(j);
	        		}
	        	}
	        	
	        	System.out.println();
	        	break;
	        	
	        case 7:
	        	System.out.println(logOut);
	            scan.nextLine();
	            return;
	            
	        default:
	            System.out.println(invalid);
	            System.out.println();
	        }
		}
	}
	
	public static void secretaryActivities() {
		while (true ) {
			int i = 1;
			int index;
			int numOfVisits = 0;
			Report report = new Report();
					
	        System.out.println(Welcome + users.get(userIndex).userName);
	        System.out.println(separate);
	        System.out.println("1. Print Invoice");
	        System.out.println("2. Print a report of visitors in a certain month");
	        System.out.println("3. Print a report of available services");
	        System.out.println("4. Sign Out");
	        System.out.println(selectOption);
	        int select = scan.nextInt();
	        System.out.println();
	        
	        switch (select) {
	        case 1:
	        	 System.out.println("Patients List:");
		            System.out.println(separate2);
		            i = 1;
		            for (int j = 0; j < record.getPatients().size(); j++)
		            	System.out.println(i++ +". " + record.getPatients().get(j).userName);
		            System.out.println();
		            System.out.println("\nPlease select a patient:");
		            index = scan.nextInt();
		            if (index > i || index < 1) {
	            		System.out.println(invalid);
	            		break;
	            	}		            	
		            index--;
		            System.out.println();
		            Patient patient = record.getPatients().get(index);
		            Invoice invoice = new Invoice(patient.getSelectedServices(), patient.getDoctorVisit());
		            invoice.printInvoice();
		            patient.getSelectedServices().clear();
		            patient.setDoctorVisit(0.00);
		            System.out.println();
		            break;
		            
	        case 2:
	        	System.out.println("Choose Month:");
	        	Integer month = scan.nextInt();
	        	for (int j = 0; j < record.getAppointments().size(); j++) {
	    			if (record.getType().get(j) == 2 && (Integer.parseInt(record.getAppointments().get(j).getMonth()) == month))
	    				numOfVisits++;
	        	}

	        	report.numOfVisitsReport(numOfVisits, month.toString());
	        	System.out.println();
	        	break;
	        	
	        case 3:
	        	report.availableServicesReport(servicesList);
	        	System.out.println();
	        	break;
	        	
	        case 4:
	        	System.out.println(logOut);
	            scan.nextLine();
	            return;
	            
	        default:
	            System.out.println(invalid);
	            System.out.println();
	        		
	        }
		}
	}
}
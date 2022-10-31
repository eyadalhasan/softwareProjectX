package clinicSys;

public class Appointment {
    private String day;
    private String month;
    private String year;
    private String time;
    
    public Appointment(String day, String month, String year, String time) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;

    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Appointment))
            return false;
        Appointment other = (Appointment) o;
        return (this.day.equals(other.day) && this.month.equals(other.month) && this.year.equals(other.year) && this.time.equals(other.time));
    }

    

}
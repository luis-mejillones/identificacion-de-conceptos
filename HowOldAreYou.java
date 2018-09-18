/**
 * Very simple application which shows a way of how to design a simple class and apply some 
 * design principles like SOLID and KISS.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

interface AgeCalculator {
    /**
     * Return the calculated age for a given date of birth.
     */
    int getCalculatedAge(Calendar dateOfBirth);
}

class AgeCalculatorImpl implements AgeCalculator {
    private Calendar dateOfBirth;
    private Calendar currentDate;

    /**
     * Initialize some data members
     */
    AgeCalculatorImpl() {
        this.currentDate = Calendar.getInstance();
    }

    public int getCalculatedAge(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        // Get differences between current date and date of birth
        int years = this.getYearsDifference();
        int months = this.getMonthsDifference();
        int days = this. getDaysDifference();
 
        // Adjust age, regarding that probably today is their birthday
        int age = this.adjustAge(years, months, days);

        return age;
    }
    
    private int getYearsDifference() {
        return this.currentDate.get(Calendar.YEAR) - this.dateOfBirth.get(Calendar.YEAR);
    }

    private int getMonthsDifference() {
        return this.currentDate.get(Calendar.MONTH) - this.dateOfBirth.get(Calendar.MONTH);
    }

    private int getDaysDifference() {
        return this.currentDate.get(Calendar.DAY_OF_MONTH) - this.dateOfBirth.get(Calendar.DAY_OF_MONTH);
    }

    private int adjustAge(int years, int months, int days) {
        if(months < 0 // Not yet month of birth
           || (months == 0 && days < 0)) { // check if it's not month or day of birth
            years--;
        }
        
        return years;
    }
}

/**
 * Very simple application which calculate age of anyone.
 */
public class HowOldAreYou {
	public static void main(String[] args) {
        // Create an instance of AgeCalculator which calculate the age.
        AgeCalculator ageCalculator = new AgeCalculatorImpl();

        // Display calculated age.
		System.out.println("Age: " + ageCalculator.getCalculatedAge(new GregorianCalendar(1980,02,14)));
	}
}


import java.util.Calendar;
import java.util.Scanner;

public class calendarClassTest {
    
    protected Calendar fecha = Calendar.getInstance();
    private int year, month, day, hour, minute, second;
    protected String[] days = {" ", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    protected String[] months = {"January", "February", "March", "April", "May", "June", "July", "Augost", "September", "October", "November", "December"};
    private Scanner sc;


    public void setYear() {
        sc = new Scanner(System.in);
        try {
            do {
                System.out.print("AÑO:      ");
                year = sc.nextInt();
                if (year < 0) {System.out.println("Years can´t be less than 0");}
            } while (year < 0);
        } catch (Exception e) {
            System.out.println("That´s not even a number!");
            setYear();
        }
    }


    public void setMonth() {
        sc = new Scanner(System.in);
        do {
            System.out.print("MES:      ");
            String monthName = sc.next();
            try {
                month = Integer.valueOf(monthName);
                if (month > 12 || month <= 0) {System.out.println("That month doesn´t exist");}
            } catch (Exception e) {
                for (int i = 0; i < months.length; i++) {
                    if (monthName.equals(months[i])) {
                        month = i + 1;
                        break;
                    } else {month = 13;}
                }
                if (month == 13) {System.out.println("That´s not even a word!");}
            }
        } while (month > 12 || month <= 0);
    }


    public void setDay() {
        sc = new Scanner(System.in);
        try {
            boolean yearType = false;
            do {
                int monthType = monthType();
                System.out.print("DIA:      "); 
                day = sc.nextInt();
                if (day > 0) {
                    if (day > monthType) System.out.println(months[month - 1] + " just have "+ monthType + " days");
                    else yearType = true;
                } else System.out.println("Days can´t be less than 1");
            } while (yearType == false);
        } catch (Exception e) {
            System.out.println("That´s not even a number!");
            setDay();
        }
    }


    public void setHour() {
        sc = new Scanner(System.in);
        try {
            do {
                System.out.print("HORA:     ");
                hour = sc.nextInt();
                if (hour >= 24) {System.out.println("Hours can´t be above 23");}
                else if(hour < 0) {System.out.println("Hours can´t be less than 00");}
            } while (hour >= 24 || hour < 0);
        } catch (Exception e) {
            System.out.println("That´s not even a number!");
            setHour();
        }
    }


    public void setMinute() {
        sc = new Scanner(System.in);
        try {
            do {
                System.out.print("MINUTO:   ");
                minute = sc.nextInt();
                if (minute >= 60) {System.out.println("Minutes can´t be above 59");}
                else if(minute < 0 ) {System.out.println("Minutes can´t be less than 00");}
            } while (minute >= 60 || minute < 0);
        } catch (Exception e) {
            System.out.println("That´s not even a number!");
            setMinute();
        }
    }


    public void setSecond() {
        sc = new Scanner(System.in);
        try {
            do {
                System.out.print("SEGUNDO:  ");
                second = sc.nextInt();
                if (second >= 60) {System.out.println("Seconds can´t be above 59");}
                else if(second < 0 ) {System.out.println("Seconds can´t be less than 00");}
            } while (second >= 60 || second < 0);
        } catch (Exception e) {
            System.out.println("That´s not even a number!");
            setSecond();
        }
    }


    public int getYear() {return this.year;}
    public int getMonth() {return this.month;}
    public int getDay() {return this.day;}
    public int getHour() {return this.hour;}
    public int getMinute() {return this.minute;}
    public int getSecond() {return this.second;}


    // Set a specific day
    public Calendar setDayData(){
        setYear();
        setMonth();
        setDay();
        setHour();
        setMinute();
        setSecond();
        // Setting a new value to the date, the date that we introduce before
        fecha.set(year, month - 1, day, hour, minute, second);
        showDay();
        return fecha;
    }


    // Bulder Method (Just to create a class of this exact moment)
    protected void setDayData(int yearT, int monthT, int dayT, int hourT, int minuteT, int secondT){
        this.year = yearT;
        this.month = monthT + 1;
        this.day = dayT;
        this.hour = hourT;
        this.minute = minuteT;
        this.second = secondT;
    }


    /**
     * Date writted in form that it can be read by a human
     * @return String
     */
    public String showDay(){
        String readDay, hora = "", minuto = "", segundo = "";
    
        if (hour < 10) {hora = "0" + Integer.valueOf(hour);
        } else {hora += Integer.valueOf(hour);}
        if (minute < 10) {minuto = "0" + Integer.valueOf(minute);
        } else {minuto += Integer.valueOf(minute);}
        if (second < 10) {segundo = "0" + Integer.valueOf(second);
        } else {segundo += Integer.valueOf(second);}

        readDay = days[fecha.get(Calendar.DAY_OF_WEEK)] + ", " + months[getMonth() - 1] + " " + day + ", " + year + " at " + hora + ":" + minuto + ":" + segundo + " hrs";
        System.out.println(readDay);
        return readDay;
    }


    /**
     * Returns the number of days that have a month, considering if it´s or not a Leap Year
     * @return int
     */
    public int monthType(){
        int monthType = 0;

        if (month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12) monthType = 31;
        else if (month == 4 || month == 6 || month == 9 ||month == 11) monthType = 30;
        else if (month == 2) {
            if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) monthType = 28;
            else monthType = 29;
        }
        return monthType;
    }


    /**
     * Returns true if the year results to be a leap year and false if it´s not
     * @return boolean
     */
    public boolean yearType(){
        boolean yearType;
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) yearType = false;
        else yearType = true;
        return yearType;
    }


    /**
     * Transforms the date to the total time
     * @return boolean
     */
    public double timeToSeconds(){
        double timeDay, timeHour, timeMinute, timeSecond;

        timeDay = (year * 365.25) + (month * 30.4375) + day;
        timeHour = (timeDay * 24) + hour;
        timeMinute = (timeHour * 60) + minute;
        timeSecond = (timeMinute * 60) + second;

        //System.out.println("The time is equal to " + timeDay + " days");
        //System.out.println("The time is equal to " + timeHour + " hours");
        //System.out.println("The time is equal to " + timeMinute + " minutes");
        //System.out.println("The time is equal to " + timeSecond + " seconds");
        return timeSecond;
    }
    

    /**
     * Compares the difference bettwen tow diffetent dates
     * @param calendarClassTest
     */
    protected void dateDifference(calendarClassTest now, calendarClassTest now2){       
        if (now.timeToSeconds()>=now2.timeToSeconds()) {
            int yearL = 0, monthL = 0, dayL = 0, hourL = 0, minuteL = 0, secondL;
        
            secondL = now.second - now2.getSecond();
            if (secondL < 0) {
                secondL += 60;
                minuteL--;
            }
            minuteL += now.minute - now2.getMinute();
            if (minuteL < 0) {
                minuteL += 60;
                hourL--;
            }
            hourL += now.hour - now2.getHour();
            if (hourL < 0) {
                hourL += 24;
                dayL--;
            }
            dayL += now.day - now2.getDay();
            if (dayL < 0) {
                now.month++;
                dayL += now.monthType();
                monthL--;
            }
            monthL += now.month - now2.getMonth();
            if (monthL < 0) {
                monthL += 11;
                yearL--;
            }
            yearL += now.year - now2.getYear();
            if (yearL < 0) yearL = -yearL;

            System.out.println("\nThe difference is about: ");
            System.out.println(secondL + " seconds ");
            System.out.println(minuteL + " minutes ");
            System.out.println(hourL   + " hours ");
            System.out.println(dayL    + " days ");
            System.out.println(monthL  + " months ");
            System.out.println(yearL  + " years "); 
        // This conditions is because this part of the program always needs to have the bigger date first in the method dateDifference()           
        } else dateDifference(now2, now);
    }

    
    /**
     * Gets the difference in two dates previously gived by the user
     */
    public void twoDaysDifference(){
        calendarClassTest date1 = new calendarClassTest();
        calendarClassTest date2 = new calendarClassTest();

        System.out.println("\nEnter the first day to comapre");
        date1.setDayData();
        System.out.println("\nEnter the second day to comapre");
        date2.setDayData();

        dateDifference(date1, date2);
    }


    /**
     * Gets the time that have past from the users birthday to this exact moment
     */
    public void lifeTime(){
        System.out.println("\nEnter your bithday: ");
        calendarClassTest date = new calendarClassTest();
        date.setDayData();

        Calendar today = Calendar.getInstance();
        calendarClassTest now = new calendarClassTest();
        now.setDayData(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), 
                       today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE), today.get(Calendar.SECOND));
        System.out.println("Today is " + now.showDay());

        if (timeToSeconds()>now.timeToSeconds()) {System.out.println("You´re even burn yet XD");
        } else{
            dateDifference(now, date); 
        }
    }




    public static void main(String[] args) {

        calendarClassTest f = new calendarClassTest();
        
        f.setDayData();
        //f.showDay();
        //f.monthType();
        //f.yearType();
        //f.timeToSeconds();
        //f.twoDaysDifference();
        //f.lifeTime();
    }
}
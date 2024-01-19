package DeadlineSchedule;

import java.net.SocketOption;
import java.util.*;
public class Student extends Corefunction {
    String nameStudent;
    int studentID;
    String username;
    String passWord1;
    String passWord2;


    Student(String name, int ID){
        this.nameStudent=name;
        this.studentID=ID;
        System.out.printf("Hello, %s\n",this.nameStudent);
    }

    public void signUp(String userName, String passWord1, String passWord2){
        super.signUp(userName,passWord1,passWord2);
        this.username=userName;
        this.passWord1=passWord1;
        this.passWord2=passWord2;
    }

    @Override
    public void displayTimeTable() {
        super.displayTimeTable();
        System.out.println("\n\nThe timetable is shown in Student Interface.");
        System.out.println("You can add your personal activities.");
    }
    //
//    @Override
//    public void modifyTimetable(String name, double duration, String date1, String date2)  {
//        super.modifyTimetable(name, duration, date1, date2);
//        System.out.println("Add something");
//   }
    public void addTimetable(){
        System.out.println("Do you want to add any personal activities?\n\t1.Yes (Y) \n\t2.No (N)");
        String check= sc.nextLine();
        while(check.equalsIgnoreCase("Y")){

//            modifyTimetable(name,duration, date1, date2);
            System.out.println("Do you want to add more personal activities?\n\t1.Yes (Y) \n\t 2.No (N)");
            String check1=sc.nextLine();
            if (check1.equalsIgnoreCase("N"))
                check=check1;
        }

    }


    public static void main(String[] args) {
        System.out.println("Welcome to Deadline Schedule!");
        System.out.println("Input your information:\n\t1.NAME\n\t2.StudentID");

        Scanner sc= new Scanner(System.in);
        String nameStudent=sc.nextLine();
        int studentID=sc.nextInt();

        Student obj= new Student(nameStudent,studentID);

        System.out.println("Please Sign Up your information before get started.");
        System.out.print("\t1.Username\n\t2.Password\n\t3.Type your password again\n");
        String userName= sc.nextLine();
        sc.nextLine();
        String passWord1=sc.nextLine();
        String passWord2=sc.nextLine();

        obj.signUp(userName,passWord1,passWord2);
        obj.addTimetable();

        Corefunction.week.put("Mon", Corefunction.Monday);
        Corefunction.week.put("Tue", Corefunction.Tuesday);
        Corefunction.week.put("Wed", Corefunction.Wednesday);
        Corefunction.week.put("Thu", Corefunction.Thursday);
        Corefunction.week.put("Fri", Corefunction.Friday);
        Corefunction.week.put("Sat", Corefunction.Saturday);
        Corefunction.week.put("Sun", Corefunction.Sunday);

        obj.TimeTable();
        obj.displayTimeTable();
    }
}
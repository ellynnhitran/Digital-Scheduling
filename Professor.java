package DeadlineSchedule;


import java.net.SocketOption;
import java.util.*;
public class Professor extends Testing  {
    String nameProfessor;
    int professorID;
    String username;
    String passWord1;
    String passWord2;


    Professor(String name, int ID){
        this.nameProfessor=name;
        this.professorID=ID;
        System.out.printf("Hello, %s\n",this.nameProfessor);
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
        System.out.println("\n\nThe timetable is shown in Professor Interface.");
        System.out.println("You can add assignments for CS Students");
    }

    @Override
    public void modifyTimetable(String name, double duration, String date1, String date2) {
        super.modifyTimetable(name, duration, date1, date2);
        System.out.println(" ");
    }

    public void addTimetable(){
        System.out.println("Do you want to add any assignments for CS Students?\n\t1.Yes (Y) \n\t2.No (N)");
        String check= sc.nextLine();
        while(check.equalsIgnoreCase("Y")){
            System.out.println("\t1.Assignment name \n\t2.Duration Estimation \n\t3.Released Date \n\t4.Finished Date");
            String nameAssignment =sc.nextLine();
            double duration=sc.nextDouble();
            sc.nextLine();
            String releaseDate= sc.nextLine();
            String finishedDate= sc.nextLine();
            modifyTimetable(nameAssignment,duration,releaseDate,finishedDate);
            System.out.println("Do you want to add more assignments for CS Students?\n\t1.Yes (Y) \n\t 2.No (N)");
            String check1=sc.nextLine();
            if (check1.equalsIgnoreCase("N"))
                check=check1;
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Deadline Schedule!");
        System.out.println("Input your information:\n\t1.NAME\n\t2.ProfessorID");

        Scanner sc= new Scanner(System.in);
        String nameProfessor=sc.nextLine();
        int professorID=sc.nextInt();

        Professor obj= new Professor(nameProfessor,professorID);

        System.out.println("Please Sign Up your information before get started.");
        System.out.print("\t1.Username\n\t2.Password\n\t3.Type your password again\n");
        String userName= sc.nextLine();
        sc.nextLine();
        String passWord1=sc.nextLine();
        String passWord2=sc.nextLine();

        obj.signUp(userName,passWord1,passWord2);

        Corefunction.week.put("Mon", Corefunction.Monday);
        Corefunction.week.put("Tue", Corefunction.Tuesday);
        Corefunction.week.put("Wed", Corefunction.Wednesday);
        Corefunction.week.put("Thu", Corefunction.Thursday);
        Corefunction.week.put("Fri", Corefunction.Friday);
        Corefunction.week.put("Sat", Corefunction.Saturday);
        Corefunction.week.put("Sun", Corefunction.Sunday);

        obj.TimeTable();
        obj.addTimetable();
    }
}
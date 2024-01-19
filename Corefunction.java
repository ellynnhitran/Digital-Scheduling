package DeadlineSchedule;


import java.util.*;

/*
In terms of class schedule, we focus on the timetable of CS Student based on my personal schedule.
Hence, the data about the timetable is fixed and not changed during the Spring Semester.
*/

class ClassSchedule{
    String nameSubject;
    double duration;
    String date;
    String release_date;
    String finish_date;

    ClassSchedule(String name, double duration,String date){
        this.nameSubject=name;
        this.duration=duration;
        this.date=date;
    }

    ClassSchedule(String name, double duration,String date1, String date2){
        this.nameSubject=name;
        this.duration=duration;
        this.release_date=date1;
        this.finish_date=date2;
    }
}

class PersonalActivity{
    String nameActivity;
    double duration;
    String date;
    PersonalActivity(String name,double duration,String date){
        this.nameActivity=name;
        this.duration=duration;
        this.date=date;
    }
}



public class Corefunction {

    Scanner sc = new Scanner(System.in);

    public void signUp(String username, String passWord1, String passWord2) {

        while (!passWord1.equals(passWord2)) {
            System.out.println("Please input your password again.");
            String passWord3 = sc.nextLine();
            String passWord4 = sc.nextLine();
            if (passWord3.equals(passWord4)) {
                String password1 = passWord3;
                String password2 = passWord4;
                break;
            } else {
                continue;
            }
        }
    }

    static ArrayList<ClassSchedule> Monday = new ArrayList<>();
    static ArrayList<ClassSchedule> Tuesday = new ArrayList<>();
    static ArrayList<ClassSchedule> Wednesday = new ArrayList<>();
    static ArrayList<ClassSchedule> Thursday = new ArrayList<>();
    static ArrayList<ClassSchedule> Friday = new ArrayList<>();
    static ArrayList<ClassSchedule> Saturday = new ArrayList<>();
    static ArrayList<ClassSchedule> Sunday = new ArrayList<>();
    static Map<String, ArrayList<ClassSchedule>> week = new LinkedHashMap<String, ArrayList<ClassSchedule>>();

    static public void TimeTable(){
        Monday.add(new ClassSchedule("Academic English", 75, "Monday"));
        Monday.add(new ClassSchedule("OOP", 75, "Monday"));
        Tuesday.add(new ClassSchedule("OOP", 75, "Tuesday"));
        Tuesday.add(new ClassSchedule("Recitation", 110, "Tuesday"));
        Tuesday.add(new ClassSchedule("Maths", 75, "Tuesday"));
        Tuesday.add(new ClassSchedule("Physics", 75, "Tuesday"));
        //Wednesday.add(new ClassSchedule("Physic Lab", 120, "Wednesday"));
        Wednesday.add(new ClassSchedule("Elective", 110, "Wednesday"));
        Wednesday.add(new ClassSchedule("OOP Lab", 120, "Wednesday"));
        Thursday.add(new ClassSchedule("Academic English", 75, "Thursday"));
        Thursday.add(new ClassSchedule("Maths", 75, "Thursday"));
        Thursday.add(new ClassSchedule("Physics", 75, "Thursday"));
        Friday.add(new ClassSchedule(null, 0, "Friday"));
        Saturday.add(new ClassSchedule(null, 0, "Saturday"));
        Sunday.add(new ClassSchedule(null, 0, "Sunday"));
    }
    public void displayTimeTable() {
        System.out.println("Timetable shown");

        for (String key : week.keySet()) {
            System.out.printf("\nSchedule in %s: ", week.get(key).get(0).date);
            if (week.get(key).get(0).nameSubject == null && week.get(key).size()==1) {
                System.out.printf("There is no classes and no assignment on %s", week.get(key).get(0).date);
                //Se co truong hop xet khuc dau no bi null nhung khi dung chung cho Class Schedule thi nhung cai
                //Assignment duoc add vao thi no khong nhan
            }
            else if(week.get(key).get(0).nameSubject == null){
                System.out.printf("There is no classes on %s but there still has ", week.get(key).get(0).date);
                for (int i=1;i<week.get(key).size();i++){
                    System.out.printf("%s assignment ",week.get(key).get(i).nameSubject);
                }
            }
            else {
                for (int j = 0; j < week.get(key).size(); j++) {
                    System.out.printf(week.get(key).get(j).nameSubject + " ");
                }
            }
        }
    }

    public void modifyTimetable(String name, double duration, String date1, String date2)  {
        ClassSchedule homework = new ClassSchedule(name, duration, date1, date2);
        week.get(date2).add(homework);
        displayTimeTable();
    }
}
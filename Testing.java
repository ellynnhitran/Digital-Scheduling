package DeadlineSchedule;

import java.util.*;


public class Testing extends Corefunction implements Comparable<Testing> {
    String nameAssignment;
    double duration;
    int start;
    int end;

    static Map<String,Double> timeAvailable= new LinkedHashMap<String,Double>() ;
    static Map<String, Double> deadlineDuration=new LinkedHashMap<String,Double>();
    //static Map<String, Double> unbalancedDate= new LinkedHashMap<String,Double>();
    static Map<String, ArrayList<Testing>> weekAssignment= new LinkedHashMap<String,ArrayList<Testing>>();
    static ArrayList<Testing> Monday = new ArrayList<Testing>();
    static ArrayList<Testing> Tuesday = new ArrayList<Testing>();
    static ArrayList<Testing> Wednesday = new ArrayList<Testing>();
    static ArrayList<Testing> Thursday = new ArrayList<Testing>();
    static ArrayList<Testing> Friday = new ArrayList<Testing>();
    static ArrayList<Testing> Saturday = new ArrayList<Testing>();
    static ArrayList<Testing> Sunday = new ArrayList<Testing>();
    static ArrayList<String> date=new ArrayList<String>(Arrays.asList("Mon","Tue","Wed","Thu","Fri","Sat","Sun")) ;
    double a; //end-start
    final static double limit =240;

    Testing(){

    }
    Testing(String nameAssignment,double duration,String release,String finish){
        this.nameAssignment=nameAssignment;
        this.duration=duration;
        convertDate(release,finish);

    }
    public void convertDate(String release, String finish){
        for (int i=0;i<date.size();i++){
            if (date.get(i).equalsIgnoreCase(release))
                this.start=i+2;
            else if (date.get(i).equalsIgnoreCase(finish)){
                this.end=i+2;
            }
        }
        this.a= this.end-this.start+1;

    }
    static public int convert(String inputDate){

        int num=0;
        for (int i=0;i<date.size();i++) {
            if (date.get(i).equalsIgnoreCase(inputDate))
                num= i + 2;
        }
        return num;
    }
    static public void checkBalance(String nameAssignment,double duration,String released,String finished){

            if (timeAvailable.get(finished)-deadlineDuration.get(finished)> limit){
                weekAssignment.get(finished).add(new Testing(nameAssignment,duration,released,finished));
                return;
            }
            else{
                arrangeDeadlines(nameAssignment,duration,released,finished);
            }
            double remain=timeAvailable.get(finished)- deadlineDuration.get(finished);
            timeAvailable.put(finished,remain);

        }

    static public void arrangeDeadlines(String nameAssignment,double duration,String released,String finished){
            while (timeAvailable.get(finished) > 0){
                weekAssignment.get(finished).add(new Testing(nameAssignment,duration,released,finished));
                double updatedRemain=timeAvailable.get(finished)-duration;
                timeAvailable.put(finished,updatedRemain);
            }
            if (timeAvailable.get(finished) < 0){
                int position= convert(finished);
                for (int i= position-1 ; i>=2; i--){
                    if (timeAvailable.get(date.get(i)) > 0) {
                        weekAssignment.get(finished).add(new Testing(nameAssignment,duration,released,finished));
                        break;
                    }
                }
                System.out.println("You should change this assignment to other due date.");
                //Move to the former date
                //if added: break
                //else: Show timetable and let professor choose
            }
    }
    public static void main(String[] args) {
        //Each date in the timeAvailable = = 1440 mins – fixed timetable
        // – relaxing time included sleeping time (600 mins)
        timeAvailable.put("Mon", 690.0);
        timeAvailable.put("Tue", 505.0);
        timeAvailable.put("Wed", 610.0);
        timeAvailable.put("Thu", 615.0);
        timeAvailable.put("Fri", 840.0);
        timeAvailable.put("Sat", 840.0);
        timeAvailable.put("Sun", 840.0);

        for (String key : Testing.timeAvailable.keySet()) {
            deadlineDuration.put(key, 0.0);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add any assignments for CS Students?\n\t1.Yes (Y) \n\t2.No (N)");
        String check = sc.nextLine();
        weekAssignment.put("Mon", Monday);
        weekAssignment.put("Tue", Tuesday);
        weekAssignment.put("Wed", Wednesday);
        weekAssignment.put("Thu", Thursday);
        weekAssignment.put("Fri", Friday);
        weekAssignment.put("Sat", Saturday);
        weekAssignment.put("Sun", Sunday);


        while (check.equalsIgnoreCase("Y")) {
            System.out.println("\t1.Assignment name \n\t2.Duration Estimation \n\t3.Released Date \n\t4.Finished Date");
            String nameAssignment = sc.nextLine();
            double duration = sc.nextDouble();
            sc.nextLine();
            String releaseDate = sc.nextLine();
            String finishedDate = sc.nextLine();

            Testing obj = new Testing(nameAssignment, duration, releaseDate, finishedDate);
            double updatedDuration = Testing.deadlineDuration.get(finishedDate) + duration;
            Testing.deadlineDuration.put(finishedDate, updatedDuration);
            Testing.checkBalance(nameAssignment, duration, releaseDate, finishedDate);

            System.out.println("Do you want to add more assignments for CS Students?\n\t1.Yes (Y) \n\t 2.No (N)");
            String check1 = sc.nextLine();
            if (check1.equalsIgnoreCase("N"))
                check = check1;
        }
        System.out.println("Timetable shown");
        System.out.println("Assignment in this week");

        for (String key: weekAssignment.keySet()){
            for (int i=0; i< weekAssignment.get(key).size();i++)
                System.out.printf("%s: %s\n",key,weekAssignment.get(key).get(i).nameAssignment);

        }
    }

    @Override
    public int compareTo(Testing o) {
        return (int)this.a- (int)o.a;
    }
}

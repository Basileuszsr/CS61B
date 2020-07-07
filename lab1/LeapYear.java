/** Class that determines whether or not a year is a leap year.
 *  @author Zhangshirui
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */

    private static boolean isLeapYear(int year){
        boolean result = false;
        if (year % 400 == 0){
            result = true;
        }else if (year % 100 != 0&& year % 4 == 0){
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length<1){
            System.out.println("Please enter year!");
        }
        for (int i = 0; i < args.length; i++){
            int y = Integer.parseInt(args[i]);
            if (isLeapYear(y)){
                System.out.printf("%d is a leap year.\n", y);
            }else{
                System.out.printf("%d is not a leap year.\n", y);
            }
            
        }

        
    }
}


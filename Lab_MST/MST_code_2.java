//Q3
package z_random;
import java.util.*;

public class MST_code_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            nums.add(sc.nextInt());
        }
        try {
            if (nums.isEmpty()) {
                throw new ArithmeticException("List Empty");
            }
            double sum = 0.00;
//            for (int i : nums) {
//                sum += i;
//            }
            for(int i =0;i<n;i++){
                sum += nums.get(i);
            }
            double average =  sum / n ;
            System.out.println(average);
        } catch (ArithmeticException e) {
            System.out.println( e.getMessage());
        }
    }
}


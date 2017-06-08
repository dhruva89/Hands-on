package leetCode;
import java.util.Scanner;

public class Candies {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int childrenCount = scan.nextInt();
        if(childrenCount == 1) {
            System.out.println(1);
        }
        
        int[] ratings = new int[childrenCount];
        int[] candies = new int[childrenCount];
        for(int i = 0; i<childrenCount;i++) {
            ratings[i] = scan.nextInt();
            if(i!=0) {
                if(ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i-1] + 1;
                } else {
                    candies[i] = 1;
                }
            } else {
                candies[i] = 1;
            }
        }
        long result = candies[childrenCount-1];
        for(int j = childrenCount-2;j>=0;j--){
            int cur = 1;
            if(ratings[j]>ratings[j+1]){
                cur = candies[j+1] + 1;
            }
            result += Math.max(candies[j],cur);
            candies[j] = cur;
        }
    System.out.println(result);
    scan.close();
    }
    
}
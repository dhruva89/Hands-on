	package hackerRank;
	
	import java.util.Scanner;
	
	public class Solution2 {
	
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();
	        long[] memo = new long[input.length()];
	        memo[0] = Long.parseLong(""+input.charAt(0));
	        long total = memo[0];
	        for(int i =1; i< input.length();i++){
	            memo[i] = (long)10 * memo[i-1] + (long)(i+1) * Long.parseLong(""+input.charAt(i));
	            memo[i] %= 1000000007; 
	            total += memo[i];
	            total %= 1000000007;
	        }
	        System.out.println(total);
	        scan.close();
	    }
	}
package leetCode;

public class ReverseWords {
	public static void main(String args[]) {
		new ReverseWords().reverseWords(new char[] { 'a',' ','b' });
	}

	public void reverseWords(char[] s) {
		for (int i = 0; i < s.length/2; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
		int i = 0;
		while (i < s.length) {
			while(s[i] == ' '){
				i++;
			}
			int j = i;
			while (j != s.length - 1 && s[j + 1] != ' ') {
				j++;
			}
			int k = 0;
			while (k <= (j - i) / 2) {
				char temp = s[i + k];
				s[i + k] = s[j - k];
				s[j - k] = temp;
				k++;
			}
			i = j;
			i++;
		}
		System.out.println(s);
	}
}

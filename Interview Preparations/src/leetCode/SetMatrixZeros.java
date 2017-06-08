package leetCode;

import java.util.Arrays;

public class SetMatrixZeros {
	
	public static void main(String args[]) {
		int[][] input = {{1,0}};
		new SetMatrixZeros().setZeroes(input);
		for(int i=0;i<input.length;i++){
			System.out.println(Arrays.toString(input[0]));
		}
		
	}
	
	public void setZeroes(int[][] matrix) {
		boolean setRow0ToZeros = false;
		boolean setColumn0ToZeros = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				setColumn0ToZeros = true;
				break;
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				setRow0ToZeros = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (setRow0ToZeros == true) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (setColumn0ToZeros == true) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}

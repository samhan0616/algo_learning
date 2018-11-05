package classic;

import java.util.Arrays;

public class BitAdd {
	public static void main(String[] args) {
		System.out.println(bitAdd(13,14));
	}
	
	static int bitAdd(int a, int b) {
		if(a == 0) return b;
		if (b == 0) return a;
		 int sum = a ^ b;
		 int carry = (a&b) << 1;
		 return bitAdd(sum, carry);

	}
}

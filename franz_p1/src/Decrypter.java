import java.util.Arrays;

public class Decrypter
{
	public int[] decrypt(int[] num)
	{
		// Create a copy of the inputed array
		int[] result = Arrays.copyOf(num, 4);
		
		// Swap the first and third digits
		int temp = result[0];
		result[0] = result[2];
		result[2] = temp;
		
		// Swap the second and fourth digits
		int temp2 = result[1];
		result[1] = result[3];
		result[3] = temp2;
				
		// Subtract 7 from each digit, adding back 10 if a digit goes negative
		for (int i = 0; i < 4; i++)
		{
			result[i] -= 7;
			
			if (result[i] < 0)
				result[i] += 10;
		}
		
		return result;
	}
}
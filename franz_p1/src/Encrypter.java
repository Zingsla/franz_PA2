import java.util.Arrays;

public class Encrypter
{
	public int[] encrypt(int[] num)
	{
		// Create a copy of the inputed array
		int[] result = Arrays.copyOf(num, 4);
		
		// Add 7 to each digit and mod by 10
		for (int i = 0; i < 4; i++)
			result[i] = (result[i] + 7) % 10;
		
		// Swap the first and third digits
		int temp = result[0];
		result[0] = result[2];
		result[2] = temp;
		
		// Swap the second and fourth digits
		int temp2 = result[1];
		result[1] = result[3];
		result[3] = temp2;
		
		return result;
	}
}
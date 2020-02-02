import java.util.Scanner;

public class Application
{
	public static void main(String[] args)
	{
		// Instantiate Objects
		Application application = new Application();
		Encrypter encrypter = new Encrypter();
		Decrypter decrypter = new Decrypter();
		Scanner in = new Scanner(System.in);
		
		// Receive a 4 digit number from the user and store as an array of characters
		System.out.println("Please enter a number to encrypt/decrypt:");
		char[] numAsChars = in.next().toCharArray();
		
		// Convert the array of characters to an array of ints to store each digit
		int[] num = new int[4];
		for (int i = 0; i < 4; i++)
		{
			num[i] = numAsChars[i] - '0';
		}
		
		// Encrypt the number and print it out
		int[] encrypted = encrypter.encrypt(num);
		System.out.print("Encrypted: ");
		application.printNum(encrypted);
		
		// Decrypt the number and print it out
		int[] decrypted = decrypter.decrypt(num);
		System.out.print("Decrypted: ");
		application.printNum(decrypted);
	}
	
	// Prints an array of integers as one continuous numbers
	public void printNum(int[] toPrint)
	{
		// Loops through each digit and prints it
		for (int i = 0; i < 4; i++)
		{
			System.out.print(toPrint[i]);
		}
		
		// Prints the new line character
		System.out.println();
	}
}
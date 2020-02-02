import java.util.Scanner;

public class BMICalculator
{
	// Instance Fields
	private boolean metric;
	private double weight;
	private double height;
	private double bmi;
	private String category;
	private Scanner in;
	
	// Default Constructor
	public BMICalculator()
	{
		metric = false;
		weight = 0.0;
		height = 0.0;
		bmi = 0.0;
		category = "";
		in = new Scanner(System.in);
	}
	
	// Reads in the unit type and measurement data from the suer
	public void readUserData()
	{
		readUnitType();
		readMeasurementData();
	}
	
	// Calculates the user's BMI and Category with the given height, weight, and system
	// Use ONLY after reading user data
	public void calculateBmi()
	{
		// Uses Metric formula
		if (metric)
		{
			bmi = weight / (height * height);
		}
		
		// Uses Imperial formula
		else
		{
			bmi = (703 * weight) / (height * height);
		}
		
		// Finds correct category for calculated BMI
		calculateBmiCategory();
	}
	
	// Prints the user's BMI value, category, and all the BMI categories for reference
	// Use ONLY after reading user input and calculating BMI
	public void displayBmi()
	{
		System.out.printf("BMI Value: %.1f\n", bmi);
		System.out.println("BMI Category: " + category);
		System.out.println("\nBMI Category Reference:");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5-24.9");
		System.out.println("Overweight = 25-29.9");
		System.out.println("Obesity = BMI of 30 or greater");
	}
	
	// Getter functions
	public double getWeight()
	{
		return weight;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public String getBmiCategory()
	{
		return category;
	}
	
	// Detects the user's input unit type
	private void readUnitType()
	{
		String input; // Stores user input
		
		// Loop until valid input is received
		while (true)
		{
			// Prompt user for unit type
			System.out.println("Would you like to use Metric or Imperial units?");
			System.out.println("Please enter 'M' for Metric, or 'I' for Imperial");
			input = in.next();
			
			// Set to Metric if 'M' is received
			if (input.equalsIgnoreCase("M"))
			{
				this.metric = true;
				return;
			}
			
			// Set to Imperial if 'I' is received
			else if (input.equalsIgnoreCase("I"))
			{
				this.metric = false;
				return;
			}
			
			// If input is invalid, try again
			System.out.println("Invalid Input. Please try again.\n");
		}
	}
	
	// Reads the correct type of data based on the unit type
	private void readMeasurementData()
	{
		if (metric)
			readMetricData();
		else
			readImperialData();
	}
	
	// Reads in Metric weight and height
	private void readMetricData()
	{
		// Prompt the user for Metric weight
		System.out.println("Please enter your weight (in kilograms)");
		setWeight(in.nextDouble());
		
		// Exit if negative weight is entered
		if (this.weight < 0)
		{
			System.out.println("Invalid weight entry. Exiting program.");
			System.exit(0);
		}
		
		// Prompt the user for Metric height
		System.out.println("Please enter your height (in meters)");
		setHeight(in.nextDouble());
		
		// Exit if negative height is entered
		if (this.height < 0)
		{
			System.out.println("Invalid height entry. Exiting program.");
			System.exit(0);
		}
	}
	
	// Reads in Imperial weight and height
	private void readImperialData()
	{
		// Prompt the user for Imperial weight
		System.out.println("Please enter your weight (in pounds)");
		setWeight(in.nextDouble());
		
		// Exit if negative weight is entered
		if (this.weight < 0)
		{
			System.out.println("Invalid weight entry. Exiting program.");
			System.exit(0);
		}
		
		// Prompt the user for Imperial height
		System.out.println("Please enter your height (in inches)");
		setHeight(in.nextDouble());
		
		// Exit if negative height is entered
		if (this.height < 0)
		{
			System.out.println("Invalid height entry. Exiting program.");
			System.exit(0);
		}
	}
	
	// Determine the corresponding category for the calculated BMI value
	private void calculateBmiCategory()
	{
		if (bmi < 18.5)
			category = "Underweight";
		else if (bmi < 25)
			category = "Normal weight";
		else if (bmi < 30)
			category = "Overweight";
		else
			category = "Obesity";
	}
	
	// Setter methods
	private void setWeight(double w)
	{
		this.weight = w;
	}
	
	private void setHeight(double h)
	{
		this.height = h;
	}
	
// Main function for testing
//	public static void main(String[] args)
//	{
//		BMICalculator app = new BMICalculator();
//		app.readUserData();
//		app.calculateBmi();
//		app.displayBmi();
//	}
}
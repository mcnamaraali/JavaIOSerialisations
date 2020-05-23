/* Writing data to a sequential text file with class Formatter */
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
	public static void main(String[] args) {
		//open clients.txt, o/p data then close file
		try (Formatter formatOutput = new Formatter ("clients.txt")){
			Scanner input = new Scanner (System.in);
			System.out.printf("%s%n%s%n?",
					"Enter a/c number, first name, last name and balance.",
					"Enter end-of-file indicator to end input");
			
			while(input.hasNext()) {
				try {
					formatOutput.format("%d %s %s %.2f%n", input.nextInt(),
							input.next(), input.next(), input.nextDouble());
				}
				catch (NoSuchElementException elementException) {
					System.err.println("Invalid input. Please try again");
					input.nextLine(); //discard input so user can try again
					}
				System.out.print("? ");
				}
			}
			catch (SecurityException | FileNotFoundException
					| FormatterClosedException e) {
				e.printStackTrace();
		}			
	}
}	

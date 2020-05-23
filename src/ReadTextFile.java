import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

	public static void main(String[] args) {
		
		//opens clients.txt, reads its contents and closes the file
		try (Scanner input = new Scanner (Paths.get("clients.txt"))){
	
			System.out.printf("%-10s%-12s%-12s%10s%n",
					"a/c number ", "first name ", "last name " ,"balance");
			
			while(input.hasNext()) {
			
				System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(),input.next(),
						input.next(),input.nextDouble());
			
			}
	     } //Implicitly closes the file by calling the Scanner close method
		catch (IOException | NoSuchElementException | IllegalStateException e) {
				e.printStackTrace();
		}
	}

}

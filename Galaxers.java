/*
 * MacchiaroliM
 * Galaxers - File I/O
 * 2-19-17
 */
import java.util.NoSuchElementException;//end of file
import java.util.Scanner;//import scanner utility
import java.io.File;//file read
import java.io.PrintWriter;//file write
import java.io.FileNotFoundException;//file error
public class Galaxers {
	public static final String FileLocation = "C:\\\\Users\\\\macchiarolim\\\\eclipse-workspace\\\\Galaxers\\\\src\\\\votes.txt";
public static void main (String[] args) 
{
	try (Scanner fin = new Scanner(new File(FileLocation)))  {//Attempt input file
	//countVotes(fin);//count Votes
		String names[] = {"Zero", "One", "Two", "Three", "Four"};
		int tally[] = countVotes(fin);
	printVotes(tally);
	System.out.println(getWinner(tally, names));
	}
	catch (FileNotFoundException ex) {//If output cannot be established
			System.out.printf("Error! File not found!%n");
			System.exit(0);
		}
	}
public static int[] countVotes (Scanner input) {
	//read votes from file, tally, return array
	int tally[] = new int[5];
	String current ="";
	while(true) { //continuous loop
		try {//try to take next string
			current = input.next();
			tally[current.charAt(1)-'0']++;//increment tally where Candidate gets point
}
catch(NoSuchElementException e){break;}}//catch no more strings
	return tally;
}

public static void printVotes (int[] v) {
	//Print votes from array
	for(int i = 0; i<5; i++) {
		System.out.println("Candidate " + i + " has " + v[i] + " vote(s)");
		}
}

public static String getWinner (int[] results, String[] names) {
	//determines winner based on rules and returns name
	/*
	 * Total divisible by 3 and 8
	 * or randomly chosen
	 */
	String win = "The winner is: Candidate ";
	for(int i = 0; i<5; i++) {
	if((results[i] % 3 == 0)&&(results[i] % 8 == 0)) {
		win = win + names[i];
	}else {
		//lose
	}}
	if(win == "The winner is: Candidate ") {
		win = win + names[(int) (Math.random()*(4))];//assign random winner
	}
	return win;
}

}

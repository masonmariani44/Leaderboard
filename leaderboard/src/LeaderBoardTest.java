import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeaderBoardTest {
    private static int[] mVals = new int[]{10, 5, 10, 15, 20, 25};
    private static int[] nVals = new int[]{10, 10, 20, 50, 100, 500};
    
    public static void main(String[] args) {
	int score = 0;
	for(int i = 0; i < 6; i++) 
	    score += test(i);
	System.out.println("Total Score: " + score);
    }

    private static int test(int testNum) {
	System.out.println("***** BEGINNING TEST " + (testNum+1) + " *****");
	int m = mVals[testNum];
	LeaderBoard lb = new LeaderBoard(m);
	int n = nVals[testNum];
	Contestant[] exp = new Contestant[n];
	BufferedReader br;
	try {
	    br = new BufferedReader(new FileReader("names.txt"));
	    String line = br.readLine();
	    int count = 0;
	    while(count < n && line != null) {
		String[] split = line.split(",");
		String name = split[0];
		int score = Integer.parseInt(split[1]) * 10 + name.length();
		exp[count] = new Contestant(name, score);
		//System.out.println(new Contestant(name, score));
		lb.add(new Contestant(name, score));
		count++;
		line = br.readLine();
	    }
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	    return 0;
	}
	Contestant[] board = lb.finalBoard();
	//lb.printBoard();
	Arrays.sort(exp);
	for(int i = 0; i < m; i++) {
	    if(exp[n-i-1].compareTo(board[i]) != 0) {
		System.out.println("Values do not match at index " + i + ".");
		return 0;
	    }
	}
	System.out.println("Success!");
	return 10;
    }
}

    
	

import java.io.*;

public class BrattleShip {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		int testCases = Integer.parseInt(in.readLine());
		
		for(int i = 1; i < testCases+1; i++){
			String[] input= in.readLine().split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			int width = Integer.parseInt(input[2]);
			int result = col/width;
			
			
			if (col%width ==0)
				result += (width-1);
			else
				result+= width;
			System.out.println("Case #"+i+": "+result*row);
		
			}
		in.close();
	
	}
}
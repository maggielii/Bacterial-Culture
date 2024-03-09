package code;

import java.util.Scanner;

public class BacterialCulture {

	public static int flood(char[][] grid, int x, int y)
	{
		char oldLetter = grid[x][y];
		int count = 1;
		grid[x][y] = 'X';
		
		if(grid[x][y+1] == oldLetter)
		{
			count += flood(grid, x, y+1);
		}
		if(grid[x][y-1] == oldLetter)
		{
			count += flood(grid, x, y-1);
		}
		if(grid[x+1][y] == oldLetter)
		{
			count += flood(grid, x+1, y);
		}
		if(grid[x-1][y] == oldLetter)
		{
			count += flood(grid, x-1, y);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		String st = "";
			
		char[][] grid = new char[101][101];
			
		for(int x = 0; x < grid[0].length; x++)
		{
			grid[0][x] = 'X';
		}
			
		for(int x = 0; x < grid[0].length; x++)
		{
			grid[grid.length - 1][x] = 'X';
		}
			
		for(int x = 1; x < grid.length - 1; x++)
		{
			st = "X" + input.next() + "X";
				grid[x] = st.toCharArray();
		}
		
		//display
//		for(int x = 0; x < grid.length; x++)
//		{
//			for(int y = 0; y < grid[0].length; y++)
//			{
//				System.out.print(grid[x][y] + " ");
//			}
//			System.out.println(" ");
//		}
		
		char character = ' ';
		int count = 0;
		int maxA = 0, maxB = 0, maxC = 0;
		
		for(int x = 0; x < 101; x++)
		{
			for(int y = 0; y < 101; y++)
			{
				if(grid[x][y] != 'X')
				{
					character = grid[x][y];
					count = flood(grid, x, y);
				}
				
				if(character == 'A' && count > maxA)	
				{
					maxA = count;
				}
				if(character == 'B' && count > maxB)	
				{
					maxB = count;
				}
				if(character == 'C' && count > maxC)	
				{
					maxC = count;
				}
			}
		}
		
		if(maxA > maxB && maxA > maxC)
		{
			System.out.println("A" + maxA);
		}
		else if(maxB > maxA && maxB > maxC)
		{
			System.out.println("B" + maxB);
		}
		else
		{
			System.out.println("C" + maxC);
		}
		
	}
}

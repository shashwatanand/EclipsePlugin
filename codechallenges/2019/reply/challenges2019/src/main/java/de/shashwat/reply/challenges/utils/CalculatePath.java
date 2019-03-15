package de.shashwat.reply.challenges.utils;

import java.awt.event.FocusEvent.Cause;
import java.nio.charset.MalformedInputException;
import java.util.List;

import de.shashwat.reply.challenges.model.CellRep;
import de.shashwat.reply.challenges.model.CustomerH;
import de.shashwat.reply.challenges.model.ReplyMap;

public class CalculatePath {

	private ReplyMap replyMap;
	private List<CustomerH> customerHsList;
	private char[][] terrainCells;
	private int n;
	private int m;

	public CalculatePath(ReplyMap replyMap, List<CustomerH> customerHsList, char[][] terrainCells) {
		this.replyMap = replyMap;
		this.customerHsList = customerHsList;
		this.terrainCells = terrainCells;
		this.n = this.replyMap.getN();
		this.m = this.replyMap.getM();
	}

	public void solve() {
		int[][] solution = new int[n][m];
		solution[0][0] = terrainCells[0][0];
		for (int i = 1; i < terrainCells.length; i++) {
			solution[0][i] = terrainCells[0][i] + solution[0][i - 1];
		}

		for (int i = 1; i < terrainCells.length; i++) {
			solution[i][0] = terrainCells[i][0] + solution[i - 1][0];
		}

		// path will be either from top or left, choose which ever is minimum

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				solution[i][j] = terrainCells[i][j] + Math.min(solution[i - 1][j], solution[i][j - 1]);
			}
		}

		return solution[A.length - 1][A.length - 1];
	}

	private int costOfTerrain(int i, int j) {
		char ch = this.terrainCells[i][j];
		switch(ch) {
		case '#' :
			return CellRep.Mountain.getCost();
		case '~' :
			return CellRep.Water.getCost();
		case '*' :
			return CellRep.Traffic_jam.getCost();
		case '+' :
			return CellRep.Dirt.getCost();
		case 'X' :
			return CellRep.Railway_level_crossing.getCost();
		case '_' :
			return CellRep.Standard_terrain.getCost();
		case 'H' :
			return CellRep.Highway.getCost();
		case 'T' :
			return CellRep.Railway.getCost();
		}
		return Integer.MIN_VALUE;
	}
	
	public void calculate() {
		int maxValue = Math.max(n, m);
		int[][][] values = new int[maxValue][maxValue][maxValue];
		int answer = 0;
		if (terrainCells[n - 1][replyMap.getM() - 1] == CellRep.Mountain.getRep() || terrainCells[0][0] == CellRep.Mountain.getRep()) {
			answer = -1 * Integer.MIN_VALUE; 			
		}
		
	    if (terrainCells[0][0] != CellRep.Mountain.getRep()) {	    	
	    	answer++; 
	    }
	    terrainCells[0][0] = 'V'; 
	  
	    if (terrainCells[n - 1][m - 1] != CellRep.Mountain.getRep()) {	    	
	    	answer++; 
	    }
	    terrainCells[n - 1][m - 1] = 'V';
	    answer += solve(values, 0, 0, 0); 
	    return max(ans, 0); 
	}

	private int solve(int[][][] values, int row1, int col1, int row2) {
		int col2 = (row1 + col1) - (row2); 
		  
	    // If both path reach the bottom right cell 
	    if (row1 == n - 1 && col1 == m - 1 && 
	        row2 == n - 1 && col2 == m - 1) 
	        return 0; 
	  
	    // If moving out of grid 
	    if (row1 >= n || col1 >= m ||  
	        row2 >= n || col2 >= m) 
	        return -1 * Integer.MIN_VALUE; 
	  
	    if (values[row1][col1][row2] != -1) 
	        return values[row1][col1][row2]; 
	  
	    int ch1 = -1 * Integer.MIN_VALUE, ch2 = -1 * Integer.MIN_VALUE; 
	    int ch3 = -1 * Integer.MIN_VALUE, ch4 = -1 * Integer.MIN_VALUE; 
	  
	    // If path 1 is moving right and path 2  
	    // is moving down. 
	    if (terrainCells[row1][col1 + 1] != '#' &&  
	    		terrainCells[row2 + 1][col2] != '#') 
	      ch1 = cost(grid, row1, col1 + 1, row2 + 1, col2) +  
	        solve(n, m, grid, dp, row1, col1 + 1, row2 + 1); 
	  
	    // If path 1 is moving right and path 2 is moving 
	    // right. 
	    if (terrainCells[row1][col1 + 1] != '#' &&  
	    		terrainCells[row2][col2 + 1] != '#') 
	      ch2 = cost(grid, row1, col1 + 1, row2, col2 + 1) +  
	            solve(n, m, grid, dp, row1, col1 + 1, row2); 
	  
	    // If path 1 is moving down and path 2 is moving right. 
	    if (terrainCells[row1 + 1][col1] != '#' &&  
	    		terrainCells[row2][col2 + 1] != '#') 
	     ch3 = cost(grid, row1 + 1, col1, row2, col2 + 1) +  
	           solve(n, m, grid, dp, row1 + 1, col1, row2); 
	  
	    // If path 1 is moving down and path 2 is moving down. 
	    if (terrainCells[row1 + 1][col1] != '#' &&  
	    	terrainCells[row2 + 1][col2] != '#') 
	      ch4 = cost(grid, row1 + 1, col1, row2 + 1, col2) + 
	         solve(n, m, grid, dp, row1 + 1, col1, row2 + 1); 
	  
	    // Returning the maximum of 4 options. 
	    return dp[row1][col1][row2] = max({ch1, ch2, ch3, ch4}); 
	}

}

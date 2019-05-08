package com.mdshkv.md;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BoggerProblem {	
	
	//8 position
	//left, right, up, down, up/right, left/down, right/down, up/left,
	static int [] rowPos= 	{ 0, 0,	-1,	1,	-1,	1,	1,	-1};
	static int [] colPos = {-1,  1,	 0,	0,   1, 1, -1,  -1};
	
	static Map<String, Integer> frequency = new HashMap<String, Integer>();
	public static void main(String[] args) {
		
		char[][] input = {
				{'F','E','B','P'},
				{'O','O','O','R'},
				{'P','K','O','V'},
				{'A','I','I','G'}
		};
		
		boolean [][] visited =new boolean[4][4];
		List<String> list=new ArrayList<String>();
		list.add("BOOK");
		
		list.add("POORVI");
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				visited[i][j] =true;
					findWord(input,visited,input[i][j]+"",i,j,list);
					visited[i][j] =false;
			}
		}
		
		for (Entry<String, Integer> entry : frequency.entrySet())  {
            System.out.println("Word = " + entry.getKey() + ", count = " + entry.getValue());
		}
		
	}
	
	private static void findWord(char[][] input, boolean[][] visited, String word, int row, int col, List<String> list) {
		if(list.contains(word)) {
			int count = frequency.containsKey(word) ? frequency.get(word) : 0;
			frequency.put(word, count + 1);
		}
		
		if(16==word.length()) {   // 16 is max number of word form matrix
			return;
		}
		
		for (int k = 0; k < rowPos.length; k++) {
			
			//updating new position in array
			int newRow=row+rowPos[k];  
			int newCol=col+colPos[k];
			
			//checking for valid position
			if(isValidPostion(visited,newRow,newCol)) {
				visited[newRow][newCol] =true;
				findWord(input, visited, word+input[newRow][newCol], newRow, newCol, list); //recursively calling same method with updated postion
				visited[newRow][newCol]=false;
					
			}
			
		}
		
		}

	private static boolean isValidPostion(boolean[][] visited, int newRow, int newCol) {
		if(newRow>=0 && newCol >=0 && newRow<visited.length&&newCol<visited.length && !visited[newRow][newCol]) {
			return true;
		}
		
		return false;
	}

}

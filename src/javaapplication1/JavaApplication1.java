/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Vancha
 */
public class JavaApplication1 {

    public static int[][] board = { { 0, 2, 6, 0, 0, 0, 8, 1, 0 },
				 { 3, 0, 0, 7, 0, 8, 0, 0, 6 }, 
				 { 4, 0, 0, 0, 5, 0, 0, 0, 7 },
				 { 0, 5, 0, 1, 0, 7, 0, 9, 0 }, 
				 { 0, 0, 3, 9, 0, 5, 1, 0, 0 },	
				 { 0, 4, 0, 3, 0, 2, 0, 5, 0 }, 
				 { 1, 0, 0, 0, 3, 0, 0, 0, 2 },
				 { 5, 0, 0, 2, 0, 4, 0, 0, 9 }, 
				 { 0, 3, 8, 0, 0, 0, 4, 6, 0 } };;
    public static int boardSize = 9;
    countClass count = new countClass();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //board = new int[boardSize][boardSize];
        
        JavaApplication1 a = new JavaApplication1();
        //initializeBoard(board);
        //showBoard(board);
        if(a.Solver(board))
        {
            System.out.println("sudoku solved");
            showBoard(board);
        }
        else
        {
            System.out.println("sudoku failed");
        }
        
    }
   
    public static void showBoard(int[][] board)
{
for(int i = 0;i < 9;i++)
	{
		for(int j = 0;j < 9;j++)
		{
			System.out.print(" "+board[i][j]+" ");
			if(j == 8)
			{
				System.out.println(" ");
			}
			
		}
	}
}

    
    public boolean Solver(int[][] board)
    {
        
        /*if(!findUnassignedLocation(board, count))
        {
            return true;
        }
        
        for(int number = 1;number < boardSize;number++)
        {
            if(isSafe(board, count.i, count.j, number))
            {
                board[count.i][count.j] = number;
                if(Solver(board))
                {
                    
                    return true;
                }
                
                board[count.i][count.j] = 0;
            }
        }
        return false;*/
        int row =  count.i;
	int col =  count.j;

		if (!findUnassignedLocation(board, count)) {
			return true;
		}
		int num;
		for (num = 1; num <= 9; num++) {
			if (isSafe(board, count.i, count.j, num)) {
				int rowValue = count.i, colValue = count.j;
				board[rowValue][colValue] = num;
				if (Solver(board))
                                {
                                    
					return true;
                                }
				board[rowValue][colValue] = 0;
			}
		}
		return false;
    }
    
    public boolean findUnassignedLocation(int[][] board, countClass count)
    {
        for(int i = 0;i < 9;i++)
        {
            for(int j = 0;j < 9;j++)
            {
                if(board[i][j] == 0)
                {
                    count.i = i;
                    count.j = j;
                    return true;
                }
            }
        }
        
        return false;
       
    }
    
    public boolean isSafe(int[][] grid, int rowValue, int colValue, int num)
    {
       if (!usedInRow(grid, rowValue, num)
				&& !usedInCol(grid, colValue, num)
				&& !usedInBox(grid, rowValue - rowValue % 3, colValue
						- colValue % 3, num)) {
			return true;
		}
		return false;
    }
    
    private static boolean usedInBox(int[][] grid, int rowValue, int colValue, int num) {
		int x, y;
		for (x = 0; x < 3; x++) {
			for (y = 0; y < 3; y++) {
				if (grid[rowValue + x][colValue + y] == num)
					return true;
			}
		}
		return false;
	}

	private static boolean usedInCol(int[][] grid, int colValue, int num) {
		int x;
		for (x = 0; x < 9; x++) {
			if (grid[x][colValue] == num)
				return true;
		}
		return false;
	}
        private static boolean usedInRow(int[][] grid, int rowValue, int num) {
		int y;
		for (y = 0; y < 9; y++) {
			if (grid[rowValue][y] == num)
				return true;
		}
		return false;
	}
    
}

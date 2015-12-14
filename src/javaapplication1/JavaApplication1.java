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

    public static int[][] board;
    public static int boardSize = 9;
    countClass count = new countClass();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        board = new int[boardSize][boardSize];
        JavaApplication1 a = new JavaApplication1();
        initializeBoard(board);
        showBoard(board);
        if(a.Solver(board))
        {
            System.out.println("sudoku solved");
        }
        
    }
    public static void initializeBoard(int[][] board)
    {
        for(int i = 0;i < 9;i++)
	{
		for(int j = 0;j < 9;j++)
		{
				board[i][j] = 0;
				if(i == 0 && j == 0)board[i][j] = 7;
				if(i == 0 && j == 1)board[i][j] = 9;
				if(i == 0 && j == 6)board[i][j] = 3;
				if(i == 1 && j == 5)board[i][j] = 6;
				if(i == 1 && j == 6)board[i][j] = 9;
				if(i == 2 && j == 0)board[i][j] = 8;
				if(i == 2 && j == 4)board[i][j] = 3;
				if(i == 2 && j == 7)board[i][j] = 7;
				if(i == 2 && j == 8)board[i][j] = 6;
				if(i == 3 && j == 5)board[i][j] = 5;
				if(i == 3 && j == 8)board[i][j] = 2;
				if(i == 4 && j == 2)board[i][j] = 5;
				if(i == 4 && j == 3)board[i][j] = 4;
				if(i == 4 && j == 4)board[i][j] = 1;
				if(i == 4 && j == 5)board[i][j] = 8;
				if(i == 4 && j == 6)board[i][j] = 7;
				if(i == 5 && j == 0)board[i][j] = 4;
				if(i == 5 && j == 3)board[i][j] = 7;
				if(i == 6 && j == 0)board[i][j] = 6;
				if(i == 6 && j == 1)board[i][j] = 1;
				if(i == 6 && j == 4)board[i][j] = 9;
				if(i == 6 && j == 8)board[i][j] = 8;
				if(i == 7 && j == 2)board[i][j] = 2;
				if(i == 7 && j == 3)board[i][j] = 3;
				if(i == 8 && j == 2)board[i][j] = 9;
				if(i == 8 && j == 7)board[i][j] = 5;
				if(i == 8 && j == 8)board[i][j] = 4;
		}
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
        S
        if(!findUnassignedLocation(board, count))
        {
            //System.out.println("waarden zijn: "+ count.i + ", voor de rij, en " + count.j + " voor de kolom.");
            return true;
        }
        //System.out.println("on row " + count.i + " and column " + count.j);
        
        for(int number = 1;number < boardSize;number++)
        {
            if(isSafe(board, count.i, count.j, number))
            {
                board[count.i][count.j] = number;
                showBoard(board);
                if(Solver(board))
                {
                    //System.out.println("waarden zijn: "+ count.i + ", voor de rij, en " + count.j + " voor de kolom.");
                    return true;
                }
                
                board[count.i][count.j] = 0;
                //System.out.println("waarden zijn: "+ count.i + ", voor de rij, en " + count.j + " voor de kolom.");
            }
        }
        //System.out.println("waarden zijn: "+ count.i + ", voor de rij, en " + count.j + " voor de kolom, fout tegengekomen.");
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
                    if(j == 6) System.out.println("ben wel bij 5 gekomen.");
                    count.i = i;
                    count.j = j;
                    //System.out.println("findlocation returned row" +count.i+ " column "+ count.j);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isSafe(int[][] puzzle, int row, int column, int number)
    {
        int i=0;
        int sectorRow = 3*(row/3);
        int sectorCol = 3*(column/3);
        int row1 = (row+2)%3;
        int row2 = (row+4)%3;
        int col1 = (column+2)%3;
        int col2 = (column+4)%3;
        
            for(int x = 0; x < boardSize;x++)
            {
                if(board[row][x] == number)
                {
                    return false;
                }
                if(board[x][column] == number){
                    return false;
                }
            }
            
            
            if(puzzle[row1+sectorRow][col1+sectorCol] == number) return false;
            if(puzzle[row2+sectorRow][col1+sectorCol] == number) return false;
            if(puzzle[row1+sectorRow][col2+sectorCol] == number) return false;
            if(puzzle[row2+sectorRow][col2+sectorCol] == number) return false;
        
        return true;
    }
    
}

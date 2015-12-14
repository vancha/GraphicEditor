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
    int row = 0, col = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        board = new int[boardSize][boardSize];
        JavaApplication1 a = new JavaApplication1();
        initializeBoard(board);
        a.Solver(board);
    }
    public static void initializeBoard(int[][] board)
    {
        for(int i = 0;i < boardSize;i++)
        {
            for(int j = 0;j < boardSize;j++)
            {
                board[i][j] = 0;
                
            }
        }
    }
    
    public boolean Solver(int[][] board)
    {
        if(!findUnassignedLocation(board, row, col))
        {
            System.out.println("waarden zijn: "+ row + ", voor de rij, en " + col + " voor de kolom.");
            return true;
        }
        
        for(int number = 1;number < boardSize;number++)
        {
            if(isSafe(board, row, col, number))
            {
                board[row][col] = number;
                if(Solver(board))
                {
                    return true;
                }
                
                board[row][col] = 0;
            }
        }
            return false;
    }
    
    public boolean findUnassignedLocation(int[][] board, int row, int col)
    {
        for(int i = 0;i < boardSize;i++)
        {
            for(int j = 0;j < boardSize;j++)
            {
                if(board[i][j] == 0)
                {
                    row = i;
                    col = j;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isSafe(int[][] board, int row, int column, int number)
    {
        
            for(int i = 0; i < boardSize;i++)
            {
                if(board[row][i] == number) return false;
                if(board[i][column] == number) return false;
            }
        
        return true;
    }
    
}

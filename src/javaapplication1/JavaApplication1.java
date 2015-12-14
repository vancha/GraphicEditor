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

    public int[][] board;
    public int boardSize = 9;
    int row = 0, col = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    boolean Solver(int[][] board)
    {
        if(!findUnassignedLocation(board, row, col))
        {
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
                }
            }
        }
        return true;
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

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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void Solver(int[][] board)
    {
        
        
    }
    public boolean isValidMove(int[][] board, int row, int column, int number)
    {
        
            for(int i = 0; i < boardSize;i++)
            {
                if(board[row][i] == number) return false;
                if(board[i][column] == number) return false;
            }
        
        return true;
    }
    
}

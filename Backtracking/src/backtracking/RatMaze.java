/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author pprashan
 */
/* Rat in a Maze */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

/*matrix for test case
rat can move forward or downward only
 {1, 0, 0, 0}
 {1, 1, 0, 1}
 {0, 1, 0, 0}
 {1, 1, 1, 1}

*/

public class RatMaze
{

	final int N = 4;
	
	//utility function to print the matrix
	void printSolution(int sol[][]){
		for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                            System.out.print(" "+sol[i][j]+" ");
                    }
                    System.out.println();
		}

		

	}
	
	//utility function to check if the move is valid
	boolean isSafe(int maze[][], int x, int y){
		return(x>=0 && x<N && y>=0 && y<N && maze[x][y]==1);
	}

        boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
            
            
           
            //check if goal is reached
            if(x==N-1 && y==N-1){
                
                sol[x][y] = 1;
                return true;
            }
            //check if maze[x][y] is valid
            if(isSafe(maze, x, y) == true){
                //mark x and y as sol path
                sol[x][y] = 1;
                
                //move forward in x direction
                if(solveMazeUtil(maze,x+1,y,sol)){
                    return true;
                }
                
                //move downward in downward direction
                if(solveMazeUtil(maze,x,y+1,sol)){
                    return true;
                }
                
                //if none of the moves are feasible
                sol[x][y] = 0;
                return false;
            }
            return false;
        }
	
        boolean solveMaze(int maze[][]){
            int sol[][] = {{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
            if(solveMazeUtil(maze,0,0,sol) == false){
                System.out.println("Solution does not exists");
                return false;
            }
            printSolution(sol);
            return true;
	}
	
        public static void main(String args[]){
            RatMaze rat = new RatMaze();
            int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
            };
            rat.solveMaze(maze);
        }
    
    
}

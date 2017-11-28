/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;
/**
 *
 * @author pprashan
 */
public class TowerOfHanoi {
    private int discs;
    private Stack<String> towerA;
    private Stack<String> towerB;
    private Stack<String> towerC;
    
    public TowerOfHanoi(){
        this.discs = 3;
        initializeTower(); 
    }
    
     public TowerOfHanoi(int N){
        this.discs = N;
        initializeTower();
    }
    
    public void printTowers(){
        Stack<String> temp = new Stack<String>();
        
        System.out.println("******************************************");
        System.out.println("******************************************");
       
        System.out.println("Tower A State: ");
        temp.addAll(towerA);
        int size = towerA.size();
        for(int i=0; i<size; i++){
          System.out.println(" -- "+ temp.pop() + " -- ");   
        }

        System.out.println("Tower B State:");
        temp.addAll(towerB);
        size = towerB.size();
        for(int i=0; i<size; i++){
          System.out.println(" -- "+ temp.pop() + " -- ");   
        }
        temp.clear();
        
        System.out.println("Tower C State:");
        temp.addAll(towerC);
        size = towerC.size();
        for(int i=0; i<size; i++){
          System.out.println(" -- "+ temp.pop() + " -- ");   
        }
        temp.clear();
    }
   
   
    
    private void initializeTower(){
        
        towerA = new Stack<String>();
        towerB = new Stack<String>();
        towerC = new Stack<String>();
        for(int i=discs; i>=1; i--){
            towerA.push(Integer.toString(i));
        }
    }

    private void move(Stack<String> X, Stack<String> Y){
        Y.push(X.pop());
    }
    
    private void solveUtil1(int n, char fromTower , char toTower, char auxTower ){
        
        if(n>=1){
            //move n-1 discs to aux tower
            solveUtil1(n-1, fromTower, auxTower, toTower);
            //move disc from ft to tt
            System.out.println("Move disc from tower: "+fromTower + " --> to tower: "+toTower );    
            //move n-1 discs from aux tower to to tower
            solveUtil1(n-1, auxTower, toTower, fromTower);
            
        }
    }
    
    private void solveUtil2(int n, Stack<String> fromTower , Stack<String> toTower, Stack<String> auxTower ){
        
        if(n>=1){
            //move n-1 discs to aux tower
            solveUtil2(n-1, fromTower, auxTower, toTower);
            //move disc from ft to tt
            move(fromTower,toTower);
            //print the state of all the towers
            printTowers();
            //move n-1 discs from aux tower to to tower
            solveUtil2(n-1, auxTower, toTower, fromTower);
            
        }
    }
    
    public void solveTowerOfHanoi(){
        //solveUtil1(this.discs,'A','B','C');
        System.out.println("initial configuration");
        printTowers();
        solveUtil2(this.discs,towerA,towerB,towerC);
    }
    
    
    public static void main(String[] args){
        TowerOfHanoi tower = new TowerOfHanoi(5);
        tower.solveTowerOfHanoi();
    }
}

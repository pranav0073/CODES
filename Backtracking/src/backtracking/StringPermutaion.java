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
public class StringPermutaion {
    private String str;
    private int len;
    private StringPermutaion(){
        this.str = "ABC";
        this.len = str.length();
    }
    public StringPermutaion(String str){
        this.str = str;
        this.len = str.length();
    }
    
    private void swap(int a, int b){
        char[] temp = str.toCharArray();
        char t = temp[a];
        temp[a] = temp[b];
        temp[b] = t;
        str = String.valueOf(temp);
        
    }
    
    private void permutateUtil(int l){
        //System.out.println("function called");
        if(l==len-1){
            System.out.println(str);
            return;    
        }
        
        for(int i=l; i<len; i++){
            
            swap(l,i);
            
            permutateUtil(l+1);
            
            swap(l,i); //backtrack
        }
        
    }
    public void permutate(){
        int l = 0;
        int r = str.length();
        permutateUtil(l);
                
    }
    
    public static void main(String args[]){
        StringPermutaion permutate = new StringPermutaion("ABC");
        permutate.permutate();
    }
    
}

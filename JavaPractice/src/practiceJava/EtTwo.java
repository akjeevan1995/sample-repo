package practiceJava;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Company {
    void assignSalaries(int[] salaries);
    void averageSalary();
    void maxSalary();
    void minSalary();

//public class EngineerFirm implements Company{
//    int count;
//    int arr[];
//    EngineerFirm(int x){
//        this.count=x;
//    }
//    void assignSalaries(int[] salaries){
//        for(int i=0;i<salaries.length;i++){
//            arr[i]= salaries[i];
//        }
//    }
//    void maxSalary(){
//        int max = arr[0];
//        for(int i=1; i<arr.length; i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//        }
//        System.out.println("Max sal is: "+max);
//    }
//    void minSalary(){
//        int min = arr[0];
//        for(int i=1; i<arr.length; i++){
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }
//        System.out.println("Min sal is: "+min);
//    }
//} 
//
//		public class EtTwo 
//		{
//    public static void main(String args[]) {
//       Scanner sc = new Scanner(System.in);
//  
//
//        String[] count = sc.nextLine().split(" ");
//
//        EngineerFirm e = new EngineerFirm(Integer.parseInt(count[0]));
//        AccountantFirm a = new AccountantFirm(Integer.parseInt(count[1]));
//
//        count = sc.nextLine().split(" ");
//
//        int[] incomeEngineers = new int[count.length];
//
//        for (int i=0; i < count.length; i++) {
//            incomeEngineers[i] = Integer.parseInt(count[i]);
//        }
//        e.assignSalaries(incomeEngineers);
//
//        count = sc.nextLine().split(" ");
//
//        int[] incomeAccountants = new int[count.length];
//
//        for (int i=0; i < count.length; i++) {
//            incomeAccountants[i] = Integer.parseInt(count[i]);
//        }
//        a.assignSalaries(incomeAccountants);
//
//        e.averageSalary();
//        e.maxSalary();
//        e.minSalary();
//
//        a.averageSalary();
//        a.maxSalary();
//        a.minSalary();
    }
    

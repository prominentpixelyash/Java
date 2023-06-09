package com.prominentpixel.FileIO;

import java.util.Scanner;

public class MatrixOperation {

    public static  void printMatrix(String[][] matrix,int n){
        System.out.println("Matrix after completion");

        for (int a=0;a<n;a++){
            for (int b=0;b<n;b++){
                System.out.print(matrix[a][b]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter ROw and Column size");

        int n=scanner.nextInt();

        System.out.println("Enter the number of operation perform on matrix");

        int k= scanner.nextInt();

        String[][] matrix=new String[n][n];



        for (int a=0;a<n;a++){
            for (int b=0;b<n;b++){
                matrix[a][b]="0";
            }
        }

        while(k-->0){

            System.out.println("Enter value of i (row)");

            int i=scanner.nextInt();

            System.out.println("Enter value of j (column)");

            int j=scanner.nextInt();

            for (int a=0;a<n;a++){
                matrix[i][a]="X";
            }

            for (int a=0;a<n;a++){
                matrix[a][j]="X";
            }

        }

        System.out.println("Operation is completed........");

        printMatrix(matrix,n);

        int countOfEmptyCell=0;

        for (int a=0;a<n;a++){
            for (int b=0;b<n;b++){
                if(matrix[a][b]=="0"){
                    countOfEmptyCell+=1;
                }
            }
        }

        System.out.println("Number of empty cell is "+countOfEmptyCell);

    }


}

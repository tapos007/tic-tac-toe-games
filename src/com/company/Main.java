package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[][] borad = new int[3][3];
    private static boolean gameStatus = true;
    private static int playerNumber = 1;
    private static  int Winplayer = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here


        while (gameStatus) {
            if(checkRowGameWin(1) || checkColumnGameWin(1) || checkRowGameWin(2) || checkColumnGameWin(2)){
                System.out.println("hurray!!!!! "+ Winplayer + " win the game");
                gameStatus = false;
            }else{
                getinput();
            }


        }
    }

    public static void getinput() {
        System.out.println("player number: " + playerNumber);

        int row = getAccurateInput("row");
        int column = getAccurateInput("column");
        if (checkValueAlreadyExists(row, column)) {
            borad[row][column] = playerNumber;
            if(playerNumber==1){
                playerNumber = 2;
            }else{
                playerNumber = 1;
            }
        }else{
            System.out.println("already value exits in this row column");
        }

    }

    public static int getAccurateInput(String msg){

        boolean condition = true;
        int myNumber = 0;
        while (condition){
            try {
                System.out.print("please enter " + msg + " number:");
                int myInput = input.nextInt();
                if(myInput>2 || myInput<0){
                    throw new Exception();
                }
                myNumber = myInput;
                condition = false;

            }catch (Exception e){
                System.out.println("please enter correct "+ msg + " value");
                input.nextLine();
            }

        }
        return myNumber;

    }

    private static boolean checkValueAlreadyExists(int row, int column) {

        if (borad[row][column] != 0) {
            return false;
        }

        return true;

    }

    private  static boolean checkRowGameWin(int player){
        for (int i = 0; i < borad.length; i++) {
            if(borad[i][0]==player && borad[i][1]== player && borad[i][2]== player){
                Winplayer = player;
                return  true;
            }
        }
        return  false;
    }

    private static    boolean checkColumnGameWin(int player){
        for (int i = 0; i < borad.length; i++) {
            if(borad[0][i]==player && borad[1][i]== player && borad[2][i]== player){
                Winplayer = player;
                return  true;
            }
        }
        return  false;
    }


}

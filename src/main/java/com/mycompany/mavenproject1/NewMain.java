/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 * my name david-roi 
 * the game mine sweeper If I pressed and there was a mine I
 * lost If I put the flags on the bombs I won
 *
 * @author dmny8
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void startGame() {
        boolean flag1;
        boolean flag = true;
        Scanner cs = new Scanner(System.in);
        Minesweeper x = null;
        int row;
        int column;
        int sumBoom;
        String what;
        while (flag) {
            flag1 = true;
            System.out.println("plasee enter of the row of the board");
            row = cs.nextInt();
            System.out.println("plasee enter of the column of the board");
            column = cs.nextInt();
            System.out.println("plasee enter of the sum boom");
            sumBoom = cs.nextInt();
            try {
                x = new Minesweeper(row, column, sumBoom);
                flag = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        }
        x.printBoard();

        while (true) {
            flag1 = false;
            System.out.println("plasee enter of the row");
            row = cs.nextInt();
            System.out.println("plasee enter of the column");
            column = cs.nextInt();
            do {
                if (flag1) {
                    System.out.println("error plaess enter open or flag");
                } else {
                    System.out.println("you open enter open or flag enter flag");
                    flag1 = true;
                }
                what = cs.nextLine();
                what = what.toLowerCase();
            } while (!what.equals("open") && !what.equals("flag"));
            flag1 = false;
            if (what.equals("open")) {
                if (x.boom(row, column) == true) {
                    System.out.println("you losss");
                    break;
                } else {
                    x.open(row, column);
                    x.printBoard();
                }
            } else if (what.equals("flag")) {

                do {
                    if (flag1) {
                        System.out.println("erroe pless enter put or remov");
                    } else {
                        System.out.println("you want to flag put or remov");
                        flag1 = true;
                    }
                    what = cs.nextLine();
                    what = what.toLowerCase();
                } while (!what.equals("put") && !what.equals("remov"));

                if (what.equals("put")) {
                    x.flags(row, column, true);
                    x.printBoard();
                } else {
                    x.flags(row, column, false);
                    x.printBoard();

                }

                if (x.win()) {
                    System.out.println("you win ");
                    break;
                }
            }

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        startGame();

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;

/**
 * my name david-roi
 *
 * @author dmny8
 */
public class Minesweeper {

    private int[][] board;
    private int[][] boardGui;
    private int row;
    private int column;
    private int sumBoom;
    private int flagsBoom;
    private int maxRow = 20;
    private int maxColunm = 20;
    private int maxSumBoom;

    /**
     * @return the board that the computer uses
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * the method gets board and update the board
     *
     * @param board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * @return the board that shown to the player
     */
    public int[][] getBoard1() {
        return boardGui;
    }

    /**
     * the method gets board of the GUI and update the board
     *
     * @param boardGui
     */
    public void setBoard1(int[][] boardGui) {
        this.boardGui = boardGui;
    }

    /**
     * @return the row of the board
     */
    public int getRow() {
        return row;
    }

    /**
     * the method gets row and update row of the board
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column of the board
     */
    public int getColumn() {
        return column;
    }

    /**
     * the method gets column and update column of the board
     *
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return how many mines
     */
    public int getSumBoom() {
        return sumBoom;
    }

    /**
     * the method gets number the mines and update the number
     *
     * @param sumBoom
     */
    public void setSumBoom(int sumBoom) {
        this.sumBoom = sumBoom;
    }

    /**
     * @return how many flags
     */
    public int getFlagsBoom() {
        return flagsBoom;
    }

    /**
     * the method gets flags and update the flags
     *
     * @param flagsBoom
     */
    public void setFlagsBoom(int flagsBoom) {
        this.flagsBoom = flagsBoom;
    }

    /**
     * @return how many the max row that can be to the board
     */
    public int getMaxRow() {
        return maxRow;
    }

    /**
     * the method gets max row and update the max row
     *
     * @param maxRow
     */
    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    /**
     * @return how many the max column that can be to the board
     */
    public int getMaxColunm() {
        return maxColunm;
    }

    /**
     * the method gets max column and update the max column
     *
     * @param maxColunm
     */
    public void setMaxColunm(int maxColunm) {
        this.maxColunm = maxColunm;
    }

    /**
     *
     * @return how many the max max mines that can be to the board
     */
    public int getMaxSumBoom() {
        return maxSumBoom;
    }

    /**
     * the boot method gets three paramters and call function testError if the
     * function return error exits the function else create the board(with
     * functions createBoard)
     *
     * @param row
     * @param column
     * @param sumBoom
     * @throws Exception
     */
    public Minesweeper(int row, int column, int sumBoom) throws Exception {
        testError(row, column, sumBoom);
        this.row = row;
        this.column = column;
        this.sumBoom = sumBoom;
        this.flagsBoom = sumBoom;
        board = new int[row][column];
        boardGui = new int[row][column];
        createBoard();
    }

    /**
     * the function check square matrix into board count - Count the number of
     * mine Starts to go over the matrix if in the board we are off the lines
     * then say go ahead (do not comment) else check if If there is a mine then
     * count a signal
     *
     * @param placeRow
     * @param placeColumn
     * @return count
     */
    public int checkNoMinos(int placeRow, int placeColumn) {
        int count = 0;
        for (int i = placeRow - 1; i < placeRow + 2; i++) {
            if (i < 0 || i > row - 1) {
                continue;
            }
            for (int j = placeColumn - 1; j < placeColumn + 2; j++) {
                if (j < 0 || j > column - 1) {
                    continue;
                }
                if (board[i][j] == -4) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * the method(the method is Recursion) gets parameters and check(Departure
     * conditions) if the place different from -1 on bath boards if yes exit
     * method else check if square matrix There is no mine if yes on both boards
     * (computer and user) put number(As the amount of bombs) and exit else put
     * 0 In the same place on both boards (computer and user) This is where the
     * recursion begins
     *
     * @param placeRow
     * @param placeColumn
     */
    public void open(int placeRow, int placeColumn) {
        int count = 0;
        if (board[placeRow][placeColumn] != -1 && boardGui[placeRow][placeColumn] != -1) {
            return;
        }
        count = checkNoMinos(placeRow, placeColumn);
        if (count != 0) {
            board[placeRow][placeColumn] = count;
            boardGui[placeRow][placeColumn] = count;
            return;
        }
        board[placeRow][placeColumn] = 0;
        boardGui[placeRow][placeColumn] = 0;
        for (int i = placeRow - 1; i <= placeRow + 1; i++) {
            if (i < 0 || i > row - 1) {
                continue;
            }
            for (int j = placeColumn - 1; j <= placeColumn + 1; j++) {
                if (j < 0 || j > column - 1) {
                    continue;
                }
                open(i, j);
            }
        }

    }

    /**
     * the method print to screen the board
     */
    public void printBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("| " + boardGui[i][j] + " | ");
            }
            System.out.println();
        }
    }

    /**
     * the function gets parameters and checks if the size of the row don't
     * between 1 to maxRow(variable of max row) if the size of the column don't
     * between 1 to maxColumn(variable of max column) if yes
     * returnException(error of row and column (text(no it is max Row and no it
     * is max column))) else return Exception(error of row(text(no it is max
     * Row)))
     *
     * if the size of the column don't between 1 to maxColumn(variable of max
     * column) if the size of the row don't between 1 to maxRow(variable of
     * maxrow) if yes return Exception(error of row and column (text(no it is
     * max Row and no it is max column))) else return Exception(error of
     * column(text(no it is max column)))
     *
     * If the multiplication of a double row column is less than sumBoom
     * (variable of max mines) return Exception(error of mine(text(no it is max
     * mine)))
     *
     * @param row
     * @param column
     * @param sumBoom -this is the number mines of the game
     * @throws Exception
     */
    public void testError(int row, int column, int sumBoom) throws Exception {
        if (row <= 0 || row > maxRow) {
            if (column <= 0 || column > maxColunm) {
                throw new Exception("no it is max Row and no it is max Colunm");
            } else {
                throw new Exception("no it is max Row");
            }
        }
        if (column <= 0 || column > maxColunm) {
            if (row <= 0 || row > maxRow) {
                throw new Exception("no it is max Row and no it is max Colunm");
            } else {
                throw new Exception("no it is max Colunm");
            }
        }
        if ((row * column) <= sumBoom) {
            throw new Exception("no it is max boom");
        }
    }

    /**
     * The function puts the bombs in a random place in Table -4(mine) And in
     * everything else there -1
     */
    public void createBoard() {
        Random random;
        random = new Random();
        for (int i = sumBoom; i != 0; i--) {
            if (board[random.nextInt(row)][random.nextInt(column)] == -4) {
                i++;
                continue;
            }
            board[random.nextInt(row)][random.nextInt(column)] = -4;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == -4) {
                    boardGui[i][j] = -1;
                    continue;
                } else {
                    board[i][j] = -1;
                    boardGui[i][j] = -1;
                }
            }
        }
    }

    /**
     * The method accepts parameters if the flag (variable) is equal to false
     * Means they want to delete the flag and check if Is there a flag in the
     * same place ? if yes so print to user There is a flag in the same place
     * and exit from function else if you add to one flag (checks if the user
     * board) And the board in the same place is name -1 and check if is a mine
     * in the same place if true you add to one mine(sumBoom)(check with the
     * board of computer else (else of first if(Want to put a flag)) check if
     * the place different from -1 if yes print no -1 else Subtracting one from
     * flag (flagsBoom) and In the same place put -2 and check if In the same
     * place there is a mine if yes so from Subtracting one
     *
     * @param placeRow
     * @param placeColumn
     * @param flag
     */
    public void flags(int placeRow, int placeColumn, boolean flag) {
        if (flag == false) {
            if (boardGui[placeRow][placeColumn] != -2) {
                System.out.println("There is a flag in the same place ");
                return;
            } else {
                this.flagsBoom = this.flagsBoom + 1;
                boardGui[placeRow][placeColumn] = -1;

                if (board[placeRow][placeColumn] == -4) {
                    this.sumBoom = this.sumBoom + 1;
                }
            }
        } else {
            if (boardGui[placeRow][placeColumn] != -1) {
                System.out.println("no -1");
                return;
            }
            this.flagsBoom = this.flagsBoom - 1;
            boardGui[placeRow][placeColumn] = -2;

            if (board[placeRow][placeColumn] == -4) {
                this.sumBoom = this.sumBoom - 1;
            }
        }
    }

    /**
     * the function gets the place of the row and place of the column and check
     * if have mine return true else return false
     *
     * @param placeRow
     * @param placeColumn
     * @return if have mine return true else return false
     */
    public boolean boom(int placeRow, int placeColumn) {
        if (board[placeRow][placeColumn] == -4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * the function check if number flags equal number mine and number mine
     * equal 0 if yes(user win) so return true and exit from function else (the
     * user don't win) return false
     *
     * @return if the player win return true else return false
     */
    public boolean win() {
        if (flagsBoom == sumBoom && sumBoom == 0) {
            return true;
        } else {
            return false;
        }
    }
}

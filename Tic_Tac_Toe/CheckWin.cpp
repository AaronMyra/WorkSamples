//
// Created by student on 21/09/19.
//
// Checks if either the user or comp has won

#include "CheckWin.h"

bool checkCol(char letter, char (*gridPtr)[3][3],int row, int col){

    if((*gridPtr)[row][col] == letter && (*gridPtr)[row + 1][col] == letter && (*gridPtr)[row + 2][col] == letter){

        return true;
    }

    else {
        return false;
    }
}

bool checkRow(char letter, char (*gridPtr)[3][3],int row, int col){

    if((*gridPtr)[row][col] == letter && (*gridPtr)[row][col + 1] == letter && (*gridPtr)[row][col + 2] == letter){

        return true;
    }

    else {
        return false;
    }
}

bool checkDiagonal(char letter, char (*gridPtr)[3][3]){

    if((*gridPtr)[0][0] == letter && (*gridPtr)[1][1] == letter && (*gridPtr)[2][2] == letter){
        return true;
    }

    else if((*gridPtr)[2][0] == letter && (*gridPtr)[1][1] == letter && (*gridPtr)[0][2] == letter){
        return true;
    }

    else {
        return false;
    }
}

bool checkWin(char (*gridPtr)[3][3], char letter, int turn){

    //Iterates through columns
    for(int i = 0; i < 3; i++ ){

        if(checkCol(letter, gridPtr, 0, i)){
            return true;
        }
    }

    //Iterates through rows
    for(int i = 0; i < 3; i++ ){

        if(checkRow(letter, gridPtr, i, 0)){
            return true;
        }
    }

    if(checkDiagonal(letter, gridPtr)){
        return true;
    }

    else{
        return false;
    }
}
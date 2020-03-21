//
// Created by student on 22/09/19.
//
// Iterates through columns and rows for possible comp win

#include "CheckPossibleWin.h"
#include "CheckMove.h"

bool checkCol(char userLetter, char (*gridPtr)[3][3],int row, int col, char compLetter){

    if((*gridPtr)[row + 1][col] == compLetter && ((*gridPtr)[row][col] == compLetter || (*gridPtr)[row + 2][col] == compLetter)){

        if (compMoveCheck(gridPtr, row, col, userLetter, compLetter)){
            (*gridPtr)[row][col] = compLetter;
            return true;
        }

        else if (compMoveCheck(gridPtr, (row + 2), col, userLetter, compLetter)){
            (*gridPtr)[row + 2][col] = compLetter;
            return true;
        }

        else {
            return false;
        }

    }

    else if ((*gridPtr)[row][col] == compLetter && (*gridPtr)[row + 2][col] == compLetter){

        if (compMoveCheck(gridPtr, (row + 1), col, userLetter, compLetter)){
            (*gridPtr)[row + 1][col] = compLetter;
            return true;
        }

        else {
            return false;
        }
    }

    else {
        return false;
    }

}

bool checkRow(char userLetter, char (*gridPtr)[3][3],int row, int col, char compLetter){

    if((*gridPtr)[row][col + 1] == compLetter && ((*gridPtr)[row][col] == compLetter || (*gridPtr)[row][col + 2] == compLetter)){

        if (compMoveCheck(gridPtr, row, col, userLetter, compLetter)){
            (*gridPtr)[row][col] = compLetter;
            return true;
        }

        else if (compMoveCheck(gridPtr, row, (col + 2), userLetter, compLetter)){
            (*gridPtr)[row][col + 2] = compLetter;
            return true;
        }

        else {
            return false;
        }
    }

    else if ((*gridPtr)[row][col] == compLetter && (*gridPtr)[row][col + 2] == compLetter){

        if (compMoveCheck(gridPtr, row, (col + 1), userLetter, compLetter)){
            (*gridPtr)[row][col + 1] = compLetter;
            return true;
        }

        else {
            return false;
        }
    }

    else {
        return false;
    }
}

bool checkDiagonal(char userLetter, char (*gridPtr)[3][3], char compLetter){

    if((*gridPtr)[1][1] == compLetter && ((*gridPtr)[0][0] == compLetter || (*gridPtr)[2][2] == compLetter)){

        if (compMoveCheck(gridPtr, 0, 0, userLetter, compLetter)){
            (*gridPtr)[0][0] = compLetter;
            return true;
        }

        else if (compMoveCheck(gridPtr, 2, 2, userLetter, compLetter)){
            (*gridPtr)[2][2] = compLetter;
            return true;
        }

        else {
            return false;
        }
    }

    else if((*gridPtr)[1][1] == compLetter && ((*gridPtr)[2][0] == compLetter || (*gridPtr)[0][2] == compLetter)){

        if (compMoveCheck(gridPtr, 2, 0, userLetter, compLetter)){
            (*gridPtr)[2][0] = compLetter;
            return true;
        }

        else if (compMoveCheck(gridPtr, 0, 2, userLetter, compLetter)){
            (*gridPtr)[0][2] = compLetter;
            return true;
        }

        else {
            return false;
        }
    }

    else {
        return false;
    }
}

bool checkPossibleWin(char (*gridPtr)[3][3], char userLetter, char compLetter){

    //Iterates through columns
    for(int i = 0; i < 3; i++ ){

        if(checkCol(userLetter, gridPtr, 0, i, compLetter)){
            return true;
        }
    }

    //Iterates through rows
    for(int i = 0; i < 3; i++ ){

        if(checkRow(userLetter, gridPtr, i, 0, compLetter)){
            return true;
        }
    }

    if(checkDiagonal(userLetter, gridPtr, compLetter)){
        return true;
    }

    else{
        return false;
    }
}
//
// Created by student on 21/09/19.
//
// Check Block iterates through columns and rows calling the appropriate check function
//

#include "Block.h"
#include "CheckMove.h"

bool checkBlockCol(char userLetter, char (*gridPtr)[3][3],int row, int col, char compLetter, char *compMovePtr){

    // Checks middle cell of column and adjacent cells above and below for possible user wins and blocks accordingly
    if((*gridPtr)[row + 1][col] == userLetter && ((*gridPtr)[row][col] == userLetter || (*gridPtr)[row + 2][col] == userLetter)) {

        if ((*gridPtr)[row + 1][col] == userLetter && (*gridPtr)[row][col] == userLetter) {
            if (compMoveCheck(gridPtr, (row + 2), col, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[row + 2][col];
                (*gridPtr)[row + 2][col] = compLetter;
                return true;
            }
            else {
                return false;
            }
        }

        else if ((*gridPtr)[row + 1][col] == userLetter && (*gridPtr)[row + 2][col] == userLetter) {
            if (compMoveCheck(gridPtr, row, col, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[row][col];
                (*gridPtr)[row][col] = compLetter;
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

    // Checks cells on both ends of column for possible user wins and blocks accordingly
    else if ((*gridPtr)[row][col] == userLetter && (*gridPtr)[row + 2][col] == userLetter){
        if(compMoveCheck(gridPtr, (row + 1), col, userLetter, compLetter)){
            *compMovePtr = (*gridPtr)[row + 1][col];
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

bool checkBlockRow(char userLetter, char (*gridPtr)[3][3],int row, int col, char compLetter, char *compMovePtr){

    // Checks middle cell of row and adjacent cells to left and right for possible user wins and blocks accordingly
    if((*gridPtr)[row][col + 1] == userLetter && ((*gridPtr)[row][col] == userLetter || (*gridPtr)[row][col + 2] == userLetter)){

        if ((*gridPtr)[row][col + 1] == userLetter && (*gridPtr)[row][col] == userLetter) {
            if (compMoveCheck(gridPtr, row, (col + 2), userLetter, compLetter)) {
                *compMovePtr =(*gridPtr)[row][col + 2];
                (*gridPtr)[row][col + 2] = compLetter;
                return true;
            }
            else {
                return false;
            }
        }

        else if ((*gridPtr)[row][col + 1] == userLetter && (*gridPtr)[row][col + 2] == userLetter) {
            if (compMoveCheck(gridPtr, row, col, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[row][col];
                (*gridPtr)[row][col] = compLetter;
                return true;
            }
            else{
                return false;
            }
        }

        else {
            return false;
        }
    }

    // Checks cells on both ends of row for possible user wins and blocks accordingly
    else if ((*gridPtr)[row][col] == userLetter && (*gridPtr)[row ][col + 2] == userLetter){
        if(compMoveCheck(gridPtr, row, (col + 1), userLetter, compLetter)){
            *compMovePtr = (*gridPtr)[row ][col + 1];
            (*gridPtr)[row ][col + 1] = compLetter;
        }
        else {
            return false;
        }
    }

    else {
        return false;
    }
}

bool checkBlockDiagonal(char userLetter, char (*gridPtr)[3][3], char compLetter, char *compMovePtr) {

    // Checks if middle cell and cell on upper right or lower right is occupied
    if ((*gridPtr)[1][1] == userLetter && ((*gridPtr)[0][0] == userLetter || (*gridPtr)[2][2] == userLetter)) {

        if (compMoveCheck(gridPtr, 0, 0, userLetter, compLetter)) {
            *compMovePtr = (*gridPtr)[0][0];
            (*gridPtr)[0][0] = compLetter;
            return true;
        } else if (compMoveCheck(gridPtr, 2, 2, userLetter, compLetter)) {
            *compMovePtr = (*gridPtr)[2][2];
            (*gridPtr)[2][2] = compLetter;
            return true;
        } else {
            return false;
        }
    }

        // Checks if middle cell and cell on upper left or lower left is occupied
    else if ((*gridPtr)[1][1] == userLetter && ((*gridPtr)[2][0] == userLetter || (*gridPtr)[0][2] == userLetter)) {

        if (compMoveCheck(gridPtr, 2, 0, userLetter, compLetter)) {
            *compMovePtr = (*gridPtr)[2][0];
            (*gridPtr)[2][0] = compLetter;
            return true;
        } else if (compMoveCheck(gridPtr, 0, 2, userLetter, compLetter)) {
            *compMovePtr = (*gridPtr)[0][2];
            (*gridPtr)[0][2] = compLetter;
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

bool checkBlock(char (*gridPtr)[3][3], char userLetter, char compLetter, char *compMovePtr){

    //Iterates through columns
    for(int i = 0; i < 3; i++ ){

        if(checkBlockCol(userLetter, gridPtr, 0, i, compLetter, compMovePtr)){
            return true;
        }
    }

    //Iterates through rows
    for(int i = 0; i < 3; i++ ){

        if(checkBlockRow(userLetter, gridPtr, i, 0, compLetter, compMovePtr)){
            return true;
        }
    }

    //Check diagional combinations
    if(checkBlockDiagonal(userLetter, gridPtr, compLetter, compMovePtr)){
        return true;
    }

    else{
        return false;
    }
}
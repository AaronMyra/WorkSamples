//
// Created by student on 21/09/19.
//
// Checks if the the cell referenced is currently occupied

#include <iostream>
#include "CheckMove.h"
#include <string>

using namespace std;

bool compMoveCheck(char (*gridPtr)[3][3],int row, int col, char userLetter, char compLetter){

    if ((*gridPtr)[row][col] == userLetter || (*gridPtr)[row][col] == compLetter){
        return false;
    }

    else {
        return true;
    }
}

bool userMoveCheck(int userInput, char (*gridPtr)[3][3], char userLetter, char compLetter){

    if (userInput <= 3){
        if ((*gridPtr)[0][(userInput - 1)] == compLetter || (*gridPtr)[0][(userInput - 1)] == userLetter){
            return false;
        }
        else {
            (*gridPtr)[0][userInput - 1] = userLetter;
            return true;
        }

    } else if (userInput > 3 && userInput <= 6){
        if ( (*gridPtr)[1][(userInput - 4)] == compLetter ||  (*gridPtr)[1][(userInput - 4)] == userLetter){
            return false;
        }
        else {
            (*gridPtr)[1][userInput - 4] = userLetter;
            return true;
        }

    }else if (userInput > 6){
        if ( (*gridPtr)[2][(userInput - 7)] == compLetter ||  (*gridPtr)[2][(userInput - 7)] == userLetter){
            return false;
        }
        else {
            (*gridPtr)[2][userInput - 7] = userLetter;
            return true;
        }
    }
    else{
        return false;
    }
}
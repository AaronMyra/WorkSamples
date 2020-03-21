//
// Created by student on 21/09/19.
//
// Detailed comp move sequence

#include "CompMove.h"
#include "CheckMove.h"
#include "Block.h"
#include "CheckPossibleWin.h"

void compMove(char (*gridPtr)[3][3], char userLetter, char compLetter, int turn, char *compMovePtr){

    // If center column is not occupied take it
    if (compMoveCheck(gridPtr, 1, 1, userLetter, compLetter)){
        (*gridPtr)[1][1] = compLetter;
        *compMovePtr = '5';
        return;
    }

    // Perform check for possible comp win
    else if (checkPossibleWin(gridPtr, userLetter, compLetter)){
        return;
    }

    // Perform check for possible user win and block
    else if (checkBlock(gridPtr, userLetter, compLetter, compMovePtr)){
        return;
    }

    // Scripted moves
    else {

        if ((*gridPtr)[0][0] == userLetter && (*gridPtr)[2][2] == userLetter) {
            if (compMoveCheck(gridPtr, 1, 1, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[1][1];
                (*gridPtr)[1][1] = compLetter;
                return;
            }
            if ((compMoveCheck(gridPtr, 0, 1, userLetter, compLetter))){
                *compMovePtr = (*gridPtr)[0][1];
                (*gridPtr)[0][1] = compLetter;
                return;
            }
        }

        else if ((*gridPtr)[0][2] == userLetter && (*gridPtr)[2][0] == userLetter) {
            if (compMoveCheck(gridPtr, 1, 1, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[1][1];
                (*gridPtr)[1][1] = compLetter;
                return;
            }

            if (compMoveCheck(gridPtr, 2, 1, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[2][1];
                (*gridPtr)[2][1] = compLetter;
                return;
            }
        }

        // Random move
        else {
            for (int i = 0; i < 2; ++i) {

                if (i == 1) { i = 2; }

                if (compMoveCheck(gridPtr, i, 0, userLetter, compLetter)) {
                    *compMovePtr = (*gridPtr)[i][0];
                    (*gridPtr)[i][0] = compLetter;
                    return;;
                } else if (compMoveCheck(gridPtr, i, 2, userLetter, compLetter)) {
                    *compMovePtr = (*gridPtr)[i][2];
                    (*gridPtr)[i][2] = compLetter;
                    return;
                }

                if (i == 2) { i = 1; }
            }

            if (compMoveCheck(gridPtr, 0, 1, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[0][1];
                (*gridPtr)[0][1] = compLetter;
                return;
            } else if (compMoveCheck(gridPtr, 1, 0, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[1][0];
                (*gridPtr)[1][0] = compLetter;
                return;
            } else if (compMoveCheck(gridPtr, 1, 2, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[1][2];
                (*gridPtr)[1][2] = compLetter;
                return;
            } else if (compMoveCheck(gridPtr, 2, 1, userLetter, compLetter)) {
                *compMovePtr = (*gridPtr)[2][1];
                (*gridPtr)[2][1] = compLetter;
                return;
            }
        }
    }
}
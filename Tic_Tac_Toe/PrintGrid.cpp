//
// Created by student on 21/09/19.
//
// Iterates through 2D array and prints grid

#include "PrintGrid.h"
#include <iostream>
#include <iostream>

using namespace std;

void printGrid(char (*gridPtr)[3][3], int p_GridRow, int p_GridCol){

    cout << "\n\n";

    for (int i = 0; i <= p_GridRow - 1 ; ++i) {
        for (int j = 0; j <= p_GridCol - 1; ++j) {
            putchar((*gridPtr)[i][j]);
            if (j != 2){
                cout << " | ";
            }
        }
        if (i != 2){
            cout << "\n----------\n";
        }

    }
    cout << "\n\n\n";
}

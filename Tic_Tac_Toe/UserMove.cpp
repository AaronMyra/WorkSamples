//
// Created by student on 21/09/19.
//
// Get user input until valid entry
//
#include "UserMove.h"
#include <iostream>
#include <string>

#include "CheckMove.h"

using namespace std;

void userMove(char (*gridPtr)[3][3], char userLetter, char compLetter){

    int userInput;
    string errorMsg = "You have entered an invalid square. Please try again";
    string errorMsg2 = "\nThat location is already taken. Please try again.\n";
    bool valid;

    do {
        cout << "Enter the number of the location you would like to go: (eg. 1) ";

        cin >> userInput;
        if (cin.fail() || userInput < 1 || userInput > 9) {
            cin.clear();
            cin.ignore(1000, '\n');
            cout << errorMsg;
            valid = false;
        }
        else {
            valid = userMoveCheck(userInput, gridPtr, userLetter, compLetter);
            if(!valid){
                cout << errorMsg2;
            }
        }
    }while (!valid);


}
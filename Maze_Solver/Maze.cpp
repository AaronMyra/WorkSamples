//
// Created by student2007 on 2020-01-28.
//

#include "Maze.h"
#include "Stack.h"
#include <fstream>
#include <iostream>
#include <string>
//#define DEBUG

using namespace std;

Maze::Maze():rows(0), cols(0){}

Maze::~Maze() {
    for (int i = 0; i < rows; ++i) {
        delete [] maze[i];
    }
    delete [] maze;
}

int Maze::dynamicallyGenerateMaze(string filePath) {


    try {
        //Open file to get row/col counts
        ifstream inStream(filePath);
        string line;
        string tempLine;

        if (inStream.fail()) {
            throw;
        }

        while (!inStream.eof()) {
            getline(inStream, line);
            if(rows == 0){
                tempLine = line;
            }
            rows++;
        }

        if(tempLine[tempLine.length() - 1] != '\r'){
            cols = tempLine.length();
        }
        else{
            cols = tempLine.length() -1;
        }
        inStream.close();

        //Dynamically allocate array
        maze = new char *[rows];
        for (int i = 0; i < rows; ++i) {
            maze[i] = new char[cols];
        }

        //Open file to retrieve contents
        inStream.open(filePath);
        if (inStream.fail()) {
            throw;
        }
        int index = 0;
        while (!inStream.eof()) {
            getline(inStream, line);
            if(line[cols] != '\r'){
                line += "\r\n";
            }
            if (index == 0){
                int xIndex = 0;
                for (int i = 0; i < line.length() - 1; ++i) {
                    if (line[i] == ' '){
                        startPoint[0] = 0;
                        startPoint[1] = xIndex;
                    }
                    xIndex++;
                }
            }
            else if (index == rows - 1){
                int xIndex = 0;
                for (int i = 0; i < line.length() - 1; ++i) {
                    if (line[i] == ' '){
                        endPoint[0] = rows - 1;
                        endPoint[1] = xIndex;
                    }
                    xIndex++;
                }
            }
            else{
                if (line[0] == ' '){
                    startPoint[0] = index;
                    startPoint[1] = 0;
                }
                if (line[cols -1]  == ' '){
                    endPoint[0] = index;
                    endPoint[1] = cols -1;
                }
            }

            //Copy Contents
            //line.copy(maze[index], line.length()); //Cause memory issue on Maze4 (?)

            for (int j = 0; j < cols; j++) {
                maze[index][j] = line[j];
            }
            index++;
        }
        inStream.close();

        if (((startPoint[0] == -1) || (startPoint[1] == -1)) || ((endPoint[0] == -1) || (endPoint[1] == -1)))  {
            return 2;
        }
        return 0;
    } catch (...) {
        return 1;
    }
}

bool Maze::SolveMaze() {

    //Initialize stack
    Stack stack;
    stack.push(startPoint[0], startPoint[1]);
    maze[startPoint[0]][startPoint[1]] = '!';

    //South
    if (maze[startPoint[0] + 1][startPoint[1]] == ' ') {
        maze[startPoint[0]][startPoint[1]] = 's';
    }

        //East
    else if (maze[startPoint[0]][startPoint[1] + 1] == ' ') {
        maze[startPoint[0]][startPoint[1]] = 'e';
    }

        //West
    else if (maze[startPoint[0]][startPoint[1] - 1] == ' ') {
        maze[startPoint[0]][startPoint[1]] = 'w';
    }

        //North
    else if (maze[startPoint[0] - 1][startPoint[1]] == ' ') {
        maze[startPoint[0]][startPoint[1]] = 'n';
    }


    //Output the maze with unicode arrows and color
    do {
        int currentX = stack.getTop().getXPosition();
        int currentY = stack.getTop().getYPosition();

        //South
        if (maze[currentY + 1][currentX] == ' ') {
            stack.push(currentY + 1, currentX);
            maze[currentY + 1][currentX] = 's';
        }

            //East
        else if (maze[currentY][currentX + 1] == ' ') {
            stack.push(currentY, currentX + 1);
            maze[currentY][currentX + 1] = 'e';
        }

            //West
        else if (maze[currentY][currentX - 1] == ' ') {
            stack.push(currentY, currentX - 1);
            maze[currentY][currentX - 1] = 'w';
        }

            //North
        else if (maze[currentY - 1][currentX] == ' ') {
            stack.push(currentY - 1, currentX);
            maze[currentY - 1][currentX] = 'n';
        }

            //Backup
        else {
            maze[currentY][currentX] = '*';
            if (currentY != startPoint[0] && currentX != startPoint[1]){
                stack.pop();
            }
            else{
                return false;
            }

        }

#ifdef DEBUG
        //For Debugging
        printGrid();
#endif

    } while ((stack.getTop().getYPosition() != endPoint[0]) || (stack.getTop().getXPosition() != endPoint[1]));
    return true;
}

void Maze::printGrid() {
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            cout << maze[i][j];
        }
        cout << endl;
    }
}

ostream &operator<<(ostream &output, Maze &maze) {

    for (int i = 0; i < maze.rows ; ++i) {
        for (int j = 0; j < maze.cols; ++j) {
            switch (maze.maze[i][j]){
                case 'n':
                    output << "\033[1;31m\u2191\033[0m";
                    break;
                case 's':
                    output << "\033[1;31m\u2193\033[0m";;
                    break;
                case 'e':
                    output << "\033[1;31m\u2192\033[0m";
                    break;
                case 'w':
                    output << "\033[1;31m\u2190\033[0m";
                    break;
                case '*':
                    output << ' ';
                    break;
                default:
                    output << maze.maze[i][j];
                    break;
            }
        }
        output << '\n';
    }
}

bool Maze::outputSolvedMazeFile(string solutionDir, string fileName) {
    try {

        string line = "";
        ofstream outStream(solutionDir + fileName);
        if (outStream.fail()) {
            return false;
        }

        for (int i = 0; i < rows ; ++i) {
            for (int j = 0; j < cols; ++j) {
                switch (maze[i][j]){
                    case 'n':
                        line += "↑";
                        break;
                    case 's':
                        line += "↓";;
                        break;
                    case 'e':
                        line += "→";
                        break;
                    case 'w':
                        line += "←";
                        break;
                    case '*':
                        line += ' ';
                        break;
                    default:
                        line += maze[i][j];
                        break;
                }
            }
            line += '\n';
            outStream << line;
            line = "";
        }

        outStream.close();
        return true;
    }
    catch (...){
        return false;
    }
}
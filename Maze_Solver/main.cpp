#include <iostream>
#include "Maze.h"

int main() {

    string mazeTextFiles[6] = {"maze.txt", "maze2.txt", "maze3.txt", "maze4.txt", "mazex.txt", "mazeTest.txt"};
    string solutionDir = "/home/student2007/CLionProjects/Data-Structures/Assignments/Assignment 2/Mazes/Solutions/";
    int numOfMazes = sizeof(mazeTextFiles)/ sizeof(*mazeTextFiles);
    int errorCode;

    for (int i = 0; i < numOfMazes; ++i) {
        Maze maze;
        errorCode = maze.dynamicallyGenerateMaze("/home/student2007/CLionProjects/Data-Structures/Assignments/Assignment 2/Mazes/" + mazeTextFiles[i]);
        if (errorCode == 1){
            cout << "\nInvalid maze file. Error opening file." << endl;
            break;
        }
        else if(errorCode == 2){
            cout << "\nInvalid maze file. Invalid entrance/exit." << endl;
            break;
        }
        cout << "\n" << mazeTextFiles[i] << " - Original" << endl;
        cout << maze;
        if(!maze.SolveMaze()){
            cout << "Maze unsolvable." << endl;
            break;
        }
        cout << "\n" << mazeTextFiles[i] << " - Solved" << endl;
        cout << maze;

        if (!maze.outputSolvedMazeFile(solutionDir, mazeTextFiles[i])){
            cout << "Error outputting solution" << endl;
            break;
        }
    }
    return 0;
}

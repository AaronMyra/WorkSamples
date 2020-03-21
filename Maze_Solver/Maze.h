//
// Created by student2007 on 2020-01-28.
//

#ifndef ASSIGNMENT_2_MAZE_H
#define ASSIGNMENT_2_MAZE_H

#include <string>

using namespace std;

class Maze {
private:
    char **maze;
    int rows, cols;
    int startPoint[2] = {-1, -1};
    int endPoint[2] = {-1, -1};

public:
    Maze();
    ~Maze();
    int dynamicallyGenerateMaze(string filePath);
    bool SolveMaze();
    bool outputSolvedMazeFile(string solutionDir, string fileName);
    friend ostream &operator<<(ostream &output, Maze &maze);
    void printGrid();
};


#endif //ASSIGNMENT_2_MAZE_H

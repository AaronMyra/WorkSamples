cmake_minimum_required(VERSION 3.13)
project(TicTacToe)

set(CMAKE_CXX_STANDARD 14)

add_executable(TicTacToe main.cpp PrintGrid.cpp PrintGrid.h CheckMove.cpp CheckMove.h UserMove.cpp UserMove.h CheckWin.cpp CheckWin.h CompMove.cpp CompMove.h Block.cpp Block.h CheckPossibleWin.cpp CheckPossibleWin.h)
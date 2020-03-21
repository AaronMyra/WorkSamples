//
// Created by w0235012 on 11/13/2019.
//

#include "IOFunctions.h"
#include <string>
#include <fstream>
#include <iostream>
#include <exception>

using namespace std;

bool getFileContents(string filePath, string *contents){

    try {
        ifstream inStream(filePath);
        string line = "";

        if (inStream.fail()) {
            return false;
        }
        while (!inStream.eof()) {
            getline(inStream, line);
            *contents += line;
            *contents += '\n';

        }
        inStream.close();
        *contents += '\000';
    } catch (...){
        throw "File IO Exception Occurred";
    }
    return true;
}

void outputContents(string filePath, string contents){
    try {
        ofstream outStream(filePath);
        if (outStream.fail()) {
            throw "File IO exception occurred";
        }
        outStream << contents;
        outStream.close();
    }
    catch (Exception& e){
        cout << e.err << endl;
    }
    catch (...){
        throw "File output Exception Occurred";
    }
}

string replaceFileExtention(string filePath, string newExtention){
    bool fileExt = false;
    newExtention += '\000';

    for (int i = 0; i < filePath.size(); i++) {
        if (filePath[i] == '.'){
            fileExt = true;
        }
        if (fileExt){
            filePath[i] = '\000';
        }
    }

    for (int j = 0; j < filePath.size(); ++j) {
        if(filePath[j + 1] == '\000'){
            filePath.replace(j, 1, newExtention);
            break;
        }
    }
    return filePath;
}
string replaceChars(string *fileContents){

    try {
        string tempStr;
        int index = 0;

        for (int i = 0; i < fileContents->size(); i++) {
            char test = (*fileContents)[i];
            switch ((*fileContents)[i]) {
                case '<':
                    for (int j = index; j < i; ++j) {
                        tempStr += (*fileContents)[j];
                    }
                    tempStr += "&lt;";
                    index = i + 1;
                    break;
                case '>':
                    for (int j = index; j < i; ++j) {
                        tempStr += (*fileContents)[j];
                    }
                    tempStr += "&gt;";
                    index = i + 1;
                    break;
                case'\000':
                    for (int j = index; j < i; ++j) {
                        tempStr += (*fileContents)[j];
                    }
                    break;
                default:
                    break;
            }
        }
        tempStr = "<PRE>" + tempStr + "</PRE>";
        return tempStr;
    } catch (exception& exception){
        throw exception.what();
    }
}

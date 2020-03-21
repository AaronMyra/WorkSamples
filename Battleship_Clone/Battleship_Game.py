#Don't forget to rename this file after copying the template
#for a new program!
"""
Student Name:   Aaron Myra 
Program Title:  Battleship Game
Description:    A digital version of the 1967 Milton Bradley game of the same name.
"""

def tryAgainFunction():
    tryAgain = input("Would you like to play again (Y/N): ").upper()
    if tryAgain == "Y":
            main()
    elif tryAgain == "N":
        print("\n")
        quit()
    else:
        while tryAgain != "Y" or tryAgain != "N":
            print("You have entered an invalid value. Please try again.")
            tryAgain = tryAgainFunction


def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    import random

    fileName = ""
    accessMode = "r"
    # numberOfTurns = 30
    shipLocations2DList = []
    numberOfHitsLeft = 17
    shotLocationList =[]
    userError = 0
    carrierHits = 5
    battleshipHits = 4
    cruiserHits = 3
    submarineHits = 3
    destroyerHits = 2
    errorNumber = 0
    gameMode = [["easy", 45], ["normal", 30], ["hard", 20]]

    display2DMap = [[" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
                  ["1", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["2", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["3", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["4", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["5", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["6", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["7", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["8", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["9", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "],
                  ["10", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "]]

    gridMap =  [["A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1", "J1"],
                ["A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2", "J2"],
                ["A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3", "I3", "J3"],
                ["A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4", "I4", "J4"],
                ["A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5", "I5", "J5"],
                ["A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6", "I6", "J6"],
                ["A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7", "I7", "J7"],
                ["A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8", "I8", "J8"],
                ["A9", "B9", "C9", "D9", "E9", "F9", "G9", "H9", "I9", "J9"],
                ["A10", "B10", "C10", "D10", "E10", "F10", "G10", "H10", "I10", "J10"]]

    fileName = "Assignment_4\Battleship_Game\map.txt" 
    #fileName = "map.txt" # <---- root folder path

    #Open and read "map.txt"
    try:
        mapFile = open(fileName, accessMode)
        mapFileData = mapFile.read()
    except FileNotFoundError:
        print("\nThe program was unable to locate the 'map' file. Please try again\n")
        quit()
        
    print("\nWelcome To Battleship!")
    print("Would you like to play on 'Easy', 'Normal' or 'Hard'")
    difficultyMode = input("\nPlease enter which difficulty level you would like to play on: ").lower()
    
    while errorNumber == 0:
        try:
            for row in gameMode:
                if difficultyMode in row:
                    numberOfTurns = row[1]
                    errorNumber = 1
        
            #Display the number of missiles remaining
            print("\nYou have {0} missiles to sink all 5 ships\nLet's Play\n".format(numberOfTurns))

        except UnboundLocalError:
                print("Error! You have entered an invalid game mode. Please try again.")
                difficultyMode = input("\nPlease enter which difficulty level you would like to play on: ").lower()
    
    print("\nYou have {0} missiles to sink all 5 ships\nLet's Play\n".format(numberOfTurns))

    #Split data into list then into 2D list
    shipLocationsList = mapFileData.split("\n")    

    for row in shipLocationsList:
        shipLocations2DList.append(row.split(","))

    #For each turn prompt the user to enter a set of coridinates (Ex. A1)
    for counter in range(numberOfTurns):
        
        #Incriment the number of turn by -1
        numberOfTurns = numberOfTurns - 1

        #Empty list values
        shotLocationList = []
        userError = 0

        #display the display map
        for row in display2DMap:
            print(*row)
        userInput = input("\nEnter the cordinates you'd like to fire at (Ex. A1): ").upper()

        #Error checking if the user entered an invalid value
        while userError == 0:
            try:

                for row in gridMap:
                    if userInput in row:
                        shotLocationList.append(gridMap.index(row))
                    for column in row:
                        if userInput == column:
                            shotLocationList.append(row.index(column))
                
                if shipLocations2DList[shotLocationList[0]][shotLocationList[1]] == "1":
                        print("\nDirect Hit!")
                        display2DMap[shotLocationList[0] + 1][shotLocationList[1] +1] = "X"
                        numberOfHitsLeft -= 1
                else:
                    print("\nMISS!")
                    display2DMap[shotLocationList[0] + 1][shotLocationList[1] +1] = "O"
            
                userError = 1

            except IndexError:
                print("\nError! You have and invalid value")
                userInput = input("\nEnter the cordinates you'd like to fire at (Ex. A1): ").upper()

        print("You have {0} missiles remaining.".format(numberOfTurns))
        print("-------------------------------------\n")

        if numberOfHitsLeft == 0:
            print("You Win!\nYou sunk all the battleships")
            tryAgainFunction()
        elif numberOfTurns == 0:
            print("You Lose!\nYou have run out of missiles.")
            tryAgainFunction()

    
    #Close file
    mapFile.close()

    #Your code ends on the line above.

#Do not change any of the code below!
if __name__ == "__main__":
    main()
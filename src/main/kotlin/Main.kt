val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
    var currentState: Int = GameConstants.PLAYING
    var userInput = ""
    var counter = 0
    //game loop
    do {
        //FIR_board.printBoard()
        /** TODO implement the game loop
         * 1- accept user move
         * 2- call getComputerMove
         * 3- Check for winner
         * 4- Print game end messages in case of Win , Lose or Tie !
         */
        var player: Int = 1 //Set player for to start the move loop
        println("Enter q to quit")
        println("Enter c to clear the board")
        print("Select a space between 0-35: ")

        userInput = readln() //Read player move  and check for quit "q"
        var location: Int = 0 //Initialize Int move variable

        if(userInput == "q"){
            println("Game ended.")
            location = 999
        }else if(userInput == "c"){
            println("Board Cleared")
            FIR_board.clearBoard()
            location = 999
            counter = 0
        }else{
            location = userInput.toInt() //Check for quit and set location for function call
        }

        if (location <= 35) {
            FIR_board.setMove(player, location) //call other file
            FIR_board.computerCheck(FIR_board.computerMove()) //computer moves
            counter++
        } else if (location == 999) {
            //quit condition
        } else {
            println("Invalid input. Try again...") //error message reruns this loop
        }

        var win = FIR_board.checkForWinner()

        if (win == 1) {
            println("YOU WON!")
            currentState = GameConstants.RED_WON
        } else if (win == 2) {
            println("COMPUTER WON!")
            currentState = GameConstants.BLUE_WON
        }

        if(counter == 16){
            currentState = GameConstants.TIE
            println("YOU TIED")
        }

    } while (currentState == GameConstants.PLAYING && userInput != "q")


}

 
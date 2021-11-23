# The SlotGame
Simple slot game made in Java 11.

Main puropse of the application is to imitate slot game in casinos or similar venues.

## Starting the application
You can run this game by using your favourite Java IDEA or in a command line by typing in your src folder:

**javac *.java
java SlotGame**

The app will run a simulation of 100000 games.

## Classes
The app is based on 3 classes: SlotGame.java which is our class with main, ReelStripsConverter.java which is enum type class and SlotMachine.java which contains all of the logic of our game.

SlotGame - this is our main class which is only creating object and call functions.

ReelStripsConverter - Main pourpose of this class is to convert primary numbers to names we use in our game. I have decided to use primary numbers due to their limited amount of dividers furthermore ReelStripsConverter contains bets amount for every name we use.

SlotMachine - In this class we are creating our array with random numbers and then we check if it can find any winning lines or shapes (V and reverse V). To check if a line contains only the same numbers, our app is multiplying all numbers in a line and then compares them to the value of the first index of the line raised to power of 5. Due to that we have to use primery numbers, because non primary numbers have more than 2 dividers for example:
 **4x4x2x1x1 = 2^5 = 32**

To check if there is a different winning shape like V or reverse V, we create another function in which we look at values in array. Additionally, SlotMachine class has functions responsible for counting winnings and displaying winning moves.

## Ways to improve our slot game
1. Using proper random generators like: https://www.random.org/, This generator uses atmospheric noise to generate numbers.
2. Add some tests.
3. Add non static betMultiplayer, which users can change during the game.

# SlotGame
Simple slot game made in Java 11.

Main puropse of the application is to imitate slot game in casinos or similar venues.

# Starting the application
You can run this game by using your favourite Java IDEA or in commond line by typing in your src folder:

javac *.java  
java SlotGame

App will run simulation of 100000 games

# Classes
App is based on 3 classes: SlotGame.java which is our class with main, ReelStripsConverter.java which is enum type class and SlotMachine.java which contains all of the logic of our game.

SlotGame - this is our main class which is only creating constructor and call functions.

ReelStripsConverter - Main pourpose of this class is to convert primery numbers to names we use in our game. I've decide to use primary numbers duo to their limited amount of dividers. 

SlotMachine - In this class we are creating our array with random numbers and then we checks we it can find any wiining lines or shape (V and reverse V). To check if a line contains only the same numbers, our app is multpiling all numbers in line and then compare to value of first index of the line raised to power of 5. Due to that we had to use primery numbers, becouse non primary numbers how more than 2 dividers for example:
2^5 = 32 = 4*4*2*1*1

To check if there is difrent winning shape like V or reverse V, we create another function in which we look at values in array. Additionally to that SlotMachine class has functions responsible for counting winnings and displing winning moves.

# Ways to improve our slot game
1. Using proper random generator like: https://www.random.org/, This generator uses atmospheric noise to generate numbers.
2. Add some tests
3. Add non static betMultiplayer, which user can change during the game.

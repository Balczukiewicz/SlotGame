package com.company;

import java.util.Arrays;
import java.util.Random;

public class SlotMachine {

    static final int ROWS_NUMBER = 3;
    static final int COLUMNS_NUMBER = 5;
    public static int[][] displayArray = new int[ROWS_NUMBER][COLUMNS_NUMBER];
    int sumOfWinnings = 0;
    static int[] reelStrips = {3, 3, 5, 5, 3, 2, 1, 2, 3, 5, 7, 7, 2, 1};
    static int betMultiplayer = 50;

    public SlotMachine() {
    }

    int[][] startingDisplay() {
        System.out.println( "Stop positions: " );
        for ( int i = 0; i < COLUMNS_NUMBER; i++ ) {
            Random random = new Random();
            int upperbound = reelStrips.length;
            int randomNumber = random.nextInt( upperbound );
            System.out.print( randomNumber + " " );
            if ( randomNumber == upperbound - 1 ) {
                displayArray[0][i] = reelStrips[randomNumber];
                displayArray[1][i] = reelStrips[0];
                displayArray[2][i] = reelStrips[1];
            }
            if ( randomNumber == upperbound - 2 ) {
                displayArray[0][i] = reelStrips[randomNumber];
                displayArray[1][i] = reelStrips[13];
                displayArray[2][i] = reelStrips[0];
            }
            if ( randomNumber < 12 ) {
                displayArray[0][i] = reelStrips[randomNumber];
                displayArray[1][i] = reelStrips[randomNumber + 1];
                displayArray[2][i] = reelStrips[randomNumber + 2];
            }
        }
        System.out.println();
        return displayArray;
    }

    int sumOfAllWinnings() {
        sumOfWinnings += winningsAmountFromLineMoves() + winningsAmountFromVandReverseVmoves();
        System.out.println( "\nWygrana wynosi: " + sumOfWinnings );
        return sumOfWinnings;
    }

    int winningsAmountFromLineMoves() {
        int winnings = 0;

        for ( int i = 0; i < displayArray.length; i++ ) {
            int multiplication;
            int[][] displayWinningMovesArray = {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0}
            };
            if ( displayArray[i][0] == displayArray[i][4] ) {
                multiplication = Arrays.stream( displayArray[i] ).reduce( 1, ( a, b ) -> a * b );
                if ( multiplication == Math.pow( displayArray[i][0], COLUMNS_NUMBER ) ) {
                    Arrays.fill( displayWinningMovesArray[i], displayArray[i][0] );
                    winnings += ( ReelStripsConverter.convertNumbersToBetAmount( displayWinningMovesArray[i][0] ) * betMultiplayer );
                }
                displayWinningMoves( winnings, displayWinningMovesArray );
            }
        }

        return winnings;
    }

    int winningsAmountFromVandReverseVmoves() {
        int winnings = 0;

        if ( displayArray[1][3] == displayArray[1][1] ) {
            if ( displayArray[0][0] == displayArray[1][1]
                    && displayArray[2][2] == displayArray[1][1]
                    && displayArray[0][4] == displayArray[1][1] ) {
                int[][] displayWinningMovesArray = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
                displayWinningMovesArray[1][1] = displayWinningMovesArray[1][3] = displayWinningMovesArray[0][0] =
                        displayWinningMovesArray[2][2] = displayWinningMovesArray[0][4] = displayArray[0][0];

                winnings += ( ReelStripsConverter.convertNumbersToBetAmount( displayWinningMovesArray[1][1] ) * betMultiplayer );
                displayWinningMoves( winnings, displayWinningMovesArray );
            }
            if ( displayArray[2][0] == displayArray[1][1]
                    && displayArray[0][2] == displayArray[1][1]
                    && displayArray[2][4] == displayArray[1][1] ) {
                int[][] displayWinningMovesArray = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
                displayWinningMovesArray[1][1] = displayWinningMovesArray[1][3] = displayWinningMovesArray[0][2] =
                        displayWinningMovesArray[2][0] = displayWinningMovesArray[2][4] = displayArray[0][0];

                winnings += ( ReelStripsConverter.convertNumbersToBetAmount( displayWinningMovesArray[1][1] ) * betMultiplayer );
                displayWinningMoves( winnings, displayWinningMovesArray );
            }

            return winnings;
        } else {
            return 0;
        }
    }

    static void displayWinningMoves( int betAmount, int[][] displayWinningMovesArray ) {
        String[][] gamesProperNames = new String[ROWS_NUMBER][COLUMNS_NUMBER];
        if ( betAmount > 0 ) {
            for ( int i = 0; i < displayWinningMovesArray.length; i++ ) {
                for ( int j = 0; j < displayWinningMovesArray[i].length; j++ ) {
                    gamesProperNames[i][j] = ReelStripsConverter.convertNumbersToNames( displayWinningMovesArray[i][j] );
                    System.out.print( gamesProperNames[i][j] + " " );
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}

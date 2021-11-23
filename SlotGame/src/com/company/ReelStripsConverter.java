package com.company;

public enum ReelStripsConverter {

    K( 7, 5 ),
    Q( 5, 4 ),
    J( 3, 3 ),
    D( 2, 2 ),
    N( 1, 1 ),
    X( 0, 0 );

    private final int number;
    private final int bet;

    ReelStripsConverter( int number, int bet ) {
        this.number = number;
        this.bet = bet;
    }

    public static String convertNumbersToNames( int number ) {
        for ( ReelStripsConverter e : ReelStripsConverter.values() ) {
            if ( e.getNumber() == number ) {
                return e.name();
            }
        }
        return "";
    }

    public static int convertNumbersToBetAmount( int number ) {
        for ( ReelStripsConverter e : ReelStripsConverter.values() ) {
            if ( e.getNumber() == number ) {
                return e.getBet();
            }
        }
        return 0;
    }

    public int getNumber() {
        return number;
    }

    public int getBet() {
        return bet;
    }
}

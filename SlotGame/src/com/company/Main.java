package com.company;

public class Main {

    public static void main( String[] args ) {
        System.out.println( "Zaczynamy gre" );
        SlotMachine slotMachine = new SlotMachine();
        double sumOfAllBets = 0;
        double sumOfAllPayouts = 0;
        double rtp;
        for ( int i = 0; i < 100000; i++ ) {
            slotMachine.startingDisplay();
            sumOfAllPayouts = slotMachine.sumOfAllWinnings();
            sumOfAllBets += 50;
            
        }
        System.out.println( "BONUS POINTS FOR RTP" );
        rtp = (sumOfAllPayouts/sumOfAllBets);
        System.out.println(rtp);

    }
}

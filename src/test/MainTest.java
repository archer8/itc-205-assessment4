package test;


//import test libraries
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

//import classes

import game.Dice;
import game.Player;
import game.DiceValue;
import game.Game;
import game.Main;


/**
 * Created by chris on 7/11/15.
 */
public class MainTest {

    private Dice dice1;
    private Dice dice2;
    private Dice dice3;
    private DiceValue diceValue;
    private Game game;
    private Player player;
    private int winnings;
    private int balance;


    @Before
    public void setUp() throws Exception {
        dice1 = mock(game.Dice.class);
        dice2 = mock(game.Dice.class);
        dice3 = mock(game.Dice.class);

        when(dice1.getValue()).thenReturn(DiceValue.ANCHOR);
        when(dice2.getValue()).thenReturn(DiceValue.ANCHOR);
        when(dice3.getValue()).thenReturn(DiceValue.SPADE);


        player = new Player("Fred", 6);
        game = new Game(dice1, dice2, dice3);

    }


    //bug 1
    @Test
    public void checkGamePaysCorrectWinnings() {

        winnings = game.playRound(player, DiceValue.ANCHOR, 5);
        System.out.println("winnings: " + winnings);
        assertEquals(10, winnings);

    }

    //bug 1
    @Test
    public void checkPlayerBalanceIncreases() {

        when(dice1.getValue()).thenReturn(DiceValue.ANCHOR);
        when(dice2.getValue()).thenReturn(DiceValue.ANCHOR);
        when(dice3.getValue()).thenReturn(DiceValue.ANCHOR);

        winnings = game.playRound(player, DiceValue.ANCHOR, 5);
        balance = player.getBalance();

        System.out.println("balance: " + balance);
        assertEquals(15, winnings);

        //player initial balance is 6 ... betting 5 and winning 15 should change balance to 16.
        assertEquals(16, balance);

    }

    //bug 2
    @Test
    public void checkAmountIsAboveLimit() {
        winnings = game.playRound(player, DiceValue.CLUB, 5);
        balance = player.getBalance();
        assertEquals(1, balance);
        System.out.println("testing amount > limit .. balance = " + balance);
    }
    //bug 2
    @Test
    public void checkAmountIsEqualToLimit() {
        winnings = game.playRound(player, DiceValue.CLUB, 6);
        balance = player.getBalance();
        assertEquals(0, balance);
        System.out.println("testing amount >= limit .. balance = "+balance);
    }






}
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

    @Test
    public void checkGamePaysCorrectWinnings() {


        int winnings = game.playRound(player, DiceValue.SPADE, 5);
        assertEquals(5, winnings);



    }
    @Test
    public void checkPlayerBalanceIncreases() {

        int winnings = game.playRound(player, DiceValue.SPADE, 5);
        int balance = player.getBalance();


        assertEquals(5, winnings);

        //player initial balance is 6 ... betting 5 and winning 5 should return balance to 6.
        assertEquals(6, balance);




    }




}
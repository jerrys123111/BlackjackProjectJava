/*
 * The MIT License
 *
 * Copyright 2017 Muhammed Imraan Shaikh.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blackjackproject;
import java.util.Scanner;

/**
 *
 * @author Muhammed Imraan Shaikh
 */
public class Blackjack
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        Deck cardDeck = new Deck();
        Hand playerHand = new Hand();
        Hand computerHand = new Hand();

        cardDeck.createDeck();

        computerHand.add(cardDeck.getCard());
        System.out.println("CPU Card 1: " + computerHand.toString());
        while (computerHand.totalValue() < 17)
        {
            computerHand.add(cardDeck.getCard());
        }

        playerHand.add(cardDeck.getCard());
        playerHand.add(cardDeck.getCard());
        System.out.println("Your Cards: " + playerHand.toString());
//        while(!cardDeck.isEmpty())
//        {
//            System.out.println(cardDeck.getCard().toString());
//        }
        do
        {
            System.out.println("Your total is : " + playerHand.totalValue());
            System.out.println("Would you like to hit or stay?(1 to hit, 2 to stay) : ");
            choice = input.nextInt();
            if(choice == 1)
            {
                playerHand.add(cardDeck.getCard());
            }
        } while(choice == 1 && playerHand.totalValue() < 21);
        System.out.println("Your Final Total: " + playerHand.totalValue());
        System.out.println("Computer Final Total: " + computerHand.totalValue());
        if(computerHand.totalValue() > 21)
        {
            System.out.println("Dealer has BUST! You win this round.");
        }
        else if(playerHand.totalValue() > 21)
        {
            System.out.println("You have BUST! You lose this round.");
        }
        else if(playerHand.totalValue() <= 21 && computerHand.totalValue() < playerHand.totalValue())
        {
            System.out.println("You Win this round!");
        }
        else if(computerHand.totalValue() <= 21 && playerHand.totalValue() < computerHand.totalValue())
        {
            System.out.println("You Lose! The dealer won!");
        }
        else if(playerHand.totalValue() == computerHand.totalValue())
        {
            System.out.println("Its a push! No one wins!");
        }
    }
}

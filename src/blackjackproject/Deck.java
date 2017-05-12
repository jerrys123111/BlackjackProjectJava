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
import java.util.Random;

/**
 *
 * @author m_shaikh
 */
public class Deck
{
    private ArrayQueue<Card> deckQueue = new ArrayQueue<Card>(104);
    private Random rand = new Random();
    private Card[] deck;

    public void createDeck()
    {
        deck = new Card[104];
        int cardNum = 0;
        int pValue = 0;
        String type = "", suit = "";
        for(int deckNum = 0; deckNum <= 1; deckNum++)
        {
            for(int suiteNum = 0; suiteNum <= 3; suiteNum++)
            {
                for(int cardValue = 1; cardValue <= 13; cardValue++)
                {
                    if(cardValue >= 1 && cardValue <= 10)
                    {
                        pValue = cardValue;
                    }
                    else if(cardValue >= 11)
                    {
                        pValue = 10;
                    }
                    type = String.valueOf(cardValue);
                    switch(suiteNum)
                    {
                        case 0:
                            suit = "clubs";
                            break;
                        case 1:
                            suit = "diamonds";
                            break;
                        case 2:
                            suit = "hearts";
                            break;
                        case 3:
                            suit = "spades";
                            break;
                        default:
                            break;
                    }
                    deck[cardNum] = new Card(pValue, type, suit);
                    cardNum++;
                }
            }
        }
        this.shuffle();
        for(int y = 0;y < deck.length - 1;y++)
        {
            deckQueue.enqueue(deck[y]);
        }
    }

    public void shuffle()
    {
        for(int x = deck.length - 1;x > 0;x--)
        {
            int randNum = rand.nextInt(x + 1);
            Card tempCard = deck[x];
            deck[x] = deck[randNum];
            deck[randNum] = tempCard;
        }
    }

    public Card getCard()
    {
        return deckQueue.dequeue();
    }
}

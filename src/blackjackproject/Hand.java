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
import javax.swing.ImageIcon;

/**
 *
 * @author m_shaikh
 */
public class Hand
{
    private Card[] cards;
    private int cardAmount = 0;

    public Hand()
    {
        cards = new Card[21];
    }

    public void add(Card card)
    {
        cards[cardAmount] = card;
        cardAmount++;
    }

    public int getCardAmount()
    {
        return cardAmount;
    }

    public ImageIcon getCardImage()
    {
        return cards[cardAmount-1].getCardImage();
    }

    public int totalValue()
    {
        int total = 0;
        for(int i = 0;i < cardAmount;i++)
        {
            total += cards[i].getPointValue();
        }
        return total;
    }

    @Override
    public String toString()
    {
        String output = "";
        for(int i = 0; i < cardAmount; i++)
        {
            output += cards[i].toString();
        }
        return output;
    }
}

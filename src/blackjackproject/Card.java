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
public class Card
{
    private int pointValue;
    private String cardType;
    private String cardSuite;
    private ImageIcon cardImage;
    public Card(int value, String type, String suite)
    {
        this.pointValue = value;
        this.cardType = type;
        this.cardSuite = suite;
        String imageLink = "playingcards/" + cardType + cardSuite + ".png";
        cardImage = new ImageIcon(getClass().getResource(imageLink));
    }

    public int getPointValue()
    {
        return pointValue;
    }

    public void setPointValue(int pointValue)
    {
        this.pointValue = pointValue;
    }

    public String getCardType()
    {
        return cardType;
    }

    public String getCardSuite()
    {
        return cardSuite;
    }

    public ImageIcon getCardImage()
    {
        return cardImage;
    }

    @Override
    public String toString()
    {
        return "(point value: " + this.getPointValue() +
          ", type: " + this.getCardType() +
          ", suite: " + this.getCardSuite() + ")";
    }
}

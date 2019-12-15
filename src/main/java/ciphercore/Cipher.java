/*
 * Copyright (C) 2018 JCarter
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ciphercore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author JCarter
 */
public abstract class Cipher
{
    private static ArrayList<Integer> sequence;
    private static HashMap<Character,Integer> alphabetMap;
    private static final char[] alphabet = 
                                     "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static String numOfSpaces = new String();

    private static void Fibo(int sequencePosition)
    {
        ArrayList<Integer> numberSequence = new ArrayList<>();
        HashMap<Character, Integer> tempMap = new HashMap<>();
        int position = 2;
        int alphabetPosition = 0;
        int firstNumber = 0;
        int secondNumber = 1;
        int sum;
    
        numberSequence.add(firstNumber);
        numberSequence.add(secondNumber);
        
        while (position < (sequencePosition + 26))
        {
            sum = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = sum;
            numberSequence.add(sum);
            position++;
        }
        sequence = numberSequence;
        
        while(alphabetPosition < alphabet.length)
        {
            tempMap.put(alphabet[alphabetPosition],
                        sequence.get(sequencePosition));
            alphabetPosition++;
            sequencePosition++;
        }
        alphabetMap = tempMap;
    }
    
    public static String encrypt(String plainString, int cipherKey)
    {
        Fibo(cipherKey);
        
        if(plainString.contains(" "))
        {
            for(int index = plainString.indexOf(' ');
                    index >= 0;
                    index = plainString.indexOf(' ', index + 1))
            {
                numOfSpaces += index + ",";
            }
            plainString = plainString.replaceAll(" ", "");
        }
        
        for(char aChar : alphabet)
        {
            plainString = plainString.replaceAll(Character.toString(aChar),
                                "#" + Integer.toString(alphabetMap.get(aChar)));
        }
        
        return plainString;
    }
    
    public static String decrypt(String encryptedString, int cipherKey)
    {
        Fibo(cipherKey);
        String[] encStrArray = encryptedString.split("#");
        String[] spacesArray = numOfSpaces.split(",");
        String tempString = "";
        
        for(String aString : encStrArray)
        {
            for(Entry<Character, Integer> entry : alphabetMap.entrySet())
            {
                if(aString.equals(Integer.toString(entry.getValue())))
                {
                    tempString += entry.getKey();
                }
            }
        }
        
        StringBuilder outString = new StringBuilder(tempString);
        
        if(!numOfSpaces.isEmpty())
        {
            for(String aString : spacesArray)
            {
                outString.insert(Integer.parseInt(aString), ' ');
            }
        }
        
        return outString.toString();
    }
}
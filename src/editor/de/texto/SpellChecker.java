/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.de.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This class processes the documents and consults the user about unknown words
 * @author Tiago Santos
 * 
 */
public class SpellChecker {
    
   private ArrayList<String> ignored;
   
   SpellChecker(){
       ignored = new ArrayList<String>();
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        SpellChecker speller = new SpellChecker();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        WordSet set = new WordSet();
        Word w = new Word();

        for(String s : w.getInputWords()){
            if(speller.isValidWord(set, s)){
                //add to file
                w.putWord(s);
            }
            else if(speller.isIgnoredWord(s)){
                //ignore a palavra
            }
            else{
                //check if the user wants to add this word to dictionary
                System.out.println("The word " + s + " is unkown on dictionary. "
                        + "Do you wish to add this word to the dictionary? Yes = 1, No = 0\n");
                int n = reader.nextInt(); // Scans the next token of the input as an int.
                if(n==1){
                    //add to output file
                    w.putWord(s);
                }
                else{
                    //add this word to the ignored set of words
                    speller.getIgnored().add(s);                 
                    
                }
                
            }
            System.out.println(s);
        }

        w.putWords(); //adds all words to output file
        
    }
    
    /**
     * 
     * 
     * 
     * @param A Wordset containing the dictionary words
     * @param word to search on the wordset
     * @return true if the word is found and false otherwise
     */
    
    boolean isValidWord(WordSet set,String word){
        for(String current: set.getWords()){
            if(current.matches(word))
                   return true; 
        }
        
        return false;
    }
    
    /**
     * 
     * 
     * @param word
     * @return 
     */
    
    boolean isIgnoredWord(String word){
       for(String current: ignored){
            if(current.matches(word))
                   return true; 
        }
        
        return false;
    }

    public ArrayList<String> getIgnored() {
        return ignored;
    }

    public void setIgnored(ArrayList<String> ignored) {
        this.ignored = ignored;
    }
    
    
    
    
}

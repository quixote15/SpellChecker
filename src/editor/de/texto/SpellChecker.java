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
        
       // Dictionary dic = new Dictionary();
        SpellChecker speller = new SpellChecker();
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        WordSet set = new WordSet();
        Word w = new Word();
        
//        this is working dic.load();
//        dic.setDictionary("Blabla blabla");
//        this is working dic.save(); 
       
        //dic.save("brakeq brakequw",dic.getFilepath());
	
        for(String s : w.getInputWords()){
            if(speller.isValidWord(set, s)){
                //add to file
            }
            else{
                //check if the user wants to add this word to dictionary
                System.out.println("The word " + s + " is unkown on dictionary. "
                        + "Do you wish to add this word to the dictionary? Yes = 1, No = 0\n");
                int n = reader.nextInt(); // Scans the next token of the input as an int.
                if(n==1){
                    //add to dictionary
                }
                else{
                    //add this word to the ignored set of words
                }
                
            }
            System.out.println(s);
        }

        
        
    }
    
    /**
     * 
     * 
     * 
     * @param set
     * @param word
     * @return 
     */
    
    boolean isValidWord(WordSet set,String word){
        for(String current: set.getWords()){
            if(current.matches(word))
                   return true; 
        }
        
        return false;
    }
    
    
    
    
}

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
   private ArrayList<String> replaced;
   
   SpellChecker(){
       ignored = new ArrayList<String>();
       replaced = new ArrayList<String>();
               
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
            else if(speller.isReplacedWord(s)){
                w.putWord(s); //replace all occurrences of this word
            }
            else{
                //check if the user wants to add this word to dictionary
                System.out.println("The word '" + s + "' is unkown on dictionary. "
                        + "Do you wish to add this word to the dictionary?\n 1. Igore = press 0\n2. Add to dictionary =  press 1\n3. Replace = press 2\n");
                int n = reader.nextInt(); // Scans the next token of the input as an int.
                if(n==1){
                    //add to output file and dictionary
                    set.add(s);
                    w.putWord(s);
                    
                }
                else if(n==2){
                    reader.nextLine();
                    System.out.println("Please write the word : ");
                    String newWord = reader.nextLine();
                 
                    w.putWord(newWord); //add the new word to the output file
                    speller.getReplaced().add(s);
                    System.out.println("The word '" + s +"' was replaced by the word '" +newWord + " .");
                }
                else{
                    //add this word to the ignored set of words
                    speller.getIgnored().add(s);                 
                    
                }
                
            }
            //System.out.println(s);
        }
        
         System.out.println("The final text is: ");
        
        for(String text: w.getOutputWords())
                System.out.print(text + "  ");
            
        set.save();
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
    
      
    boolean isReplacedWord(String word){
       for(String current: replaced){
            if(current.matches(word))
                   return true; 
        }
        
        return false;
    }

    public ArrayList<String> getReplaced() {
        return replaced;
    }

    public void setReplaced(ArrayList<String> replaced) {
        this.replaced = replaced;
    }
    
    

    public ArrayList<String> getIgnored() {
        return ignored;
    }

    public void setIgnored(ArrayList<String> ignored) {
        this.ignored = ignored;
    }
    
    
    
    
}

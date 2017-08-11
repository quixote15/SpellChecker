/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.de.texto;

/**
 *
 * @author Tiago Santos
 */
public class WordSet extends Dictionary {
    
  
    /**
     * WordSet Constructor
     */
        WordSet(){
            super();
            // superclass constructor call the load method load();                    
        }
    
    /**
     * 
     * @param word to be added into the wordset
     */
    void add(String word){
        String wordset = getDictionary();
        wordset = wordset + "\n";
        setDictionary(wordset); //add to conctanated string
        setWords(word); //add to arraylist
    }
    
    
    /**
     * 
     * 
     * @param word to be compared with the wordset
     * @return true if the word is in the wordset and false otherwise
     */
    boolean contains(String word){
        boolean matches = false;
        for(String current : getWords()){
            if(current.matches(word) ){
                matches = true;
                break;
            }
        }
        return matches;
    }
}

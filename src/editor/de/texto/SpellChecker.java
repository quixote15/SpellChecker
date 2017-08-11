/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.de.texto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  This class processes the documents and consults the user about unknown words
 * @author Tiago Santos
 * 
 */
public class SpellChecker {
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // Dictionary dic = new Dictionary();
        WordSet set = new WordSet();
        Word w = new Word();
        
//        this is working dic.load();
//        dic.setDictionary("Blabla blabla");
//        this is working dic.save(); 
       
        //dic.save("brakeq brakequw",dic.getFilepath());
	
        for(String s : w.getInputWords()){
            System.out.println(s);
        }

        
        
    }
    
}

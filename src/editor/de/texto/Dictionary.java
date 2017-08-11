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
 *
 * @author Tiago Santos
 */
public class Dictionary {
    private String filepath = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\dictionary.txt";
    private String dictionary;
    
    /**
     * This  Method loads the dictionary of known words from a file
     * and stores those words on main memory
     *  
     * 
     * @return String containing the set of known words
     */
    String load(){
        
         
	BufferedReader buffer = null;
	FileReader reader = null;
        
        	try {

			//br = new BufferedReader(new FileReader(FILENAME));
			reader = new FileReader(filepath);
			buffer = new BufferedReader(reader);

			String sCurrentLine;

			while ((sCurrentLine = buffer.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
                        
                        this.dictionary = sCurrentLine;

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (buffer != null)
					buffer.close();

				if (reader != null)
					reader.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
                }
        return dictionary;
    }
    
    
    /**
     * The Save method saves a word into the dictionary
     * 
     */
    
    void save(){
        
    }
    
}

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
    
    private static final String INPUTFILENAME = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\input.txt";
    
    private static final String OUTPUTFILENAME = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\output.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // Dictionary dic = new Dictionary();
        WordSet set = new WordSet();
//        this is working dic.load();
//        dic.setDictionary("Blabla blabla");
//        this is working dic.save(); 
        System.out.println("the word fuck is on dictionary? ");
        System.out.println(set.contains("fuck"));
      
        //dic.save("brakeq brakequw",dic.getFilepath());
	BufferedReader buffer = null;
	FileReader reader = null;
        
        	try {

			//br = new BufferedReader(new FileReader(FILENAME));
			reader = new FileReader(INPUTFILENAME);
			buffer = new BufferedReader(reader);

			String sCurrentLine;

			while ((sCurrentLine = buffer.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

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

        
        
    }
    
}

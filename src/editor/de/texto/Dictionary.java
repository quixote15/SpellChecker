/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.de.texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tiago Santos
 */
public class Dictionary {
    private final static String filepath = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\dictionary.txt";
    private String dictionary;
    private ArrayList<String> words;
    
    Dictionary(){
        words = new ArrayList<String>();
        load();
    }
    
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
				//
                                words.add(sCurrentLine);
                                this.dictionary += sCurrentLine + "\n";
			}
                        
                        
                        System.out.println(sCurrentLine);

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
     * 
     * Overloading method load
     * @param path to locate the dictionary file
     * @return String containing the set of known words
     */
    String load(String path){
        //Set the path variable and then call load method
       // setFilepath(path);
        load();
        
        return "";
    }
    
    /**
     * The Save method saves a set of words into the final dictionary
     * 
     */
    
    void save(){
        BufferedWriter bw = null;
	FileWriter fw = null;

		try {

			//String content = "This is the content to write into file\n";

			fw = new FileWriter(filepath);
			bw = new BufferedWriter(fw);
			bw.write(dictionary); //write words on the dictionary

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
                }
    
    }

    
    void save(String words, String path){
        setDictionary(words);
        //setFilepath(path);
        save();
    }
    public String getFilepath() {
        return filepath;
    }

   

    public String getDictionary() {
        return dictionary;
    }

    public void setDictionary(String dictionary) {
        this.dictionary = dictionary;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
    
    
    
    
}

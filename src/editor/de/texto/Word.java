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
 * This class treats the input and output set of words of the aplication
 * @author Tiago Santos
 */
public class Word {
    private ArrayList<String> inputWords;
    private ArrayList<String> outputWords;
    
    private static final String INPUTFILENAME = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\input.txt";
    private static final String OUTPUTFILENAME = "C:\\Users\\Tiago Santos\\Documents\\NetBeansProjects\\Editor de Texto\\src\\editor\\de\\texto\\output.txt";
    
    /**
     * Word constructor
     *  Inicialize variables and loads the input file
     * 
     */
    Word(){
        inputWords = new ArrayList<String>();
        outputWords = new ArrayList<String>();
        
        BufferedReader buffer = null; 
	FileReader reader = null;
        
        	try {

		
			reader = new FileReader(INPUTFILENAME);
			buffer = new BufferedReader(reader);

			String sCurrentLine;

			while ((sCurrentLine = buffer.readLine()) != null) {
				inputWords.add(sCurrentLine); //add current word
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
    
    
    /**
     * 
     * @param index of the element on the array of words
     * @return the element at index
     */
    String getWord(int index){
        return this.inputWords.get(index);
    }
    
    /**
     * 
     * @param word to be included at the array of words
     */
    void putWord(String word){
        outputWords.add(word); //Appends the word at the end of array
    }
    
    
    void putWords(){
         BufferedWriter bw = null;
	FileWriter fw = null;

		try {

			//String content = "This is the content to write into file\n";

			fw = new FileWriter(OUTPUTFILENAME);
			bw = new BufferedWriter(fw);
                        //for each word append to the output file
			for(String current : outputWords)
                            bw.append(current);
                        
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
}

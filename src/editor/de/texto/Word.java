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
    
    private static final String INPUTFILENAME = "/home/thiago/Área de Trabalho/SpellChecker/src/editor/de/texto/input.txt";
    private static final String OUTPUTFILENAME = "/home/thiago/Área de Trabalho/SpellChecker/src/editor/de/texto/output.txt";
    
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
                            /**
                             * This Regex  means :

                                    Zero or more whitespaces (\\s*)
                                    Arrow, or comma, or whitespace (=>|,|\\s)
                                    Zero or more whitespaces (\\s*)
                             * 
                             */
                                String list[] = sCurrentLine.split("\\s+|,|\\.\\s+"); //get words separated by space
                                for(String s : list)
                                    inputWords.add(s); //add current word
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
    
    
    
    public ArrayList<String> getInputWords() {
        return inputWords;
    }

    public void setInputWords(ArrayList<String> inputWords) {
        this.inputWords = inputWords;
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
                            bw.append(current+"\n");
                        
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

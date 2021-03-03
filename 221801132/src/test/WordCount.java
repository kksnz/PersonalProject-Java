package test;

import java.io.IOException;

public class WordCount {
	  public static void main(String[] args) throws IOException {
	        String inputFile = args[0];
	        String outputFile = args[1];
	        Lib.CountCharacters(inputFile, outputFile);
	        Lib.CountLines(inputFile, outputFile);
	    }
}

package WordCount;

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
	 public static void main(String[] args) throws IOException {
	    	if (args.length != 2)
	    	{
	            System.out.println("命令行参数错误，需要两个文件名！");
	            System.exit(0);
	        }
	        String inputFile = args[0];
	        String outputFile = args[1];
	        Lib.CountCharacters(inputFile, outputFile);	      
	        Lib.CountWords(inputFile, outputFile);
	        Lib.CountLines(inputFile, outputFile);
	        Lib.WordsNumSort(inputFile, outputFile);
	    }   
}

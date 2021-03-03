package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WordCountTest {

	@Test
	public void testCharactersCount() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(15,WordCount.CountCharacters(inputFile1, outputFile));
        assertEquals(14,WordCount.CountCharacters(inputFile2, outputFile));
        
	}

	@Test
	public void testCountLines() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(2,WordCount.CountLines(inputFile1, outputFile));
        assertEquals(3,WordCount.CountLines(inputFile2, outputFile));
	}

	@Test
	public void testCountWords() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(0,WordCount.CountWords(inputFile1, outputFile));
        assertEquals(0,WordCount.CountWords(inputFile2, outputFile));
	}
}

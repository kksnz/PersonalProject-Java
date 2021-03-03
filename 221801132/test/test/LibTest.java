package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LibTest {

	@Test
	public void testCharactersCount() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(15,Lib.CountCharacters(inputFile1, outputFile));
        assertEquals(14,Lib.CountCharacters(inputFile2, outputFile));
        
	}

	@Test
	public void testCountLines() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(2,Lib.CountLines(inputFile1, outputFile));
        assertEquals(3,Lib.CountLines(inputFile2, outputFile));
	}

}

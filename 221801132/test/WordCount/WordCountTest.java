package WordCount;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WordCountTest {
	
	@Test
	public void InputFile() throws IOException {
		String inputFile3 = "D:\\test\\test3.txt";
        assertEquals(null,WordCount.InputFile(inputFile3));                
	}	//测试读取文件失败时的运行结果

	@Test
	public void testCharactersCount() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(521,WordCount.CountCharacters(inputFile1, outputFile));
        assertEquals(15,WordCount.CountCharacters(inputFile2, outputFile));
        
	}	//测试字符数统计功能
	
	@Test
	public void testCountWords() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(20,WordCount.CountWords(inputFile1, outputFile));
        assertEquals(2,WordCount.CountWords(inputFile2, outputFile));
	}	//测试单词数统计功能
	
	@Test
	public void testCountLines() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        assertEquals(3,WordCount.CountLines(inputFile1, outputFile));
        assertEquals(1,WordCount.CountLines(inputFile2, outputFile));
	}	//测试行数统计功能
	
	@Test
	public void WordsNumSort() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt"; 
        String outputFile = "D:\\test\\out.txt";
        String test = "round";
        test.equals( WordCount.WordsNumSort(inputFile1, outputFile));
	}	//测试单词频率统计功能
}

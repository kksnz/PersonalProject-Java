package WordCount;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WordCountTest {

	@Test
	public void InputFile() throws IOException {
		String inputFile3 = "D:\\test\\test3.txt";
        assertEquals(null,Lib.InputFile(inputFile3));                
	}	//测试读取文件失败时的运行结果
	
	@Test
	public void testCountCharacters() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt"; 
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        if(Lib.CountCharacters(inputFile1, outputFile) == 521)
        {
        	System.out.println("字符数统计功能测试成功"); 
        }
        if(Lib.CountCharacters(inputFile2, outputFile) == 15)
        {
        	System.out.println("字符数统计功能测试成功");
        }
	}	//测试字符数统计功能
	 
	@Test
	public void testCountWords() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        if(Lib.CountWords(inputFile1, outputFile) == 20)
        {
        	System.out.println("单词数统计功能测试成功"); 
        }
        if(Lib.CountWords(inputFile2, outputFile) == 2)
        {
        	System.out.println("单词数统计功能测试成功");
        }
	}	//测试单词数统计功能 
	
	@Test
	public void testCountLines() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";
		String inputFile2 = "D:\\test\\test2.txt";
        String outputFile = "D:\\test\\out.txt";
        if(Lib.CountLines(inputFile1, outputFile) == 3)
        {
        	System.out.println("行数统计功能测试成功"); 
        }
        if(Lib.CountLines(inputFile2, outputFile) == 1)
        {
        	System.out.println("行数统计功能测试成功");
        }
	}	//测试行数统计功能
	
	@Test
	public void WordsNumSort() throws IOException {
		String inputFile1 = "D:\\test\\test1.txt";  
        String outputFile = "D:\\test\\out.txt";
        String test = "round";
        if(test.equals(Lib.WordsNumSort(inputFile1, outputFile)))
        {
        	System.out.println("单词频率统计功能测试成功");
        };
	}	//测试单词频率统计功能
}

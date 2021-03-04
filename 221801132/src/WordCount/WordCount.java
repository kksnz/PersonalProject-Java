package WordCount;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
    public static Reader InputFile(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到输入文件！");
        } 
        return reader;
    }

    public static BufferedWriter OutputFile(String fileName) throws IOException {
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName),true),"utf-8"));
        return write;
    }

    public static int CountCharacters(String InputFile, String OutputFile) throws IOException {
        Reader reader = InputFile(InputFile);
        Writer writer = new FileWriter(OutputFile);
        int CharactersNum = 0;
        while (reader.read() != -1)	//读取到-1时停止。
        {  
            CharactersNum++;
        }
        writer.write("characters:" + CharactersNum + '\n');
        writer.close();
        reader.close();
        return CharactersNum;
    }	    // 统计字符数。
    
    public static int CountWords(String inputFile, String outputFile) throws IOException {
        Reader reader = InputFile(inputFile);
        Writer writer = OutputFile(outputFile);
        int length;    //表示单词的长度，大于等于4合法
        int temp;
        int WordsNum = 0;
        String word = "";
        String regex = "[a-zA-Z]{4}[^ ,.]+";	//正则表达式判断是否为四个英文开头
        Pattern p = Pattern.compile(regex);
        while ((temp = reader.read()) != -1) 
        {
            while ((temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57)) {
                word += (char) temp;
                temp = reader.read();
            }
            while ((!(temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57)) && temp != -1)	//去除空白字符和分隔符 
            {	
                temp = reader.read();
            }
           Matcher m = p.matcher(word);
           length = word.length();
            if (length >= 4 && m.matches()) 
            {	
                WordsNum++;
            }
            word = "" + (char)temp;
        }
        writer.append("words: " + WordsNum + '\n');
        writer.close();
        reader.close();
        return WordsNum;
    }	//统计单词数


    public static int CountLines(String inputFile, String outputFile) throws IOException {
        Reader reader = InputFile(inputFile);
        Writer writer = OutputFile(outputFile);
        int temp;
        int LinesNum = 0;
        String line = "";	
        while ((temp = reader.read()) != -1)
        {
            while (temp != -1 && (char) temp != '\n')
            {
                if (temp != ' ' && temp != '\t' && temp != '\r')  
                {
                    line += (char)temp;
                }
                temp = reader.read();
            }
            if (line != " ") 
            {
                LinesNum++;
            }
            line = " ";
        }
        writer.append("lines:" + LinesNum + "\n");
        reader.close();
        writer.close();
        return LinesNum;
    }		//统计行数。
    
    public static String WordsNumSort(String inputFile, String outputFile) throws IOException {
        Reader reader = InputFile(inputFile);
        Writer writer = OutputFile(outputFile);
        int temp;
        String word = "";
        String regex = "[a-zA-Z]{4}[^ ,.]+";	//正则表达式判断是否为四个英文开头
        Pattern p = Pattern.compile(regex);
        Map<String, Integer> words = new HashMap<String, Integer>();
        while ((temp = reader.read()) != -1) 
        {
            while ((temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57))
            {
                if (temp >= 65 && temp <= 90)
                {
                    temp += 32; 
                }
                word += (char)temp;
                temp = reader.read();
            }
            while ((!(temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57)) && temp != -1) 
            {
                temp = reader.read();
            }
            Matcher m = p.matcher(word);
            if (m.matches()) {
                if (words.get(word) == null) 
                {
                    words.put(word, Integer.valueOf(1));
                } 
                else 
                {
                    words.put(word, Integer.valueOf(words.get(word).intValue() + 1));
                }
            }
            if (temp >= 65 && temp <= 90) 
            { 
                temp += 32;
            }
            word = "" + (char) temp;
        }	//与统计单词数的方法类似，不合法的单词不进行排序。
        
        Map<String, Integer> WordsSort = words.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() 
                {
                    public int compare(Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) 
                    {
                        if (w1.getValue().equals(w2.getValue())) 
                        {
                            return w1.getKey().compareTo(w2.getKey());
                        } 
                        else 
                        {
                            return w2.getValue().compareTo(w1.getValue());
                        }
                    }
                }
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));	//对单词频率进行排序
        String test = null;	//设定频率最低的词以便单元测试
        int i = 0;
        for (Map.Entry<String, Integer> entry : WordsSort.entrySet()) 
        {
        	test = entry.getKey();
            writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            if (i++ >= 9) {
                break;
            }
        }	////打印频率前十的单词 
        reader.close();
        writer.close();   
        return test;	//返回频率最低的词
    }       
    
    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        WordCount.CountCharacters(inputFile, outputFile);	      
        WordCount.CountWords(inputFile, outputFile);
        WordCount.CountLines(inputFile, outputFile);
        WordCount.WordsNumSort(inputFile, outputFile);
    }
}
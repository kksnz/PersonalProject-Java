package test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static Reader InputFile(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("�Ҳ��������ļ���");
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
        while (reader.read() != -1)	//��ȡ��-1ʱֹͣ��
        {  
            CharactersNum++;
        }
        writer.write("characters:" + CharactersNum + '\n');
        writer.close();
        reader.close();
        return CharactersNum;
    }	    // ͳ���ַ�����
    
    public static int CountWords(String inputFile, String outputFile) throws IOException {
        Reader reader = InputFile(inputFile);
        Writer writer = OutputFile(outputFile);
        int length;    //��ʾ���ʵĳ��ȣ����ڵ���4�Ϸ�
        int temp;
        int WordsNum = 0;
        String word = "";
        String regex = "[a-zA-Z]{4}[^ ,.]+";	//������ʽ�ж��Ƿ�Ϊ�ĸ�Ӣ�Ŀ�ͷ
        Pattern p = Pattern.compile(regex);
        while ((temp = reader.read()) != -1) 
        {
            while ((temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57)) {
                word += (char) temp;
                temp = reader.read();
            }
            while ((!(temp >= 97 && temp <= 122) || (temp >= 65 && temp <= 90) || (temp >= 48 && temp <= 57)) && temp != -1)	//ȥ���հ��ַ��ͷָ��� 
            {	
                temp = reader.read();
            }
           Matcher m = p.matcher(word);
           length = word.length();
            if (length >= 4 && m.matches()) 
            {	
                WordsNum++;
            }
            word = "" + (char) temp;
        }
        writer.append("words: " + WordsNum + '\n');
        writer.close();
        reader.close();
        return WordsNum;
    }	//ͳ�Ƶ�����


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
    }		//ͳ��������
    
    
    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        WordCount.CountCharacters(inputFile, outputFile);	      
        WordCount.CountWords(inputFile, outputFile);
        WordCount.CountLines(inputFile, outputFile);
    }
}
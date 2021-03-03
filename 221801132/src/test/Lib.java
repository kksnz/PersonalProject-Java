package test;

import java.io.*;

public class Lib {
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

    public static int CountLines(String inputFile, String outputFile) throws IOException {
        Reader reader = InputFile(inputFile);
        Writer writer = OutputFile(outputFile);
        int temp;
        int LinesNum = 0;
        String line = "";	//初始化行的内容。
        while ((temp = reader.read()) != -1)
        {
            while (temp != -1 && (char) temp != '\n')
            {
                if (temp != ' ' && temp != '\t' && temp != '\r') 
                {
                    line += temp;
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

}
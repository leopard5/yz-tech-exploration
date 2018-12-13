package com.yz.jvm.main;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        String filePath = "/Users/yazhong/vimtest.txt";
        System.out.println(getLineNumber(filePath));
        readCountLine(filePath);
        count2(filePath);
    }

    // 统计行数
    private static int getLineNumber(String fileName) {
        long start = System.currentTimeMillis();
        int lineNum = 0;
        LineNumberReader lnr = null;
        try {
            lnr = new LineNumberReader(new InputStreamReader(
                    new FileInputStream(fileName)));
            long linenumber = 0;
            while (lnr.readLine() != null){
                linenumber++;
            }
            System.out.println("Total number of lines : " + linenumber);
            lineNum = lnr.getLineNumber() + 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lnr) {
                    lnr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("Use Time getLineNumber: " + (end - start) + " Line Num: " + lineNum);

        return lineNum;
    }

    public static void readCountLine(String filePath) {
        try {
            long start = System.currentTimeMillis();
            File file = new File(filePath);
            Scanner sc = new Scanner(new FileInputStream(file));
            int count = 0;
            while(sc.hasNextLine()) {
                count++;
                String fileContext = sc.nextLine();
                if (fileContext == null || fileContext.trim().length() == 0){
                    count--;
                }
            }
            sc.close();
//            System.out.println("count=" + count);
            long end = System.currentTimeMillis();

            System.out.println("Use Time readCountLine: " + (end - start) + " Line Num: " + count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void count2(String hugeFilePath) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(hugeFilePath));
        int count = 0;
        long start = System.currentTimeMillis();
        try {
            byte[] c = new byte[1024];
            int readChars = 0;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n')
                        ++count;
                }
            }
        } finally {
            is.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Use Time count2: " + (end - start) + " Line Num: " + count);
    }
}

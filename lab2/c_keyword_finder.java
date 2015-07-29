// Input is a c program taken through file
// Output has to be all the keywords present
// in the c program to another file.

import java.io.*;
import java.util.*;

public class c_keyword_finder {
    public static void main(String args[]) throws IOException {

        // Specify the files of input and output
        // Input has to be from c file this time
        File input_file = new File("input.c");
        File output_file = new File("output.txt");

        // This is a set which will store all
        // the keywords of c
        HashSet <String> c_key = new HashSet<String>();

        // For reading and writing to the files
        BufferedReader br = new BufferedReader(new FileReader(input_file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output_file));

        // Adding all the keywords of c
        // in the HashSet
        c_key.add("auto");
        c_key.add("break");
        c_key.add("char");
        c_key.add("const");
        c_key.add("continue");
        c_key.add("default");
        c_key.add("do");
        c_key.add("double");
        c_key.add("else");
        c_key.add("enum");
        c_key.add("extern");
        c_key.add("float");
        c_key.add("for");
        c_key.add("goto");
        c_key.add("if");
        c_key.add("int");
        c_key.add("long");
        c_key.add("register");
        c_key.add("return");
        c_key.add("short");
        c_key.add("signed");
        c_key.add("sizeof");
        c_key.add("static");
        c_key.add("struct");
        c_key.add("switch");
        c_key.add("typedef");
        c_key.add("union");
        c_key.add("unsigned");
        c_key.add("void");
        c_key.add("volatile");
        c_key.add("while");

        // The idea is to input the
        // file line by line and split
        // them into and array of strings
        // and if an individual string
        // is present in the HashSet, then output
        // it in different file.
        // The input variable stores the
        // input line as a string.
        String input = null;

        try {
            // Don't break untill and unless
            // the whole file is read in which
            // case the input would be null
            while ((input = br.readLine()) != null) {

                // Split the input into an array of strings
                String[] parts = input.split(" ");

                // Iterate over the array of strings.
                // If the string is present in hash set
                // then output it.
                for (int i = 0; i < parts.length; i++) {
                    if (c_key.contains(parts[i])) {
                        bw.write(parts[i] + "\n");
                    }
                }

            }
        } finally {

                // Never forget to flush
                // the buffer.
                br.close();
                bw.flush();
                bw.close();
        }
    }
}

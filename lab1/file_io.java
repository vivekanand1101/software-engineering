import java.io.*;

public class file_io {
   public static void main(String args[]) throws IOException
   {
        File input_file = new File("input.txt");
        File output_file = new File("output.txt");
        String [] input;
        BufferedReader br = new BufferedReader(new FileReader(input_file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output_file));
      try {
         while ((input = br.readLine()) ) {
            System.out.println (input);
            bw.write(input);
         }
      }finally {
         if (input != null) {
            input_file.close();
         }
         if (input != null) {
            output_file.close();
         }
      }
   }
}

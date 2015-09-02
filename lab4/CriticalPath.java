
package criticalpath;
import java.io.*;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author placements2016
 */
public class CriticalPath {

    /**
     * @param args the command line arguments
     */
    static int max_(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int n = sc.nextInt();
        int matrix[][] = new int[50][50];
        
        int start_time[] = new int[50];
        int completion_time[] = new int[50];
        int execution_time[] = new int[50];
        //int dependencies[] = new int[n];
        int path[] = new int[50];
        
                
        System.out.println("Execution time: ");
        for (int i = 0; i < n; i++) {
            execution_time[i] = sc.nextInt();
        }
        
        start_time[0] = 0;
        completion_time[0] = execution_time[0];
        System.out.println("Boolean dependency matrix input: ");
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                matrix[i][j] = sc.nextInt();
            }
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] == 1) {
                    max = max_(completion_time[j], max);
                }
            }
            
            start_time[i] = max;
            completion_time[i] = start_time[i] + execution_time[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Process: " + i);
            System.out.println("Start Time: " + start_time[i] + " Execution Time: " + completion_time[i]);
        }
        
        int max_index = 0;
        int max_time = 0;
        for(int i = 0; i < n; i++){
            max_time = max_(max_time,completion_time[i]);
            if(max_time == completion_time[i]){
                max_index = i;
            }
        }
        while (max_index >= 0) {
            max_time = 0;
            System.out.print(max_index + " ");
            int flag = 0;
            int copy = max_index;
            for (int j = 0; j < copy; j++) {
                if (matrix[copy][j] == 1) {
                    flag = 1;
                    max_time = max_(max_time,completion_time[j]);
                    if(max_time == completion_time[j]){
                        max_index = j;
                    }
                }
            }
            
            if (flag == 0) {
                break;
            }
        }
    }
    
}
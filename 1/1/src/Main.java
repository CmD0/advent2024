import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String... args) {
        try {
            File input = new File("1/input");
            Scanner scan = new Scanner(input);
            int[] arr1 = new int[1000];
            int[] arr2 = new int[1000];
            for (int i = 0; i < 1000; ++i) {
                arr1[i] = scan.nextInt();
                arr2[i] = scan.nextInt();
            }
            scan.close();
            
            int total = 0;
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for (int i = 0; i < arr1.length; ++i) {
                int distance = (arr1[i] <= arr2[i]) ? arr2[i] - arr1[i] : arr1[i] - arr2[i];
                total += distance;
            }
            System.out.println(total);
        } catch (FileNotFoundException exception) {
            System.out.println("input file missing;");
        }
    }
}
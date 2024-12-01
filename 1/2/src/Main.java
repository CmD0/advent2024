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

            int total = 0;
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for (int i = 0; i < arr1.length; ++i) {
                int similarity = 0;
                int base = arr1[i];
                for (int j = 0; j < arr2.length; ++j) {
                    if (arr2[j] == base) {
                        similarity += base;
                    }
                }
                total += similarity;
            }
            System.out.println(total);
        } catch (FileNotFoundException exception) {
            System.out.println("input file missing;");
        }
    }
}
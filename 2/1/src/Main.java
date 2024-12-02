import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String... args) {
        try {
            File input = new File("2/input");
            Scanner scan = new Scanner(input);
            int total = 0; 
            for (int i = 0; i < 1000; ++i) {

                String line = scan.nextLine();
                String[] strings = line.split(" ");
                int[] numbers = new int[strings.length];
                int j = 0;

                for (String string : strings) {
                    numbers[j] = Integer.parseInt(string);
                    j++;
                }

                               
                boolean safe = true;
                boolean ascending = false;
                for (j=0; j < numbers.length - 1 && safe; ++j) {
                    if (j == 0) {
                        if (numbers[j] < numbers[j+1]) {
                            ascending = true;
                        }
                    }
                    if (Math.abs(numbers[j] - numbers[j+1]) > 3) {
                        safe = false;
                    } else {
                        safe = ascending ? numbers[j] < numbers[j+1] : numbers[j] > numbers[j+1];
                    }
                }
                if (safe) {
                    ++total;
                }
            }
            scan.close();
            System.out.println(total);
        } catch (FileNotFoundException exception) {
            System.out.println("input file missing");
        }
    }
}

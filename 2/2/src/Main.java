import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        try {
            File input = new File("2/input");
            Scanner scan = new Scanner(input);
            int total = 0; 
            
            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                String[] strings = line.split(" ");
                ArrayList<Integer> numbers = new ArrayList<>(strings.length);
                

                for (String string : strings) {
                    numbers.add(Integer.parseInt(string));
                }
                               
                boolean ascending;
                int ascendCount = 0;
                int descendCount = 0;
                for (int i=0; i < numbers.size() - 1; ++i) {
                    if (numbers.get(i) < numbers.get(i+1)) {
                        ascendCount++;
                    } else if (numbers.get(i) > numbers.get(i+1)) {
                        descendCount++;
                    }
                }
                ascending = ascendCount > descendCount;
                boolean safe = false;            
                for (int i = -1; i < numbers.size() && !safe; ++i) {
                    ArrayList<Integer> numbersCopy;
                    if (i == -1) {
                        numbersCopy = new ArrayList<>(numbers);
                    } else {
                        numbersCopy = new ArrayList<>(numbers);
                        numbersCopy.remove(i);
                    }
                    safe = true;
                    for (int j = 0; j < numbersCopy.size() - 1 && safe; ++j) {
                        if (Math.abs(numbersCopy.get(j) - numbersCopy.get(j+1)) > 3) {
                            safe = false;
                        } else {
                            safe = ascending ? numbersCopy.get(j) < numbersCopy.get(j+1) : numbersCopy.get(j) > numbersCopy.get(j+1);
                        }
                    }
                    if (safe) {
                        System.out.println(numbersCopy);
                        ++total;
                    }
                }
            }
            scan.close();
            System.out.println(total);
        } catch (FileNotFoundException exception) {
            System.out.println("input file missing");
        }
    }
}

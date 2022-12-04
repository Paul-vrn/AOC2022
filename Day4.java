import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        int val = 0;
        while (in.hasNextLine()) {
            String[] sections = in.nextLine().split(",");
            if (sections[0].equals("exit")) {
                break;
            } else if (sections.length == 1) {
                continue;
            }
            String[] numbers1 = sections[0].split("-");
            String[] numbers2 = sections[1].split("-");
            int x1 = Integer.parseInt(numbers1[0]);
            int y1 = Integer.parseInt(numbers1[1]);
            int x2 = Integer.parseInt(numbers2[0]);
            int y2 = Integer.parseInt(numbers2[1]);
            /* V1
            if ((x1 <= x2 && y2 <= y1) || (x2 <= x1 && y1 <= y2)) {
                val += 1;
            }*/
            // overlapping
            if (x1 <= x2) { // x1 left
                if (x2 <= y1) val +=1;
            } else { // x2 left
                if (x1 <= y2) val +=1;
            }
        }
        System.out.println(val);
    }
}

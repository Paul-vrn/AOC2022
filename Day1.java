import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int val = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("exit")) {
                System.out.println((pq.poll() + pq.poll() + pq.poll()));
                break;
            } else if (line.equals("")) {
                pq.add(val);
                val = 0;
            } else {
                val += Integer.parseInt(line);
            }
        }
    }
}
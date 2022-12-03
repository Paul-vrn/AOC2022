import java.util.*;

public class Day2 {
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        // map rock paper scissors
        //strat1(in);
        int val = 0;
        while (in.hasNextLine()){
            String[] line = in.nextLine().split(" ");
            if (line[0].equals("exit")) {
                break;
            } else if (line.length ==1){
                continue;
            }
            switch (line[1]){
                case "X"->{
                    switch (line[0]){
                        case "A" -> val += 3;
                        case "B" -> val += 1;
                        case "C" -> val += 2;
                    }
                    break;
                }
                case "Y"->{
                    val += 3;
                    switch (line[0]){
                        case "A" -> val += 1;
                        case "B" -> val += 2;
                        case "C" -> val += 3;
                    }
                    break;
                }
                case "Z"->{
                    val += 6;
                    switch (line[0]){
                        case "A" -> val += 2;
                        case "B" -> val += 3;
                        case "C" -> val += 1;
                    }
                    break;
                }
            }
            System.out.println(val);
        }
        System.out.println(val);
    }

    public static void strat2(Scanner in){
        int val = 0;
        String[] line = in.nextLine().split(" ");
        while (in.hasNextLine()){
            if (line[0].equals("exit")) {
                break;
            } else if (line.length ==1){
                continue;
            }
            switch (line[1]){
                case "X"->{
                    switch (line[0]){
                        case "A" -> val += 3;
                        case "B" -> val += 1;
                        case "C" -> val += 2;
                    }
                    break;
                }
                case "Y"->{
                    val += 3;
                    switch (line[0]){
                        case "A" -> val += 1;
                        case "B" -> val += 2;
                        case "C" -> val += 3;
                    }
                    break;
                }
                case "Z"->{
                    val += 6;
                    switch (line[0]){
                        case "A" -> val += 2;
                        case "B" -> val += 3;
                        case "C" -> val += 1;
                    }
                    break;
                }
            }
        }
        System.out.println(val);
    }
    public static void strat1(Scanner in) {
        Map<String, Move> map = new HashMap<>();
        map.put("A", Move.ROCK);
        map.put("B", Move.PAPER);
        map.put("C", Move.SCISSORS);
        map.put("X", Move.ROCK);
        map.put("Y", Move.PAPER);
        map.put("Z", Move.SCISSORS);

        int val = 0;
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" ");
            if (line[0].equals("exit")) {
                break;
            } else if (line.length ==1){
                continue;
            }
            switch (map.get(line[1])) {
                case ROCK -> val += 1;
                case PAPER -> val += 2;
                case SCISSORS -> val += 3;
            }
            if (map.get(line[0]).equals(map.get(line[1]))){
                val +=3;
            } else if (map.get(line[1]).beats(map.get(line[0]))){
                val +=6;
            }
        }
        System.out.println(val);
    }
    public enum Move {
        ROCK, PAPER, SCISSORS;

        public boolean beats(Move move) {
            return switch (this) {
                case ROCK -> move == SCISSORS;
                case PAPER -> move == ROCK;
                case SCISSORS -> move == PAPER;
            };
        }
    }
}
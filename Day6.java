import java.util.*;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {
        //read input

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            if (line.equals("exit")) {
                break;
            } else if (line.equals("")) {
                continue;
            }
            // for char
            int index = 14;
            for (int i = index; i < line.length(); i++){
                String substring = line.substring(i-14, i);
                System.out.println(substring);
                Set<Character> charsSet = substring.chars()
                        .mapToObj(e->(char)e).collect(Collectors.toSet());
                System.out.println(charsSet);
                if (charsSet.size() == 14){
                    System.out.println(i);
                    break;
                }
            }

            }
        }
}

import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        //read input
        String[] input = {
                "ZPMHR","PCJB","SNHGLCD","FTMDQSRL","FSPQBTZM","TFSZBG","NRV","PGLTDVCM","WQNJFML"
        };
        Scanner in = new Scanner(System.in);
        List<Stack<Character>> stacks = new ArrayList<>();
        Stack<Character> tmp = new Stack<>();
        for (String s : input) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
            stacks.add(stack);
        }

        while (in.hasNextLine()){
            String line = in.nextLine();
            if (line.equals("exit")) {
                break;
            } else if (line.equals("")) {
                continue;
            }
            String[] lines = line.split(" ");
            int nb = Integer.parseInt(lines[1]);
            int index_pop = Integer.parseInt(lines[3])-1;
            int index_push = Integer.parseInt(lines[5])-1;
            for (int i = 0; i < nb; i++){
                tmp.push(stacks.get(index_pop).pop());
            }
            for (int i =0; i < nb; i++){
                stacks.get(index_push).push(tmp.pop());
            }
        }
        for (Stack<Character> stack : stacks) {
            System.out.print(stack.peek());
        }
    }
}

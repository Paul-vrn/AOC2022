import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        //read input
        Map<Character, Boolean> container1;
        Map<Character, Boolean> container2;
        Map<Character, Boolean> container3;
        Scanner in = new Scanner(System.in);
        int val = 0;
        while (in.hasNextLine()) {
            container1 = new HashMap<>();
            container2 = new HashMap<>();
            container3 = new HashMap<>();
            char[] elf1 = in.nextLine().toCharArray();
            char[] elf2 = in.nextLine().toCharArray();
            char[] elf3 = in.nextLine().toCharArray();
            if (elf1[0] == '\n') {
                break;
            } else if (elf1.length == 1) {
                break;
            } else {
                for (int i = 0; i < elf1.length; i++){
                    container1.put(elf1[i], true);
                }
                for (int i = 0; i < elf2.length; i++){
                    container2.put(elf2[i], true);
                }
                for (int i = 0; i < elf3.length; i++){
                    container3.put(elf3[i], true);
                }
                int m = Math.max(container1.keySet().size(), Math.max(container2.keySet().size(), container3.keySet().size()));
                if (container1.keySet().size() ==m) {
                    for (char letter : container1.keySet()){
                        if (container2.containsKey(letter) && container3.containsKey(letter)){
                            val += (int) Character.toLowerCase(letter) - 96;
                            if (Character.isUpperCase(letter)) val += 26;
                        }
                    }
                } else if (container2.keySet().size() == m){
                    for (char letter : container2.keySet()){
                        if (container1.containsKey(letter) && container3.containsKey(letter)){
                            val += (int) Character.toLowerCase(letter) - 96;
                            if (Character.isUpperCase(letter)) val += 26;
                        }
                    }

                } else {
                    for (char letter : container3.keySet()){
                        if (container2.containsKey(letter) && container1.containsKey(letter)){
                            val += (int) Character.toLowerCase(letter) - 96;
                            if (Character.isUpperCase(letter)) val += 26;
                        }
                    }
                }
                System.out.println(container1.keySet());
            }
            System.out.println(val);
        }
    }
}

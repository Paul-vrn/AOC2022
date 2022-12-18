import java.util.*;

public class Day9 {

    public static Set<Case> passed = new HashSet<>();
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        Case H = new Case(0, 0);
        List<Case> followers = new ArrayList<>();
        for (int i=0; i<9;i++){
            followers.add(new Case(0, 0));
        }
        passed.add(new Case(0, 0));
        while (in.hasNextLine()){
            String[] line = in.nextLine().split(" ");
            if (line[0].equals("exit")) {
                break;
            } else if (line[0].equals("")) {
                continue;
            }
            String direction = line[0];
            int nbPas = Integer.parseInt(line[1]);
            switch (direction){
                case "R":
                    for (int i = 0; i < nbPas; i++) {
                        H = new Case(H.x + 1, H.y);
                        followers.set(0, deplace(H, followers.get(0)));
                        for(int j = 0; j<followers.size()-1; j++){
                            followers.set(j+1,deplace(followers.get(j), followers.get(j+1)));
                        }
                        passed.add(followers.get(followers.size()-1));
                    }
                    break;
                case "L":
                    for (int i = 0; i < nbPas; i++) {
                        H = new Case(H.x - 1, H.y);
                        followers.set(0, deplace(H, followers.get(0)));
                        for(int j = 0; j<followers.size()-1; j++){
                            followers.set(j+1,deplace(followers.get(j), followers.get(j+1)));
                        }
                        passed.add(followers.get(followers.size()-1));
                    }
                    break;
                case "U":
                    for (int i = 0; i < nbPas; i++) {
                        H = new Case(H.x, H.y + 1);
                        followers.set(0, deplace(H, followers.get(0)));
                        for(int j = 0; j<followers.size()-1; j++){
                            followers.set(j+1,deplace(followers.get(j), followers.get(j+1)));
                        }
                        passed.add(followers.get(followers.size()-1));
                    }
                    break;
                case "D":
                    for (int i = 0; i < nbPas; i++) {
                        H = new Case(H.x, H.y - 1);
                        followers.set(0, deplace(H, followers.get(0)));
                        for(int j = 0; j<followers.size()-1; j++){
                            followers.set(j+1,deplace(followers.get(j), followers.get(j+1)));
                        }
                        passed.add(followers.get(followers.size()-1));
                    }
                    break;
            }
            System.out.println("H:"+H);
            for (Case c : followers){
                System.out.println(c);
            }
        }
        System.out.println(passed.size());
    }
    public static Case deplace(Case H, Case T){
        System.out.println("deplace:"+H+" - "+T);
        if (
                !((H.x == T.x || H.x+1 == T.x || H.x-1 == T.x)
                && (H.y == T.y || H.y+1 == T.y || H.y-1 == T.y))
        ){
            if (H.x == T.x){
                if (H.y > T.y){
                    T = new Case(T.x, T.y+1);
                } else {
                    T = new Case(T.x, T.y-1);
                }
            } else {
                if (H.y == T.y){
                    // pas mm ligne mais mm col
                    if (H.x > T.x){
                        T = new Case(T.x+1, T.y);
                    } else {
                        T = new Case(T.x-1, T.y);
                    }
                } else {
                    if (H.y > T.y){
                        if (H.x > T.x){
                            T = new Case(T.x+1, T.y+1);
                        } else {
                            T = new Case(T.x-1, T.y+1);
                        }
                    } else {
                        if (H.x > T.x){
                            T = new Case(T.x+1, T.y-1);
                        } else {
                            T = new Case(T.x-1, T.y-1);
                        }

                    }
                }
            }
        }
        return T;
    }
    public static class Case {
        int x;
        int y;

        public Case(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Case aCase)) return false;
            return x == aCase.x && y == aCase.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        public String toString(){
            return x+","+y;
        }
    }
}

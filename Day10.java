import java.util.Scanner;

public class Day10 {

    public static int signalstrength;
    public static int sprite =1;
    public static boolean[][] dessin = new boolean[7][40];
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        int cycle =0;
        while (in.hasNextLine()){
            String[] line = in.nextLine().split(" ");
            if (line[0].equals("exit")) {
                break;
            } else if (line[0].equals("")) {
                continue;
            }
            String instruction = line[0];
            if (instruction.equals("noop")){
                cycle = draw(cycle);
            } else if(instruction.equals("addx")){
                cycle = draw(cycle);
                cycle = draw(cycle);
                sprite += Integer.parseInt(line[1]);
            }
        }
        for (int i=0;i<dessin.length;i++){
            for (int j=0;j<dessin[i].length;j++){
                System.out.print(
                        (dessin[i][j]) ? "#" : "."
                );
            }
            System.out.println();
        }
    }
    public static int augmente(int cycle){
        cycle++;
        if (cycle == 20 || (cycle-20)%40 == 0){
            signalstrength += cycle* sprite;
        }
        return cycle;
    }
    public static int draw(int cycle){
        cycle++;
        int row = (int)cycle/40;
        int pos = (cycle-1)%40;
        System.out.println("row="+row+":pos="+pos);
        dessin[row][pos] = (pos == sprite || pos == sprite+1 || pos == sprite-1);
        return cycle;
    }
}

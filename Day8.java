import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day8 {

    public static int iMax;
    public static int jMax;
    public static void main(String[] args) {
        //read input
        List<List<Integer>> matrix = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            if (line.equals("exit")) {
                break;
            } else if (line.equals("")) {
                continue;
            }
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++){
                row.add((int) line.charAt(i) - '0');
            }
            matrix.add(row);
        }
        System.out.println(matrix);
        iMax = matrix.size();
        jMax = matrix.get(0).size();
        int nbTrees = 0;
        /*for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.get(i).size(); j++){
                if (i == 0 || j == 0 || i == matrix.size() - 1 || j == matrix.get(i).size() - 1){
                    nbTrees++;
                } else {
                    if (ree(matrix, i, j, true, 1)
                        || ree(matrix, i, j, true, -1)
                        || ree(matrix, i, j, false, 1)
                        || ree(matrix, i, j, false, -1)
                    ){
                        nbTrees++;
                    }
                }
            }
        }*/
        int maxVue=0;
        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.get(i).size(); j++){
                int vueTree = ree(matrix, i, j, true, 1)
                        * ree(matrix, i, j, true, -1)
                        * ree(matrix, i, j, false, 1)
                        * ree(matrix, i, j, false, -1);
                if (vueTree > maxVue){
                    maxVue = vueTree;
                }
            }
        }
        System.out.println(maxVue);
    }

    public static int ree(List<List<Integer>> map, int i, int j, boolean direction, int sens) {
        int sizeMainTree = map.get(i).get(j);
        int nbTreeVisible = 0;
        int TreeSizeMax = 0;
        if (direction){
            //i
            i += sens;
            while (i < iMax && i >= 0){
//              if (val <= map.get(i).get(j)){return false;}
                if (map.get(i).get(j) <= sizeMainTree && map.get(i).get(j) > TreeSizeMax){
                    nbTreeVisible++;
                    TreeSizeMax = map.get(i).get(j);
                }
                i += sens;
            }
        } else {
            //j
            j += sens;
            while (j < jMax && j >= 0){
//                if (val <= map.get(i).get(j)){return false;}
                if (map.get(i).get(j) <= sizeMainTree && map.get(i).get(j) > TreeSizeMax){
                    nbTreeVisible++;
                    TreeSizeMax = map.get(i).get(j);
                }
                j += sens;
            }
        }
        return nbTreeVisible;
    }
}

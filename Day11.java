import java.math.BigInteger;
import java.util.*;

public class Day11 {

    public static List<Monkey> monkeys = new ArrayList<>();
    public static long supermodulo =1;
    public static void main(String[] args) {
        //read input
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] line = in.nextLine().split(" ");
            if (line[0].equals("exit")) {
                break;
            } else if (line[0].equals("")) {
                continue;
            }
            if (line[0].equals("Monkey")){
                Monkey monkey = new Monkey();
                String[] numbers = in.nextLine().split(":")[1].split(", ");
                for (String number : numbers){
                    monkey.items.add(Long.parseLong(number.trim()));
                }
                String[] operations = in.nextLine().split(" ");
                monkey.operation = operations[6];
                monkey.operationNumber = operations[7];
                String[] test = in.nextLine().split(" ");
                monkey.testNumber = Long.parseLong(test[test.length-1]);
                monkey.trueMonkey = Integer.parseInt(in.nextLine().split(" ")[9]);
                monkey.falseMonkey = Integer.parseInt(in.nextLine().split(" ")[9]);
                monkeys.add(monkey);
            }
        }
        for (Monkey m : monkeys){
            supermodulo *= m.testNumber;
        }
        for (int i = 0;i<10000;i++){
            for(Monkey monkey : monkeys){
                int nbItems = monkey.items.size();
                for (int j=0;j<nbItems;j++){
                    monkey.operate();
                }
            }
        }

        Collections.sort(monkeys, Comparator.comparingLong(Monkey::getInspected));
        for(Monkey m : monkeys){
            System.out.println(m);
        }
        System.out.println(monkeys.get(monkeys.size()-1).inspected * monkeys.get(monkeys.size()-2).inspected);
    }

    public static class Monkey{
        public List<Long> items = new ArrayList<>();
        public String operation;
        public String operationNumber;
        public Long testNumber;
        public int trueMonkey;
        public int falseMonkey;
        public long inspected = 0;
        public void operate(){
            inspected++;
            Long val = items.remove(0);
            Long opp = (operationNumber.equals("old")? val : Long.parseLong(operationNumber));
            val = (operation.equals("*")) ? (val%supermodulo)*(opp%supermodulo) : (val%supermodulo)+(opp%supermodulo);
            //val = Math.floorDiv(val,3);
            if (val%testNumber == 0){
                monkeys.get(trueMonkey).items.add(val);
            } else {
                monkeys.get(falseMonkey).items.add(val);
            }
        }

        public long getInspected(){ return inspected; }
        public String toString(){
            return ""+inspected;
        }
    }
    public static Long GCF(Long a, Long b) {
        if (b == 0) return a;
        else return (GCF (b, a % b));
    }
}

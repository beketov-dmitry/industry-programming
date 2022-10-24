import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class mySort implements Comparator<Integer>{
        @Override
        public int compare(Integer t1, Integer t2) {
            return t2 - t1;
        }
    }
    public static void topNSymb(String str, int n) {
        char chars[] = str.toCharArray();
        Arrays.sort(chars);
        HashMap<String, Integer> symbols = new HashMap<>();
        for (int i =  0; i < chars.length; i++){
            if(!symbols.containsKey(String.valueOf(chars[i]))){
                symbols.put(String.valueOf(chars[i]), 1);
            } else {
                symbols.put(String.valueOf(chars[i]), symbols.get(String.valueOf(chars[i]))+1);
            }
        }
        if(n > symbols.size()){
            System.out.println("n слишком большое");
            return;
        }
        HashMap<String, Integer> sortedMap = new HashMap<>();
        sortedMap = symbols.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
        ArrayList<Integer> mapValues = new ArrayList<>(sortedMap.values());
        ArrayList<String> keys = new ArrayList<>(sortedMap.keySet());
        for(int i = keys.size() - n; i<keys.size(); i++) {
            System.out.println(keys.get(i) + "-" + mapValues.get(i));
        }
    }
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer n = scanner.nextInt();
        topNSymb(str, n);
    }
}

package DeutscheBank.Day4;

import java.util.*;

abstract class Stundet {
    abstract void mama();
}

interface idiot {
    void mama2();
}

class Mama implements idiot{
    @Override
    public void mama2() {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
       // map.
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*LinkedList<Integer> linkedList = new LinkedList<Integer>();

        while(scanner.hasNextInt()){
            int x = scanner.nextInt();

            if (x == 0){
                linkedList.addFirst(x);
            }else{
                linkedList.addLast(x);
            }
        }

        for (Integer x : linkedList){
            System.out.print (x + " ");
        }
        System.out.println();*/

        /*String line = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char c : line.toCharArray()){
            if (stack.peek() != null){
                if (stack.peek() == c){
                    stack.pop();
                }
            }else{
                stack.add(c);
            }
        }

        StringBuilder stringBuilder =new StringBuilder();

        for (Character c : stack){
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());*/

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add(1, "d");
        System.out.println(arrayList);

    }
}

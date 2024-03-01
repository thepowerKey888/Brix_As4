import java.util.Stack;
import java.util.HashMap;

public class BalancedBrackets {

    public static String isBalanced(String s) {

        //char[] input = s.toCharArray();
        //int size = input.length;
        Stack<Character> stack = new Stack<>();

        //create the pairs of brackets
        HashMap<Character, Character> brackets = new HashMap<>();

        //adding bracket pairs to HashMap
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');

        if(s.length() < 1 || s.length() > 1000){
            return "Size of input is too big or too small!";
        }

        for(char bracket : s.toCharArray() ){
            if(bracket == '(' || bracket == '[' || bracket == '{'){
                stack.push(bracket);
            }
            else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty()) {
                    return "NO!"; //no match to closing bracket
                }
                char last = stack.pop();
                if (bracket != brackets.get(last)) {
                    return "NO!"; //a mismatch
                }
            } else{
                return "NO!"; //input wasn't a bracket
            }
        }

        //check if the stack has remaining brackets
        if(!stack.isEmpty()){
            return "NO!";
        }
        //if it is empty
        else{
            return "YES!";
        }

    }

    public static void main(String[] args){

        String input = "{[()]}";
        String input2 = "{[(])}";
        String input3 = "{{[[(())]]}}";
        System.out.println(isBalanced(input));
        System.out.println(isBalanced(input2));
        System.out.println(isBalanced(input3));
    }
}

import java.util.Stack;
import java.util.HashMap;
public class InfixToPostfix {

    public static String postfix(String infix){

        StringBuilder expression = new StringBuilder();
        Stack<Character> operator = new Stack<>();

        char[] expression_array = infix.toCharArray();
        for(char ch : expression_array){
            if(Character.isLetterOrDigit(ch)){ //checks char value
                expression.append(ch);
            }
            //checks if char is (
            else if (ch == '(') {
                operator.push(ch);
            }
            //checks if char is )
            else if (ch == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    expression.append(operator.pop());
                }
                operator.pop(); //removes (
            }

            //checks operators are in correct order
            else{
                while(!operator.isEmpty() && order(ch) <= order(operator.peek())){
                    expression.append(operator.pop());
                }
                operator.push(ch);
            }
        }

        //remove left over elements
        while(!operator.isEmpty()){
            expression.append(operator.pop());
        }

        return expression.toString();
    }


    private static int order(char operator){
         HashMap<Character, Integer> orders = new HashMap<>();
         orders.put('^', 3);
        orders.put('*', 2);
        orders.put('/', 2);
        orders.put('+', 1);
        orders.put('-', 1);

        return orders.getOrDefault(operator, 0);
    }

    public static void main(String[] args){

        String expressionIn = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(postfix(expressionIn));
    }
}

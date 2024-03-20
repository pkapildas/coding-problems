public class stackproblems {

    /**
     * assuming expressions are given as a string with space 
     *  2 1 + 3 * == (2+1 )*3 = 9 
     * 4 13 5 / + = 4+ (13/5) = 6
     */
    public int evaluateReversePolishNotation(String expr){
        String tokens = expr.split(" ");
        int value = 0;
        String operators = "+-*/";
        Stack<Integer>  stack = new Stack<>();

        for(String token : tokens){
            if(operators.contains(token)){
                // there's an operator matched 
                //fetch operands 
                int a =  stack.pop();
                int b =  stack.pop();
                swith(token) {
                    case '+' :
                        stack.push(a+b);
                        break;
                    case '-' :
                        stack.push(a+b);
                        break;
                    case '*' :
                        stack.push(a+b);
                        break;
                    case '/' :
                        stack.push(a+b);
                        break;
                }

            }else{
                stack.push(token);
            }
        }
        value = stack.pop();
        return value;
    }

    //One Improvement instead of comparing with characters we can compare with index 
    // index = operator.indexOf(token);
    // and do the case 0 , 1, such that.
}
import java.util.Scanner;

public class Tokenizer {
    int pos;
    char[] expression;

    Tokenizer(String expression) {
        this.expression = expression.toCharArray();
        this.pos = 0;
    }

    enum Type { OPERATOR, NUMBER, UNKNOWN, LETTER }

    class Lexeme {
        String type, token;
        int tokenno;
        Lexeme(String type, String token, int tokenno) {
            this.type = type;
            this.token = token;
            this.tokenno = tokenno;
        }
    }

    Lexeme getNextToken() {
        StringBuilder token = new StringBuilder();
        boolean endOfToken = false;
        int tokenno;
        Type type = Type.UNKNOWN;
        if(type==Type.NUMBER)
        {
        	tokenno=10;
        }else if(type==Type.LETTER)
        {
        	tokenno=11;
        }
        else 
        {
        	tokenno=0;
        }
        while (!endOfToken && hasMoreTokens()) {
            while(expression[pos] == ' ' && hasMoreTokens())
                pos++;
            switch (expression[pos]) {
                case '+':
                	tokenno=21;
                	if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case '-':
                	tokenno=22;
                	if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case '*':  
                	tokenno=23;
                	if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case '/':
                	tokenno=24;
                	if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case '(':
                	tokenno=25;
                	if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case ')':
                	tokenno=26;
                    if((type != Type.NUMBER)&&(type != Type.LETTER)) {
                        type = Type.OPERATOR;
                        token.append(expression[pos]);
                        pos++;
                    }
                    endOfToken = true;
                    break;
                case ' ':
                    endOfToken = true;
                    tokenno=-1;
                    pos++;
                    break;
                default:
                    if(Character.isDigit(expression[pos]) || expression[pos] == '.') {
                        token.append(expression[pos]);
                        type = Type.NUMBER;
                        tokenno=10;
                    } else if(Character.isAlphabetic(expression[pos]) || expression[pos] =='.') {
                    	token.append(expression[pos]);
                    	type = Type.LETTER;
                    	tokenno=11;
                    }else{
                        System.out.println("Systax error at position: " + pos);
                    }
                    pos++;
                    break;
            }
        }
        return new Lexeme(type.name().toLowerCase(), token.toString(), tokenno);
    }

    boolean hasMoreTokens() {
        return pos < expression.length;
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	String expression;
    	 Scanner in = new Scanner(System.in);
    	 
         System.out.println("Enter the expression");
         expression = in.nextLine();
        
        Tokenizer tokenizer = new Tokenizer(expression);
        while (tokenizer.hasMoreTokens()) {
            Lexeme nextToken = tokenizer.getNextToken();
            System.out.print("token:" + nextToken.tokenno + "\tLexeme: " + nextToken.token + "\n");
        }
    }
}
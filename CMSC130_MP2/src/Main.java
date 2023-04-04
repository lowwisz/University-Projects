/***************************
 INPUTS:
 	1. Type of flipflop
 	2. How many flipflops to be used
 	3. How many input variables
 	4. Output variables
 	5. Flipflop input variables
 ***************************/

import java.util.Scanner;

public class Main {

	static String decimalForm[] = new String[10000];

	public static void main(String[] args) {
		System.out.println("FLIP-FLOPS");
		System.out.println("[1] D Flip-flop");
		System.out.println("[2] T Flip-flop");
		System.out.println("[3] RS Flip-flop");
		System.out.println("[4] JK Flip-flop");

		System.out.print("\nChoose flip-flop: ");
		Scanner flipflopInput = new Scanner(System.in);
		int flipflopChoice = flipflopInput.nextInt();

		while(flipflopChoice > 4 || flipflopChoice < 1) {
			System.out.print("\nChoose flip-flop: ");
			flipflopInput = new Scanner(System.in);
			flipflopChoice = flipflopInput.nextInt();
		}

		System.out.println("\nHow many flip-flops to be used? 1 or 2?");
		System.out.print("> ");

		Scanner countInput = new Scanner(System.in);
		int flipflopCount = countInput.nextInt();

		while(flipflopCount > 2 || flipflopCount < 1) {
			System.out.print("> ");
			countInput = new Scanner(System.in);
			flipflopCount = countInput.nextInt();
		}

		int ffcount = flipflopCount;

		if(flipflopChoice == 3 || flipflopChoice == 4) {
			flipflopCount *= 2;
		}

		System.out.println("\nHow many input variables (x/y)? 1 or 2?");
		System.out.print("> ");

		Scanner varCountInput = new Scanner(System.in);
		int inputVarCount = varCountInput.nextInt();

		while(inputVarCount > 2 || inputVarCount < 1) {
			System.out.print("> ");
			varCountInput = new Scanner(System.in);
			inputVarCount = varCountInput.nextInt();
		}

		System.out.println("\nHow many output variable (none/z)? 0 or 1?");
		System.out.print("> ");

		Scanner outputCountInput = new Scanner(System.in);
		int outputVarCount = outputCountInput.nextInt();

		while(outputVarCount > 1 || outputVarCount < 0) {
			System.out.print("> ");
			outputCountInput = new Scanner(System.in);
			outputVarCount = outputCountInput.nextInt();
		}

		int functionCount = flipflopCount + outputVarCount;

		System.out.println("Instructions for inputting functions:");
		System.out.println("[1] Enclose variable complements in parentheses for correct input like (x')");
		System.out.println("[2] Make sure to use ^ for XOR, * for AND, and + for OR. (For AND, program will not read Ax correctly, input as A*x.)");
		System.out.print("[3] Note that you inputted " + ffcount + " flip-flop and " + inputVarCount + " input variables.");
		System.out.print("\n[4] Enter " + functionCount + " functions in the order of " + flipflopCount + " flipflop");
		System.out.print(" and " + outputVarCount + " output functions.\n");
		System.out.println("[5] Function variables allowed are as follows: A and B for flip-flops and x and y for inputs.");

		System.out.println("\nFlip-flop input functions: ");
		System.out.print("> ");

		Scanner inputFunctions = new Scanner(System.in);
		String flipflopInputFunctions = inputFunctions.nextLine();

		String[] functions = flipflopInputFunctions.split("\\s+");

		while(functions.length != functionCount) {
			System.out.println("\nFlip-flop input functions: ");
			System.out.print("> ");

			inputFunctions = new Scanner(System.in);
			flipflopInputFunctions = inputFunctions.nextLine();

			functions = flipflopInputFunctions.split("\\s+");

			functionCount = flipflopCount + outputVarCount;
		}

		int binaryCount = ffcount + inputVarCount;

		String[] binaryForms = decimalToBinary(binaryCount);

		if(flipflopChoice == 1) {
			String D[][] = substituteFunctions(binaryForms, functions, inputVarCount, ffcount);
			DFlipflop.dFlipFlop(binaryForms, D, functions, flipflopCount, inputVarCount, outputVarCount);
		}

		if(flipflopChoice == 2) {
			String[][] T = substituteFunctions(binaryForms, functions, inputVarCount, ffcount);
			TFlipflop.tFlipFlop(binaryForms, T, functions, flipflopCount, inputVarCount, outputVarCount);
		}

		if(flipflopChoice == 3) {
			String[][] RS = substituteFunctions(binaryForms, functions, inputVarCount, ffcount);
			RSFlipflop.rsFlipFlop(binaryForms, RS, functions, flipflopCount, inputVarCount, outputVarCount);
		}

		if(flipflopChoice == 4) {
			String[][] JK = substituteFunctions(binaryForms, functions, inputVarCount, ffcount);
			JKFlipflop.jkFlipFlop(binaryForms, JK, functions, flipflopCount, inputVarCount, outputVarCount);
		}

		flipflopInput.close();
		countInput.close();
		varCountInput.close();
		outputCountInput.close();
		inputFunctions.close();
	}

	//Methods

	//method that converts decimal number to binary
	public static String[] decimalToBinary(int binaryCount) {
		double num = Math.pow(2, binaryCount); //2^k rows
		int n = (int) num;
		String binaryNumbers[] = new String[n];
		for (int i = 0; i < n; i++) {
			binaryNumbers[i] = new String();
			binaryNumbers[i] = Integer.toBinaryString(i);
			int digitCount = binaryCount - binaryNumbers[i].length();
			for (int j = 0; j < digitCount; j++) {
				binaryNumbers[i] = "0" + binaryNumbers[i];
			}
		}
		return binaryNumbers;
	}

	//method that substitutes values of flip-flop and input variables into the functions
	public static String[][] substituteFunctions(String[] binaryForms, String[] functions, int inputVarCount, int ffcount) {
		String str[][] = new String[binaryForms.length][functions.length];

		if(binaryForms[0].length() == 2 && inputVarCount == 1 && ffcount == 1) {
			for(int i = 0; i < binaryForms.length; i++) {
				for(int j = 0; j < functions.length; j++) {
					for(int k = 0; k < binaryForms[i].length(); k++) {
						str[i][j] = functions[j].replace('A', binaryForms[i].charAt(0)); //flipflop 1 present state
						str[i][j] = str[i][j].replace('x', binaryForms[i].charAt(1)); //input 1 variable
					}
				}
			}
		}

		if(binaryForms[0].length() == 3 && inputVarCount == 1 && ffcount == 2) {
			for(int i = 0; i < binaryForms.length; i++) {
				for(int j = 0; j < functions.length; j++) {
					for(int k = 0; k < binaryForms[i].length(); k++) {
						str[i][j] = functions[j].replace('A', binaryForms[i].charAt(0)); //flipflop 1 present state
						str[i][j] = str[i][j].replace('B', binaryForms[i].charAt(1)); //flipflop 2 present state
						str[i][j] = str[i][j].replace('x', binaryForms[i].charAt(2)); //input 1 variable
					}
				}
			}
		}

		if(binaryForms[0].length() == 3 && inputVarCount == 2 && ffcount == 1) {
			for(int i = 0; i < binaryForms.length; i++) {
				for(int j = 0; j < functions.length; j++) {
					for(int k = 0; k < binaryForms[i].length(); k++) {
						str[i][j] = functions[j].replace('A', binaryForms[i].charAt(0)); //flipflop 1 present state
						str[i][j] = str[i][j].replace('x', binaryForms[i].charAt(1)); //input 1 variable
						str[i][j] = str[i][j].replace('y', binaryForms[i].charAt(2)); //input 2 variable
					}
				}
			}
		}

		if(binaryForms[0].length() == 4) {
			for(int i = 0; i < binaryForms.length; i++) {
				for(int j = 0; j < functions.length; j++) {
					for(int k = 0; k < binaryForms[i].length(); k++) {
						str[i][j] = functions[j].replace('A', binaryForms[i].charAt(0)); //flipflop 1 present state
						str[i][j] = str[i][j].replace('B', binaryForms[i].charAt(1)); //flipflop 2 present state
						str[i][j] = str[i][j].replace('x', binaryForms[i].charAt(2)); //input 1 variable
						str[i][j] = str[i][j].replace('y', binaryForms[i].charAt(3)); //input 2 variable
					}
				}
			}
		}
		return str;
	}

	//method to evaluate boolean expression
	//method created by Boann, shared on https://stackoverflow.com/a/26227947
	//modified it a bit, turned doubles into ints and added a line of code to read the not ' operator and XOR ^ operator
	public static int eval(final String str) {
		return new Object() {
			int pos = -1, ch;

			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			boolean eat(int charToEat) {
				while (ch == ' ') nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}

			int parse() {
				nextChar();
				int x = parseExpression();
				if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
				return x;
			}

			// Grammar:
			// expression = term | expression `+` term | expression `-` term
			// term = factor | term `*` factor | term `/` factor
			// factor = `+` factor | `-` factor | `(` expression `)`
			//        | number | functionName factor | factor `^` factor

			int parseExpression() {
				int x = parseTerm();
				for (;;) {
					if      (eat('+')) x += parseTerm(); // addition
					else if (eat('-')) x -= parseTerm(); // subtraction
					else return x;
				}
			}

			int parseTerm() {
				int x = parseFactor();
				for (;;) {
					if      (eat('*')) x *= parseFactor(); // multiplication
					else if (eat('/')) x /= parseFactor(); // division
					else if (eat('^')) x ^= parseFactor();
					else if (eat('\'')) {
						if(x == 0) {
							x = 1;
						}
						else if(x == 1) {
							x = 0;
						}
					}
					else return x;
				}
			}

			int parseFactor() {
				if (eat('+')) return parseFactor(); // unary plus
				if (eat('-')) return -parseFactor(); // unary minus

				int x = 0;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					eat(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
					x = Integer.parseInt(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') { // functions
					//	                while (ch >= 'a' && ch <= 'z') nextChar();
					//	                String func = str.substring(startPos, this.pos);
					//	                x = parseFactor();
					//	                if (func.equals("sqrt")) x = Math.sqrt(x);
					//	                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
					//	                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
					//	                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
					//	                else throw new RuntimeException("Unknown function: " + func);
				} else {
					throw new RuntimeException("Unexpected: " + (char)ch);
				}

				//	            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

				return x;
			}
		}.parse();
	}
}
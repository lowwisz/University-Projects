
public class JKFlipflop {

	//for JK flip-flop function values
	public static void JKFlipFlopStateTable(String binaryForms[], String JK[][], int flipflopCount) {
		String str[] = new String[binaryForms.length];
		String str1[][] = new String[binaryForms.length][2];

		int s[][] = new int[JK.length][JK[0].length];
		for(int i = 0; i < JK.length; i++) {
			for(int j = 0; j < JK[i].length; j++) {
				s[i][j] = Main.eval(JK[i][j]);

				if(s[i][j] > 1) {
					s[i][j] = 1;
				}	
			}
		}

		if(flipflopCount == 2) {
			//for A next state
			for(int i = 0; i < JK.length; i++) {
				if(s[i][0] == 0 && s[i][1] == 0) {
					str[i] = Character.toString(binaryForms[i].charAt(0));
				}
				else if(s[i][0] == 0 && s[i][1] == 1) {
					str[i] = "0";
				}
				else if(s[i][0] == 1 && s[i][1] == 0) {
					str[i] = "1";
				}
				else if(s[i][0] == 1 && s[i][1] == 1) {
					if(binaryForms[i].charAt(0) == '0') {
						str[i] = "1";
					}
					else {
						str[i] = "0";
					}
				}
			}
		}

		if(flipflopCount == 4) {
			for(int i = 0; i < JK.length; i++) {
				//for A next state
				if(s[i][0] == 0 && s[i][1] == 0) {
					str1[i][0] = Character.toString(binaryForms[i].charAt(0));
				}
				else if(s[i][0] == 0 && s[i][1] == 1) {
					str1[i][0] = String.valueOf(0);
				}
				else if(s[i][0] == 1 && s[i][1] == 0) {
					str1[i][0] = String.valueOf(1);
				}
				else if(s[i][0] == 1 && s[i][1] == 1) {
					if(binaryForms[i].charAt(0) == '0') {
						str1[i][0] = "1";
					}
					else {
						str1[i][0] = "0";
					}
				}

				//for B next state
				if(s[i][2] == 0 && s[i][3] == 0) {
					str1[i][1] = Character.toString(binaryForms[i].charAt(1));
				}
				else if(s[i][2] == 0 && s[i][3] == 1) {
					str1[i][1] = String.valueOf(0);
				}
				else if(s[i][2] == 1 && s[i][3] == 0) {
					str1[i][1] = String.valueOf(1);
				}
				else if(s[i][2] == 1 && s[i][3] == 1) {
					if(binaryForms[i].charAt(1) == '0') {
						str1[i][1] = "1";
					}
					else {
						str1[i][1] = "0";
					}
				}
			}
		}

		if(flipflopCount == 2) {
			for(int i = 0; i < JK.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < JK[i].length; j++) {
					int evaluated = Main.eval(JK[i][j]);

					if(evaluated > 1) {
						evaluated = 1;
					}	

					System.out.print(evaluated + "        " );
				}
				System.out.print(str[i] + "        ");
				System.out.println();
			}
		}

		if(flipflopCount == 4) {
			for(int i = 0; i < JK.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < JK[i].length; j++) {
					int evaluated = Main.eval(JK[i][j]);

					if(evaluated > 1) {
						evaluated = 1;
					}	

					System.out.print(evaluated + "        ");
				}
				System.out.print(str1[i][0] + "        " + str1[i][1]);
				System.out.println();
			}
		}
	}

	//for JK Flip-flop output display
	public static void jkFlipFlop(String binaryForm[], String str[][], String functions[], int flipflopCount, int inputVarCount, int outputVarCount) {
		System.out.println("\nJK FLIP-FLOP STATE TABLE\n");

		if(outputVarCount == 0) {
			if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println();
				System.out.println("A        x        JA       KA       A(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 1) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("JB = " + functions[2]);
				System.out.println("KB = " + functions[3]);
				System.out.println();
				System.out.println("A        B        x        JA       KA       JB       KB       A(t+1)   B(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println();
				System.out.println("A        x        y        JA       KA       A(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 2) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("JB = " + functions[2]);
				System.out.println("KB = " + functions[3]);
				System.out.println();
				System.out.println("A        B        x        y        JA       KA       JB       KB       A(t+1)   B(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
		} else if(outputVarCount == 1) {
			if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        x        JA       KA       z        A(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 1) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("JB = " + functions[2]);
				System.out.println("KB = " + functions[3]);
				System.out.println("z (output) = " + functions[4]);
				System.out.println();
				System.out.println("A        B        x        JA       KA       JB       KB       z        A(t+1)   B(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        x        y        JA       KA       z        A(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 2) {
				System.out.println("JA = " + functions[0]);
				System.out.println("KA = " + functions[1]);
				System.out.println("JB = " + functions[2]);
				System.out.println("KB = " + functions[3]);
				System.out.println("z (output) = " + functions[4]);
				System.out.println();
				System.out.println("A        B        x        y        JA       KA       JB       KB       z        A(t+1)   B(t+1)");
				JKFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
		}
	}
}
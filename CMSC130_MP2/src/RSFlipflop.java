
public class RSFlipflop {

	//for RS Flip-flop function values
	public static void RSFlipFlopStateTable(String binaryForms[], String RS[][], int flipflopCount) {
		String str[] = new String[binaryForms.length];
		String str1[][] = new String[binaryForms.length][2];

		int s[][] = new int[RS.length][RS[0].length]; 
		for(int i = 0; i < RS.length; i++) {
			for(int j = 0; j < RS[i].length; j++) {
				s[i][j] = Main.eval(RS[i][j]);

				if(s[i][j] > 1) {
					s[i][j] = 1;
				}	
			}
		}

		if(flipflopCount == 2) {
			//for A next state
			for(int i = 0; i < RS.length; i++) {
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
					str[i] = "?";
				}
			}
		}

		if(flipflopCount == 4) {
			for(int i = 0; i < RS.length; i++) {
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
					str1[i][0] = "?";
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
					str1[i][1] = "?";
				}
			}
		}

		if(flipflopCount == 2) {
			for(int i = 0; i < RS.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < RS[i].length; j++) {
					int evaluated = Main.eval(RS[i][j]);

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
			for(int i = 0; i < RS.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < RS[i].length; j++) {
					int evaluated = Main.eval(RS[i][j]);

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

	//for RS Flip-flop output display
	public static void rsFlipFlop(String binaryForms[], String str[][], String functions[], int flipflopCount, int inputVarCount, int outputVarCount) {
		System.out.println("\nRS FLIP-FLOP STATE TABLE\n");

		if(outputVarCount == 0) {
			if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println();
				System.out.println("A        x        SA       RA       A(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 1) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("SB = " + functions[2]);
				System.out.println("RB = " + functions[3]);
				System.out.println();
				System.out.println("A        B        x        SA       RA       SB       RB       A(t+1)   B(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println();
				System.out.println("A        x        y        SA       RA       A(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 2) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("SB = " + functions[2]);
				System.out.println("RB = " + functions[3]);
				System.out.println();
				System.out.println("A        B        x        y        SA       RA       SB       RB       A(t+1)   B(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
		} 

		else if(outputVarCount == 1) {
			if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        x        SA       RA       z        A(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 1) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("SB = " + functions[2]);
				System.out.println("RB = " + functions[3]);
				System.out.println("z (output) = " + functions[4]);
				System.out.println();
				System.out.println("A        B        x        SA       RA       SB       RB       z        A(t+1)   B(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        x        y        SA       RA       z        A(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 4 && inputVarCount == 2) {
				System.out.println("SA = " + functions[0]);
				System.out.println("RA = " + functions[1]);
				System.out.println("SB = " + functions[2]);
				System.out.println("RB = " + functions[3]);
				System.out.println("z (output) = " + functions[4]);
				System.out.println();
				System.out.println("A        B        x        y        SA       RA       SB       RB       z        A(t+1)   B(t+1)");
				RSFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
		}
	}
}
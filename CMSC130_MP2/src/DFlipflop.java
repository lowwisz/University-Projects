
public class DFlipflop {
	
	//for D Flip-flop function values
	public static void DFlipFlopStateTable(String binaryForms[], String D[][], int flipflopCount) {
		String str[] = new String[binaryForms.length];
		String str1[][] = new String[binaryForms.length][2];

		int s[][] = new int[D.length][D[0].length]; 
		for(int i = 0; i < D.length; i++) {
			for(int j = 0; j < D[i].length; j++) {
				s[i][j] = Main.eval(D[i][j]);

				if(s[i][j] > 1) {
					s[i][j] = 1;
				}
			}
		}

		if(flipflopCount == 1) {
			//for A next state
			for(int i = 0; i < D.length; i++) {
				str[i] = String.valueOf(s[i][0]); //A(t+1) = DA
			}
		}

		if(flipflopCount == 2) {
			//for A next state
			for(int i = 0; i < D.length; i++) {
				str1[i][0] = String.valueOf(s[i][0]); //A(t+1) = DA
			}

			//for B next state
			for(int i = 0; i < D.length; i++) {
				str1[i][1] = String.valueOf(s[i][1]); //B(t+1) = DB
			}
		}

		if(flipflopCount == 1) {
			for(int i = 0; i < D.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < D[i].length; j++) {
					int evaluated = Main.eval(D[i][j]);

					if(evaluated > 1) {
						evaluated = 1;
					}	

					System.out.print(evaluated + "        " );
				}
				System.out.print(str[i] + "        ");
				System.out.println();
			}
		}

		if(flipflopCount == 2) {
			for(int i = 0; i < D.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < D[i].length; j++) {
					int evaluated = Main.eval(D[i][j]);

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
	
	//for D Flip-flop output display
	public static void dFlipFlop(String binaryForms[], String str[][], String functions[], int flipflopCount, int inputVarCount, int outputVarCount) {
		System.out.println("\nD FLIP-FLOP STATE TABLE\n");

		if(outputVarCount == 0) {
			if(flipflopCount == 1 && inputVarCount == 1) {
				System.out.println("DA = " + functions[0]);
				System.out.println();
				System.out.println("A        x        DA       A(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("DA = " + functions[0]);
				System.out.println("DB = " + functions[1]);
				System.out.println();
				System.out.println("A        B        x        DA       DB       A(t+1)   B(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 1 && inputVarCount == 2) {
				System.out.println("DA = " + functions[0]);
				System.out.println();
				System.out.println("A        x        y        DA       A(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("DA = " + functions[0]);
				System.out.println("DB = " + functions[1]);
				System.out.println();
				System.out.println("A        B        x        y        DA       DB       A(t+1)   B(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
		} else if(outputVarCount == 1) {
			if(flipflopCount == 1 && inputVarCount == 1) {
				System.out.println("DA = " + functions[0]);
				System.out.println("z (output) = " + functions[1]);
				System.out.println();
				System.out.println("A        x        DA       z        A(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("DA = " + functions[0]);
				System.out.println("DB = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        B        x        DA       DB       z        A(t+1)   B(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 1 && inputVarCount == 2) {
				System.out.println("DA = " + functions[0]);
				System.out.println("z (output) = " + functions[1]);
				System.out.println();
				System.out.println("A        x        y        DA       z        A(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("DA = " + functions[0]);
				System.out.println("DB = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        B        x        y        DA       DB       z        A(t+1)   B(t+1)");
				DFlipFlopStateTable(binaryForms, str, flipflopCount);
			}
		}
	}
}

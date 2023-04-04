
public class TFlipflop {

	//For T Flip-flop function values
	public static void TFlipFlopStateTable(String binaryForms[], String T[][], int flipflopCount) {
		String str[] = new String[binaryForms.length];
		String str1[][] = new String[binaryForms.length][2];

		int s[][] = new int[T.length][T[0].length]; 
		for(int i = 0; i < T.length; i++) {
			for(int j = 0; j < T[i].length; j++) {
				s[i][j] = Main.eval(T[i][j]);

				if(s[i][j] > 1) {
					s[i][j] = 1;
				}
			}
		}

		if(flipflopCount == 1) {
			//for A next state
			for(int i = 0; i < T.length; i++) {
				if(s[i][0] == 0) { //TA = 0
					str[i] = Character.toString(binaryForms[i].charAt(0)); //A(t+1) = A
				}
				else { //TA = 1
					if(binaryForms[i].charAt(0) == '0') { 
						str[i] = "1"; //A = 0 -> A(t+1) = 1
					}
					else {
						str[i] = "0"; //A = 1 -> A(t+1) = 0
					}
				}
			}
		}

		if(flipflopCount == 2) {
			//for A next state
			for(int i = 0; i < T.length; i++) {
				if(s[i][0] == 0) { //TA = 0
					str1[i][0] = Character.toString(binaryForms[i].charAt(0)); //A(t+1) = A
				}
				else { //TA = 1
					if(binaryForms[i].charAt(0) == '0') { 
						str1[i][0] = "1"; //A = 0 -> A(t+1) = 1
					}
					else {
						str1[i][0] = "0"; //A = 1 -> A(t+1) = 0
					}
				}
			}

			//for B next state
			for(int i = 0; i < T.length; i++) {
				if(s[i][1] == 0) { //TB = 0
					str1[i][1] = Character.toString(binaryForms[i].charAt(1)); //B(t+1) = B
				}
				else { //TB = 1
					if(binaryForms[i].charAt(1) == '0') { 
						str1[i][1] = "1"; //B = 0 -> B(t+1) = 1
					}
					else {
						str1[i][1] = "0"; //A = 1 -> B(t+1) = 0
					}
				}
			}
		}

		if(flipflopCount == 1) {
			for(int i = 0; i < T.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < T[i].length; j++) {
					int evaluated = Main.eval(T[i][j]);

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
			for(int i = 0; i < T.length; i++) {
				System.out.print(binaryForms[i].replaceAll(".", "$0        "));
				for(int j = 0; j < T[i].length; j++) {
					int evaluated = Main.eval(T[i][j]);

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

	//for T flip-flop output display
	public static void tFlipFlop(String binaryForm[], String str[][], String functions[], int flipflopCount, int inputVarCount, int outputVarCount) {
		System.out.println("\nT FLIP-FLOP STATE TABLE\n");

		if(outputVarCount == 0) {
			if(flipflopCount == 1 && inputVarCount == 1) {
				System.out.println("TA = " + functions[0]);
				System.out.println();
				System.out.println("A        x        TA       A(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("TA = " + functions[0]);
				System.out.println("TB = " + functions[1]);
				System.out.println();
				System.out.println("A        B        x        TA       TB       A(t+1)   B(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 1 && inputVarCount == 2) {
				System.out.println("TA = " + functions[0]);
				System.out.println();
				System.out.println("A        x        y        TA       A(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("TA = " + functions[0]);
				System.out.println("TB = " + functions[1]);
				System.out.println();
				System.out.println("A        B        x        y        TA       TB        A(t+1)   B(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
		} else if(outputVarCount == 1) {
			if(flipflopCount == 1 && inputVarCount == 1) {
				System.out.println("TA = " + functions[0]);
				System.out.println("z (output) = " + functions[1]);
				System.out.println();
				System.out.println("A        x        TA       z        A(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 1) {
				System.out.println("TA = " + functions[0]);
				System.out.println("TB = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        B        x        TA       TB       z        A(t+1)   B(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 1 && inputVarCount == 2) {
				System.out.println("TA = " + functions[0]);
				System.out.println("z (output) = " + functions[1]);
				System.out.println();
				System.out.println("A        x        y        TA       z        A(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
			else if(flipflopCount == 2 && inputVarCount == 2) {
				System.out.println("TA = " + functions[0]);
				System.out.println("TB = " + functions[1]);
				System.out.println("z (output) = " + functions[2]);
				System.out.println();
				System.out.println("A        B        x        y        TA       TB       z        A(t+1)   B(t+1)");
				TFlipFlopStateTable(binaryForm, str, flipflopCount);
			}
		}
	}
}

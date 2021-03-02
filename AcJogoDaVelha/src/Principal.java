import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		char teste[][] = new char[3][3];
		
		for (int i=0; i < 3; i++){
            String linha = ler.nextLine();
            String[] linhas = linha.split(" ");
            for (int j=0; j < 3; j++)
               teste[i][j] = linhas[j].charAt(0);
        }
		
		Exibir(teste);
	}
	
	
	
	
	
	
	
	
	public static void Exibir(char layout[][]) {
		for (int i=0; i < layout.length; i++){
            for (int j=0; j< layout[0].length; j++)
                System.out.print (layout[i][j] + " ");
            System.out.println();
		}
	}
}

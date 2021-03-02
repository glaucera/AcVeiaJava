package Principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciar jogo? (s/n)");
        char resp = ler.next().toLowerCase().charAt(0);

        if(resp == 's'){
            do{
                Metodos.game();
                System.out.println("Jogar novamente? (s/n)");
                resp = ler.next().charAt(0);
            }while(resp == 's');
        }
        ler.close();
    }
}
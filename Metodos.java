package Principal;

import java.util.Scanner;

public class Metodos {

    public static char[][] initialize() {
        char[][] Matriz = new char[3][3];
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                Matriz[i][j] = ' ';
            }
        }
        return Matriz;
    }

    public static void Mostrar(char Matriz[][]) {
        for (int i = 0; i < Matriz.length; i++) {
            if (i > 0 && i < 3) {
                System.out.println();
                System.out.println("______");
            }
            for (int j = 0; j < Matriz[0].length; j++) {
                System.out.print(Matriz[i][j]);
                if (j < Matriz.length - 1) {
                    System.out.print("|");
                }
            }
        }
    }

    public static boolean step(char Matriz[][], int lin, int col, char Jogador) {

        boolean preencher = false;

        if (Matriz[lin][col] == ' ') {
            preencher = true;
            Matriz[lin][col] = Jogador;
        }
        return preencher;
    }

    public static int Linhas() {
        Scanner ler = new Scanner(System.in);

        System.out.println("\nDigite a linha de sua jogada. (0 a 2) ");
        int lin = ler.nextInt();
        while (lin > 2 || lin < 0) {
            System.out.println("Digite uma Casa Disponivel!");
            System.out.println("\nDigite a linha de sua jogada. (0 a 2) ");
            lin = ler.nextInt();
        }
        return lin;
    }

    public static int Colunas() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a coluna de sua jogada. (0 a 2)");
        int col = ler.nextInt();
        while (col > 2 || col < 0) {
            System.out.println("Digite uma Casa Disponivel!");
            System.out.println("Digite a coluna de sua jogada. (0 a 2) ");
            col = ler.nextInt();
        }
        return col;
    }

    public static int status(char Matriz[][]) {
        int status = 15;
        if (Vencedor(Matriz, 'O') == 'O') {
            status = 1;
        } else if (Vencedor(Matriz, 'X') == 'X') {
            status = 2;
        }
        if (MatrizCompleta(Matriz) == true && status != 1 && status != 2) {
            status = 0;
        }
        if (MatrizCompleta(Matriz) == false && status != 1 && status != 2) {
            status = -1;
        }
        switch (status) {
            case 0:
                System.out.println("\n\nEmpate!");
                break;
            case 1:
                System.out.println("\n\nJogador O ganhou!");
                break;
            case 2:
                System.out.println("\n\nJogador X ganhou!");
                break;
        }
        return status;
    }

    public static char Vencedor(char Matriz[][], char Jogador) {
        char Vencedor = 'Q';
        for (int i = 0; i < Matriz.length; i++) {
            if ((Matriz[i][0] == Jogador && Matriz[i][1] == Jogador && Matriz[i][2] == Jogador)
                    || (Matriz[0][i] == Jogador && Matriz[1][i] == Jogador && Matriz[2][i] == Jogador)) {
                Vencedor = Jogador;
            }
        }
        int contagem = 0;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                if (i == j) {
                    if (Matriz[i][j] == Jogador) {
                        contagem += 1;
                    }
                }
            }
            if (contagem == 3) {
                Vencedor = Jogador;
            }
        }
        if (Matriz[0][2] == Jogador && Matriz[1][1] == Jogador && Matriz[2][0] == Jogador) {
            Vencedor = Jogador;
        }
        return Vencedor;
    }

    public static boolean MatrizCompleta(char Matriz[][]) {
        boolean resp;
        int contagem = 0;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                if (Matriz[i][j] != ' ') {
                    contagem += 1;
                }
            }
        }
        if (contagem == 9) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    public static void game() {

        char Matriz[][] = Metodos.initialize();
        char player = 'Q';
        System.out.println();
        Mostrar(Matriz);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }
            System.out.print("\n\nVez do jogador: " + player);

            boolean bool = step(Matriz, Metodos.Linhas(), Metodos.Colunas(), player);
            if (bool == false) {
                do {
                    System.out.print("\nDigite um campo valido!");
                    bool = step(Matriz, Metodos.Linhas(), Metodos.Colunas(), player);
                } while (bool == false);
            }
            System.out.println();
            Mostrar(Matriz);
            int x = status(Matriz);

            if (x == 1 || x == 2 || x == 0) {
                break;
            }
        }
    }
}

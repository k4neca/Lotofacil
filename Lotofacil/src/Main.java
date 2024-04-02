import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        Random gerador = new Random();

        int opcao = 999, numero=1, numSorteado;
        char letra, letraSorteada = 'C';
        boolean condicao = true;

        do{
            try {
                System.out.println("*******************************************");
                System.out.println("Menu LOTOFÁCIL:");
                System.out.println("1) Apostar de 0 a 100");
                System.out.println("2) Apostar de A à Z");
                System.out.println("3) Apostar em par ou ímpar");
                System.out.println("0) Sair");
                System.out.println("*******************************************");

                System.out.print("Selecione uma opção: ");
                opcao = scn.nextInt();

                switch (opcao) {
                    case 1:
                        do {
                            try{
                                System.out.print("Informe um número de 0 a 100: ");
                                numero = scn.nextInt();
                                if (numero < 0 || numero > 100) {
                                    System.out.println("\nO numero informado não está entre 0 e 100\n");
                                    condicao = false;
                                } else {
                                    numSorteado = gerador.nextInt(101);

                                    if (numero == numSorteado) {
                                        System.out.println("\nParabéns, você ganhou R$ 1.000,00 reais\n");
                                        condicao = true;
                                    } else {
                                        System.out.println("\nInfelizmente o número sorteado é o " + numSorteado+"\n");
                                        condicao = true;
                                    }
                                }
                            }catch (InputMismatchException err){
                                System.out.println("\nPor favor digite um número!\n");
                                scn.nextLine();
                                condicao = false;
                            }
                        } while (!condicao);
                        break;
                    case 2:
                        do {
                            System.out.print("Informe uma letra de A a Z: ");
                            letra = (char) System.in.read();
                            letra = Character.toUpperCase(letra);
                            if (Character.isLetter(letra)) {
                                if (letra == letraSorteada) {
                                    System.out.println("\nParabéns! Você ganhou R$ 500 reais\n");
                                    condicao = true;
                                } else {
                                    System.out.println("\nQue pena! A letra sorteada foi: " + letraSorteada+"\n");
                                    condicao = true;
                                }
                            } else {
                                System.out.println("\nAposta inválida.\n");
                                condicao = false;
                            }
                        }while (!condicao);
                        break;
                    case 3:
                        System.out.print("Informe um numero inteiro: ");
                        numero = scn.nextInt();

                        if (numero % 2 == 0) {
                            System.out.println("\nParabéns! Você ganhou R$ 100,00 reais\n");
                        } else {
                            System.out.println("\nQue pena! O número digitado é ímpar e a premiação foi para números pares.\n");
                        }
                        break;
                    case 0:
                        System.out.println("\nSaindo...");
                        break;
                    default:
                        System.out.println("\nOpção inválida!\n");
                }
            }catch (InputMismatchException err){
                System.out.println("\nOpção inválida!\n");
                scn.nextLine();
            }
        }while (opcao != 0);
    }
}
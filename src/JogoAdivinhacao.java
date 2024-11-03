import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Bem-vindo ao Jogo de Adivinhação de Números!");
        
        System.out.println("Aqui você será desafiado pela máquina!");

        try {
            // Escolha do intervalo pelo jogador
            System.out.print("Digite o valor mínimo do intervalo que o computador pode escolher: ");
            int min = scanner.nextInt();
            System.out.print("Digite o valor máximo do intervalo que o computador pode escolher: ");
            int max = scanner.nextInt();
            
            if (min >= max) {
                System.out.println("O intervalo mínimo deve ser menor que o máximo. Encerrando o jogo.");
                return;
            }
            
            // Geração do número aleatório no intervalo definido
            int numeroSecreto = random.nextInt((max - min) + 1) + min;
            int tentativas = 0;
            boolean acertou = false;
            
            System.out.println("Tente adivinhar o número entre " + min + " e " + max + ". Digite -1 para sair.");
            
            // Loop principal do jogo
            while (!acertou) {
                System.out.print("Digite sua tentativa: ");
                
                int tentativa;
                try {
                    tentativa = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    scanner.next(); // Limpa a entrada inválida
                    continue;
                }

                // Opção de sair
                if (tentativa == -1) {
                    System.out.println("Jogo encerrado. O número secreto era: " + numeroSecreto);
                    break;
                }

                tentativas++;

                // Fornecimento de dicas
                if (tentativa < numeroSecreto) {
                    System.out.println("O número é maior que " + tentativa);
                } else if (tentativa > numeroSecreto) {
                    System.out.println("O número é menor que " + tentativa);
                } else {
                    System.out.println("Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativas.");
                    acertou = true;
                }
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir números inteiros.");
        } finally {
            System.out.println("Obrigado por jogar!");
            scanner.close();
        }
    }
}

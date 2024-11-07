package trabalho;

import java.util.Scanner;

class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    // Construtor da classe Campeao
    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    // Método que calcula o dano recebido pelo campeão
    public void receberDano(int dano) {
        int danoFinal = Math.max(dano - armadura, 1);  // Garante que o dano mínimo seja 1
        vida = Math.max(vida - danoFinal, 0);  // Garante que a vida não seja negativa
    }

    // Método que retorna o status atual do campeão
    public String status() {
        return vida > 0 ? nome + ": " + vida + " de vida" : nome + ": 0 de vida (morreu)";
    }

    // Getters para acessar atributos do campeão
    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }
}

public class Combate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de dados para o primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome1 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = sc.nextInt();
        sc.nextLine();  // Limpa o buffer do scanner

        // Instanciação do primeiro campeão
        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);

        // Entrada de dados para o segundo campeão
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String nome2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = sc.nextInt();

        // Instanciação do segundo campeão
        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        // Definindo o número de turnos
        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = sc.nextInt();

        // Loop dos turnos de combate
        for (int i = 1; i <= turnos; i++) {
            // Campeão 1 ataca o Campeão 2
            campeao2.receberDano(campeao1.getAtaque());

            // Campeão 2 ataca o Campeão 1
            campeao1.receberDano(campeao2.getAtaque());

            // Exibe o resultado do turno
            System.out.println("Resultado do turno " + i + ":");
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());

            // Verifica se algum campeão morreu
            if (campeao1.getVida() == 0 || campeao2.getVida() == 0) {
                break;
            }
        }

        System.out.println("### FIM DO COMBATE ###");
        sc.close();
    }
}

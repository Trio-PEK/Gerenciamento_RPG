package rpg;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("   GERENCIADOR DE AVENTURA RPG");
        System.out.println("================================");
        System.out.println();

        /*
         * ENTRADA + VALIDAÇÃO
         *
         * Cada metodo abaixo fica repetindo a pergunta até receber um
         * valor válido.
         *
         * Neste momento ainda NÃO criamos o objeto Personagem.
         */

        String nome = lerNome();
        int idade = lerIdade();
        Raca raca = lerRaca();
        int classe = lerClasse();
        Arma arma = lerArma(classe);

        /*
         * REQUISITO — VALIDAÇÃO ANTES DA INSTANCIAÇÃO
         *
         * Só chegamos aqui depois que nome, idade, raça, classe e arma
         * passaram pelas validações.
         *
         * O metodo criarPersonagem faz a INSTANCIAÇÃO:
         * new Mago(...), new Guerreiro(...) ou new Arqueiro(...).
         *
         * POLIMORFISMO:
         * a variável é do tipo Personagem, mas o objeto concreto pode ser
         * Mago, Guerreiro ou Arqueiro.
         */
        Personagem personagem = criarPersonagem(
                nome, idade, raca, arma, classe
        );

        System.out.println();
        System.out.println("================================");
        System.out.println("     PERSONAGEM CRIADO!!");
        System.out.println("================================");

        personagem.mostrarAtributos();

        /*
         * POLIMORFISMO NA PRÁTICA
         *
         * A chamada é feita através da referência Personagem.
         * Em tempo de execução, Java usa a implementação sobrescrita da
         * classe concreta: Mago, Guerreiro ou Arqueiro.
         */
        System.out.println();
        personagem.atacar();

        /*
         * INTERFACE
         *
         * Personagem implementa Aventureiro, então possui iniciarAventura().
         */
        personagem.iniciarAventura();

        scanner.close();
    }

    /*
     * VALIDAÇÃO DO NOME
     *
     * O while(true) cria um ciclo que só termina quando o dado é válido.
     */
    private static String lerNome() {
        while (true) {
            System.out.print("Digite o nome do personagem: ");
            String nome = scanner.nextLine().trim();

            if (Validador.validarNome(nome)) {
                return nome;
            }

            System.out.println("❌ O nome não pode ficar vazio. Tente novamente.");
        }
    }

    /*
     * VALIDAÇÃO DA IDADE + TRATAMENTO DE EXCEÇÃO
     *
     * Integer.parseInt pode gerar NumberFormatException se o usuário
     * digitar "abc", por exemplo.
     *
     * O try/catch impede que o programa quebre.
     */
    private static int lerIdade() {
        while (true) {
            System.out.print("Digite a idade: ");
            String entrada = scanner.nextLine().trim();

            try {
                int idade = Integer.parseInt(entrada);

                if (Validador.validarIdade(idade)) {
                    return idade;
                }

                System.out.println("❌ A idade deve ser um número positivo.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "❌ Digite uma idade válida usando apenas números."
                );
            }
        }
    }

    /*
     * LEITURA E VALIDAÇÃO DA RAÇA
     */
    private static Raca lerRaca() {
        while (true) {
            System.out.println();
            System.out.println("Escolha a raça:");

            Raca[] racas = Raca.values();

            for (int i = 0; i < racas.length; i++) {
                System.out.println(
                        (i + 1) + " - " + racas[i].getNome()
                );
            }

            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(entrada);

                if (Validador.validarRaca(opcao)) {
                    return racas[opcao - 1];
                }

                System.out.println("❌ Escolha uma opção válida.");

            } catch (NumberFormatException e) {
                System.out.println("❌ Digite apenas o número da opção.");
            }
        }
    }

    /*
     * LEITURA E VALIDAÇÃO DA CLASSE
     */
    private static int lerClasse() {
        while (true) {
            System.out.println();
            System.out.println("Escolha a classe:");
            System.out.println("1 - Mago");
            System.out.println("2 - Guerreiro");
            System.out.println("3 - Arqueiro");
            System.out.print("> ");

            String entrada = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(entrada);

                if (Validador.validarClasse(opcao)) {
                    return opcao;
                }

                System.out.println("❌ Escolha uma classe válida.");

            } catch (NumberFormatException e) {
                System.out.println("❌ Digite apenas o número da opção.");
            }
        }
    }

    /*
     * LEITURA DA ARMA + REGRA DE NEGÓCIO
     *
     * Aqui acontece a validação mais importante do projeto:
     * classe + arma precisam ser compatíveis.
     *
     * Se a combinação for inválida, o personagem NÃO é criado.
     */
    private static Arma lerArma(int classe) {
        while (true) {
            System.out.println();
            System.out.println("Escolha a arma:");

            Arma[] armas = Arma.values();

            for (int i = 0; i < armas.length; i++) {
                System.out.println(
                        (i + 1) + " - " + armas[i].getNome()
                );
            }

            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            try {
                int opcao = Integer.parseInt(entrada);

                if (!Validador.validarArma(opcao)) {
                    System.out.println("❌ Escolha uma arma válida.");
                    continue;
                }

                Arma arma = armas[opcao - 1];

                /*
                 * VALIDAÇÃO ANTES DA INSTANCIAÇÃO
                 *
                 * O Validador verifica se a arma pode ser usada pela classe.
                 */
                if (!Validador.validarArmaPorClasse(classe, arma)) {
                    System.out.println(
                            "❌ Arma inválida para a classe escolhida."
                    );
                    System.out.println(
                            Validador.mensagemArmasPermitidas(classe)
                    );
                    continue;
                }

                // Só retorna quando a arma for válida.
                return arma;

            } catch (NumberFormatException e) {
                System.out.println("❌ Digite apenas o número da opção.");
            }
        }
    }

    /*
     * POLIMORFISMO + INSTANCIAÇÃO
     *
     * O retorno é Personagem (superclasse), mas cada case cria uma
     * subclasse diferente.
     *
     * Isso é uma das partes mais importantes para explicar:
     *
     * Personagem personagem = new Mago(...);
     *
     * A variável é da superclasse, mas o objeto é da subclasse.
     */
    private static Personagem criarPersonagem(
            String nome,
            int idade,
            Raca raca,
            Arma arma,
            int classe) {

        return switch (classe) {
            case 1 -> new Mago(nome, idade, raca, arma);
            case 2 -> new Guerreiro(nome, idade, raca, arma);
            case 3 -> new Arqueiro(nome, idade, raca, arma);
            default -> throw new IllegalArgumentException(
                    "Classe inválida."
            );
        };
    }
}

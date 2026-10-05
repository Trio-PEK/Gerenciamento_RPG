package rpg;

/*
 * POO — ABSTRAÇÃO
 *
 * Personagem é uma classe abstrata porque representa o conceito geral de
 * personagem, mas não queremos criar um "Personagem genérico".
 *
 * O usuário deverá criar uma especialização:
 * Mago, Guerreiro ou Arqueiro.
 *
 * POO — INTERFACE
 *
 * "implements Aventureiro" significa que Personagem assume o contrato
 * definido pela interface Aventureiro.
 */

public abstract class Personagem implements Aventureiro {

    /*
     * POO — ENCAPSULAMENTO
     *
     * Os atributos são private. Isso significa que outras classes não podem
     * alterar esses dados diretamente.
     *
     * O acesso é controlado pelos métodos públicos (getters).
     *
     * final significa que, depois de inicializados pelo construtor, esses
     * valores não serão substituídos.
     */
    private final String nome;
    private final int idade;
    private final Raca raca;
    private final Arma arma;

    /*
     * CONSTRUTOR
     *
     * protected permite que as subclasses utilizem este construtor por meio
     * de super(...), mas evita que o código externo tente construir
     * diretamente a parte abstrata Personagem.
     *
     * A validação acontece ANTES deste construtor ser chamado, na Main.
     */
    protected Personagem(String nome, int idade, Raca raca, Arma arma) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.arma = arma;
    }

    /*
     * ENCAPSULAMENTO — GETTERS
     *
     * Eles permitem consultar os dados privados sem expor diretamente os
     * atributos.
     */
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Raca getRaca() {
        return raca;
    }

    public Arma getArma() {
        return arma;
    }

    /*
     * ABSTRAÇÃO + POLIMORFISMO
     *
     * Este método é abstract: Personagem declara que todo personagem precisa
     * saber atacar, mas deixa cada subclasse decidir COMO atacar.
     *
     * Mago, Guerreiro e Arqueiro sobrescrevem este método.
     */
    public abstract void atacar();

    /*
     * Comportamento comum.
     *
     * Todas as subclasses podem reutilizar este método.
     */
    public void mostrarAtributos() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Raça: " + raca.getNome());
        System.out.println("Arma: " + arma.getNome());
    }

    /*
     * INTERFACE
     *
     * Personagem implementa Aventureiro, então precisa implementar
     * iniciarAventura().
     *
     * @Override ajuda o compilador a verificar que estamos realmente
     * implementando um método herdado da interface.
     */
    @Override
    public void iniciarAventura() {
        System.out.println();
        System.out.println("================================");
        System.out.println("     INICIANDO AVENTURA...");
        System.out.println("================================");
    }
}

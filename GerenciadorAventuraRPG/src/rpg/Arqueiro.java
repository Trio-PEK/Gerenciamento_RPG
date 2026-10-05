package rpg;

/*
 * POO — HERANÇA
 *
 * Arqueiro é uma subclasse de Personagem.
 */
public class Arqueiro extends Personagem {

    // ATRIBUTOS PRÓPRIOS do Arqueiro.
    private final int precisao;
    private final int agilidade;

    public Arqueiro(String nome, int idade, Raca raca, Arma arma) {
        super(nome, idade, raca, arma);

        this.precisao = 95;
        this.agilidade = 90;
    }

    // ENCAPSULAMENTO — getters.
    public int getPrecisao() {
        return precisao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    /*
     * POLIMORFISMO — implementação específica de atacar().
     */
    @Override
    public void atacar() {
        System.out.println("O Arqueiro dispara uma flecha certeira!");
    }

    /*
     * POLIMORFISMO — sobrescrita de mostrarAtributos().
     */
    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Classe: Arqueiro");
        System.out.println("Precisão: " + precisao);
        System.out.println("Agilidade: " + agilidade);
    }
}

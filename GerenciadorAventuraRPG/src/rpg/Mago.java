package rpg;

/*
 * POO — HERANÇA
 *
 * "extends Personagem" significa que Mago é uma especialização de
 * Personagem. Mago herda os comportamentos e atributos acessíveis da
 * superclasse e pode adicionar suas próprias características.
 *
 * Mago também é um Personagem. Por isso podemos usar um objeto Mago
 * onde o programa espera um Personagem.
 */
public class Mago extends Personagem {

    // ATRIBUTOS PRÓPRIOS da especialização Mago.
    // Eles não pertencem a todos os personagens, somente ao Mago.
    private final int poderMagico;
    private final int mana;

    /*
     * CONSTRUTOR DA SUBCLASSE
     *
     * super(...) chama o construtor da superclasse Personagem para
     * inicializar nome, idade, raça e arma.
     */
    public Mago(String nome, int idade, Raca raca, Arma arma) {
        super(nome, idade, raca, arma);

        // Valores específicos da classe Mago.
        this.poderMagico = 90;
        this.mana = 100;
    }

    // ENCAPSULAMENTO — acesso controlado aos atributos próprios.
    public int getPoderMagico() {
        return poderMagico;
    }

    public int getMana() {
        return mana;
    }

    /*
     * POLIMORFISMO — SOBRESCRITA
     *
     * Personagem declarou atacar() como abstract.
     * O Mago fornece sua própria implementação.
     */
    @Override
    public void atacar() {
        System.out.println("O Mago lança um feitiço poderoso!");
    }

    /*
     * POLIMORFISMO — SOBRESCRITA
     *
     * Aqui o Mago adapta a exibição de atributos para incluir seus
     * atributos específicos.
     *
     * super.mostrarAtributos() reaproveita a implementação comum da
     * superclasse e depois adicionamos os dados do Mago.
     */
    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Classe: Mago");
        System.out.println("Poder mágico: " + poderMagico);
        System.out.println("Mana: " + mana);
    }
}

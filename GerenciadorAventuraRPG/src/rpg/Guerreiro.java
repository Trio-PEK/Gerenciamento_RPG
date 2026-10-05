package rpg;

/*
 * POO — HERANÇA
 *
 * Guerreiro herda de Personagem.
 */
public class Guerreiro extends Personagem {

    // ATRIBUTOS PRÓPRIOS do Guerreiro.
    private final int forca;
    private final int defesa;

    public Guerreiro(String nome, int idade, Raca raca, Arma arma) {
        // HERANÇA — inicializa a parte comum herdada de Personagem.
        super(nome, idade, raca, arma);

        this.forca = 90;
        this.defesa = 85;
    }

    // ENCAPSULAMENTO — getters para os atributos privados.
    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    /*
     * POLIMORFISMO — cada subclasse possui seu próprio atacar().
     */
    @Override
    public void atacar() {
        System.out.println("O Guerreiro desfere um poderoso golpe!");
    }

    /*
     * POLIMORFISMO — sobrescrita do método da superclasse.
     */
    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Classe: Guerreiro");
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
    }
}

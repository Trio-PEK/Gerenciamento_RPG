package rpg;

/*
 * ENUMERAÇÃO
 *
 * Arma representa as opções de armas permitidas pelo sistema.
 *
 * A arma MAO_LIVRE foi incluída como regra especial:
 * todas as classes podem utilizá-la.
 */
public enum Arma {
    ESPADA("Espada"),
    ARCO("Arco"),
    CAJADO("Cajado"),
    MACHADO("Machado"),
    MAO_LIVRE("Mão livre");

    // ENCAPSULAMENTO: atributo privado.
    private final String nome;

    Arma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

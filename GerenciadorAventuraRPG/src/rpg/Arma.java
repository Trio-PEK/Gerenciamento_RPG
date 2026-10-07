package rpg;


 // ENUM Arma = representa as opções de armas permitidas pelo sistema.
 // OBS: A arma MAO_LIVRE foi incluída como regra especial, todas as classes podem utilizá-la.


public enum Arma {
    ESPADA("Espada"),
    ARCO("Arco"),
    CAJADO("Cajado"),
    MACHADO("Machado"),
    MAO_LIVRE("Mão livre");

    // ENCAPSULAMENTO: atributo privado.
    private final String nome;

//Atributo encapslado
    Arma(String nome) {
        this.nome = nome;
    }

// Metodo de exibição de nome
    public String getNome() {
        return nome;
    }
}

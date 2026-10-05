package rpg;

/*
 * ENUMERAÇÃO
 *
 * Raca é um enum. Ele representa um conjunto fechado de opções válidas.
 * Isso evita que o usuário informe qualquer texto diferente das raças
 * disponíveis.
 *
 * Não é uma superclasse e não participa da hierarquia de herança.
 */
public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ANAO("Anão"),
    ORC("Orc");

    // ENCAPSULAMENTO: atributo privado.
    private final String nome;

    Raca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

package rpg;

/*
 * POO — INTERFACE
 *
 * Uma interface define um contrato: ela diz QUAL comportamento deve existir,
 * sem precisar concentrar aqui todos os detalhes de COMO esse comportamento
 * será executado.
 *
 * O professor pediu explicitamente o uso de Interface.
 */
public interface Aventureiro {

    // Qualquer classe que implementar Aventureiro deverá possuir este metodo.
    void iniciarAventura();
}

package rpg;

/*
 * CLASSE UTILITÁRIA PARA VALIDAÇÃO
 */

public final class Validador {

    private Validador() {
    }



     //REQUISITO — VALIDAÇÃO NOME  =  O nome precisa existir e não pode ser vazio.

    public static boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }



     //REQUISITO — VALIDAÇÃO IDADE   =  A idade precisa ser positiva.

    public static boolean validarIdade(int idade) {
        return idade > 0;
    }



     //Validação das opções de menu de raça.

    public static boolean validarRaca(int opcao) {
        return opcao >= 1 && opcao <= Raca.values().length;
    }




     //Validação das opções de classe.

    public static boolean validarClasse(int opcao) {
        return opcao >= 1 && opcao <= 3;
    }



     //Validação das opções de arma.

    public static boolean validarArma(int opcao) {
        return opcao >= 1 && opcao <= Arma.values().length;
    }



    /*
     * REQUISITO — VALIDAÇÃO DA REGRA DE NEGÓCIO
     *
     * Esta é a principal regra do nosso RPG:
     *
     * 1 = Mago       -> Cajado ou Mão livre
     * 2 = Guerreiro  -> Espada, Machado ou Mão livre
     * 3 = Arqueiro   -> Arco ou Mão livre
     *
     * A validação ocorre antes de criar o objeto do personagem.
     */



    public static boolean validarArmaPorClasse(int classe, Arma arma) {

        // Mão livre é permitida para TODAS as classes.
        if (arma == Arma.MAO_LIVRE) {
            return true;
        }



         //switch que verifica a classe e compara a arma permitida.



        return switch (classe) {
            case 1 -> arma == Arma.CAJADO;
            case 2 -> arma == Arma.ESPADA || arma == Arma.MACHADO;
            case 3 -> arma == Arma.ARCO;
            default -> false;
        };
    }


     //Mensagem para explicar ao usuário quais armas aquela classe pode utilizar.

    public static String mensagemArmasPermitidas(int classe) {
        return switch (classe) {
            case 1 -> "Mago pode usar: Cajado ou Mão livre.";
            case 2 -> "Guerreiro pode usar: Espada, Machado ou Mão livre.";
            case 3 -> "Arqueiro pode usar: Arco ou Mão livre.";
            default -> "Classe inválida.";
        };
    }
}

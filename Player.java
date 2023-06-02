/**
 * Classe que contém informações e ações básicas relacionadas aos jogadores
 */
public class Player {

    private final String name;
    private final Color pieceColor;
    private Card[] cards;
    public static Card tableCard;

    /**
     * Construtor que define informações básicas do jogador
     * 
     * @param name       Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param cards      Cartas na mão do jogador
     */
    public Player(String name, Color pieceColor, Card[] cards) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.cards = cards;
    }

    /**
     * Construtor que define informações básicas do jogador
     * 
     * @param name       Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param card1      A primeira carta na mão do jogador
     * @param card2      A segunda carta na mão do jogador
     */
    public Player(String name, Color pieceColor, Card card1, Card card2) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.cards[0] = card1;
        this.cards[1] = card2;
    }

    /**
     * Método que devolve o nome do jogador(a)
     * 
     * @return String com o nome do jogador(a)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devolve a cor das peças do jogador
     * 
     * @return Enum Color com a cor das peças do jogador
     */
    public Color getPieceColor() {
        return pieceColor;
    }

    /**
     * Método que devolve as cartas da mão do jogador
     * 
     * @return Booleano true para caso seja um mestre e false caso contrário
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Método que troca uma carta da mão por outra carta (idealmente da mesa)
     * 
     * @param oldCard A carta que será substituída
     * @param newCard A carta que irá substituir
     * @exception InvalidCardException Caso a carta não esteja na mão do jogador
     *                                 e/ou na mesa
     */
    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException {
        if(newCard != tableCard || oldCard != getCards()[0] || oldCard != getCards()[1])
            throw new InvalidCardException("Carta nao esta na mao do jogador e/ou na mesa");
        if(oldCard == getCards()[0])
            getCards()[0] = newCard;
        else 
            getCards()[1] = newCard;
        tableCard = oldCard;
    }
}

public class Player {
    //atribut
    private String name;

    private int mana;
    private int maxMana;

    private int health;
    private int maxHealth;

    private Deck deck;

    ArrayList<Card> cardInHand;

    List<Card> board;
    // Card[5] board;
    private int selectedCardInHandIndex;
    
    public void draw(GameWindow gameWindow){
        Card buffer = deck.showThreeCards(gameWindow);
        addCardInHand(gameWindow, buffer);
       // FS kartu yg dipilih udah masuk ke hand, kartu sisa udah masuk dec
    }
    public void removeCardInHand(){
        //ngupdate cardInHand
        
    }

    public void boardOnClick(){
        // kalo boardnya di klik,
        // if selectedCardInHandIndex = -1, do nothing
        // if selectedCardInHandIndex != -1,
        // cek kartu in hand yg diklik itu spell atau character,
        //kalau karakter: cek apakah board yg diklik kosong, kalau kosong panggil addCardToBoard
        //kalau spell: cek apakah board yg diklik itu ada isinya, kalau ada, panggil spellnya.activate(card di board yg diklik)
    }
    public void addCardToBoard(GameWindow gameWindow, Card newCard){
        // mirip addcard inhand
        //  aku mau dia nambah card di index ke 'selctedCardInHand' ke board, abis itu delete card di hand di index 'selectedCardInHand', trus selectedCardInHand brubah jadi -1
        //update GUI cardInHand sama cardOnBoard
        //kalau spell:
        //
    }
    public void addCardInHand(GameWindow gameWindow, Card newCard){
        //ngupdate cardInHand
        // jangan lupa di bind ke fungsi, on hover sama on click
        gameWindow.cardInHandButton.OnHover.addActionListener(e -> {
            newCard.cardOnHover(gameWindow);
        });
    }
    // public void cardInHandOnHover(int idx){
    //     //dari index, dapetin card yg sedang di hover
    //     // pass itu ke method card on Hover
    //     // Card buffer = ...
    //     // buffer.cardOnHover(gameWindow);
    // }
    public void cardInHandOnClick(int idx){

    }
}

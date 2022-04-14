import java.util.ArrayList;

public class Player {
    //atribut
    private String name;
    private int mana; // default 1
    private int maxMana;
    private int health; // default 80
    private Deck deck;
    private int selectedCardInHandIndex;
    private CardInHand cardInHand;
    private ArrayList<SummonedCard> cardInBoard;

    Player() {
        this.name = "Steve";
        this.mana = 1;
        this.maxMana = 10;
        this.health = 80;
        this.deck = new Deck();
        this.selectedCardInHandIndex = -1;
        this.cardInHand = new CardInHand();
    }

    Player(String name, int mana, Deck deck, int selectedCardInHandIndex, CardInHand cardInHand) {
        this.name = name;
        this.mana = mana;
        this.deck = deck;
        this.selectedCardInHandIndex = selectedCardInHandIndex;
        this.cardInHand = cardInHand;
    }

    // Getter Setter

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        // At the beginning of turn, mana = turn
        if (mana <= maxMana) {
            this.mana = mana;
        }
    }

    public void resetMana(int turn) {
        if (turn <= maxMana) {
            this.mana = turn;
        } else {
            this.mana = maxMana;
        }
    }
    

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Boolean isDead() {
        return (health <= 0 || deck.getSize() == 0);
    }

    public void draw(GameWindow gameWindow){
        Card buffer = deck.showThreeCards(gameWindow);
        addCardInHand(gameWindow, buffer);
       // FS kartu yg dipilih udah masuk ke hand, kartu sisa udah masuk dec
    }

    public void removeCardInHand(Card card) {
        cardInHand.removeByCard(card);
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

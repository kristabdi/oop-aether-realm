public class Board {
    private Card[] cardBoard;
    private int[] fillingIndicator;
    this.filled;

    public Board(){
        this.cardBoard = new Card[5];
        this.fillingIndicator = new int[]{0,0,0,0,0};
        this.filled =0;
    }

    public Board(Card[] cardBoard, int[] int fillingIndicator, int filled){
        this.filled = filled;
        this.cardBoard = new Card[5];
        this.fillingIndicator = new int[5];
        int i =0;
        while(i<5){
            if(fillingIndicator[i]==1){
                this.cardBoard[i]=cardBoard[this.filled-filled];
            }
            this.fillingIndicator[i]=fillingIndicator[i];
            i++;
            filled--;
        }
    }

    public Card getCardBoardByIdx(int idx){
        if(this.fillingIndicator[idx]!=0){
            return this.cardBoard[idx];
        }else{
            throw CardBoardNoneException();
        }
    }
    public int getFilled(){
        return this.filled;
    }

    public void addCard(Card c){
        //cek dah penuh belum
        //kalo belum
        //cari index pertama yang kosong
        //isi indx pertama yang kosong dengan kartu tadi
        //ubah array keterisian index ke-index menjadi terisi(1)
        //tambah jumlah kterisian
        if(this.filled>=5){
            throw new BoardFullException();
        }else{
            int i;
            while(this.fillingIndicator[i]!=0 && i<4){
                i++;
            }
            //karna sudah cek kepenuhan
            //mentok i di idx 4 dan pasti dapet yang indexNone
            this.cardBoard[i]=c;
            this.fillingIndicator[i]=1;
            this.filled++;
        }
    }

    //asumsi input selalu benar
    //exception di atas
    public void addCardById(int id,Card c){
        this.fillingIndicator[id]=1;
        this.filled++;
        this.cardBoard[id]=c;
    }
    public int popCard(int index){
        //ngambil kartu dari index ke-index
        //ubah indikator index ke-index -> 0
        //kurangi filled -1
        //return kartu pada index ke-index
        this.fillingIndicator[index]=0;
        this.filled--;
        return this.cardBoard[index];
    }
}

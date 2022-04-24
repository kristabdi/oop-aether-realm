public class Board {
    private Card[] cardBoard;
    private int[] fillingIndicator;
    this.filled;

    public Board(){
        this.cardBoard = new Card[5];
        this.fillingIndicator = new int[]{0,0,0,0,0};
        this.filled =0;

    }

    public addCard(Card c){
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

    public popCard(int index){
        //ngambil kartu dari index ke-index
        //ubah indikator index ke-index -> 0
        //kurangi filled -1
        //return kartu pada index ke-index
        this.fillingIndicator[index]=0;
        this.filled--;
        return this.cardBoard[index];
    }
}

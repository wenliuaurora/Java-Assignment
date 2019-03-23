import java.util.Scanner;
class Display{
    private String s;

    //if the input is not right,player can input it again.
    public void getWord(Board b){
        do{
            Scanner input = new Scanner(System.in);
            s=input.nextLine();
        }while(!checkerror(s,b));
    }

    public boolean checkerror(String s,Board b){
        int j=s.charAt(0)-'0';
        if(s.length()!=1){
            System.out.println("You need to type an number");
            return false;
        }
        if(j<0||j>6){
            System.out.println("the colom number is not in the right range");
            return false;
        }
        if(!b.validposition(j)){
            System.out.println("there is no more sapce in this collum");
            return false;
        }
        return true;
    }
    

    public void printBoard(Board board){
        System.out.printf(" | 0 | 1 | 2 | 3 | 4 | 5 | 6 | ");
        for(int i=0;i<6;i++){
            System.out.printf("\n--+--+--+--+--+--+--+--+--+--\n |");
            for(int j=0;j<7;j++){
                System.out.printf(" %c |",translate(board.getstate(i, j)));
            }
        }
        System.out.printf("\n--+--+--+--+--+--+--+--+--+--\n\n");
    }

    private char translate(int i){
        if(i==1){
            return 'O';
        }
        if(i==2){
            return 'X';
        }
        return ' ';
    }

    public void printturn(Board b){
        System.out.printf("It's player%d's turn!\n",b.getwhomove());
    }


    public void printResult(int winner){
        if(winner==0){
            System.out.println("Game finished. Draw game!");
        }else{
            System.out.printf("Game finished. Player %d wins the game!\n",winner);
        }


}
}
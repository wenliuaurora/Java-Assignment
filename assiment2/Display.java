import java.util.Scanner;

class Display{
    private String s;
    private int level;

    public void printBoard(Board b){
        System.out.printf("  | 1 | 2 | 3 | ");
        for(int i=0;i<3;i++){
            System.out.printf("\n--+---+---+---+\n%c |",97+i);
            for(int j=0;j<3;j++){
                System.out.printf(" %c |",translate(b.state[i][j]));
            }
        }
        System.out.printf("\n--+---+---+---+\n\n");
    }

    public char translate(int num){
        if(num==1){
            return 'O';
        }
        if(num==2){
            return 'X';
        }
        else
        return ' ';
    }

    public void printTurn(Board b){
        System.out.printf("It's player%d's turn!\n",b.whomove);
    }
    
    public String getWord(Board b){
        do{
            Scanner input = new Scanner(System.in);
            s=input.nextLine();
        }while(!validPos(s,b));
        return s;
    }

    private boolean validPos(String s, Board b){
        if(s.length()!=2){
            return errorMessage("You need to type a character and an number");
        }
        int y=s.charAt(1)-'0'-1;
        int x=s.charAt(0)-'a';
        if(x < 0 || x > 2 || y < 0 || y > 2){
            return errorMessage("The chars are out of range, try again");
        }
        if(!b.validposition(x,y)){
            return errorMessage("Board is already filled here");
        }
        return true;
    }

    private boolean errorMessage(String error){
        System.out.println(error);
        return false;
    }

    public void printResult(int winner){
        if(winner==0){
            System.out.println("Game finished. Draw game!");
        }else{
            System.out.printf("Game finished. Player %d wins the game!\n",winner);
        }
}

}

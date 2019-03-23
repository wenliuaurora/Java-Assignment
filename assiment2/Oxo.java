class Oxo{
   public static void main(String args[]){
       Oxo Oxo=new Oxo();
       Board b=new Board();
       Display d=new Display();
       b.test();
       Oxo.playgame(b,d);
   }
   private void playgame(Board b,Display d){
       int win=-1;
       b.randomturn();
       while(win==-1){
           d.printTurn(b);
           b.fillposition(d.getWord(b),b.whomove);
           d.printBoard(b);
           win=endgame(b);
           b.nextmove();
       }
       d.printResult(win);
    }
    private int endgame(Board b){
        int winner=b.checkwin();
        if(b.getfillednum()==9){
            return 0;
        }
        if(winner!=0){
            return winner;
        }
        return -1;
    }
}
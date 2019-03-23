class Stag{
    int winner;

    public static void main(String[] args) {
        Board board=new Board();
        Display display=new Display();
        Stag stag=new Stag();
        stag.playgame(board,display);
    }

    private void playgame(Board board,Display display){
        winner=-1;
        while(winner==-1){
            board.nextmove();
            display.printturn(board);
            display.getWord(board);
            board.fillposition();
            winner=end(board);
            display.printBoard(board);
        }
        display.printResult(winner);
    }

    private int end(Board board){
        if(board.Checkwin()){
            winner=board.getwhomove();}
        if(board.getfillednum()==42){
            return 0;
        }
        if(winner!=0){
            return winner;
        }
        return -1;
    }
}
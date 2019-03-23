class Board{
    public int whomove;
    public int state[][];
    private int fillednum;

    Board(){
        state=new int[3][3];
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                 state[i][j]=0;
            }
        }
        fillednum=0;
    }
    
   public int checkwin(){
        if(checkrow()==true||
        checkcol()==true||
        checkacrossconer()==true){
            return whomove;
        }
        return 0;
    }
    
    private boolean checkrow(){
        for(int i=0;i<=2;i++){
            if(state[i][0]==whomove&&
            state[i][1]==whomove&&
            state[i][2]==whomove){
                return  true;
            }
        }
        return false;
    }

    private boolean checkcol(){
        for(int j=0;j<=2;j++){
            if(state[0][j]==whomove
            &&state[1][j]==whomove&&
            state[2][j]==whomove){
                return  true;
            }
        }
        return false;
    }

    private boolean checkacrossconer(){
        if(state[0][0]==whomove&&
        state[1][1]==whomove&&
        state[2][2]==whomove){
            return true;
        }
        if(state[0][2]==whomove
        &&state[1][1]==whomove
        &&state[2][0]==whomove){
            return true;
        }
         return false;
    }

    public void nextmove(){
        if(whomove==1){
            whomove++;
            return;
        }
        if(whomove==2){
            whomove--;
            return;
        }
    }

    public void randomturn(){
        whomove=(Math.random()<0.5)?1:2;
    }

    public boolean validposition(int i,int j){
        if(state[i][j]==0){
            return true;
        }
        return false;
    }

    public void fillposition(String s,int who){
        int j=s.charAt(1)-'0'-1;
        int i=(int)s.charAt(0)-'a';
        state[i][j]=who;
        fillednum++;
    }

    public int getfillednum(){
        return fillednum;
    }

     public void test(){
        //row checks
        testcheckwin("111220000",1,1);
        testcheckwin("102202111",1,1);
        testcheckwin("222110000",2,2);
        testcheckwin("000222110",2,2);
        //col checks
        testcheckwin("122100100",1,1);
        testcheckwin("022121021",2,2);
        testcheckwin("120120020",2,2);
        //diag checks
        testcheckwin("122010001",1,1);
        testcheckwin("102020201",2,2);
        //draw checks
        testcheckwin("122211212",2,0);
        testcheckwin("112122121",1,0);
        //false checks
        testcheckwin("000002000",2,0);
        testcheckwin("000000221",2,0);
        testcheckwin("121212000",2,0);
        testcheckwin("121122010",1,0);
        testcheckwin("211102121",2,0);
        testcheckwin("000000000",1,0);
    }

    private void testcheckwin(String board_, int whomove_, int b){
        whomove=whomove_;
        for(int i=0;i<9;i++){
            state[i/3][i%3]=(int)board_.charAt(i)-48;
        }
        assert b==checkwin();
}
}
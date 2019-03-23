import java.util.Random;

class Board{
    private int state[][];
    private int fillednum;
    private int whomove=0;
    private int position[];

    Board(){
        state=new int[6][7];
        for(int i=0;i<=5;i++){
            for(int j=0;j<=6;j++){
                state[i][j]=0;
            }
        }
        position=new int[2];
        position[0]=0;
        position[1]=0;
        fillednum=0;
        randomturn();
    }

    public int randomturn(){
        return whomove=(Math.random()<0.5? 1:2);
    }

    public boolean validposition(int j){
            position[1]=j;
            for(int i=5;i>=0;i--){
                if(state[i][j]==0){
                position[0]=i;
                return true;
        }   
    } 
    return false;
    }

    public void fillposition(){
        int i=position[0];
        int j=position[1];
        state[i][j]=whomove;
        fillednum++;
    }

    public boolean Checkwin(){
        if(Checkrow(position[0],position[1])==true||Checkcol(position[0],position[1])==true){
            return true;
        }
        if(Checkacross1(position[0],position[1])==true||Checkacross2(position[0],position[1])==true){
            
            return true;
        }

        return false;
    }

    private boolean Checkrow(int i,int j){
        int num=0;
        while(j>=1&&state[i][j-1]==whomove){
                j--;

            System.out.println(j);
        }
        while(j<6&&state[i][j]==whomove){
                num++;
                j++;
            if(num==4){
                return true;
            }
            }
        return false;
    }

    private boolean Checkcol(int i,int j){
        int num=0;
        while(i<=5&&state[i][j]==whomove){
            num++;
            i++;
            if(num==4){
                return true;
            }
        }
        return false;
    }

    private boolean Checkacross1(int i,int j){
        int num=0;
        while(i>=1&&i<=6&&j>=0&&j<=5&&state[i-1][j+1]==whomove){
            i--;
            j++;
        }
        while(i<=5&&j>=0&&state[i][j]==whomove){
            num++;
            i++;
            j--;
            if(num==4){
                return true;
            }
        }
        return false;
    }

    private boolean Checkacross2(int i,int j){
        int num=0;
        while(i>=1&&i<=6&&j>=1&&j<=7&&state[i-1][j-1]==whomove){  
            j--;
            i--;
        }
        while(i<=5&&j<=6&&state[i][j]==whomove){
            num++;
            i++;
            j++;
            if(num==4){
                return true;
            }
        }
        return false;
    }

    public void nextmove(){
        if(whomove==1){
            whomove=2;
            return;
        }
        if(whomove==2){
            whomove=1;
            return;
        }
    }

    public int getstate(int i,int j){
        return state[i][j];
    }

    public int getwhomove(){
        return whomove;
    }
    public int getfillednum(){
        return fillednum;
    }
}
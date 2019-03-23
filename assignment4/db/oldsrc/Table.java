import java.util.ArrayList;

class Table{
private ArrayList<Record> table;
private ArrayList<String> title;

Table(Record record){
    table=new ArrayList<Record>();
    title=new ArrayList<String>();
    table.add(record);
}

public boolean InsertRecord(Record record,int index){
    if(index==-1){
        table.add(record);
        return true;
    }
    if(!Checktablerange(index)){
        table.add(index,record);
        return true;
    }
    System.out.println("You can not insert a blank record into table");
    return false;
}

public Record GetRecord(int index){
    if(!Checktablerange(index)){
        System.out.println("You can not get the"+index+"index record, it is not exist");
        return 0;
    }
    else return table.get(index);
}

public boolean DeleteRecord(int index){
    if(!Checktablerange(index)){
        System.out.println("You can not delete the"+index+"index record, it is not exist");
        return false;
    }
    else {
        table.remove(index);
        return true;
    }
}

public boolean UpdateRecord(int index,Record record){
    if(InsertRecord(record,index)){
        table.remove(index+1);
        return true;
    }
    else return false;
}

public void Addtitle(String[] inputs){
    for(int i=0;i<inputs.length;i++){
        title.add(inputs[i]);
    }
}

public void Updatetitle(String input, int index){
    if(index>=title.size()){
        System.out.println("You can not update the title on"+index+" position, it is out of range");
    }
    else{

    }
}


private boolean Checktablerange(int i){
    if(i>=table.size()){
        return false;
    }
    else return true;
}
}
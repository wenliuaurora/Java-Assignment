import java.util.ArrayList;
/*In this class, you can add record to a table and when you add a new record ,the record will
be checked whether the key colum collide with existed data*/
import java.util.Arrays;

class Table{
private ArrayList<Record> table;
private ArrayList<String> title;
private int key=0;
private String tablename;

Table(int k,String name){
    table=new ArrayList<Record>();
    title=new ArrayList<String>();
    tablename=name;
    ChangeKey(k);
}

/*If the new key have same keywords in table,than use the oldkey */
public void ChangeKey(int k){
    int oldkey=key;

    if(k>=0&&k<title.size()){
    this.key=k;
    }
    for(int i=0;i<table.size();i++){
        if(CheckKeyCol(i)==true)
        {
            this.key=oldkey;
            System.out.println("Change key failed!");
            return;
        }
    }
}

public boolean AddRecord(Record record){
    if(record.GetSize()!=0){
        table.add(record);
        if(table.size()>1){
            if(!CheckKeyCol(table.size()-1)){
            return true;
        }
        else {
            table.remove(table.size()-1);
            return false;
        }
        }
        return true;
    }
    else{
    System.out.println("You can not insert a blank record into table");
    return false;
    }
}

/* Input the line number which you are checking , and you can konw the key colum 
whether have same keywords*/
private boolean CheckKeyCol(int index) {
    String s=GetRecord(index).Getdata(key);
    for(int i=0;i<table.size();i++){
        if(i!=index&&table.get(i).Getdata(key).equals(s))
        {
            System.out.println("The key colum have same data!");
            return true;
        }
    }
    return false;
}

public Record GetRecord(int index){
    if(!Checktablerange(index)){
        System.out.println("You can not get the "+ index +" index record, it is not exist");
        return null;
    }
    else return table.get(index);
}

public boolean DeleteRecord(int index){
    if(!Checktablerange(index)){
        System.out.println("You can not delete the "+ index +" index record, it is not exist");
        return false;
    }
    else {
        table.remove(index);
        return true;
    }
}

public boolean UpdateRecord(int index,Record record){
    if(AddRecord(record)){
        table.remove(index);
        return true;
    }
    else return false;
}

public void Addtitle(ArrayList<String> t){
    this.title=t;
}

public void Addtitle(String[] inputs){
    for(int i=0;i<inputs.length;i++)
    {
        title.add(inputs[i]);
    }
} 

public int GetSize(){
    return this.table.size();
}

public int GetLength(){
    return this.table.get(0).GetSize();
}

public ArrayList<String> Gettitle(){
    return this.title;
}

public String Gettablename(){
    return this.tablename;
}


private boolean Checktablerange(int i){
    if(i>=table.size()){
        return false;
    }
    else return true;
}
public static void main(String[] args) {
    boolean testing = false;
    assert(testing = true);
    if (testing) {
        test();
}
}

private static void test(){
    String[] title = new String[]{"ID", "Name", "Kind", "Owner"};
    Record testRecord1 = new Record(new String[]{"1", "Fido", "dog", "ab123"});
    Record testRecord2 = new Record(new String[]{"2", "Wanda", "dog", "ef789"});
    Record testRecord3 = new Record(new String[]{"1", "Fidou", "dogu", "ab123u"});
    Table testtable=new Table(0,"table1");
    testtable.Addtitle(title);
    testtable.AddRecord(testRecord1);
    testtable.AddRecord(testRecord2);
    /*It will show warnings can not add this record */
    testtable.AddRecord(testRecord3);
    /*it will show change key filed  */
    testtable.ChangeKey(2);
}

}
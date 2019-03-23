import java.util.ArrayList;

class Printing{
private ArrayList<ArrayList<String>> printdata;
private ArrayList<String> printtitle;
private String printname;
private int pCol;
private int pRow;
private int maxStringlength=20;

Printing(Table table){
    printdata=new ArrayList<ArrayList<String>>();
    printtitle=table.Gettitle();
    Buildprintdata(table);
    printname=table.Gettablename();
}

private void Buildprintdata(Table table){
    for(int i=0;i<table.GetSize();i++){
        printdata.add(table.GetRecord(i).Getdata());
    }
}

public int printTable(){

    pCol=printdata.get(0).size();
    pRow=printdata.size();
    Drawtitle();
    DrawTable();
    
    return 0;
}

private void Drawtitle(){
    System.out.println(printname);
    for(int i=0;i<printtitle.size();i++){
        System.out.printf("%20s|",printtitle.get(i));
    }
    System.out.println();
}

private void DrawTable(){
    for(int i=0;i<pRow;i++){
        for(int j=0;j<pCol;j++){
            int symble=0;
            while(symble<maxStringlength){
                System.out.print("-");
                symble++;
            }
            System.out.print("+");
        }
        System.out.println();
        for(int j=0;j<pCol;j++){
        System.out.printf("%20s",printdata.get(i).get(j));
        System.out.print("|");
        }
        System.out.println("");
    }
    System.out.println("");
}
public static void main(String[] args) {
    boolean testing = false;
    assert(testing = true);
    if (testing) {
        test();
}
}

private static void test(){
    Record testRecord0 = new Record(new String[]{"ID", "Name", "Kind", "Owner"});
    Record testRecord1 = new Record(new String[]{"1", "Fido", "dog", "ab123"});
    Record testRecord2 = new Record(new String[]{"2", "Wanda", "fish", "ef789"});

    Table testtable=new Table(0,"table1");
    testtable.AddRecord(testRecord1);
    testtable.AddRecord(testRecord2);
    Printing printtable=new Printing(testtable);
    printtable.printTable();
}

}
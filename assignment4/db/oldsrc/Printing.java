import java.util.ArrayList;


class Printing{
private ArrayList<String[]> printdata;
private int pCol;
private int pRow;
private int maxlength=15;

Printing(ArrayList<Record> table){
    printdata=new ArrayList<String[]>();

    printTable(table);
}

public int printTable(ArrayList<Record> table){
    
    printdata=data;
    pCol=printdata.get(0).length;
    pRow=printdata.size();
    DrawTable();
    
    return 0;
}


private void DrawTable(){
    for(int i=0;i<pRow;i++){
        for(int j=0;j<pCol;j++){
            int symble=0;
            while(symble<maxlength){
                System.out.print("-");
                symble++;
            }
            System.out.print("+");
        }
        System.out.println();
        for(int j=0;j<pCol;j++){
        System.out.printf("%15s",printdata.get(i)[j]);
        System.out.print("|");
        }
        System.out.println();
    }
}
public static void main(String[] args) {
    test();
}

private static void test(){
    ArrayList<String[]> table = new ArrayList<String[]>();
    table.add(new String[]{"ID", "Name", "Kind", "Owner"});
    table.add(new String[]{"1", "Fido", "dog", "ab123"});
    table.add(new String[]{"2", "Wanda", "Hippopotamus", "ef789"});

    Printing printtable=new Printing(table);
}
}
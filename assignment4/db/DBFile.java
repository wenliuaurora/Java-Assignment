import java.util.*;
import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

class DBFile{
    private File file;
    private ArrayList<ArrayList<String>> tabledata;


    public static void main(String[] args) {
    test();
    }

    DBFile(File file,boolean loading){
        tabledata=new ArrayList<ArrayList<String>>();
        this.file=file;
        if(loading==true){
        LoadFile();
        }
        else {
            try { 
                new PrintWriter(file).close(); 
            }
            catch (IOException e) {
            System.out.println("File not found!"); }
        }
    }

    public void LoadFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String readline="";
            while((readline=br.readLine())!=null){
                ArrayList<String> cutline=new ArrayList<String>();
                for(int i=0;i<readline.split("--").length;i++){
                    cutline.add(readline.split("--")[i]);
                }
                tabledata.add(cutline);
            }
        }
        catch (IOException e)
        {
            System.out.println("Fail to load file");
        }
    }

    public boolean SaveTableTofile(Table table){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            
            bw.append(Savetitle(table)+"\n");
            for(int i=0;i<table.GetSize();i++){
                String waittosave="";
                for(int j=0;j<table.GetLength();j++){
                    waittosave+=table.GetRecord(i).Getdata(j)+"--";
                }
            waittosave=waittosave.substring(0,waittosave.length()-2);
            bw.append(waittosave);
            bw.newLine();
            }
            return true;
        }

        catch (IOException e){
            System.out.println("Fail to save in file");
            return false;
        }
    }

    private String Savetitle(Table table){
        String waittosave="";
        for(int j=0;j<table.Gettitle().size();j++){
            waittosave+=table.Gettitle().get(j)+"--";
        }
        waittosave=waittosave.substring(0,waittosave.length()-2);
        return waittosave;
    }

    public ArrayList<ArrayList<String>> Gettabledata(){
        return tabledata;
    }

    public ArrayList<String> Gettabledata(int i){
        return tabledata.get(i);
    }

    private static void test(){
        File file = new File("test.tab");
        String[] title = new String[]{"ID", "Name", "Kind", "Owner"};
        Record testRecord1 = new Record(new String[]{"1", "Fido", "dog", "ab123"});
        Record testRecord2 = new Record(new String[]{"2", "Wanda", "fish", "ef789"});
       
        Table testtable=new Table(0,"table1");
        testtable.Addtitle(title);
        testtable.AddRecord(testRecord1);
        testtable.AddRecord(testRecord2);

        DBFile save=new DBFile(file,false);
        save.SaveTableTofile(testtable);
        DBFile read=new DBFile(file, true);

        assert(read.tabledata.get(0).get(0).equals("ID"));
        assert(read.tabledata.get(0).get(1).equals("Name"));
        assert(read.tabledata.get(0).get(2).equals("Kind"));
        assert(read.tabledata.get(0).get(3).equals("Owner"));
        assert(read.tabledata.get(1).get(0).equals("1"));
        assert(read.tabledata.get(1).get(1).equals("Fido"));
        assert(read.tabledata.get(1).get(2).equals("dog"));
        assert(read.tabledata.get(1).get(3).equals("ab123"));
    }
}
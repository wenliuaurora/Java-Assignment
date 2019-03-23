import java.util.*;
import java.io.*;
class Database{
    private String dbName;
    private ArrayList<Table> tables;
    
    Database(String name){
        dbName=name;
        tables=new ArrayList<Table>();
    }

    public static void main(String[] args) {
        test();
    }

    public void AddTableTolist(Table table){
        tables.add(table);
    }

    public void Savetable(Table table){
        String filePath ="databases/"+dbName + "-" + table.Gettablename() + ".tab";
        File file = new File(filePath);
        DBFile fSave = new DBFile(file, false);
        
        fSave.SaveTableTofile(table);
        System.out.println("Table saved: " + table.Gettablename());
    }

    public void SaveDbTables()
    {
        for (Table table : tables) 
        {
            Savetable(table);
        }
    }

    private Table FindTable(String tableName)
    {
        for (Table table : tables)
        {
            if (table.Gettablename().equals(tableName))
            {
                return table;
            }
        }
        return null;
    }
    private void LoadDbTables()
    {
    File DbFolder = new File("databases/");
    File[] tableFiles = DbFolder.listFiles();
    for (File file : tableFiles) 
    {
        tables.add(LoadTable(file, true));
    }
    
    if (tableFiles.length == 0) System.out.println("Database is empty, no tables to load!");
    }

    // Load one table from file
    private Table LoadTable(File file, Boolean suppress)
    {
        /*Get table name */
    String tableName = file.getName();
    DBFile loadfile = new DBFile(file, true);
    int pos = tableName.lastIndexOf(".");
    tableName = tableName.substring(0, pos);

    /*Put the first line into title than delete it */
    Table table = new Table(0,tableName);
    table.Addtitle(loadfile.Gettabledata(0));
    loadfile.Gettabledata().remove(0);

    /*whatever context to build a record for a new table*/
    for(int i=0;i<loadfile.Gettabledata().size();i++){
        Record record=new Record(new String[]{"ID", "Name"});
        record.SetData(loadfile.Gettabledata(i));
        table.AddRecord(record);
    }
    if (suppress == false){
        System.out.println(" Entries\t" + tableName);
    }
    return table;
    }

    private void PrintTables(){
        for(int i=0;i<tables.size();i++){
            Printing printtable=new Printing(tables.get(i));
            printtable.printTable();
        }
    }

    private static void test(){
        Database db=new Database("db");
        String[] title = new String[]{"ID", "Name", "Kind", "Owner"};
        Record testRecord1 = new Record(new String[]{"1", "Fido", "dog", "ab123"});
        Record testRecord2 = new Record(new String[]{"2", "Wanda", "fish", "ef789"});
        Record testRecord3 = new Record(new String[]{"1", "Fidou", "dogu", "ab123u"});
        
        Table testtable1=new Table(0,"table1");
        testtable1.Addtitle(title);
        Table testtable2=new Table(0,"table2");
        testtable2.Addtitle(title);
        /*Add the two table to list than save them to file */
        testtable1.AddRecord(testRecord1);
        db.AddTableTolist(testtable1);
        testtable2.AddRecord(testRecord2);
        testtable2.AddRecord(testRecord3);
        db.AddTableTolist(testtable2);
        db.SaveDbTables();

        Database db1=new Database("db1");
        db1.LoadDbTables();
        db1.PrintTables();
    }

}
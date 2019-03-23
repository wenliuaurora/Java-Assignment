import java.util.*;
import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

class DBFile{
    private File file;
    private ArrayList<String[]> filesavebyline;
    private int linenum;

    public static void main(String[] args) {
    test();
    }

    DBFile(File file,boolean loading){
        filesavebyline=new ArrayList<String[]>();
        this.file=file;
        if(loading==true){
        linenum=0;
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
                String[] cutline=readline.split("--");
                filesavebyline.add(cutline);
            }
        }
        catch (IOException e)
        {
            System.out.println("Fail to load file");
        }
    }

    public boolean SavelineTofile(String[] string){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            String waittosave="";
            for(int i=0;i<string.length;i++){
                waittosave+=string[i]+"--";
            }
            waittosave=waittosave.substring(0,waittosave.length()-2);
            bw.append(waittosave);
            bw.newLine();
            return true;
        }

        catch (IOException e){
            System.out.println("Fail to save in file");
            return false;
        }
    }

    

    private static void test(){
        File file = new File("test.tab");
        String[] testString1 = new String[]{"Id","Name","Kind","Owner"};
        String[] testString2 = new String[]{"1","Fido","dog","ab123"};

        DBFile save=new DBFile(file,false);
        save.SavelineTofile(testString1);
        save.SavelineTofile(testString2);

        DBFile read=new DBFile(file, true);
        for(int i=0;i<read.filesavebyline.size();i++) {
            System.out.print(Arrays.toString(read.filesavebyline.get(i)) );
           }
        assert(Arrays.equals(read.filesavebyline.get(0), testString1) == true);
        assert(Arrays.equals(read.filesavebyline.get(2), testString2) == true);

    }
}
import java.util.*;
/*this class is for insert or delete the database's context */
class Record{
    private ArrayList<String> data;

    Record(String[] inputs){
        data= new ArrayList<String>();
        for (int i = 0; i < inputs.length; i++) {
            data.add(inputs[i]);
        }
    }

    /* Add  data  into exist type data */
    public void SetData(ArrayList<String> inputs){
        this.data=inputs;
    }

    public boolean UpdateData(String inputs,int index){
        if(!CheckDataRange(index)){
            return false;
        }
        else data.add(index, inputs);
        return true;
    }

    public String Getdata(int index){
        if(!CheckDataRange(index)){
            return "fail";
        }
        else
        return data.get(index);
    }

    public ArrayList<String> Getdata(){
        return data;
    }


    public int GetSize(){
        return data.size();
    }

    private boolean CheckDataRange(int index){
         if(data.size()<index){
            System.out.println("Can not add a data, the data index"+index+"is out of range");
            return false;
        }
        return true;
    }





    public static void main(String[] args){
        boolean testing = false;
        assert(testing = true);
        if (testing) {
            test();
}
    }

    private static void test(){
        // Two test records for testing the other functions
        Record testRecord1 = new Record(new String[]{"1", "Fido", "dog", "ab123"});
        Record testRecord2 = new Record(new String[]{"2", "Wanda", "fish", "ef789"});
        
        // Test that Getdata() functions correctly for valid/invalid inputs
        assert(testRecord1.Getdata(0).equals("1"));
        assert(testRecord1.Getdata(1).equals("Fido"));
        assert(testRecord1.Getdata(2).equals("dog"));
        assert(testRecord1.Getdata(3).equals("ab123"));
        assert(testRecord2.Getdata(0).equals("2"));
        assert(testRecord2.Getdata(1).equals("Wanda"));
        assert(testRecord2.Getdata(2).equals("fish"));
        assert(testRecord2.Getdata(3).equals("ef789"));

        
        assert(testRecord1.UpdateData("female", 4)==true);
        assert(testRecord2.UpdateData("male", 3)==true);
        assert(testRecord1.Getdata(4)=="female");
        assert(testRecord2.Getdata(3)=="male");

        

        assert(testRecord1.GetSize()==5);
        assert(testRecord1.GetSize()==5);

    }

}
import java.util.HashSet;

public class ArgsTransferDemo {

    public static void main1(String[] args) {


        ArgsTransferDemo at = new ArgsTransferDemo();
        int i = 10;
        int j = 5;


        System.out.println("i=: "+i+"  "+"j=: "+j);
        at.testSwap(i,j);

        System.out.println("i=: "+i+"  "+"j=: "+j);


    }


    public void testSwap(int i,int j){
        int temp = i;
        i = j;
        j = temp;
    }











    public static void main(String[] args) {

        ArgsTransferDemo at = new ArgsTransferDemo();
        Str str = new Str();

        System.out.println("str.i:"+str.i+"  "+"str.j"+str.j);
        at.test(str);

        System.out.println("str.i:"+str.i+"  "+"str.j"+str.j);


    }


    public void test(Str str){
        int temp = str.i;
        str.i = str.j;
        str.j = temp;
    }
}



class Str{
    int i = 10;
    int j = 5;
}
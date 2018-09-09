import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class GaleShaply {

    public static void main(String[] arg1) throws FileNotFoundException {

        // Getting command line as input and put it into a array


        //checking the second command word find or check to run the algorithm in the right direction
        if ( arg1[0].equals("find")  ) {


            Scanner boys = new Scanner( new FileReader(arg1[1]));
            Scanner girls = new Scanner(new FileReader(arg1[2]));
            int test = boys.nextInt();
            System.out.print("test is ok "+ test);

        }
         else if(arg1[0].equals( "check")){}
        else{ System.out.print("shuhs");}
        };






    }


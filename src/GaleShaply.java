import com.sun.jdi.InvalidTypeException;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GaleShaply {

    public static void main(String[] arg) throws FileNotFoundException {

        // Getting command line as input and put it into a array


        //checking the second command word find or check to run the algorithm in the right direction
        if ( arg[0].equals("find")  ) {

            ArrayList<QueueLinkedList<Object>> Menpreferences = new ArrayList<QueueLinkedList<Object>>();
            QueueLinkedList EMenpref = new QueueLinkedList();

            // reading files and puting them into a 2D array first

                Scanner boys = new Scanner(new File(arg[1]));


            while(boys.hasNextLine()) {

                Scanner MenPrefReader = new Scanner(boys.nextLine());

                while (MenPrefReader.hasNextInt()) {
                    EMenpref.adToQueue(MenPrefReader.nextInt());
                }
                Menpreferences.add(EMenpref);



                //System.out.println(Menpreferences.size());
               //testing the reader file System.out.print(EMenpref);

            }
            System.out.println(EMenpref.size());
            System.out.println(Menpreferences.size());
                //Closing the boys file
                boys.close();






            //Scanner girls = new Scanner(new FileReader(arg[2]));
            //int test = boys.nextInt();
           // test the body of the loop by System.out.print("test is ok "+ test);

        }
         else if(arg[0].equals( "check")){}
        else{ System.out.print("shuhs");}
        };






    }


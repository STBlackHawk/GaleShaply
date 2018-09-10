import com.sun.jdi.InvalidTypeException;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GaleShaply {

    // Getting command line as one argument input and put it into a array of strings
    public static void main(String[] arg) throws FileNotFoundException {




        //checking the second command word find or check to run the algorithm in the right direction
        if (arg[0].equals("find")) {

            ArrayList<QueueLinkedList<Integer>> Menpreferences = new ArrayList<QueueLinkedList<Integer>>();


            // reading files and puting them into a 2D array first

                Scanner boys = new Scanner(new File(arg[1]));


            while(boys.hasNextLine()) {

                Scanner MenPrefReader = new Scanner(boys.nextLine());
                QueueLinkedList EMenpref = new QueueLinkedList();

                while (MenPrefReader.hasNextInt()) {
                    EMenpref.adToQueue(MenPrefReader.nextInt());
                }
                Menpreferences.add(EMenpref);

                //System.out.println(Menpreferences.size());
            }

            int test = Menpreferences.get(1).takeFromQueue();
            System.out.print(test);
//            System.out.println(EMenpref.size());
//            System.out.println(Menpreferences.size());
                //Closing the boys file
                System.out.print(Menpreferences);
                boys.close();






            //Scanner girls = new Scanner(new FileReader(arg[2]));
            //int test = boys.nextInt();
           // test the body of the loop by System.out.print("test is ok "+ test);

        }
         else if(arg[0].equals( "check")){}
        else{ System.out.print("shuhs");}
        };






    }


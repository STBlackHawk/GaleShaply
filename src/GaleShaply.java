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

            //Creating an array that each element of it is a Queue which is the men preference list
            ArrayList<QueueLinkedList<Integer>> menpreferences = new ArrayList<QueueLinkedList<Integer>>();
            ArrayList<ArrayList<Integer>> womenpreference = new ArrayList<ArrayList<Integer>>();

            // creating a Scanner file for boys preference which file name
            // should be the same as your second word of the argument in
            // your command line
            Scanner boys = new Scanner(new File(arg[1]));

            //reading text from the first argument file and
            // putting each integer into its position
            while(boys.hasNextLine()) {

                Scanner MenPrefReader = new Scanner(boys.nextLine());
                QueueLinkedList EMenpref = new QueueLinkedList();

                while (MenPrefReader.hasNextInt()) {
                    EMenpref.adToQueue(MenPrefReader.nextInt());
                }
                menpreferences.add(EMenpref);


            }

            boys.close();

            // creating a Scanner file for girls preference which file name
            // should be the same as your second word of the argument in
            // your command line
            Scanner girls = new Scanner (new File(arg[2]));

            ////reading text from the second argument file and
            // putting each integer into its position
            while (girls.hasNextLine()){
                Scanner WomenPrefReader = new Scanner(girls.nextLine());
                ArrayList Ewomenpref = new ArrayList();

                while(WomenPrefReader.hasNextInt()){
                    Ewomenpref.add(WomenPrefReader.nextInt());
                }

                womenpreference.add(Ewomenpref);
            }
            

        }
         else if(arg[0].equals( "check")){}
        else{ System.out.print("shuhs");}
        };






    }


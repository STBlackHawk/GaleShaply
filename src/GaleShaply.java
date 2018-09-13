
import java.io.FileNotFoundException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



public class GaleShaply {

    // Getting command line as one argument input and put it into a array of strings
    public static void main(String[] arg) throws FileNotFoundException {




        //checking the second command word find or check to run the algorithm in the right direction
        if (arg[0].equals("find")) {

            //Creats Number of men and wmen variable
            int Rmen = 0;
            int Cmen = 0;

            //creating a Scanner file for boys preference which file name
            // should be the same as your second word of the argument in
            // your command line
            Scanner boys = new Scanner(new File(arg[1]));

            //Creating matrix with the number of men as the size of rows
            // and number of women size of comuns
            while (boys.hasNextLine()){
                ++Rmen;
                Scanner Colmen = new Scanner(boys.nextLine());
                Cmen = 0;
                while(Colmen.hasNextInt()){
                    ++Cmen;
                    Colmen.nextInt();
                }
            }

            boys.close();


            int menpref[][] = new int[Rmen][Cmen];

            //closing the file


            //Opening the file and
            //Copying the input into the matrix

            boys = new Scanner(new File(arg[1]));

            for (int i=0; i<Rmen; i++){
                for (int j=0; j<Cmen; j++){
                  if(boys.hasNextInt()){ menpref[i][j] = boys.nextInt(); }
                }
            }
            boys.close();


            int Rwomen = 0;
            int Cwomen = 0;

            Scanner girls = new Scanner(new File(arg[1]));

            while (girls.hasNextLine()){
                ++Rwomen;
                Scanner Colwomen = new Scanner(girls.nextLine());
                Cwomen = 0;
                while(Colwomen.hasNextInt()){
                    ++Cwomen;
                    Colwomen.nextInt();
                }
            }

            int womenpref[][] = new int[Rwomen][Cwomen];

            //closing the file
            girls.close();

            //Opening the file and
            //Copying the input into the matrix

            girls = new Scanner(new File(arg[2]));

            for (int i=0; i<Rwomen; i++){
                for (int j=0; j<Cwomen; j++){

                    if(girls.hasNextInt()){womenpref[i][j] = girls.nextInt();}
                }
            }
            girls.close();

            //Reversing women's preference list for better search
            int[][] womenreverse = new int[Rwomen][Cwomen];

            for (int i=0; i<Rwomen; i++){
                ArrayList<Integer> q = new ArrayList<Integer>();
                for (int j=0; j<Cwomen; j++){

                    womenreverse[i][womenpref[i][j]-1]= j;


                }
            }

            System.out.println(Arrays.deepToString(womenpref));
            System.out.println(Arrays.deepToString(womenreverse));



        }



//            //Creating an array that each element of it is a Queue which is the men preference list
//            ArrayList<QueueLinkedList<Integer>> menpreferences = new ArrayList<>();
//            ArrayList<ArrayList<Integer>> womenpreference = new ArrayList<>();
//
//            // creating a Scanner file for boys preference which file name
//            // should be the same as your second word of the argument in
//            // your command line
//            Scanner boys = new Scanner(new File(arg[1]));
//
//            //reading text from the first argument file and
//            // putting each integer into its position
//            while(boys.hasNextLine()) {
//
//                Scanner MenPrefReader = new Scanner(boys.nextLine());
//                QueueLinkedList EMenpref = new QueueLinkedList();
//
//                while (MenPrefReader.hasNextInt()) {
//                    EMenpref.adToQueue(MenPrefReader.nextInt());
//                }
//                menpreferences.add(EMenpref);
//
//
//            }
//
//            boys.close();
//
//            // creating a Scanner file for girls preference which file name
//            // should be the same as your second word of the argument in
//            // your command line
//            Scanner girls = new Scanner (new File(arg[2]));
//
//            ////reading text from the second argument file and
//            // putting each integer into its position
//            while (girls.hasNextLine()){
//                Scanner WomenPrefReader = new Scanner(girls.nextLine());
//                ArrayList Ewomenpref = new ArrayList();
//
//                while(WomenPrefReader.hasNextInt()){
//                    Ewomenpref.add(WomenPrefReader.nextInt());
//                }
//
//                womenpreference.add(Ewomenpref);
//            }
//
//            //Testing the men and women preferences
//
////            List<Object> mmylist = new ArrayList<Object>(menpreferences);
////            List<Object> wmylist = new ArrayList<Object>(womenpreference);
////
////            for (Object q :menpreferences){System.out.println(q);}
////            for (Object a: womenpreference){System.out.println(a);}
//
//
//            //Reversing women's preference list for better search
//
//            ArrayList[] girl = new ArrayList[]{womenpreference.get(1)};
//            System.out.println(girl.toString());
//
////            for (int i=0; i<= womenpreference.size(); i++ ){
////
////
////                for (int j=0; j<= menpreferences.size(); j++)
//
//
//
//
//
//
//        }
         else if(arg[0].equals( "check")){}
        else{ System.out.print("shuhs");}
        };






    }


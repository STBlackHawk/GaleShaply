/**This is an Impementation for GaleShaply algorithm
 * this implementation have its own data type,
 * men preferences are in Queue and unmarrie men are in Stack.
 * The assumption of this implementation is that preferences and matching files
 * all should be in .txt format.
 * More over you should provide the matches in n*2 matrix to check and see whether or not
 * you have a stable match
 * This is for CLass Algorithm Design and Analysis
 * ECU, Fall of 2018.
 *
 * @author Shahin Taghikhani
 *
 *
 */

import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;



public class GaleShaply {

    // Getting command line as one argument input and put it into a array of strings
    public static void main(String[] arg) throws FileNotFoundException {




        //Creating an array that each element of it is a Queue which is the men preference list
        ArrayList<QueueLinkedList<Integer>> menpreferences = new ArrayList<>();


        // creating a Scanner file for boys preference which file name
        // should be the same as your second word of the argument in
        // your command line
        Scanner boys = new Scanner(new File(arg[1]+".txt"));

        //reading text from the first argument file and
        // putting each integer into its position
        while (boys.hasNextLine()) {

            Scanner MenPrefReader = new Scanner(boys.nextLine());
            QueueLinkedList EMenpref = new QueueLinkedList();

            while (MenPrefReader.hasNextInt()) {
                EMenpref.adToQueue(MenPrefReader.nextInt() - 1);
            }
            menpreferences.add(EMenpref);


        }

        boys.close();

        //Creating the objects for the number of rows and columns for women's preference list
        int Rwomen = 0;
        int Cwomen = 0;

        //reading in the data file for gilrs just to determine the rows and columns matrix
        Scanner girls = new Scanner(new File(arg[2]+".txt"));

        while (girls.hasNextLine()) {
            Rwomen++;
            Scanner Colwomen = new Scanner(girls.nextLine());
            Cwomen = 0;
            while (Colwomen.hasNextInt()) {
                Cwomen++;
                Colwomen.nextInt();
            }
        }

        int womenpref[][] = new int[Rwomen][Cwomen];

        //closing the file
        girls.close();

        //Opening the file and
        //Copying the input into the matrix

        girls = new Scanner(new File(arg[2]+".txt"));

        for (int i = 0; i < Rwomen; i++) {
            for (int j = 0; j < Cwomen; j++) {

                if (girls.hasNextInt()) {
                    womenpref[i][j] = girls.nextInt() - 1;
                }
            }
        }
        girls.close();

        //Reversing women's preference list for better search
        int[][] womenreverse = new int[Rwomen][Cwomen];

        for (int i = 0; i < Rwomen; i++) {

            for (int j = 0; j < Cwomen; j++) {

                womenreverse[i][womenpref[i][j]] = j;


            }
        }

        //checks to make sure that the number of women and men that you are providing are equal
        if( Rwomen != menpreferences.size()) {

            throw new IllegalArgumentException("the number of your Men and Women are not equal");
        }



        //Creats matched arrays indexes are husbands and what contains in that index is the wife
        ArrayList<Integer> matched = new ArrayList<>();
        while(matched.size()< menpreferences.size()){matched.add(null);}

        //checking the second command word find or check to run the algorithm in the right direction
        if (arg[0].equals("find")) {

            //creating specific data types for unmatched men and women
            //and filling them with candidates
            StacK<Integer> unMatchedM = new StacK<>();
            ArrayList unMatchedW = new ArrayList();

            for (int i = menpreferences.size() - 1 ; i >= 0; i--) {
                unMatchedM.push(i);
            }
            for (int i = 0; i <= Rwomen - 1 ; i++) {
                unMatchedW.add(i);
            }
            //implementing the GaleShaply algorithm
            while (!unMatchedM.isEmpty()) {
                int i = unMatchedM.pop();
                for (int j = 0; j < menpreferences.size(); j++) {
                    int k = menpreferences.get(i).takeFromQueue();

                if (unMatchedW.contains(k)) {
                        matched.set(i, k);
                        unMatchedW.set(unMatchedW.indexOf(k), null);
                        break;

                    } else if (!unMatchedW.contains(k) && (womenpref[k][i] < womenpref[k][matched.indexOf(k)])) {
                        unMatchedM.push(matched.indexOf(k));
                        matched.set(matched.indexOf(k),null);
                        matched.set(i, k);

                        break;

                    }

                }


            }
            //prints out an stable matching on the proper file if your computer does not
            //support the encoding it will throw an exception
            try {
                PrintWriter stableMatches = new PrintWriter(arg[3]+".txt","UTF-8");
                stableMatches.println("your stable matches are below");
                stableMatches.println("Husbands"+" "+"Wives");
                for (int i = 0; i < matched.size(); i++) {
                    stableMatches.println(i + 1 + " " + (matched.get(i) + 1));


                }
                stableMatches.close();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }



        }


        //Cheks the argument to run the checking part of the algorithm
       else if(arg[0].equals( "check")){
            //Reads the data from the matching provided
            Scanner matchList = new Scanner(new File(arg[3]+".txt"));




            //number of rows and columns for matched provided by user
            int Rmatched = 0;
            int Cmatched = 0;

            Scanner matchData = new Scanner(new File(arg[3]+".txt"));

            //getting number of the rows and datas from list of matches
            while (matchData.hasNextLine()){
                Rmatched++;
                Scanner ColmatchRedear = new Scanner(matchData.nextLine());
                Cmatched = 0;

                while (ColmatchRedear.hasNextInt()){
                    Cmatched++;
                    ColmatchRedear.nextInt();
                }

            }


            //checking whether or not the data provided are correct
            // matches are provided in n*2 matrix


            if (Cmatched != 2){
                throw new IllegalArgumentException(
                        "your matches are more than two persons you " +
                                "should provide matches in n*2 dimensional matrix");
            }

            //checks the number of matches and number of people to be the same
            if (Rmatched != menpreferences.size()){
                throw new IllegalArgumentException("the number of matches and " +
                        "number of people are not compatibale");
            }





            //Creates and Array with the size of candidates for matches
            ArrayList<Integer> matched2 = new ArrayList<>();
            while ( matched2.size()< Rmatched){matched2.add(null);}

            while(matchList.hasNextInt()) {
                for (int i = 0; i < Rmatched; ++i) {
                    for (int j = 0; j < Cmatched; ++j) {

                       if (matchList.hasNextInt()){

                           matched2.set(matchList.nextInt() - 1, matchList.nextInt() - 1);
                       }

                    }

                }

                //checking the perfect matching, checks that all element be in the matched2
                // at least one and all the indexs contain an element so if an index is null
                // or there is duplicate this is not perfect matching
                Set <Integer> dublicate = new HashSet<>(matched2);
                if (dublicate.size()<matched2.size()) {
                    throw new IllegalArgumentException("set of matches you provided" +
                            "are not perfect matching ");
                }

                if(menpreferences.size()!= Rwomen || Rwomen!= matched2.size()
                        || menpreferences.size()!= matched2.size()){
                    throw new   IllegalArgumentException("\"set of matches you provided\" +\n" +
                            "                            \"are not perfect matching \"");
                }



                }

                //checks the stable matching and print if there is a counter example
                //stores counter examples in an Array
                int a = 0;

                ArrayList counterExample = new ArrayList<>();

                for (int i=0;i<matched2.size();++i ){

                    for(int j =0; j< menpreferences.size(); j++){
                        if(menpreferences.get(i).peek() == matched2.get(i)){break;}
                        int k = menpreferences.get(i).takeFromQueue();
                         if(womenreverse[k][i] < womenreverse[k][matched2.indexOf(k)]) {
                            a++;

                                    counterExample.add(((i + 1) + " " + (k + 1)));
                                }
                         }
                        }
                        //printing only the first counter example
                    if (counterExample!= null){System.out.println(counterExample.get(1)+" Are unstable match");}

                    //Check the counter for counter examples if its 0 then we have a stable match
                    if(a==0){ System.out.println("you have stable matching");}
                    else{
                        System.out.println("your match is not stable");
                        System.out.print("you have "+ a+" unstable matches");}

                }


            else{ System.out.print("shuhs");}

        }


    }






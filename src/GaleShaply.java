import java.util.Scanner;


public class GaleShaply {

    public static void galeshaply(String[] arg1){

        // Getting command line as input and put it into a array
        Scanner comand = new Scanner(System.in);
        System.out.print("Type in your command");

        String input = comand.nextLine();

        //spliting using a single space the command into diiferent componenst so it can detect
        // which command it needs to be done

        String[] comandDiv = input.split("");

        //checking the second command word find or check to run the algorithm in the right direction
        if ( comandDiv[2] == "find" ) {}
        if (comandDiv[2] == "check"){}
        else{};






    }
}

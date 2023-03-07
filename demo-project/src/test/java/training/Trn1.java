package training;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Trn1 {

    public static void main(String[] args) throws IOException {
//            toMilesPerHour(-12);
//            toMilesPerHour(25.12);
//            printConversion(14.46);
//            printConversion(-18);
//
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .forEach(number -> System.out.println(number));


        File file = new File("./test001.txt");
        if (file.exists())
            file.delete();
        file.createNewFile();

        FileWriter fw = new FileWriter(file);

        String s = "HELLO!";
        fw.write(s);




    }

//    public static long toMilesPerHour(double kilometersPerHour) {
////        System.out.println((number>0) ? "Positive" : ((number<0) ? "negative" : "zero"));
//        if (kilometersPerHour < 0) {
////            System.out.println("invalid value");
//            return -1;
//        } else {
//
//            long milesPerHour  = Math.round(kilometersPerHour/1.609);
////            System.out.println("rounded = " + rounded);
//
//            return milesPerHour;
//        }
//    }
//    public static void printConversion(double kilometersPerHour) {
//        if (kilometersPerHour < 0) {
//            System.out.println("Invalid Value");
//        } else {
//            long miles = toMilesPerHour(kilometersPerHour);
//            System.out.println(kilometersPerHour + " km/h = " + miles + " mi/h");
//
//        }
//    }
}

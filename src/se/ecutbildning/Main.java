package se.ecutbildning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws ParseException {
        // write your code here

        LinkedList<PersonData> groupOne = new LinkedList<>();
        LinkedList<PersonData> groupTwo = new LinkedList<>();
        ArrayList<PersonData> personsWithSameTS = new ArrayList<>();

        //
        int personsWithAInName = 0;
        int personsWorkWithAndroid = 0;

        fillGroup(1, 3, groupOne);
        fillGroup(2, 4, groupTwo);

        compareTimeStamps(groupOne, personsWithSameTS);




        for (PersonData p : groupOne) {

            System.out.println(" Time Stamp: " + p.getTimeStamp()
                    + "| Name: " + p.getName()
                    + "| E-address: " + p.getEmailAddress()
                    + "| Has android: " + p.isHasAndroid()
                    + "| Works with: " + p.getWorksWith());
            System.out.println("******************************************");


            if (p.hasLetter('a')) {
                personsWithAInName = personsWithAInName + 1;
            }
            if (p.isHasAndroid()){
                personsWorkWithAndroid = personsWorkWithAndroid + 1;
            }


        }

        for (PersonData p : groupTwo) {

            System.out.println(" Time Stamp: " + p.getTimeStamp()
                    + "| Name: " + p.getName()
                    + "| E-address: " + p.getEmailAddress()
                    + "| Has android: " + p.isHasAndroid()
                    + "| Works with: " + p.getWorksWith());
            System.out.println("******************************************");


            if (p.hasLetter('a')) {
                personsWithAInName = personsWithAInName + 1;
            }
            if (p.isHasAndroid()){
                personsWorkWithAndroid = personsWorkWithAndroid + 1;
            }


        }

        System.out.println("PPL WITH NAME A: " + personsWithAInName);
        System.out.println("PPL with Same ts:" + personsWithSameTS.size());
        System.out.println("PPL With android:" + personsWorkWithAndroid);

    }


    private static void fillGroup(int nameCol, int e_addressCol, LinkedList<PersonData> group) {

        String csvFile = "sample.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] personData = line.split(cvsSplitBy);

                selectGroup(nameCol, e_addressCol, group, personData);


            }

            //Deletes the first row which is the columns' names
            group.remove(0);

            //Delete empty rows from list


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void selectGroup(int nameCol, int e_addressCol, LinkedList<PersonData> group, String[] fileData) throws ParseException {
        PersonData personData = new PersonData();

        if (!fileData[0].equalsIgnoreCase("")) {
            personData.setTimeStamp(fileData[0]);
            personData.setName(fileData[nameCol]);
            personData.setEmailAddress(fileData[e_addressCol]);
            personData.setHasAndroid(hasAndroid(fileData[5]));
            personData.setWorksWith(fileData[6]);
            group.add(personData);
        }


//        System.out.println( personData.toString());
    }

    private static boolean hasAndroid(String hasAndroid) {


        return hasAndroid.equalsIgnoreCase("yes i do");
    }


    //method that checks an array of strings, returns true if the arrays is empty


    public static void compareTimeStamps(LinkedList<PersonData> personData, ArrayList< PersonData> personswithSameTs) {
        int compare;

        for ( int i = 0; i < personData.size()-1; i++) {

            String ts1 = personData.get(i).getTimeStamp();
            String ts2 = personData.get(i+1).getTimeStamp();

            compare = ts1.compareTo(ts2);

            System.out.println("Compare Result is : " + compare  );
            if (compare == 0){
                personswithSameTs.add(personData.get(i));
                personswithSameTs.add(personData.get(i+1));
            }
        }
    }


//    //Convert timeStamp from string to
//
//    private static String convertTimeStamp(String timeStamp) throws ParseException {
//
////         string = "11/27/2012 3:57:36";
//
//        DateFormat format = new SimpleDateFormat("MM/d/yyyy HH:mm", Locale.ENGLISH);
//        Calendar date = Calendar.getInstance();
//        date.setTime(format.parse(timeStamp));
//        System.out.println(format.format(date.getTime())); //  11/27/2012 3:57:36
//
//        int hours = date.get(Calendar.HOUR_OF_DAY); // 3
//        int minutes = date.get(Calendar.MINUTE); // 57
//
////        date.add(Calendar.HOUR_OF_DAY, 1); // add a hour
////        date.add(Calendar.MINUTE , 1); // add a minute
////        System.out.println(format.format(date.getTime())); // 11/27/2012 3:57:36
//
//        return format.format(date.getTime());
//    }


//    private void saveCode(){
//
//        for ( Person p:   groupOne  ) {
//
//            System.out.println(" Time Stamp: "+ p.getTimeStamp()
//                    +  " Name: " + p.getName()
//                    +  " E-address: " + p.getEmailAddress()
//                    +  " Has android: "+ p.isHasAndroid()
//                    +  " Works with: " + p.isHasAndroid());
//            System.out.println("******************************************");
//
//        }
//    }

}


package se.ecutbildning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        // write your code here

        LinkedList<PersonData> groupOne = new LinkedList<>();
        LinkedList<PersonData> groupTwo = new LinkedList<>();

        //
        int personsWithAInName = 0;
        int personsWorkWithAndroid;

        fillGroup(1, 3, groupOne);
        fillGroup(2, 4, groupTwo);


        for (PersonData p : groupOne) {

            System.out.println(" Time Stamp: " + p.getTimeStamp()
                    + "| Name: " + p.getName()
                    + "| E-address: " + p.getEmailAddress()
                    + "| Has android: " + p.isHasAndroid()
                    + "| Works with: " + p.isHasAndroid());
            System.out.println("******************************************");

            if (p.hasLetter('a')){
                personsWithAInName = personsWithAInName +1 ;
            }


        }

        System.out.println("PPL WITH NAME A: " + personsWithAInName);
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    private static void selectGroup(int nameCol, int e_addressCol, LinkedList<PersonData> group, String[] personData) {
        PersonData person = new PersonData();
        person.setTimeStamp(personData[0]);
        person.setName(personData[nameCol]);
        person.setEmailAddress(personData[e_addressCol]);
        person.setHasAndroid(hasAndroid(personData[5]));
        person.setWorksWith(personData[6]);
        group.add(person);

//        System.out.println( person.toString());
    }

    private static boolean hasAndroid(String hasAndroid) {


        if (hasAndroid.equalsIgnoreCase("yes i do")) {
            return true;
        } else return false;
    }























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


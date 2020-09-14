package se.ecutbildning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws ParseException {
        // write your code here

        LinkedList<PersonData> groupOne = new LinkedList<>();
        LinkedList<PersonData> groupTwo = new LinkedList<>();
        HashMap<String, String> personsWithSameTS = new HashMap<>();

        //
        int personsWithAInName = 0;
        int personsWorkWithAndroid = 0;

        fillGroup(1, 3, groupOne);
        fillGroup(2, 4, groupTwo);

        compareTimeStamps(groupOne, groupTwo, personsWithSameTS);


        //print out the hash map
        for (Map.Entry me : personsWithSameTS.entrySet()) {
            System.out.println( me.getKey() + "  And " + me.getValue() + " Have the same time stamp!");
        }



        //print linked list 1 out
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


        //print linked list 2 out
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
        sortNamesAndEmails(groupOne, groupTwo);

    }


    //Read and Store
    private static void fillGroup(int nameCol, int e_addressCol, LinkedList<PersonData> group) {

        String csvFile = "sample.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {


            //Initializing BF obj
            br = new BufferedReader(new FileReader(csvFile));


            while ((line = br.readLine()) != null) {

                // use comma as separator and store data into a string array
                String[] personData = line.split(cvsSplitBy);

                //select group column numbers "name, address" and add it to the linked list
                selectGroup(nameCol, e_addressCol, group, personData);


            }

            //Deletes the first row which is the columns' names
            group.remove(0);



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


    //Select the group based on group columns, store them in parametered linked list
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


    }

    private static boolean hasAndroid(String hasAndroid) {


        return hasAndroid.equalsIgnoreCase("yes i do");
    }






    //Compare time stamps between persons in two groups
    public static void compareTimeStamps(LinkedList<PersonData> group1, LinkedList<PersonData> group2, HashMap<String, String> personsWithSameTs){
        int compare;

        System.out.println(group1.size());
        System.out.println(group2.size());
        for (int i = 0; i < group1.size(); i++) {
            for (int j = 0 ; j< group2.size(); j++){

                String ts1 = group1.get(i).getTimeStamp();
                String ts2 = group2.get(j).getTimeStamp();

                compare = ts1.compareTo(ts2);

                if (compare == 0){
                    personsWithSameTs.put(group1.get(i).getName(), group2.get(j).getName());
                }
            }

        }
    }



    //Check if two persons have the same email address
    public static void sortNamesAndEmails(LinkedList<PersonData> g1, LinkedList<PersonData> g2){

        for (int i = 0; i < g1.size(); i++) {

            for (int j = 0 ; j< g2.size(); j++){


                if (g1.get(i).getEmailAddress().equals(g2.get(j).getEmailAddress())){

                    System.out.println(g1.get(i).getName() + " And " + g1.get(j).getName() + " Have the same email address!");


                }


            }

        }

    }

}


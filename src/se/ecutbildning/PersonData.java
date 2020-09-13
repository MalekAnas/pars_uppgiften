package se.ecutbildning;

public class PersonData {



    private String timeStamp;
    private String name;
    private String emailAddress;
    private boolean hasAndroid;
    private String worksWith;




    //check if the person name has a specific char in the name
    public boolean hasLetter(char c){

        boolean returnValue = false;

        for (char letter : this.getName().toLowerCase().toCharArray() ) {
            if (letter == c){
                returnValue = true;
            }
        }
        return  returnValue;
    }












    //Getters&Setters
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isHasAndroid() {
        return hasAndroid;
    }

    public void setHasAndroid(boolean hasAndroid) {
        this.hasAndroid = hasAndroid;
    }



    public String getWorksWith() {
        return worksWith;
    }

    public void setWorksWith(String worksWith) {
        this.worksWith = worksWith;
    }


    @Override
    public String toString() {
        return "Person{" +
                "timeStamp='" + timeStamp + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hasAndroid=" + hasAndroid +
                ", worksWith='" + worksWith + '\'' +
                '}';
    }
}

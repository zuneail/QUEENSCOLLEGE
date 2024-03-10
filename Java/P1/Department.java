public enum Department {
    NONE("No Department"),
    CSCI("Computer Science"),
    CHEM("Chemistry"),
    PHYSICS("Physics"),
    BIO("Biology"),
    GEO("Geography");

    private String name;
    private Department(String name){
        this.name = name;
    }
    public String getName(){return name;}
}
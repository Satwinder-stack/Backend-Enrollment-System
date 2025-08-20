import java.util.*;

public class database {
    /*The database or the constructor*/
    private int studentAge;
    private String name;
    private int pays;
    private String pa;
    private int sem;
    private int year;
    public database(){

    }
    /*This is where everything is being passed back and forth into and out*/

    public database(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setParent(String sp){
        this.pa = sp;
    }
    public String getParent(){
        return pa;
    }
    public void setAge(int age){
        this.studentAge = age;
    }
    /*This contains the name, age, parent's approval, semester, and a lot more*/

    public int getAge(){
        return studentAge;
    }
    public void setPs(int ps){
        this.pays = ps;
    }

    public int getPs(){
        return pays;
    }
    public void setSem(int se){
        this.sem = se;
    }

    public int getSem(){
        return sem;
    }
    public void setYear(int ye){
        this.year = ye;
    }

    public int getYear(){
        return year;
}
}


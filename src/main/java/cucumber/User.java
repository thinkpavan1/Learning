package cucumber;


public class User {
    private String name;
    private String certification;
    private int marks;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public boolean getResults(){
        if( marks < 60 ){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", certification='" + certification + '\'' +
                ", marks=" + marks +
                '}';
    }
}

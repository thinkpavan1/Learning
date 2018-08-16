package doubts;

public class C extends B{
    @Override
    public String getClassName() {
        return "C";
    }

    public static void main(String[] args) {
       new C().showClassName ();
    }
}

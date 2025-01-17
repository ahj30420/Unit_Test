package project.unitTesting.v6;

public class Precondition {

    public static void requires(boolean precondition, String message) throws Exception {
        if(!precondition){
            throw new Exception(message);
        }
    }

    public static void requires(boolean precondition) throws Exception {
        requires(precondition, null);
    }
}

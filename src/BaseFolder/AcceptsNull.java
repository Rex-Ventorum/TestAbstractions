package BaseFolder;

public class AcceptsNull implements NoNullsence{

    @Override
    public Object echoNeverNullObject(Object arg) {
       //if(arg == null) throw new IllegalArgumentException("Does Not Accept Null Arguments");
       return arg;
    }
    
}

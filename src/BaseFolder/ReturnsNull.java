package BaseFolder;

public class ReturnsNull implements NoNullsence{

    @Override
    public Object echoNeverNullObject(Object arg) throws IllegalArgumentException{
       if(arg == null) throw new IllegalArgumentException("Does Not Accept Null Arguments");
       return null;
       //return arg;
    }
    
}

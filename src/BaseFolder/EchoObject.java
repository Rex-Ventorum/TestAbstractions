package BaseFolder;

public class EchoObject implements NoNullsence{

    @Override
    public Object echoNeverNullObject(Object arg) throws IllegalArgumentException{
        if(arg == null) throw new IllegalArgumentException("Does Not Accept Null Objects");
        return arg;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseFolder;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static BaseFolder.ClassFinder.*;


public class NoNullsenceTest {
    
    private final Class<NoNullsence>[] subClasses;
    private NoNullsence[] instances;
    
    public NoNullsenceTest() {
        subClasses = (Class<NoNullsence>[])findAllClassInstancesInProject(NoNullsence.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        instances = new NoNullsence[subClasses.length];
        for(int i=0; i<subClasses.length; i++){
            try {
                instances[i] = (NoNullsence) subClasses[i].newInstance();
            } catch (IllegalAccessException | InstantiationException e){
                System.out.println("Here");
            }
        }// end of instnace Loop
    }
    
    @After
    public void tearDown() {
        instances = null;
    }
    
    @Test 
    public void subClassesNeverAcceptNullArgument(){
        for(NoNullsence instance : instances){
            try{
                instance.echoNeverNullObject(null);
            }catch(IllegalArgumentException iae){
                continue;//Do Nothing this is what we want
            }
            fail(instance.getClass().getName() + " Accepted a null Argument");
        }
    }
    
    @Test
    public void subClassesNeverReturnNull(){
        for(NoNullsence instance : instances){
            Object returned = instance.echoNeverNullObject("Test Object");
            if(returned == null) fail(instance.getClass().getName() + " returned a null Argument");
        }
    }
    
    @Test 
    public void subClassesEchoArgumentAsReturnValue(){
        for(NoNullsence instance : instances){
            String testObject = "Test Object";
            Object returned = instance.echoNeverNullObject(testObject);
            if(testObject != returned) fail(instance.getClass().getName() + " did not echo argument");
        }
    }
}

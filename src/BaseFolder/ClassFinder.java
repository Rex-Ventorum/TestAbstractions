package BaseFolder;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ClassFinder {
    
    public static Class<?>[] findAllClassInstancesInProject(Class<?> inClass){
        List<Class<?>> instanceClasses = new LinkedList<Class<?>>();
        String sourceFolder = ".";
        File projectDir = new File(sourceFolder);
        File[] allProjectFiles = getAllFiles(projectDir);
        for(File file : allProjectFiles){
            try{
                String className = getFileNameWithNoExtention(file);
                Class<?> foundClass = Class.forName("BaseFolder." + className);
                if(inClass.isAssignableFrom(foundClass) && !inClass.equals(foundClass)){
                    if(!instanceClasses.contains(foundClass))instanceClasses.add(foundClass);
                }
            }catch(ClassNotFoundException cnf){
                continue; //Ignore and simply move on
            }
        }// end of file loop
        return instanceClasses.toArray(new Class<?>[]{});
    }
    
    private static File[] getAllFiles(File dir){
        if(!dir.isDirectory()) return new File[]{dir};
        else{
            List<File> fileList = new LinkedList<File>();
            for(File file : dir.listFiles()){
                for(File subFile : getAllFiles(file)){
                    fileList.add(subFile);
                }//end of subfile loop
            }//end of file loop
            return fileList.toArray(new File[]{});
        }//end of else
    }
    
    private static String getFileNameWithNoExtention(File file){
        return file.getName().substring(0, file.getName().lastIndexOf("."));
    }
}

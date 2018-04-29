package mytr.cucumber.ex.testrunner;

import java.io.File;
import java.io.FilenameFilter;

public class Eample {

	public static void main(String[] args) {
		 File[] fileList = getFileList("directory path");

         for(File file : fileList) {
             System.out.println(file.getName());
         }

	}

	private static File[] getFileList(String string) {
		 File dir = new File("C:\\Users\\UX008098\\Documents\\Workspace\\CucumberTest\\target");   

         File[] fileList = dir.listFiles(new FilenameFilter() {
             public boolean accept(File dir, String name) {
                 return name.endsWith(".json");
             }
         });
         return fileList;
	}

}

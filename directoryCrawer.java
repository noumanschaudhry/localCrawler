
package directorycrawler;

import static directorycrawler.DirectoryCrawler.index;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


 class dCrawler implements Runnable{
     File aStartingDir;
     
      dCrawler(File b){
      aStartingDir = b;
     }
    private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else return "";
	}
    public int crawl(){
    File[] filesAndDirs = aStartingDir.listFiles();
    Thread myThreads[] = new Thread[filesAndDirs.length];
		List<File> dir = new ArrayList<File>();
		
                int iterator = 0;
                				List<String> tempList = new ArrayList<String>();

		//List all files in directory
		for (File file : filesAndDirs){
			if (file.isFile()) {
				
                                
				tempList.add(aStartingDir.toString() + "\\" + file.getName());
				index.put(file.getName(), tempList);
				if (getFileExtension(file).equals("txt")){
                                    Indexer a = new Indexer(aStartingDir,file);
                                   
                                    myThreads[iterator] = new Thread(a);
                                    myThreads[iterator].start();
                                    

				}
                                                        tempList.clear();

			}
                        


			else {
				//Add first level directory to a list
				dir.add(file);
			}
		}
for (Thread thread : myThreads){
    try{
    thread.join();
    }
    catch(Exception e){
    //System.out.println("Lol");
    }
}
                try{
		if (dir.isEmpty())
			return 0;
		else {
			/
			for (File file : dir){
                            try{
                            crawl();
                            }
                            catch(Exception e){
                            System.out.println("Error LoL");

                            }
			}
                
		}
                return 1;
                }
                catch(Exception e){
                System.out.println("Error LoL");
                }
                return 1;
    }
    @Override
    public void run(){
        try{
        crawl();
        }
        catch(Exception e){
        System.out.println("Something Went wrong");
        }
        

	}
}

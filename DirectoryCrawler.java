/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package directorycrawler;

/**
*
* @author DELL
*/
import java.util.*;
import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class DirectoryCrawler{
	public static void main(String[] args)throws Exception{
		//Starting directory for parsing
		File aStartingDir = new File("C:\\Users\\NoumanShafi\\IdeaProjects\\lab6AP\\src\\crawlerDir");
		System.out.println("Working Directory = " +
			System.getProperty("user.dir"));

                File bStartingDir = new File("C:\Users\NoumanShafi\IdeaProjects\lab6AP\src");

                File cStartingDir = new File("C:\\Users\\NoumanShafi\\IdeaProjects\\lab6AP\\src\\CrawlerDir");

dCrawler t1 = new dCrawler(aStartingDir) ;
dCrawler t2 = new dCrawler(bStartingDir) ;
dCrawler t3 = new dCrawler(cStartingDir) ;

Thread tt1 = new Thread(t1);
tt1.start();

Thread tt2 = new Thread(t2);
tt2.start();


Thread tt3 = new Thread(t3);
tt3.start();

tt1.join();
tt2.join();
tt3.join();



		System.out.println();
		System.out.println();
                SearchingService search = new SearchingService();
                Thread searchThread = new Thread(search);
                searchThread.start();
                
                
                
                Iterator it = index.keySet().iterator();
        BufferedWriter fileout = new BufferedWriter(new FileWriter("file.txt"));

while (it.hasNext()) {
            		List<String> ab = new ArrayList<String>();

   String key = it.next().toString();
   ab = index.get(key);
   
   fileout.write("key is:" + key + "\n");
      fileout.write("\n");

   fileout.write("locations found in:");
   
		for (int i = 0; i < ab.size(); i++){
			fileout.write(ab.get(i));

		}

}



	}
	
	static HashMap<String, List<String>> index = new HashMap<String, List<String>>();

	//Crawls and indexes directories and files, also inside of text files
        
	
}

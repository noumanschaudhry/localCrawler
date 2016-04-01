/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorycrawler;

import static directorycrawler.DirectoryCrawler.index;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;

/**
 *
 * @author DELL
 */
public class Indexer implements Runnable{
    Indexer(File a,File b){
    aStartingDir = a;
    file = b;
    }
    File aStartingDir;
    File file;
    List<String> tempList = new ArrayList<String>();

    public void run(){
    
        
        List<String> tempLst = new ArrayList<String>();
					index.put(file.getName(), tempList);

                                        try{
					//Index content of text files
					BufferedReader read = new BufferedReader(new FileReader(aStartingDir.toString() + "\\" + file.getName()));
					String line = null;
					while ((line = read.readLine()) != null) {
						StringTokenizer tokens = new StringTokenizer(line);
						while (tokens.hasMoreElements()){
							String firstname = tokens.nextToken();
							tempLst.add(aStartingDir.toString() + "\\" + file.getName());
							//System.out.println(tempLst.size());

							index.put(firstname, tempLst);
                                                





						}
					}
                                        }
                                        catch(Exception e){
                                        System.out.println(e);
                                        }
    
    
    }
}

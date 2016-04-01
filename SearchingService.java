/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorycrawler;

import static directorycrawler.DirectoryCrawler.index;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class SearchingService implements Runnable{
    
    public void run(){
    
            
        		List<String> ab = new ArrayList<String>();



		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter string to search: ");
		String n = reader.nextLine(); 

		ab = index.get(n);

		System.out.println("Your string present in : ");
		for (int i = 0; i < ab.size(); i++){
			System.out.println(ab.get(i));

		}
		System.out.println("Parsing complete");

    
    
    
    }
}

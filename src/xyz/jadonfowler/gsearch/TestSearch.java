/**
 * This file was created and is owned by 
 * Jadon "Phasesaber" Fowler, just because
 * it is open source does not mean you own
 * it. If you have questions or comments,
 * contact me at http://jadonfowler.xyz/
 */
package xyz.jadonfowler.gsearch;

import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * GSearch:xyz.jadonfowler.gsearch.TestSearch.java
 * 
 * @author Phase
 * @date Jan 28, 2015
 */
public class TestSearch {

	public static void main(String[] ar){
		Search s = new Search("github.com/Phasesaber");
		HashMap<String, String> r = null;
		try {
			r = s.getResults(4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String sr : r.keySet()){
			System.out.println(sr + ":\n  " + r.get(sr) + "\n");
		}
	}

}

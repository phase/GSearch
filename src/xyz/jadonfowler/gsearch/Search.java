/**
 * This file was created and is owned by 
 * Jadon "Phasesaber" Fowler, just because
 * it is open source does not mean you own
 * it. If you have questions or comments,
 * contact me at http://jadonfowler.xyz/
 */
package xyz.jadonfowler.gsearch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import com.google.gson.Gson;

/**
 * 
 * GSearch:xyz.jadonfowler.gsearch.Search.java
 * 
 * @author Phase
 * @date Jan 28, 2015
 */
public class Search {

	private String query;

	static final String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	static final String charset = "UTF-8";

	private Reader getReader() {
		try {
			return new InputStreamReader(new URL(address
					+ URLEncoder.encode(query, charset)).openStream(), charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Searches something on Google
	 * 
	 * @param query
	 *            What you want to search
	 */
	public Search(String query) {
		this.query = query;
	}

	/**
	 * Gets results off Google
	 * 
	 * @param amount
	 *            Amount of search results (divisible by 4)
	 * @return HashMap<String, String> Results in Title, URL
	 * @throws IOException
	 */
	public HashMap<String, String> getResults(int amount) throws IOException {
		HashMap<String, String> results = new HashMap<String, String>();
		Reader r = getReader();
		for (int i = 0; i < amount; i += 4) {
			SearchResults sr = new Gson().fromJson(r, SearchResults.class);
			System.out.println(r);
			for(int j = 0; j < 4; j++){
				results.put(
						sr.getResponseData().getResults().get(j).getTitle(),
						sr.getResponseData().getResults().get(j).getUrl()
					);
			}
		}
		return results;
	}

}

/**
 * This file was created and is owned by 
 * Jadon "Phasesaber" Fowler, just because
 * it is open source does not mean you own
 * it. If you have questions or comments,
 * contact me at http://jadonfowler.xyz/
 */
package xyz.jadonfowler.gsearch;

import java.util.List;

/**
 * 
 * GSearch:xyz.jadonfowler.gsearch.SearchResults.java
 * 
 * @author Phase
 * @date Jan 28, 2015
 */
public class SearchResults {

	private ResponseData responseData;

	public ResponseData getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseData r) {
		responseData = r;
	}

	public String toString() {
		return "ResponseData[" + responseData.toString() + "]";
	}

	static class ResponseData {
		private List<Result> results;

		public List<Result> getResults() {
			return results;
		}

		public void setResults(List<Result> r) {
			results = r;
		}

		public String toString() {
			return "Results[" + results + "]";
		}
	}

	static class Result {
		private String url;
		private String title;

		public String getUrl() {
			return url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String t) {
			title = t;
		}

		public void setUrl(String u) {
			url = u;
		}
	}

}

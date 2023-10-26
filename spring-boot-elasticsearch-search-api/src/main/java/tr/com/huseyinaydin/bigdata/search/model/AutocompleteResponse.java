package tr.com.huseyinaydin.bigdata.search.model;

import java.util.List;

//بسم الله الرحمن الرحيم

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot - Elasticsearch.
 * 
 */

public class AutocompleteResponse {
	private List<AutocompleteDetail> data;

	public AutocompleteResponse() {
	}

	public AutocompleteResponse(List<AutocompleteDetail> data) {
		this.data = data;
	}

	public List<AutocompleteDetail> getData() {
		return data;
	}

	public void setData(List<AutocompleteDetail> data) {
		this.data = data;
	}
}

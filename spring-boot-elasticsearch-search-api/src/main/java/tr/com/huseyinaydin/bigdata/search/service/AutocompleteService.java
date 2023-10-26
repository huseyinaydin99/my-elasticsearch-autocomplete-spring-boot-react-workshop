package tr.com.huseyinaydin.bigdata.search.service;

import java.io.IOException;

import tr.com.huseyinaydin.bigdata.search.model.AutocompleteResponse;

//بسم الله الرحمن الرحيم

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot - Elasticsearch.
 * 
 */

public interface AutocompleteService {
	AutocompleteResponse search(String term) throws IOException;
}
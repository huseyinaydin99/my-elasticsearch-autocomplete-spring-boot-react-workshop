package tr.com.huseyinaydin.bigdata.search.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.bigdata.search.model.AutocompleteResponse;
import tr.com.huseyinaydin.bigdata.search.service.AutocompleteService;

import java.io.IOException;

//بسم الله الرحمن الرحيم

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot - Elasticsearch.
 * 
 */

@RestController
public class SearchController {

	@Autowired
	AutocompleteService autocompleteService;

	//@GetMapping("/autocomplete")
	@GetMapping("/search/stream")
	public AutocompleteResponse autocomplete(@RequestParam String term) throws IOException {
		AutocompleteResponse response = autocompleteService.search(term);
		return response;
	}
}

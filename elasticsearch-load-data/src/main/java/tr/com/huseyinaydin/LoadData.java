package tr.com.huseyinaydin;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.simple.JSONObject;
import org.apache.http.HttpHost;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Elasticsearch.
* 
*/

public class LoadData {
	public static void main(String[] args) throws IOException {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200)));
		IndexRequest request = new IndexRequest("product3");
		File file = new File("C:\\Users\\Huseyin_Aydin\\Desktop\\productlist.csv");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			System.out.println(line);
			String[] terms = line.split(",");
			String brand = terms[0];
			String title = terms[1];
			JSONObject data = new JSONObject();
			data.put("brand", brand);
			data.put("title", title);
			request.source(data.toJSONString(), XContentType.JSON);
			client.index(request, RequestOptions.DEFAULT);
		}
		scanner.close();
		client.close();
		System.out.println("Bitti");
	}
}
package datasetapiexample;

import java.util.List;

import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.aggregation.Aggregations;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;

import datasetapiexample.models.Author;
import datasetapiexample.models.IdKeySelectorAuthor;
import datasetapiexample.models.IdKeySelectorAuthorAge;
import datasetapiexample.models.IdKeySelectorQuotes;
import datasetapiexample.models.Quotes;

public class DataSetService {

	public void filterbyretirement(DataSet<Author> authors){
		
		try {
			List<Author> retiredAuthors = 
			authors.filter(a -> a.getRetired())
			.collect();
			
			System.out.println(retiredAuthors.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void filterbyage(DataSet<Author> authors){
		
		try {
			List<Author> agedauthors = 
			authors.filter(a -> a.getAuthorage() > 75)
			.collect();
			
			System.out.println(agedauthors.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		public void filterbyagenameonly(DataSet<Author> authors){
			
			try {
				List<String> agedauthornames = 
				authors.filter(a -> a.getAuthorage() > 75)
				.map(p -> p.getAuthorname())
				.collect();
				
				System.out.println(agedauthornames.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	
		//function to sort the authors by age 
		public void sort(DataSet<Author> authors){
			try{
				List<Author> sorted = authors.sortPartition(new IdKeySelectorAuthorAge(), Order.ASCENDING)
						.collect();
				
				System.out.println(sorted.toString());
				
			} catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		public void join(DataSet<Author> authors, DataSet<Quotes> quotes){
			try{
				List<Tuple2<Author, Quotes>> joinedList = authors.join(quotes)
						.where(new IdKeySelectorAuthor())
						.equalTo(new IdKeySelectorQuotes())
						.collect();
				
				System.out.println(joinedList.toString());
				
			} catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		public void wordcount(DataSet<Quotes> quotes){
			try{
				DataSet<Tuple2<String, Integer>> wordcount = quotes
						.map(p -> p.getQuote())
						.flatMap(new LineSplitter())
						.groupBy(0)
						.aggregate(Aggregations.SUM, 1);
			
				wordcount.print();
				
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	
}

package datasetapiexample;

import java.util.Arrays;
import java.util.Date;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple5;
import datasetapiexample.models.*;
public class Controller {

	public static void main(String[] args) {
		
		//creating execution environment
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		
		//creating the  authors dataset
		DataSet<Author> authors = env.fromCollection(
				Arrays.asList(
						new Author(1, "R. K. Narayan", 70, "India", true),
						new Author(2, "Ruskin Bond", 80, "India", true),
						new Author(3, "Ayn Rand", 85, "NA", true),
						new Author(4, "Chetan Bhagat", 45, "India", false)
						));
				
		//creating the  quotes dataset
				DataSet<Quotes> quotes = env.fromCollection(
						Arrays.asList(
								new Quotes(1, "May you live long", 2, new Date()),
								new Quotes(2, "I shall live longer", 3, new Date()),
								new Quotes(3, "I am inevitable", 2, new Date()),
								new Quotes(4, "I am Iron Man", 1, new Date()),
								new Quotes(5, "Eye for an eye", 3, new Date()),
								new Quotes(6, "Bite me", 2, new Date()),
								new Quotes(7, "Make yourself scarce tonight", 1, new Date())
								));
			
			DataSetService dss  = new DataSetService();
		
			//find the authors who have retired
			System.out.println("Now printing authors who have retired");
			dss.filterbyretirement(authors);
			
			//find the authors with age more than 75
			System.out.println("Now printing authors who are aged more than 75");
			dss.filterbyage(authors);
			
			//print just the names of the authors who are aged more than 75
			System.out.println("Now printing authors names only who are aged more than 75");
			dss.filterbyagenameonly(authors);	
			
			//print the author names sorted by author age
			System.out.println("Printing author names by author age");
			dss.sort(authors);
			
			//joining 
			System.out.println("Making a join of authors and quotes");
			dss.join(authors, quotes);
			
			//doing word count on all the quotes
			System.out.println("Now doing a word count on all the quotes");
			dss.wordcount(quotes);
			
	}

}

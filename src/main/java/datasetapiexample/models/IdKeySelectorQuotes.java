package datasetapiexample.models;

import org.apache.flink.api.java.functions.KeySelector;

public class IdKeySelectorQuotes implements KeySelector<Quotes, Integer> {
	  @Override
	  public Integer getKey(Quotes value) {
	      return value.getAuthorid();
	  }
	}
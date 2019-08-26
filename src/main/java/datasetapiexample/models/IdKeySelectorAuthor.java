package datasetapiexample.models;

import org.apache.flink.api.java.functions.KeySelector;

public class IdKeySelectorAuthor 
implements KeySelector<Author, Integer> {
  @Override
  public Integer getKey(Author value) {
      return value.getAuthorid();
  }
}

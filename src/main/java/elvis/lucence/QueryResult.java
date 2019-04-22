package elvis.lucence;

import org.apache.lucene.search.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by jwyuan on 2017/11/9.
 */
public class QueryResult {
    List<Map<String, Object>> result;
    Query query;
    int totalHit = 0;

    public QueryResult() {
    }

    public QueryResult(List<Map<String, Object>> result, Query query) {
        this.result = result;
        this.query = query;
    }

    public List<Map<String, Object>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public int getTotalHit() {
        return totalHit;
    }

    public void setTotalHit(int totalHit) {
        this.totalHit = totalHit;
    }
}

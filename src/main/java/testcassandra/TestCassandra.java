package testcassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class TestCassandra {

	public static void main(String[] args) {
		String user = System.getenv("CASSANDRA_USER");
		String pass = System.getenv("CASSANDRA_PASSWORD");
		
		CqlSession session =
			    CqlSession.builder()
			        .withAuthCredentials(user, pass)
			        .build();
		
		ResultSet rs = session.execute("select release_version from system.local");
		Row row = rs.one();
		System.out.println(row.getString("release_version")); 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

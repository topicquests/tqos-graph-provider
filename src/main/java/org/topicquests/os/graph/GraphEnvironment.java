/**
 * 
 */
package org.topicquests.os.graph;

import org.topicquests.os.graph.api.IGraph;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class GraphEnvironment extends RootEnvironment {
	private PostgresConnectionFactory provider;
	private IGraph theGraph;

	/**
	 */
	public GraphEnvironment() {
		super("graph-props.xml", "logger.properties");
		String dbName = getStringProperty("GraphDatabaseName");
		String schemaName = getStringProperty("GraphDatabaseSchema");
		provider = new PostgresConnectionFactory(dbName, schemaName);
		theGraph = new SQLGraph(this);
	}

	public PostgresConnectionFactory getProvider() {
		return provider;
	}
	
	public IGraph getGraph() {
		return theGraph;
	}
	
	@Override
	public void shutDown() {
		System.out.println("GraphEnvironment.shutDown");
		provider.shutDown();

	}

}

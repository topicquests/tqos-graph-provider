/**
 * 
 */
package org.topicquests.os.graph;

import org.topicquests.os.graph.api.IGraph;
import org.topicquests.os.graph.api.IGraphModel;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class GraphEnvironment extends RootEnvironment {
	private PostgresConnectionFactory provider;
	private IGraphModel model;

	/**
	 */
	public GraphEnvironment() {
		super("graph-props.xml", "logger.properties");
		String dbName = getStringProperty("GraphDatabaseName");
		String schemaName = getStringProperty("GraphDatabaseSchema");
		provider = new PostgresConnectionFactory(dbName, schemaName);
		model = new SQLGraphModel(this);
	}

	public PostgresConnectionFactory getProvider() {
		return provider;
	}
	
	public IGraphModel getGraphModel() {
		return model;
	}
	
	@Override
	public void shutDown() {
		System.out.println("GraphEnvironment.shutDown");
		provider.shutDown();

	}

}

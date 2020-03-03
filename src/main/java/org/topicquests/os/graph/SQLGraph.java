/**
 * 
 */
package org.topicquests.os.graph;

import org.topicquests.os.graph.api.IEdge;
import org.topicquests.os.graph.api.IGraph;
import org.topicquests.os.graph.api.INode;
import org.topicquests.os.graph.api.IVertex;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SQLGraph implements IGraph {
	private GraphEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public SQLGraph(GraphEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}

	@Override
	public IVertex addIVertex(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVertex getIVertex(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeIVertex(IVertex vertex) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<IVertex> getVertices() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IVertex> getVertices(String key, Object value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEdge addIEdge(String id, IVertex outIVertex, IVertex inIVertex, String label) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEdge getIEdge(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeIEdge(IEdge edge) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<IEdge> getIEdges() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IEdge> getIEdges(String key, Object value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nodeExists(IPostgresConnection conn, String vertexId, IResult r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNodePropertyValue(IPostgresConnection conn, String id, String key, IResult r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToNodeSetProperty(IPostgresConnection conn, String nodeId, String key, String value, IResult r) {
		// TODO Auto-generated method stub

	}


	@Override
	public IVertex addVertex(IPostgresConnection conn, String id, String label, IResult r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEdge addEdge(IPostgresConnection conn, String id, String outVertexId, String inVertexId, String label,
			IResult r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getNode(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getNode(IPostgresConnection conn, String id, IResult r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult executeSQL(String sqlQuery, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeSQL(IPostgresConnection conn, String sqlQuery, IResult r, Object... values) {
		// TODO Auto-generated method stub
		
	}

}

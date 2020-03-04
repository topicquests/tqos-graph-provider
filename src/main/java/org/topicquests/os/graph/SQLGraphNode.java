/**
 * 
 */
package org.topicquests.os.graph;

import java.io.PrintWriter;
import java.util.List;

import org.topicquests.os.graph.api.IDirection;
import org.topicquests.os.graph.api.IEdge;
import org.topicquests.os.graph.api.IGraphNode;
import org.topicquests.os.graph.api.IVertex;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class SQLGraphNode implements IVertex, IEdge, IGraphNode {
	private GraphEnvironment environment;
	private PostgresConnectionFactory provider;
	private JSONObject data;

	/**
	 * 
	 */
	public SQLGraphNode(GraphEnvironment env) {
		environment = env;
		provider = environment.getProvider();
		data = new JSONObject();
	}

	@Override
	public JSONObject getData() {
		return data;
	}

	@Override
	public String toJSONString() {
		return data.toJSONString();
	}

	@Override
	public void toJSONString(PrintWriter out) {
		out.println(data.toJSONString());
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDescription(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> listDescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addProperty(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addToSetProperty(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult removeProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVertex getVertex(IDirection direction) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IEdge> getEdges(IDirection direction, String... labels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IVertex> getVertices(IDirection direction, String... labels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEdge addEdge(String label, IVertex inVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addIEdge(IEdge edge) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addIVertex(IVertex vertex) throws Exception {
		// TODO Auto-generated method stub
		
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
	
	
	/////////////////////////////////
	// SQL Support
	/////////////////////////////////

}

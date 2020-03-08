/**
 * 
 */
package org.topicquests.os.graph;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.topicquests.os.graph.api.IDirection;
import org.topicquests.os.graph.api.IEdge;
import org.topicquests.os.graph.api.IGraphNode;
import org.topicquests.os.graph.api.INode;
import org.topicquests.os.graph.api.ISQLQueries;
import org.topicquests.os.graph.api.IVertex;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
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
		data.put(INode.ID_KEY, id);
	}

	@Override
	public String getId() {
		return data.getAsString(INode.ID_KEY);
	}

	@Override
	public void setLabel(String label, String language) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDescription(String description, String language) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> listDescriptions(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addProperty(String key, Object value) {
		IResult result = new ResultPojo();
		String sql = ISQLQueries.GET_PROPERTY;
      	IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
        	conn = provider.getConnection();
           	conn.setProxyRole(r);
           	//TODO this has to deal with lists, booleans, numbers
           	addProperty(conn, key, (String)value, sql, result);
	    } catch (Exception e) {
	    	result.addErrorString(e.getMessage());
	    	environment.logError(e.getMessage(), e);
	    }
		return result;
	}
	
	void addProperty(IPostgresConnection conn, String key, String value, String sql, IResult result) throws Exception {
    	Object [] vals = new Object[3];
    	vals[0] = this.getId();
    	vals[1] = key;
    	vals[2] = value;
    	conn.executeSQL(sql, result, vals);
	}

	@Override
	public IResult addToSetProperty(String key, String value) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult getValue(String key) {
		IResult result = new ResultPojo();
		Object o = data.get(key);
		if (o == null) {
			String sql = ISQLQueries.GET_PROPERTY;
	      	IPostgresConnection conn = null;
		    IResult r = new ResultPojo();
		    try {
	        	conn = provider.getConnection();
	           	conn.setProxyRole(r);
	           	result = getValue(conn, key, sql, r);
		    } catch (Exception e) {
		    	result.addErrorString(e.getMessage());
		    	environment.logError(e.getMessage(), e);
		    }
		} else
			result.setResultObject(o);
		return result;
	}
	
	/**
	 * Returns either {@code null}, a {@code String} or a {@code List}
	 * @param conn
	 * @param key
	 * @param sql
	 * @param r
	 * @return
	 * @throws Exception
	 */
	IResult getValue(IPostgresConnection conn, String key, String sql, IResult r) throws Exception {
		IResult result = new ResultPojo();
    	Object [] vals = new Object[2];
    	vals[0] = this.getId();
    	vals[1] = key;
    	conn.executeSelect(sql, r, vals);
        ResultSet rs = (ResultSet)r.getResultObject();
    	List<String> l = new ArrayList<String>();
        if (rs != null) {
        	while (rs.next()) {
        		l.add(rs.getString(1));
        	}
        }
        if (!l.isEmpty()) {
        	if (l.size() == 1)
        		result.setResultObject(l.get(0));
        	else
        		result.setResultObject(l);
        }
		return result;
	}

	@Override
	public IResult removeProperty(String key) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
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

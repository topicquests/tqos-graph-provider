/**
 * 
 */
package org.topicquests.os.graph;

import java.util.*;

import org.topicquests.os.graph.api.IGraph;
import org.topicquests.os.graph.api.IGraphModel;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SQLGraphModel implements IGraphModel {
	private GraphEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * @param env
	 */
	public SQLGraphModel(GraphEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}

	@Override
	public IGraph createGraph(String id, String description, String language, String creatorId) {
		IGraph result = null;
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IGraph getGraph(String id) {
		IGraph result = null;
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult removeGraph(String id) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult findByKeyValuePairs(Map<String, String> properties) {
		IResult result = new ResultPojo();
		List<IGraph> graphs = new ArrayList<IGraph>();
		result.setResultObject(graphs);
		// TODO Auto-generated method stub
		return result;
	}

}

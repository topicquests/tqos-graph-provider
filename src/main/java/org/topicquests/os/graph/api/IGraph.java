/**
 * 
 */
package org.topicquests.os.graph.api;

import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * <p>The primary Graph API</p>
 * <p>Most code adapted from TinkerPop Blueprints</p>
 * <p><em>NOTE</em><br/>
 * There are several ways to think about this:
 * <ol><li>Database has separate Vertices and Edges table, in which case
 * <em>identifiers</em> must reveal whether a node is an edge</li>
 * <li>Database has two tables: nodes, and properties, in which case,
 *  {@code getVertex} and {@code getEdge} all go to the same table</li></ol>
 *  </p>
 */
public interface IGraph {

    ////////////////////
    // API from TinkerPop Blueprints with some slight modifications
	// These are all SQL queries which can throw exceptions
    ////////////////////

    /**
     * Create a new vertex, add it to the graph, and return the newly created vertex.
     * The provided object identifier is a recommendation for the identifier to use.
     * It is not required that the implementation use this identifier.
     *
     * @param id the recommended object identifier
     * @return the newly created vertex
     * @throws
     */
    public IVertex addIVertex(String id) throws Exception;

    /**
     * Return the vertex referenced by the provided object identifier.
     * If no vertex is referenced by that identifier, then return null.
     *
     * @param id the identifier of the vertex to retrieved from the graph
     * @throws
     */
    public IVertex getIVertex(String id) throws Exception;

    /**
     * Remove the provided vertex from the graph.
     * Upon removing the vertex, all the edges by which the vertex is connected must be removed as well.
     *
     * @param vertex the vertex to remove from the graph
     * @throws
     */
    public void removeIVertex(IVertex vertex) throws Exception;

    /**
     * Return an iterable to all the vertices in the graph.
     * If this is not possible for the implementation, then an UnsupportedOperationException can be thrown.
     *
     * @return an iterable reference to all vertices in the graph
     * @throws
     */
    public Iterable<IVertex> getVertices() throws Exception;

    /**
     * Return an iterable to all the vertices in the graph that have a particular key/value property.
     * If this is not possible for the implementation, then an UnsupportedOperationException can be thrown.
     * The graph implementation should use indexing structures to make this efficient else a full vertex-filter scan is required.
     *
     * @param key   the key of vertex
     * @param value the value of the vertex
     * @return an iterable of vertices with provided key and value
     * @throws
     */
    public Iterable<IVertex> getVertices(String key, Object value) throws Exception;

    /**
     * Add an edge to the graph. The added edges requires a recommended identifier, a tail vertex, an head vertex, and a label.
     * Like adding a vertex, the provided object identifier may be ignored by the implementation.
     *
     * @param id        the recommended object identifier
     * @param outIVertex the vertex on the tail of the edge
     * @param inIVertex  the vertex on the head of the edge
     * @param label     the label associated with the edge
     * @return the newly created edge
     * @throws
     */
    public IEdge addIEdge(String id, IVertex outIVertex, IVertex inIVertex, String label) throws Exception;

    /**
     * Return the edge referenced by the provided object identifier.
     * If no edge is referenced by that identifier, then return null.
     *
     * @param id the identifier of the edge to retrieved from the graph
     * @return the edge referenced by the provided identifier or null when no such edge exists
     * @throws
     */
    public IEdge getIEdge(String id) throws Exception;

    /**
     * Remove the provided edge from the graph.
     *
     * @param edge the edge to remove from the graph
     * @throws
     */
    public void removeIEdge(IEdge edge) throws Exception;

    /**
     * Return an iterable to all the edges in the graph.
     * If this is not possible for the implementation, then an UnsupportedOperationException can be thrown.
     *
     * @return an iterable reference to all edges in the graph
     * @throws
     */
    public Iterable<IEdge> getIEdges() throws Exception;

    /**
     * Return an iterable to all the edges in the graph that have a particular key/value property.
     * If this is not possible for the implementation, then an UnsupportedOperationException can be thrown.
     * The graph implementation should use indexing structures to make this efficient else a full edge-filter scan is required.
     *
     * @param key   the key of the edge
     * @param value the value of the edge
     * @return an iterable of edges with provided key and value
     * @throws
     */
    public Iterable<IEdge> getIEdges(String key, Object value) throws Exception;
    
    ////////////////////
    // Added API
    ////////////////////
    
    boolean nodeExists(IPostgresConnection conn, String vertexId, IResult r);
    
    String getNodePropertyValue(IPostgresConnection conn, String id, String key, IResult r);
    
    
    void addToNodeSetProperty(IPostgresConnection conn, String nodeId, String key, String value, IResult r);
       
    IVertex addVertex(IPostgresConnection conn, String id, String label, IResult r);
    
    /**
     * Create an Edge between to vertices
     * <p><em>Note</em>: there is an issue of duplicate Edges
     * in terms of the inVertex-label-outVertex characteristics</p>
     * <p>In the single-table database, we would use two property rows for the two vertexIds
     * and a join to the label table.<br/>
     * This argues for an edge table which has four cols:<br/>
     * <ol><li>inVertexId</li>
     * <li>label</li>
     * <li>language</li>
     * <li>outVertexId</li></ol></p>
     * @param conn
     * @param id
     * @param outVertexId
     * @param inVertexId
     * @param label
     * @param r
     * @return
     */
    IEdge addEdge(IPostgresConnection conn, String id, String outVertexId, String inVertexId, 
    		String label, IResult r);
    
    INode getNode(String id) throws Exception;

    INode getNode(IPostgresConnection conn, String id, IResult r);
    
    /**
     * Locate graph nodes in this graph by full text search
     * @param labelText
     * @param descriptionText
     * @return
     */
    IResult fullTextSearch(String labelText, String descriptionText);
    
    ////////////////////
    // Custom Queries
    // Allows this database to gain extended capabilities
    ////////////////////
    /**
     * Returns a {@code java.sql.ResultSet}
     * @param sqlQuery
     * @param values go with the query - can be {@code null} or Object [] array
     * @return
     */
    IResult executeSQL(String sqlQuery, Object... values);

    void executeSQL(IPostgresConnection conn, String sqlQuery, IResult r, Object... values);


}

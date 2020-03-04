/**
 * 
 */
package org.topicquests.os.graph.api;

/**
 * @author jackpark
 *	This should serve the needs of Conceptual Graph nodes
 */
public interface IGraphNode extends INode {

	/**
     * Add an {@code IVertex} to this graph node
     *
     * @param id the recommended object identifier
     * @return the newly created vertex
     * @throws
     */
    public void addIVertex(IVertex vertex) throws Exception;

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
     * @param edge
     * @throws
     */
    public void addIEdge(IEdge edge) throws Exception;

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
}

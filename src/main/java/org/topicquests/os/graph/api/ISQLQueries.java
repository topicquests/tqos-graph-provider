/**
 * 
 */
package org.topicquests.os.graph.api;

/**
 * @author jackpark
 *
 */
public interface ISQLQueries {
/**
A Vertex isA Node
DO NOT NEED label here
tq_graph.nodes (
	id text NOT NULL PRIMARY KEY,
	label text NOT NULL
);
tq_graph.node_properties (
	node_id text NOT NULL,
	key text NOT NULL,
	value TEXT,
	CONSTRAINT fk_node FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);
tq_graph.lang_labels (
	node_id text NOT NULL,
	label text NOT NULL,
	language varchar (3) NOT NULL,
	CONSTRAINT fk_node_l FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);
tq_graph.lang_descriptions (
	node_id text NOT NULL,
	description tsvector NOT NULL,
	language varchar (3) NOT NULL,
	CONSTRAINT fk_node_d FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);
An Edge isA Vertex isA Node
It just adds the inVertexId and outVertexId
IT MIGHT BE THAT LABEL DOES NOT NEED TO BE HERE
WE HAVE A LABEL TABEL
AND EDGES CAN HAVE DESCRIPTIONS AND PROPERTIES just like nodes
tq_graph.edges (
	node_id text NOT NULL,
	inVertexId text NOT NULL,
	label text NOT NULL,
	outVertexId text NOT NULL
	CONSTRAINT fk_node_e FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);
 */
	
	public static final String INSERT_NODE =
			"INSERT INTO tq_graph.nodes ( id ) VALUES ( ? )";
	
	public static final String GET_NODE =
			"SELECT * tq_graph.node_properties WHERE node_id=?"; //TODO there's more BAD
	
	public static final String GET_PROPERTY =
			"SELECT value FROM tq_graph.node_properties WHERE node_id=? AND key=?";
	
	public static final String INSERT_PROPERTY =
			"INSERT INTO tq_graph.node_properties (node_id, key, value) VALUES ( ?, ?, ? )";
}

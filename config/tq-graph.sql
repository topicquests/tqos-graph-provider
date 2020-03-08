--
-- Create a schema to hide the  tables from public view.
-- This builds on the established roles from the tq schema
--
CREATE SCHEMA IF NOT EXISTS tq_graph;
GRANT ALL ON schema tq_graph TO tq_proxy;
GRANT USAGE ON schema tq_graph TO tq_proxy_ro;

CREATE TABLE IF NOT EXISTS 
tq_graph.nodes (
	id text NOT NULL PRIMARY KEY
);

GRANT ALL PRIVILEGES ON tq_graph.nodes TO tq_proxy;
GRANT SELECT ON tq_graph.nodes TO tq_proxy_ro;

CREATE INDEX IF NOT EXISTS idx_node_ids
	ON tq_graph.nodes (id);


CREATE TABLE IF NOT EXISTS 
tq_graph.lang_labels (
	node_id text NOT NULL,
	label text NOT NULL,
	language varchar (3) NOT NULL,
	CONSTRAINT fk_node_l FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);

GRANT ALL PRIVILEGES ON tq_graph.lang_labels TO tq_proxy;
GRANT SELECT ON tq_graph.lang_labels TO tq_proxy_ro;
CREATE INDEX IF NOT EXISTS tsv_node_id_idx ON tq_graph.lang_labels (node_id);

CREATE INDEX IF NOT EXISTS tsv_label_idx ON tq_graph.lang_labels (left(label, 200));
CREATE INDEX IF NOT EXISTS tsv_lang_idx ON tq_graph.lang_labels (language);

CREATE TABLE IF NOT EXISTS 
tq_graph.lang_descriptions (
	node_id text NOT NULL,
	description text NOT NULL,
	language varchar (3) NOT NULL,
	CONSTRAINT fk_node_d FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);

GRANT ALL PRIVILEGES ON tq_graph.lang_descriptions TO tq_proxy;
GRANT SELECT ON tq_graph.lang_descriptions TO tq_proxy_ro;
CREATE INDEX IF NOT EXISTS tsx_node_id_idx ON tq_graph.lang_descriptions (node_id);

CREATE INDEX IF NOT EXISTS tsx_desc_idx ON tq_graph.lang_descriptions (left(description, 200);
CREATE INDEX IF NOT EXISTS tsx_lang_idx ON tq_graph.lang_descriptions (language);

CREATE TABLE IF NOT EXISTS 
tq_graph.node_properties (
	node_id text NOT NULL,
	key text NOT NULL,
	value TEXT,
	CONSTRAINT fk_node FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);


GRANT ALL PRIVILEGES ON tq_graph.node_properties TO tq_proxy;
GRANT SELECT ON tq_graph.node_properties TO tq_proxy_ro;

CREATE INDEX IF NOT EXISTS idx_node_properties 
	ON tq_graph.node_properties (node_id);
CREATE INDEX IF NOT EXISTS idx_node_properties_1 
	ON tq_graph.node_properties (key);
CREATE INDEX IF NOT EXISTS idx_node_properties_2
	ON tq_graph.node_properties (left(value, 200));
	
CREATE TABLE IF NOT EXISTS 
tq_graph.edges (
	node_id text NOT NULL,
	inVertexId text NOT NULL,
	label text NOT NULL,
	outVertexId text NOT NULL
	CONSTRAINT fk_node_e FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
		ON DELETE CASCADE
);

GRANT ALL PRIVILEGES ON tq_graph.edges TO tq_proxy;
GRANT SELECT ON tq_graph.edges TO tq_proxy_ro;

CREATE INDEX IF NOT EXISTS idx_edge_invert
	ON tq_graph.edges (inVertexId);

CREATE INDEX IF NOT EXISTS idx_edge_outvert
	ON tq_graph.edges (outVertexId);

--
-- prevent duplicates
--
CREATE UNIQUE INDEX if not exists idx_edges_uniq
    ON tq_graph.edges (inVertexId, outVertexId, label);
	
	
CREATE TABLE IF NOT EXISTS 
tq_graph.util_1 (
	node_id text NOT NULL,
	key text NOT NULL,
	n text NOT NULL
	CONSTRAINT fk_node_1 FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
	ON DELETE CASCADE
);

GRANT ALL PRIVILEGES ON tq_graph.util_1 TO tq_proxy;
GRANT SELECT ON tq_graph.util_1 TO tq_proxy_ro;

CREATE INDEX IF NOT EXISTS idx_idx_util_1 
	ON tq_graph.node_properties (node_id);
CREATE INDEX IF NOT EXISTS idx_util_1_1
	ON tq_graph.node_properties (key);
CREATE INDEX IF NOT EXISTS idx_util_1_2
	ON tq_graph.node_properties (left(value, 200));

CREATE TABLE IF NOT EXISTS 
tq_graph.util_2 (
	node_id text NOT NULL,
	key text NOT NULL,
	n text NOT NULL
	CONSTRAINT fk_node_2 FOREIGN KEY (node_id) REFERENCES tq_graph.nodes (id)
	ON DELETE CASCADE
);

GRANT ALL PRIVILEGES ON tq_graph.util_2 TO tq_proxy;
GRANT SELECT ON tq_graph.util_2 TO tq_proxy_ro;

CREATE INDEX IF NOT EXISTS idx_idx_util_2 
	ON tq_graph.node_properties (node_id);
CREATE INDEX IF NOT EXISTS idx_util_2_1
	ON tq_graph.node_properties (key);
CREATE INDEX IF NOT EXISTS idx_util_2_2
	ON tq_graph.node_properties (left(value, 200));
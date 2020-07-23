CREATE KEYSPACE IF NOT EXISTS tags WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': 3
};

USE tags;
/*
CREATE TABLE tags (
  tag_name text,
  product_id int,
  content_id text,
  added_timestamp timestamp,

  PRIMARY KEY(product_id, content_id, tag_name)
);
*/
CREATE TABLE IF NOT EXISTS products (
  product_id int PRIMARY KEY,
  product_name text
);

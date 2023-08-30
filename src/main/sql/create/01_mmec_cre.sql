create table mmec.mmec
(
  mmec_id int,
  ontorel_ref_id text,
  source_ref_id text,
  last_modified timestamptz,
  primary key (mmec_id)
);
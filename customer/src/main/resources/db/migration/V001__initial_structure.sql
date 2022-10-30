CREATE TABLE customer
(
    id    BIGINT NOT NULL,
    first_name  VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    CONSTRAINT pk_cat PRIMARY KEY (id)
);

create sequence customer_id_sequence;
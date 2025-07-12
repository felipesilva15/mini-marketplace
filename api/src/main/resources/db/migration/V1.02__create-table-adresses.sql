CREATE TABLE IF NOT EXISTS addresses
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(80) NOT NULL,
    postal_code VARCHAR(8) NOT NULL,
    street VARCHAR(80) NOT NULL,
    locality VARCHAR(40) NOT NULL,
    city VARCHAR(60) NOT NULL,
    region VARCHAR(40) NOT NULL,
    region_code CHAR(2) NOT NULL,
    number VARCHAR(10) NOT NULL,
    complement VARCHAR(120) NULL,
    user_id BIGINT NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);
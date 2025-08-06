CREATE TABLE IF NOT EXISTS deposits
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(120) NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	created_at timestamp NULL,
    updated_at timestamp NULL
);

CREATE TABLE IF NOT EXISTS movements
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
    product_id BIGINT NOT NULL,
    deposit_id BIGINT NOT NULL,
    operation CHAR(1) NOT NULL,
    price DECIMAL(12,2) NULL,
    cost DECIMAL(12,2) NULL,
	observations TEXT NULL,
	created_at timestamp NULL,
    updated_at timestamp NULL
);
CREATE TABLE IF NOT EXISTS categories
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(120) NOT NULL,
	description TEXT NULL,
	created_at timestamp NULL,
    updated_at timestamp NULL
);

CREATE TABLE IF NOT EXISTS brands
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(120) NOT NULL,
	created_at timestamp NULL,
    updated_at timestamp NULL
);

CREATE TABLE IF NOT EXISTS products
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	sku VARCHAR(40) NOT NULL,
    name VARCHAR(255) NOT NULL,
	description TEXT NULL,
	observations TEXT NULL,
	unit_measurement CHAR(3) NULL,
	price DECIMAL(12,2) NULL,
	net_weight DECIMAL(10,3) NULL,
	gross_weight  DECIMAL(10,3) NULL,
	width DECIMAL(8,2) NULL,
	height DECIMAL(8,2) NULL,
	length DECIMAL(8,2) NULL,
	ean VARCHAR(14) NULL,
	minimum_stock DECIMAL (10, 2) NULL,
	maximum_stock DECIMAL (10, 2) NULL,
	production_type CHAR(2),
	brand_id BIGINT NULL,
	category_id BIGINT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	created_at timestamp NULL,
    updated_at timestamp NULL,
	FOREIGN KEY (brand_id) REFERENCES brands(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
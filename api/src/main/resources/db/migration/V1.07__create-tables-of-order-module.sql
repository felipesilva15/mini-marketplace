CREATE TABLE IF NOT EXISTS orders
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	user_id BIGINT NOT NULL,
	postal_code VARCHAR(8) NOT NULL,
    street VARCHAR(80) NOT NULL,
    locality VARCHAR(40) NOT NULL,
    city VARCHAR(60) NOT NULL,
    region VARCHAR(40) NOT NULL,
    region_code CHAR(2) NOT NULL,
    number VARCHAR(10) NOT NULL,
    complement VARCHAR(120) NULL,
	order_date DATE NOT NULL,
	status CHAR(1) NOT NULL,
	products_value DECIMAL(12,2) NOT NULL,
	shipping_cost DECIMAL(12,2) NULL,
	total DECIMAL(12,2) NOT NULL,
	created_at timestamp NULL,
    updated_at timestamp NULL
);

CREATE TABLE IF NOT EXISTS order_items
(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	product_id BIGINT NOT NULL,
	order_id BIGINT NOT NULL,
	quantity DECIMAL(12,2) NOT NULL,
	price DECIMAL(12,2) NOT NULL,
	total DECIMAL(12,2) NOT NULL,
	created_at timestamp NULL,
    updated_at timestamp NULL
);
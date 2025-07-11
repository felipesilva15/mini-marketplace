CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(80) NULL,
    email VARCHAR(254) NULL,
    password VARCHAR(254) NULL,
    document CHAR(11) NULL,
    created_at timestamp NULL,
    updated_at timestamp NULL
);
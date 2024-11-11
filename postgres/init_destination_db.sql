CREATE TABLE IF NOT EXISTS destinations (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    localisation VARCHAR(255) NOT NULL,
    picUrl VARCHAR(255)
);
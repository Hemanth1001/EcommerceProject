CREATE TABLE IF NOT EXISTS inventory (
    product_id INT PRIMARY KEY,
    available_quantity INT
);

INSERT INTO inventory (product_id, available_quantity) VALUES (1, 10);
INSERT INTO inventory (product_id, available_quantity) VALUES (2, 20);
INSERT INTO inventory (product_id, available_quantity) VALUES (3, 5);

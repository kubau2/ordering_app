DROP TABLE IF EXISTS Products;

CREATE TABLE Products (
                          ID int AUTO_INCREMENT  PRIMARY KEY,
                          Name varchar(255) NOT NULL,
                          Price number NOT NULL,
                          Amount int NOT NULL
);

-- -----------------------------------------------------
-- schema restaurant
-- -----------------------------------------------------
CREATE SCHEMA restaurant;

-- -----------------------------------------------------
-- table restaurant_table_area
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS restaurant_table_area
(
    id BIGINT NOT NULL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- table restaurant_table
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS restaurant_table
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    seats_number INT NOT NULL,
    reservable BOOLEAN NOT NULL,
    area_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_restaurant_table_restaurant_table_area
        FOREIGN KEY (area_id)
            REFERENCES restaurant_table_area (id)
);


-- -----------------------------------------------------
-- insert into the restaurant_table_area predefined records
-- -----------------------------------------------------
INSERT INTO restaurant_table_area(id,name) VALUES (1, 'Indoor');
INSERT INTO restaurant_table_area(id,name) VALUES (2, 'Outdoor');
INSERT INTO restaurant_table_area(id,name) VALUES (3, 'Terrace');
INSERT INTO restaurant_table_area(id,name) VALUES (4, 'Counter');



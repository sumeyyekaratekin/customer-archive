CREATE DATABASE customerArchive;
CREATE TABLE customerArchive.users(
id int NOT NULL AUTO_INCREMENT primary key,
username varchar(50) NOT NULL,
password varchar(50) NOT NUll,
claim varchar(50) NOT NULL
);

CREATE TABLE customerArchive.customers(
id int NOT NULL AUTO_INCREMENT primary key,
name varchar(50) NOT NULL,
email varchar(50) NOT NUll,
phone_number varchar(50) NOT NUll
);

CREATE TABLE customerArchive.files(
id varchar(250) NOT NULL primary key,
name varchar(250) NOT NULL,
type varchar(50) NOT NULL,
data blob NOT NULL,
customer_id int NULL,
FOREIGN KEY (customer_id) REFERENCES customers(id)
);


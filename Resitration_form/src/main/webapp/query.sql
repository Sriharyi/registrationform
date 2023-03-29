create database registration;

use database registration;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    gender VARCHAR(10) NOT NULL,
    dateofbirth DATE NOT NULL,
    role VARCHAR(20) NOT NULL,
    phonenumber VARCHAR(20) NOT NULL
);

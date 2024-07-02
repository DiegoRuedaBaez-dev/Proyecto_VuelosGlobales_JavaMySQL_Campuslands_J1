-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Database airport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Database airport
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS airport;
USE airport;

-- -----------------------------------------------------
-- Table document_types
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS document_types (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table customers
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS customers (
  id VARCHAR(20) NOT NULL,
  name VARCHAR(30) NOT NULL,
  age INT NOT NULL,
  id_document INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_customers_document_types
    FOREIGN KEY (id_document)
    REFERENCES document_types (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table flight_fares
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS flight_fares (
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(20) NOT NULL,
  details TEXT NOT NULL,
  value DOUBLE(7,3) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table trips
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS trips (
  id INT NOT NULL AUTO_INCREMENT,
  trip_date DATE NOT NULL,
  price_tripe DOUBLE NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table trip_booking
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS trip_booking (
  id INT NOT NULL AUTO_INCREMENT,
  date DATE NOT NULL,
  id_trips INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_trip_booking_trips
    FOREIGN KEY (id_trips)
    REFERENCES trips (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table trip_booking_details
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS trip_booking_details (
  id INT NOT NULL AUTO_INCREMENT,
  id_trip_booking INT NOT NULL,
  id_customers VARCHAR(20) NOT NULL,
  id_fares INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_trip_booking_details_customers
    FOREIGN KEY (id_customers)
    REFERENCES customers (id),
  CONSTRAINT FK_trip_booking_details_fares
    FOREIGN KEY (id_fares)
    REFERENCES flight_fares (id),
  CONSTRAINT FK_trip_booking_details_trip_booking
    FOREIGN KEY (id_trip_booking)
    REFERENCES trip_booking (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table airlines
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS airlines (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tripulation_roles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tripulation_roles (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table countries
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS countries (
  id VARCHAR(5) NOT NULL,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table cities
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cities (
  id VARCHAR(5) NOT NULL,
  name VARCHAR(30) NOT NULL,
  id_country VARCHAR(5) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_cities_countries
    FOREIGN KEY (id_country)
    REFERENCES countries (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table airports
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS airports (
  id VARCHAR(5) NOT NULL,
  name VARCHAR(50) NOT NULL,
  id_city VARCHAR(5) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_airports_cities
    FOREIGN KEY (id_city)
    REFERENCES cities (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table employees
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS employees (
  id VARCHAR(20) NOT NULL,
  name VARCHAR(40) NOT NULL,
  id_rol INT NOT NULL,
  ingress_date DATE NOT NULL,
  id_airline INT NOT NULL,
  id_airport VARCHAR(5) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_employees_airlines
    FOREIGN KEY (id_airline)
    REFERENCES airlines (id),
  CONSTRAINT FK_employees_tripulation_roles
    FOREIGN KEY (id_rol)
    REFERENCES tripulation_roles (id),
  CONSTRAINT FK_employees_airport
    FOREIGN KEY (id_airport)
    REFERENCES airports (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table revisions_details
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS revisions_details (
  id VARCHAR(20) NOT NULL,
  descriptions TEXT NOT NULL,
  id_employee VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_revisions_details_employees
    FOREIGN KEY (id_employee)
    REFERENCES employees (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table gates
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gates (
  id INT NOT NULL AUTO_INCREMENT,
  gatenumber VARCHAR(10) NOT NULL,
  id_airport VARCHAR(5) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_gates_airports
    FOREIGN KEY (id_airport)
    REFERENCES airports (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table manufacturers
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS manufacturers (
  id INT NOT NULL,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table models
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS models (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  manufactured_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_models_manufacturer
    FOREIGN KEY (manufactured_id)
    REFERENCES manufacturers (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table statuses
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS statuses (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table planes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS planes (
  id INT NOT NULL,
  plates VARCHAR(30) NOT NULL,
  capacity INT NOT NULL,
  fabrication_date DATE NOT NULL,
  id_status INT NOT NULL,
  id_model INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_planes_models
    FOREIGN KEY (id_model)
    REFERENCES models (id),
  CONSTRAINT FK_planes_status
    FOREIGN KEY (id_status)
    REFERENCES statuses (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table trip_status
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS trip_status (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table connections
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS connections (
  id INT NOT NULL AUTO_INCREMENT,
  connection_number VARCHAR(20) NOT NULL,
  id_trip INT NOT NULL,
  id_plane INT NOT NULL,
  id_airport VARCHAR(5) NOT NULL,
  id_trip_status INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_connections_airports
    FOREIGN KEY (id_airport)
    REFERENCES airports (id),
  CONSTRAINT FK_connections_trip
    FOREIGN KEY (id_trip)
    REFERENCES trips (id),
  CONSTRAINT FK_connections_plane
    FOREIGN KEY (id_plane)
    REFERENCES planes (id),
  CONSTRAINT FK_connections_trip_status
    FOREIGN KEY (id_trip_status)
    REFERENCES trip_status (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table trip_crews
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS trip_crews (
  id_employees VARCHAR(20) NOT NULL,
  id_connection INT NOT NULL,
  PRIMARY KEY (id_employees, id_connection),
  CONSTRAINT FK_trip_crews_employees
    FOREIGN KEY (id_employees)
    REFERENCES employees (id),
  CONSTRAINT FK_trip_crews_connection
    FOREIGN KEY (id_connection)
    REFERENCES connections (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table revisions
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS revisions (
  id INT NOT NULL AUTO_INCREMENT,
  revisions_date DATE NOT NULL,
  id_plane INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_revisions_planes
    FOREIGN KEY (id_plane)
    REFERENCES planes (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table rev_employee
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rev_employee (
  id_employee VARCHAR(20) NOT NULL,
  id_revision INT NOT NULL,
  PRIMARY KEY (id_employee, id_revision),
  CONSTRAINT FK_rev_employee_employee
    FOREIGN KEY (id_employee)
    REFERENCES employees (id),
  CONSTRAINT FK_rev_employee_revision
    FOREIGN KEY (id_revision)
    REFERENCES revisions (id))
ENGINE = InnoDB;
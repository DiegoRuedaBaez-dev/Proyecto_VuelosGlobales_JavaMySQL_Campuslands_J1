-- Inserts para document_types
INSERT INTO document_types (name) VALUES 
('DNI'),
('Pasaporte'),
('Carné de identidad'),
('Licencia de conducir'),
('Visa');

-- Inserts para airlines
INSERT INTO airlines (name) VALUES 
('Aerolíneas Argentinas'),
('Avianca'),
('LATAM Airlines'),
('Iberia'),
('American Airlines'),
('Delta Air Lines'),
('United Airlines'),
('Air France'),
('Lufthansa'),
('British Airways');

-- Inserts para tripulation_roles
INSERT INTO tripulation_roles (name) VALUES 
('Piloto'),
('Copiloto'),
('Ingeniero de Vuelo'),
('Asistente de Vuelo'),
('Jefe de Cabina'),
('Mecánico de Aviación'),
('Oficial de Seguridad'),
('Supervisor de Servicio al Cliente'),
('Despachador de Vuelo'),
('Instructor de Vuelo');

-- Inserts para countries
INSERT INTO countries (id, name) VALUES 
('ARG', 'Argentina'),
('BRA', 'Brasil'),
('CHL', 'Chile'),
('COL', 'Colombia'),
('MEX', 'México'),
('USA', 'Estados Unidos'),
('CAN', 'Canadá'),
('ESP', 'España'),
('FRA', 'Francia'),
('GER', 'Alemania');

-- Inserts para cities
INSERT INTO cities (id, name, id_country) VALUES 
('BSAS', 'Buenos Aires', 'ARG'),
('RIO', 'Río de Janeiro', 'BRA'),
('SCL', 'Santiago', 'CHL'),
('BOG', 'Bogotá', 'COL'),
('MEX', 'Ciudad de México', 'MEX'),
('NYC', 'Nueva York', 'USA'),
('YTO', 'Toronto', 'CAN'),
('MAD', 'Madrid', 'ESP'),
('PAR', 'París', 'FRA'),
('BER', 'Berlín', 'GER');

-- Inserts para airports
INSERT INTO airports (id, name, id_city) VALUES 
('EZE', 'Aeropuerto Internacional Ministro Pistarini', 'BSAS'),
('GIG', 'Aeropuerto Internacional Galeão', 'RIO'),
('SCL', 'Aeropuerto Internacional Arturo Merino Benítez', 'SCL'),
('BOG', 'Aeropuerto Internacional El Dorado', 'BOG'),
('MEX', 'Aeropuerto Internacional Benito Juárez', 'MEX'),
('JFK', 'Aeropuerto Internacional John F. Kennedy', 'NYC'),
('YYZ', 'Aeropuerto Internacional Toronto Pearson', 'YTO'),
('MAD', 'Aeropuerto Adolfo Suárez Madrid-Barajas', 'MAD'),
('CDG', 'Aeropuerto Charles de Gaulle', 'PAR'),
('TXL', 'Aeropuerto de Berlín-Tegel', 'BER');

-- Inserts para employees
INSERT INTO employees (id, name, id_rol, ingress_date, id_airline, id_airport) VALUES 
('EMP001', 'Juan Pérez', 1, '2020-01-15', 1, 'EZE'),
('EMP002', 'María López', 2, '2019-05-20', 2, 'GIG'),
('EMP003', 'Carlos García', 3, '2021-02-10', 3, 'SCL'),
('EMP004', 'Ana Martínez', 4, '2018-09-01', 1, 'BOG'),
('EMP005', 'Pedro Sánchez', 5, '2022-03-05', 2, 'MEX'),
('EMP006', 'Laura Rodríguez', 6, '2017-11-12', 3, 'JFK'),
('EMP007', 'José Fernández', 7, '2019-08-25', 1, 'YYZ'),
('EMP008', 'Lucía Gómez', 8, '2020-04-30', 2, 'MAD'),
('EMP009', 'Javier Díaz', 9, '2023-01-02', 3, 'CDG'),
('EMP010', 'Sofía Ramírez', 10, '2021-06-18', 1, 'TXL');

-- Inserts para trip_status
INSERT INTO trip_status (name) VALUES 
('Programado'),
('En curso'),
('Finalizado'),
('Cancelado'),
('Atrasado'),
('Desviado'),
('En espera'),
('Divertido'),
('Abordando'),
('En tierra');

-- Inserts para gates
INSERT INTO gates (gatenumber, id_airport) VALUES 
('Gate A1', 'EZE'),
('Gate B2', 'GIG'),
('Gate C3', 'SCL'),
('Gate D4', 'BOG'),
('Gate E5', 'MEX'),
('Gate F6', 'JFK'),
('Gate G7', 'YYZ'),
('Gate H8', 'MAD'),
('Gate I9', 'CDG'),
('Gate J10', 'TXL');

-- Inserts para planes
INSERT INTO planes (id, plates, capacity, fabrication_date, id_status, id_model) VALUES 
(1, 'LV-FNI', 150, '2018-05-20', 1, 1),
(2, 'PT-ABC', 180, '2019-10-15', 2, 2),
(3, 'CC-PQR', 200, '2017-03-10', 1, 3),
(4, 'MX-123', 170, '2020-07-01', 2, 1),
(5, 'US-456', 160, '2016-12-05', 1, 2);

-- Inserts para connections
INSERT INTO connections (connection_number, id_trip, id_plane, id_airport, id_trip_status) VALUES 
('CON001', 1, 1, 'EZE', 1),
('CON002', 2, 2, 'GIG', 2),
('CON003', 3, 3, 'SCL', 3),
('CON004', 4, 4, 'BOG', 4),
('CON005', 5, 5, 'MEX', 5),
('CON006', 6, 1, 'JFK', 1),
('CON007', 7, 2, 'YYZ', 2),
('CON008', 8, 3, 'MAD', 3),
('CON009', 9, 4, 'CDG', 4),
('CON010', 10, 5, 'TXL', 5);

-- Inserts para rev_employee
INSERT INTO rev_employee (id_employee, id_revision) VALUES 
('EMP001', 1),
('EMP002', 2),
('EMP003', 3),
('EMP004', 4),
('EMP005', 5),
('EMP006', 6),
('EMP007', 7),
('EMP008', 8),
('EMP009', 9),
('EMP010', 10);
-- Inserts para statuses
INSERT INTO statuses (name) VALUES
('Active'),
('Inactive'),
('Maintenance'),
('Scheduled'),
('Delayed');
-- Inserts para models
INSERT INTO models (name, manufactured_id) VALUES
('Boeing 737', 1),
('Airbus A320', 2),
('Embraer E175', 3),
('Bombardier CRJ900', 4),
('Boeing 787', 1),
('Airbus A350', 2),
('Embraer E190', 3),
('Bombardier Dash 8 Q400', 4),
('Boeing 747', 1),
('Airbus A380', 2);
-- Inserts para manufacturers
INSERT INTO manufacturers (id, name) VALUES
(1, 'Boeing'),
(2, 'Airbus'),
(3, 'Embraer'),
(4, 'Bombardier');
-- Create databases
CREATE DATABASE IF NOT EXISTS demo_auth_db;
CREATE DATABASE IF NOT EXISTS demo_resource_db;

-- Create users and assign privileges to the databases
CREATE USER IF NOT EXISTS 'demo_auth'@'%' IDENTIFIED BY 'demo_auths_password';
CREATE USER IF NOT EXISTS 'demo_resource'@'%' IDENTIFIED BY 'demo_resources_password';

-- Grant privileges on the databases to users
GRANT ALL PRIVILEGES ON demo_auth_db.* TO 'demo_auth'@'%';
GRANT ALL PRIVILEGES ON demo_resource_db.* TO 'demo_resource'@'%';

CREATE USER 'auth_user'@'localhost' IDENTIFIED BY 'Auth@1234';
GRANT ALL PRIVILEGES ON demo_auth_db.* TO 'auth_user'@'localhost';
GRANT ALL PRIVILEGES ON demo_resource_db.* TO 'demo_resource'@'%';

INSERT INTO role (name) VALUES ('ROLE_USER');


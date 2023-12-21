DROP DATABASE IF EXISTS fm_kanban_db;
DROP USER IF EXISTS `admin`@`localhost`;

CREATE DATABASE fm_kanban_db;
CREATE USER `admin`@`localhost` IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON fm_kanban_db.* TO `admin`@`localhost`;
FLUSH PRIVILEGES;
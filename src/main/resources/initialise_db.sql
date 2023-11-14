DROP DATABASE IF EXISTS kanban_db;
DROP USER IF EXISTS `kanban_admin`@`localhost`;
DROP USER IF EXISTS `kanban_user`@`localhost`;

CREATE DATABASE kanban_db;
CREATE USER IF NOT EXISTS `kanban_admin`@`localhost` IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS `kanban_user`@`localhost` IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON kanban_db.* TO `kanban_admin`@`localhost`;
FLUSH PRIVILEGES;
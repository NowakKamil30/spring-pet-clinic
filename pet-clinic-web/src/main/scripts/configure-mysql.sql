
CREATE DATABASE pc_dev;
CREATE DATABASE pc_prod;


CREATE USER 'pc_dev_user'@'localhost' IDENTIFIED BY 'kamil';
CREATE USER 'pc_prod_user'@'localhost' IDENTIFIED BY 'kamil';
CREATE USER 'pc_dev_user'@'%' IDENTIFIED BY 'kamil';
CREATE USER 'pc_prod_user'@'%' IDENTIFIED BY 'kamil';


GRANT SELECT ON pc_dev.* to 'pc_dev_user'@'localhost';
GRANT INSERT ON pc_dev.* to 'pc_dev_user'@'localhost';
GRANT DELETE ON pc_dev.* to 'pc_dev_user'@'localhost';
GRANT UPDATE ON pc_dev.* to 'pc_dev_user'@'localhost';
GRANT SELECT ON pc_prod.* to 'pc_prod_user'@'localhost';
GRANT INSERT ON pc_prod.* to 'pc_prod_user'@'localhost';
GRANT DELETE ON pc_prod.* to 'pc_prod_user'@'localhost';
GRANT UPDATE ON pc_prod.* to 'pc_prod_user'@'localhost';
GRANT SELECT ON pc_dev.* to 'pc_dev_user'@'%';
GRANT INSERT ON pc_dev.* to 'pc_dev_user'@'%';
GRANT DELETE ON pc_dev.* to 'pc_dev_user'@'%';
GRANT UPDATE ON pc_dev.* to 'pc_dev_user'@'%';
GRANT SELECT ON pc_prod.* to 'pc_prod_user'@'%';
GRANT INSERT ON pc_prod.* to 'pc_prod_user'@'%';
GRANT DELETE ON pc_prod.* to 'pc_prod_user'@'%';
GRANT UPDATE ON pc_prod.* to 'pc_prod_user'@'%';

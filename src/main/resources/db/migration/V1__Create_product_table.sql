CREATE TABLE `dmall_product_db`.`product`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(100) NULL,
  `description` varchar(2000) NULL,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);
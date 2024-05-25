CREATE DATABASE IF NOT EXISTS `poseidon`
USE `poseidon`;

CREATE TABLE IF NOT EXISTS bidList (
  bidListId bigint NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  bidQuantity DOUBLE,
  askQuantity DOUBLE,
  bid DOUBLE ,
  ask DOUBLE,
  benchmark VARCHAR(125),
  bidListDate TIMESTAMP,
  commentary VARCHAR(125),
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  book VARCHAR(125),
  creationName VARCHAR(125),
  creationDate TIMESTAMP ,
  revisionName VARCHAR(125),
  revisionDate TIMESTAMP ,
  dealName VARCHAR(125),
  dealType VARCHAR(125),
  sourceListId VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (bidListId)
);

CREATE TABLE IF NOT EXISTS trade (
  tradeId bigint NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  buyQuantity DOUBLE,
  sellQuantity DOUBLE,
  buyPrice DOUBLE ,
  sellPrice DOUBLE,
  tradeDate TIMESTAMP,
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  benchmark VARCHAR(125),
  book VARCHAR(125),
  creationName VARCHAR(125),
  creationDate TIMESTAMP ,
  revisionName VARCHAR(125),
  revisionDate TIMESTAMP ,
  dealName VARCHAR(125),
  dealType VARCHAR(125),
  sourceListId VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (TradeId)
);

CREATE TABLE IF NOT EXISTS curvePoint (
  curvePointId bigint NOT NULL AUTO_INCREMENT,
  curveId bigint,
  asOfDate TIMESTAMP,
  term DOUBLE ,
  value DOUBLE ,
  creationDate TIMESTAMP ,

  PRIMARY KEY (curvePointId)
);

CREATE TABLE IF NOT EXISTS rating (
  ratingId bigint NOT NULL AUTO_INCREMENT,
  moodysRating VARCHAR(125),
  sandPRating VARCHAR(125),
  fitchRating VARCHAR(125),
  orderNumber tinyint,

  PRIMARY KEY (ratingId)
);

CREATE TABLE IF NOT EXISTS ruleName (
  ruleNameId bigint NOT NULL AUTO_INCREMENT,
  name VARCHAR(125),
  description VARCHAR(125),
  json VARCHAR(125),
  template VARCHAR(512),
  sqlStr VARCHAR(125),
  sqlPart VARCHAR(125),

  PRIMARY KEY (ruleNameId)
);

CREATE TABLE IF NOT EXISTS users (
  userId bigint NOT NULL AUTO_INCREMENT,
  username VARCHAR(125),
  password VARCHAR(125),
  fullname VARCHAR(125),
  role VARCHAR(125),

  PRIMARY KEY (userId)
);

insert into Users(fullname, username, password, role) values('Administrator', 'admin", '$2a$12$a5KuvsOJZ64quL1aeuK1UOoF.Q/HqaHGxamnjPIgHxY9hXDm1g.LW', 'ADMIN);
insert into Users(fullname, username, password, role) values('User', 'user', '$2a$12$CWWqw5GsIu9rkr8VeXTOmOBj/biwz4VcVHtr74cLv6SCoNytwnHgi', 'USER');

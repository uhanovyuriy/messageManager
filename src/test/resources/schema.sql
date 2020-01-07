DROP TABLE user_roles
IF EXISTS;
DROP TABLE history_requests
IF EXISTS;
DROP TABLE users
IF EXISTS;
DROP TABLE companies
IF EXISTS;
DROP SEQUENCE global_seq
IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
  id            INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name          VARCHAR(255)            NOT NULL,
  email         VARCHAR(255)            NOT NULL,
  company_id    INTEGER                 NOT NULL,
  password      VARCHAR(255)            NOT NULL,
  registered    TIMESTAMP DEFAULT now() NOT NULL,
  enabled       BOOLEAN DEFAULT TRUE    NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE companies
(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name       VARCHAR(255)            NOT NULL,
  email      VARCHAR(255),
  address    VARCHAR(255)
);
CREATE UNIQUE INDEX companies_unique_email_idx
  ON companies (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);

CREATE TABLE history_requests
(
  id                INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  user_id           INTEGER   NOT NULL,
  date_time_request TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);
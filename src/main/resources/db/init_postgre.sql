DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS history_requests;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ
  AS INTEGER
  START WITH 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR(255)            NOT NULL,
  email      VARCHAR(255)            NOT NULL,
  company    VARCHAR(255)            NOT NULL,
  password   VARCHAR(255)            NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL,
  enabled    BOOLEAN DEFAULT TRUE    NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

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
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id           INTEGER   NOT NULL,
  date_time_request TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);
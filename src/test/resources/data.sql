DELETE FROM "PUBLIC"."PUBLIC".COMPANIES;
DELETE FROM "PUBLIC"."PUBLIC".USERS;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO "PUBLIC"."PUBLIC".COMPANIES (name, email, address) VALUES
  ('Company 1', 'company_1@gmail.com', 'company_1_address'),
  ('Company 2', 'company_2@gmail.com', 'company_2_address');

INSERT INTO "PUBLIC"."PUBLIC".USERS (name, email, company_id, password) VALUES
  ('user_1', 'user_1@gmail.com', 100000, 'user_1_password'),
  ('user_2', 'user_2@gmail.com', 100000, 'user_2_password');
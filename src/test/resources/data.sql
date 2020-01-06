DELETE FROM "PUBLIC"."PUBLIC".COMPANIES;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO "PUBLIC"."PUBLIC".COMPANIES (name, email, address, password, enabled) VALUES
  ('Company 1', 'company_1@gmail.com', 'company_1_address', 'company_1_password', true),
  ('Company 2', 'company_2@gmail.com', 'company_2_address', 'company_2_password', true);
--   ('company_3', 'company_3@gmail.com', 'company_3_address', 'company_3_password', true);
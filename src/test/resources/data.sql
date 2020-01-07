DELETE FROM "PUBLIC"."PUBLIC".COMPANIES;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO "PUBLIC"."PUBLIC".COMPANIES (name, email, address) VALUES
  ('Company 1', 'company_1@gmail.com', 'company_1_address'),
  ('Company 2', 'company_2@gmail.com', 'company_2_address');
INSERT INTO USERS (user_name, email, password, name, last_name, user_role, crated_at, created_by, active) VALUES
('user', 'user@domain.com', 'password', null, null, 'ROLE_USER', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('gjozef', 'gjozef84@gmail.com', 'THDWTKAqS4zqc7Je8jCAN6pXFnyalCflqnj.pEHI.iyLWie', 'Grzegorz', 'Jozefowicz', 'ROLE_USER', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE');

INSERT INTO DEVICE_CATEGORY (name, crated_at, created_by, active) VALUES
('LODÓWKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('TELEWIZOR', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('PIEKARNIK', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('PŁYTA INDYKCYJNA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('MAŁE AGD', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('ODKURZACZ', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('ŻELAZKO', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('MIKROFALÓWKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('ZMYWARKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('ZAMRAŻARKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('EKSPRES DO KAWY', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('RADIO', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('PRALKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('SUSZARKA', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE');

INSERT INTO DEVICE (name, id_device_category, status, crated_at, created_by, active) VALUES
('Whirlpool W7 921O OX', (SELECT id FROM device_category WHERE name='LODÓWKA'), 'SPRAWNY', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('Samsung RB31FERNCSA', (SELECT id FROM device_category WHERE name='LODÓWKA'), 'SPRAWNY', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('Philips 55PUS6754/12', (SELECT id FROM device_category WHERE name='TELEWIZOR'), 'SPRAWNY', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE'),
('Samsung UE55RU7472U', (SELECT id FROM device_category WHERE name='TELEWIZOR'), 'SPRAWNY', '2020-01-01 00:00:00', 'SYSTEM', 'TRUE');


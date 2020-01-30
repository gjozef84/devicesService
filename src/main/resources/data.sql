insert into USERS (user_name, email, password, name, last_name, user_role, created_at, created_by, active) values
('user', 'user@domain.com', 'password', null, null, 'ROLE_USER', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('gjozef', 'gjozef84@gmail.com', 'THDWTKAqS4zqc7Je8jCAN6pXFnyalCflqnj.pEHI.iyLWie', 'Grzegorz', 'Jozefowicz', 'ROLE_USER', '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

insert into DEVICE_CATEGORY (name, created_at, created_by, active) values
('LODÓWKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('TELEWIZOR', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('PIEKARNIK', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('PŁYTA INDYKCYJNA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('MAŁE AGD', '2020-01-01 00:00:00', 'ADMIN', 'FALSE'),
('ODKURZACZ', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('ŻELAZKO', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('MIKROFALÓWKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('ZMYWARKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('ZAMRAŻARKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('EKSPRES DO KAWY', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('RADIO', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('PRALKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('SUSZARKA', '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

insert into DEVICE (name, description, id_device_category, status, created_at, created_by, active) values
('Whirlpool W7 921O OX', 'Zawsze idealne warunki do przechowywania żywności', (select id from device_category where name='LODÓWKA'), 'SPRAWNY', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Samsung RB31FERNCSA', 'Przechowuj produkty w komorze świeżości i zachowuj ich witalność', (select id from device_category where name='LODÓWKA'), 'SPRAWNY', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Philips 55PUS6754/12', 'Przenieś emocje do dowolnego pomieszczenia w swoim domu. Ten telewizor Philips, został zaprojektowany tak, aby wyglądał świetnie, gdziekolwiek go postawisz', (select id from device_category where name='TELEWIZOR'), 'SPRAWNY', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Samsung UE55RU7472U', 'Subtelnie dopełni Twoje wnętrze w eleganckim stylu. Telewizor nie będzie już przeszkodą w aranżacji mieszkania, stanie się jego dekoracyjnym elementem', (select id from device_category where name='TELEWIZOR'), 'SPRAWNY', '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

insert into COMMENTS (content, id_device, created_at, created_by, active) values
('Bardzo udany model, bardzo funkcjonalny', (select id from device where name='Whirlpool W7 921O OX'), '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Super lodówka, bardzo cicha i oszczędna', (select id from device where name='Whirlpool W7 921O OX'), '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Mega słaba lodówka, niepolecam', (select id from device where name='Whirlpool W7 921O OX'), '2020-01-01 00:00:00', 'ADMIN', 'FALSE'),
('Niepowtarzalny design', (select id from device where name='Samsung RB31FERNCSA'), '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('SmartTv działa świetnie, jakość obrazu bardzo dobra', (select id from device where name='Samsung UE55RU7472U'), '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

insert into PARAMETER (name, created_at, created_by, active) values
('Kolor', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Marka', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Rozdzielczość', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Pojemność', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Roczne zużycie energii', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Częstotliwość odświeżania', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Poziom hałasu', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
('Ekran', '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

insert into DEVICE_PARAMS (id_device, id_parameter, value, created_at, created_by, active) values
((select id from device where name='Whirlpool W7 921O OX'), (select id from parameter where name='Kolor'), 'Biała', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Whirlpool W7 921O OX'), (select id from parameter where name='Poziom hałasu'), '40 dB', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung RB31FERNCSA'), (select id from parameter where name='Kolor'), 'Stal nierdzewna', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung RB31FERNCSA'), (select id from parameter where name='Poziom hałasu'), '39 dB', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung RB31FERNCSA'), (select id from parameter where name='Pojemność'), '206l', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung UE55RU7472U'), (select id from parameter where name='Rozdzielczość'), '4K UHD 3840x2160', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung UE55RU7472U'), (select id from parameter where name='Częstotliwość odświeżania'), '50 Hz', '2020-01-01 00:00:00', 'ADMIN', 'TRUE'),
((select id from device where name='Samsung UE55RU7472U'), (select id from parameter where name='Ekran'), '55 cali 138cm 16:9', '2020-01-01 00:00:00', 'ADMIN', 'TRUE');

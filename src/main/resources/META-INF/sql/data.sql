insert into users (email, enabled, first_name, last_name, password, role,username) values ('admin@inventory.pl',1,'Adam', 'Kowalski','$2a$10$W8aoGCAvHQ4yquuD.Y3gNuzr26Ho3.5Vx2h3WVE9SHtT5O1OWkK6G','ROLE_ADMIN', 'admin2');
insert into users (email, enabled, first_name, last_name, password, role,username) values ('user@inventory.pl',1,'Adam', 'Kowalski','$2a$10$xHrPRXZnsBMXDYXKMi6Rhe.ZGWXsIE5nakkNbly6qxZgA0iH02QoG','ROLE_USER', 'user');
insert into countries (country_name, currency, days_delivery) values ('France','EURO', 5),('Italy','EURO',4),('RPA','USD',14);
insert into producers (name, adress,email , phone_number, country_id) values('Abbaye Saint-Antoine', '13 Rue Jules Philippe, 89800 Chablis, Burgundy ', 'saint@antoine.fr','33678990',1),
                                                                            ('Abbazia di Praglia','Via Abbazia di Praglia 16, 35037 Teolo (PD), Veneto ','abbazia@dipraglia','3997866897',2),
                                                                            ('Cavas del Valle','Valle de Elqui, D-485 15190, Paihuano, Coquimbo ','cavas@delvalle','6399889800',3);
insert into wines (name, price, amount, date_last_delivery, monthly,producer_id) values('Montmains, Chablis Premier Cru', 106,12, '2021-03-23',4,1),
                                                                                                  ('''Domnus Abbas'' Extra Brut, Veneto', 69,20,'2020-09-20',5,2),
                                                                                                  ('Cavas del Valle Gran Reserva Syrah, Elqui Valley',48,5,'2019-05-02',5,3);

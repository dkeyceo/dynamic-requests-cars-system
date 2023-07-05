INSERT INTO brand (id, name) values
(1, 'MERCEDES'),(2, 'BMW');

INSERT INTO model (id, name, brand_id) values
(1,'CLASS C', 1),
(2,'CLASS E', 1),
(3,'CLASS S', 1),
(4,'SERIA 3', 2),
(5,'SERIA 5', 2),
(6,'SERIA 7', 2);

INSERT INTO car (id, changed, color, km, version, model_id) values
(1, b'0', 'GREY', 100000, '220d',1),
(2, b'1', 'BLACK', 200000, '220 cdi',1),
(3, b'0', 'WHITE', 300000, '300d',2),
(4, b'0', 'GREY', 400000, '280 cdi',2),
(5, b'0', 'BLACK', 500000, 's 500',3),
(6, b'1', 'WHITE', 500000, 's 350',3),
(7, b'0', 'GREY', 600000, '320 d',4),
(8, b'1', 'BLACK', 100000, '318 d',4),
(9, b'0', 'WHITE', 200000, '525 i',5),
(10, b'1', 'GREY', 300000, '520 d',5),
(11, b'0', 'WHITE', 400000, '730 d',6),
(12, b'1', 'WHITE', 500000, '728 i',6);
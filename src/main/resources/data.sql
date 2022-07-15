INSERT INTO fahrrad_type (id, typ) VALUES
(1, 'bike'),
(2, 'citybike');

INSERT INTO marke (id, marken_type) VALUES
(1, 'bmc'),
(2, 'Tour de Suisse');

INSERT INTO fahrrad_besitzer(id, name) VALUES
(1, 'Hans'),
(2, 'Sepp');

INSERT INTO fahrrad (id, fahrrad_type_id, marke_id, fahrrad_besitzer_id) VALUES
(1, 1, 1, 1),
(2,2,2, 2);


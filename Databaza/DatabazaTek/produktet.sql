CREATE TABLE `produktet` (
  `id` int(4) NOT NULL,
  `emrprod` varchar(225) NOT NULL,
  `katprod` varchar(225) NOT NULL,
  `qmimi` varchar(5) NOT NULL,
  `sasia` int(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `produktet` (`id`, `emrprod`, `katprod`, `qmimi`, `sasia`) VALUES
(1, 'Amerikane', 'PijeteNgrohta', '1.0', 1),
(2, 'Espreso', 'PijeteNgrohta', '0.7', 1),
(3, 'Turke', 'PijeteNgrohta', '0.5', 1),
(4, 'NesCaffe', 'PijeteNgrohta', '1.0', 1),
(5, 'Qaj Frutash/Bimeve', 'PijeteNgrohta', '0.5', 1),
(6, 'Hot Chocolate', 'PijeteNgrohta', '1.5', 1),
(7, 'Uje Natyral & Mineral', 'Pije', '0.5', 1),
(8, 'Pije Te Gazuara', 'Pije', '1.0', 1),
(9, 'Red Bull', 'Pije', '2.0', 1),
(10, 'Ice Tea', 'Pije', '1.0', 1),
(11, 'Fructal', 'Pije', '1.0', 1),
(12, 'Lengje ne Gote', 'Pije', '0.7', 1),
(13, 'Trileqe', 'Embelsira', '1.5', 1),
(14, 'Tiramisu', 'Embelsira', '2.0', 1),
(15, 'Snickers', 'Embelsira', '2.0', 1),
(16, 'Birra Peja', 'PijeAlkolike', '1.2', 1),
(17, 'Birra Corona', 'PijeAlkolike', '3.0', 1),
(18, 'Birra Lasko', 'PijeAlkolike', '1.2', 1),
(19, 'Birra Heineken', 'PijeAlkolike', '3.0', 1),
(20, 'Birra Tuborg', 'PijeAlkolike', '2.5', 1),
(21, 'Tequila', 'PijeAlkolike', '3.0', 1),
(22, 'Gin Tonic', 'PijeAlkolike', '2.5', 1),
(23, 'Vodka Red Bull', 'PijeAlkolike', '4.5', 1),
(24, 'Jack Daniel', 'PijeAlkolike', '3.5', 1),
(25, 'Chicken Fingers', 'Snacks', '4.5', 1),
(26, 'Chicken Nuggets', 'Snacks', '3.5', 1),
(27, 'Pomfrita', 'Snacks', '2.5', 1),
(28, 'Meze e Ftoht', 'Snacks', '4.2', 1),
(29, 'Milka', 'Embelsira', '2.0', 1);

ALTER TABLE `produktet`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `produktet`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
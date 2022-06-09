CREATE TABLE `katprod` (
  `id` int(11) NOT NULL,
  `emrkat` varchar(20) NOT NULL,
  `pershkrimi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `katprod` (`id`, `emrkat`, `pershkrimi`) VALUES
(1, 'PijeteNgrohta', 'Ketu bejne pjese Kafet, Qajrat dhe gjithqka ne lidhje me pijet e nxehta.'),
(5, 'Pije', 'Ketu bejne pjes pijet si uji, pije te gazuara, pije energjike, te gjitha pijet jo alkoholije dhe jo te ngrohta.'),
(6, 'Embelsira', 'Ketu bejne pjese te gjitha llojet e embelsirave.'),
(7, 'PijeAlkolike', 'Ketu bejne pjese te gjitha pijet alkolike si birra, raki ,verea apo qdo lloj pije tjeter qe permban alkol.'),
(8, 'Snacks', 'Ketu bejne pjese ushqimet e shpejta.');

ALTER TABLE `katprod`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `katprod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
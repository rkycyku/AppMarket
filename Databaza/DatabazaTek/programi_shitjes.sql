CREATE TABLE `programi_shitjes` (
  `ID` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `shuma` varchar(50) NOT NULL,
  `pagesa` varchar(50) NOT NULL,
  `data` date NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `programi_shitjes`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `programi_shitjes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
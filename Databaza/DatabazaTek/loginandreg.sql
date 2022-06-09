CREATE TABLE `loginandreg` (
  `ID` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_uname` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_bdate` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_access` VARCHAR(50) NOT NULL DEFAULT "1 - Admin"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `the_app` (`ID`, `u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`) VALUES
(1, 'Rilind', 'Kyçyku', 'admin', 'admin', '', '');


ALTER TABLE `the_app`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `the_app`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
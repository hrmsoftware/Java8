--Test script 1
IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='IntegratedCircuits')
BEGIN
  PRINT 'A new table is borne'
  CREATE TABLE dbo.IntegratedCircuits (
  id int IDENTITY Primary Key,
  name varchar(12) not NULL ,
  description VARCHAR (255)
  )
END
GO
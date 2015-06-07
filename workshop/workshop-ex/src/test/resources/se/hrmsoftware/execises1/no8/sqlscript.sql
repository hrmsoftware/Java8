--This is a small script to create a couple of tables in a database.
IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='IntegratedCircuits')
  BEGIN
    PRINT 'A new table is borne'
    CREATE TABLE dbo.IntegratedCircuits (
      id	int IDENTITY  Primary Key,
      name   	varchar(12) not NULL ,
      description		varchar(255)
    )
  END
GO

IF NOT EXISTS (SELECT * FROM SysObjects O INNER JOIN SysColumns C ON O.ID=C.ID WHERE O.Name='IntegratedCircuits' AND C.Name='operating_voltage')
  BEGIN
    ALTER TABLE IntegratedCircuits ADD operating_voltage int NULL
  END
GO

IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='colors')
  BEGIN
    PRINT 'Another table is borne'
    CREATE TABLE dbo.Colors (
      id	int IDENTITY  Primary Key,
      color	varchar(12) not null,
      value int not null
    )
  END
GO

IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='Resistors')
  BEGIN
    PRINT 'Another table is borne'
    CREATE TABLE dbo.Resistors (
      id	int IDENTITY  Primary Key,
      band_1		int not null,
      band_2 int not null,
      multiplier int not null,
      tolerance int not null,
      foreign key ( band_1 ) references colors (id),
      foreign key ( band_2 ) references colors (id),
      foreign key ( multiplier ) references colors (id),
      foreign key ( tolerance ) references colors (id)
    )
  END
GO


CREATE TABLE dbo.IntegratedCircuits (
  id	int IDENTITY  Primary Key,
  name   	varchar(12) not NULL ,
  description		varchar(255)
)
GO

IF NOT EXISTS (SELECT * FROM SysObjects WHERE Name='ic_holders')
  BEGIN
    PRINT 'A place for holders, but not a place holder.'
    CREATE TABLE dbo.holders (
      id	int IDENTITY  Primary Key,
      pin_count	int not null,
      count int not null
    )
  END
GO

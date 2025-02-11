create table register(username varchar(200),Full_Name varchar(200),Email varchar(200),Sex varchar(20),Date_of_Birth date,Password varchar(100),Phone_No numeric(10,0),primary key(Username));
select * from register;
truncate table register
create table Donor(Donor_ID varchar(200),Name varchar(200),Age int,Sex varchar(20),Register_Date date,Blood_Type varchar(20),Blood_Quantity int,STATE varchar(200),CITY varchar(200),primary key(Donor_ID));
select * from Donor;





-- Drop the register table if it exists
DROP TABLE IF EXISTS register;

-- Create the register table
CREATE TABLE register (
    username VARCHAR(200),
    Full_Name VARCHAR(200),
    Email VARCHAR(200),
    Sex VARCHAR(20),
    Date_of_Birth DATE,
    Password VARCHAR(100),
    Phone_No NUMERIC(10,0),
    PRIMARY KEY (username)
);

-- Drop the Donor table if it exists
DROP TABLE IF EXISTS Donor;

-- Create the Donor table
CREATE TABLE Donor (
    Donor_ID VARCHAR(200),
    Name VARCHAR(200),
    Age INT,
    Sex VARCHAR(20),
    Register_Date DATE,
    Blood_Type VARCHAR(20),
    Blood_Quantity INT,
    STATE VARCHAR(200),
    CITY VARCHAR(200),
    PRIMARY KEY (Donor_ID)
);

-- Optional: Select from the tables to verify creation
SELECT * FROM register;
SELECT * FROM Donor;


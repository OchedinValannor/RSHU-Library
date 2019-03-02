CREATE TABLE labrshu.dbo.Book
(
  BookID      INT PRIMARY KEY NOT NULL IDENTITY,
  Title       VARCHAR(250)    NOT NULL,
  Author      VARCHAR(250)    NOT NULL,
  Pledge      INT             NOT NULL,
  RentalPrice INT             NOT NULL,
  Genre       VARCHAR(250)    NOT NULL
)

CREATE TABLE labrshu.dbo.Reader
(
  ReaderID    INT PRIMARY KEY NOT NULL IDENTITY,
  Surname     VARCHAR(250)    NOT NULL,
  FirstName   VARCHAR(250)    NOT NULL,
  Patronymic  VARCHAR(250),
  HomeAddress VARCHAR(250)    NOT NULL,
  PhoneNumber INT             NOT NULL
)

CREATE TABLE labrshu.dbo.Record
(
  RecordID   INT PRIMARY KEY NOT NULL IDENTITY,
  BookID     INT             NOT NULL,
  ReaderID   INT             NOT NULL,
  IssueDate  DATE            NOT NULL,
  ReturnDate DATE            NOT NULL

    CONSTRAINT Record_Book_BookID_fk FOREIGN KEY (BookID) REFERENCES Book (BookID),
  CONSTRAINT Record_Reader_ReaderID_fk FOREIGN KEY (ReaderID) REFERENCES Reader (ReaderID)
)

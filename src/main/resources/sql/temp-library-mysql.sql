CREATE TABLE Book
(
  BookID      INT AUTO_INCREMENT PRIMARY KEY,
  Title       VARCHAR(250)    NOT NULL,
  Author      VARCHAR(250)    NOT NULL,
  Pledge      INT             NOT NULL,
  RentalPrice INT             NOT NULL,
  Genre       VARCHAR(250)    NOT NULL
);

CREATE TABLE Reader
(
  ReaderID    INT AUTO_INCREMENT PRIMARY KEY,
  Surname     VARCHAR(250)    NOT NULL,
  FirstName   VARCHAR(250)    NOT NULL,
  Patronymic  VARCHAR(250),
  HomeAddress VARCHAR(250)    NOT NULL,
  PhoneNumber INT             NOT NULL
);

CREATE TABLE Record
(
  RecordID   INT AUTO_INCREMENT PRIMARY KEY,
  BookID     INT             NOT NULL,
  ReaderID   INT             NOT NULL,
  IssueDate  DATE            NOT NULL,
  ReturnDate DATE            NOT NULL,

  CONSTRAINT Record_Book_BookID_fk FOREIGN KEY (BookID) REFERENCES Book (BookID),
  CONSTRAINT Record_Reader_ReaderID_fk FOREIGN KEY (ReaderID) REFERENCES Reader (ReaderID)
);

CREATE VIEW record_meta_data AS
  SELECT
    Record.RecordID,
    Book.BookID,
    Book.Title,
    Reader.ReaderID,
    Reader.Surname,
    Book.RentalPrice,
    Record.IssueDate,
    Record.ReturnDate,
    DATEDIFF(Record.ReturnDate, Record.IssueDate) AS Total_days,
    (Book.RentalPrice*DATEDIFF(Record.ReturnDate, Record.IssueDate)) AS Total_rent
  FROM Book, Reader, Record
  WHERE Book.BookID = Record.BookID AND Reader.ReaderID = Record.ReaderID
GO

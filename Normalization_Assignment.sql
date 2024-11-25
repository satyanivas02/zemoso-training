CREATE TABLE HospitalRecords (
    PatientID INT,
    PatientName VARCHAR(50),
    ContactNumbers VARCHAR(100),
    AppointmentDetails TEXT,
    DoctorName VARCHAR(50),
    DoctorSpecialization VARCHAR(50),
    DoctorContact VARCHAR(50),
    RoomDetails VARCHAR(50)
);

INSERT INTO HospitalRecords VALUES
(1, 'Satya', '123-456, 789-012', '2024-11-13:10:00AM, 2024-11-14:11:00AM', 'Dr. Naga', 'Cardiology', '555-111', 'Room 101'),
(2, 'Swaroop', '456-789', '2024-11-14:09:30AM', 'Dr. Sai', 'Orthopedics', '555-222', 'Room 102'),
(3, 'Sai', '123-123', '2024-11-15:12:00PM', 'Dr. Murari', 'Dermatology', '555-333', 'Room 103'),
(1, 'Satya', '123-456, 789-012', '2024-11-15:01:00PM', 'Dr. Manish', 'Neurology', '555-444', 'Room 104');

SELECT * FROM HospitalRecords;

CREATE TABLE HospitalRecords_1NF (
    PatientID INT,
    PatientName VARCHAR(50),
    ContactNumber VARCHAR(50),
    AppointmentDateTime DATETIME,
    DoctorName VARCHAR(50),
    DoctorSpecialization VARCHAR(50),
    DoctorContact VARCHAR(50),
    RoomDetails VARCHAR(50)
);

INSERT INTO HospitalRecords_1NF VALUES
(1, 'Satya', '123-456', '2024-11-13 10:00:00', 'Dr. Naga', 'Cardiology', '555-111', 'Room 101'),
(1, 'Satya', '789-012', '2024-11-14 11:00:00', 'Dr. Naga', 'Cardiology', '555-111', 'Room 101'),
(2, 'Swaroop', '456-789', '2024-11-14 09:30:00', 'Dr. Sai', 'Orthopedics', '555-222', 'Room 102'),
(3, 'Sai', '123-123', '2024-11-15 12:00:00', 'Dr. Murari', 'Dermatology', '555-333', 'Room 103'),
(1, 'Satya', '123-456', '2024-11-15 01:00:00', 'Dr. Manish', 'Neurology', '555-444', 'Room 104');

CREATE TABLE Patients (
    PatientID INT,
    PatientName VARCHAR(50),
    ContactNumber VARCHAR(50),
    PRIMARY KEY (PatientID, ContactNumber)
);

INSERT INTO Patients VALUES
(1, 'Satya', '123-456'),
(1, 'Satya', '789-012'),
(2, 'Swaroop', '456-789'),
(3, 'Sai', '123-123');

CREATE TABLE Doctors (
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    DoctorName VARCHAR(50),
    DoctorSpecialization VARCHAR(50),
    DoctorContact VARCHAR(50),
    RoomDetails VARCHAR(50)
);

INSERT INTO Doctors VALUES
(1, 'Dr. Naga', 'Cardiology', '555-111', 'Room 101'),
(2, 'Dr. Sai', 'Orthopedics', '555-222', 'Room 102'),
(3, 'Dr. Murari', 'Dermatology', '555-333', 'Room 103'),
(4, 'Dr. Manish', 'Neurology', '555-444', 'Room 104');

CREATE TABLE Appointments (
    AppointmentID INT AUTO_INCREMENT PRIMARY KEY,
    PatientID INT,
    AppointmentDateTime DATETIME,
    DoctorID INT,
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

INSERT INTO Appointments VALUES
(1, 1, '2024-11-13 10:00:00', 1),
(2, 1, '2024-11-14 11:00:00', 1),
(3, 2, '2024-11-14 09:30:00', 2),
(4, 3, '2024-11-15 12:00:00', 3),
(5, 1, '2024-11-15 01:00:00', 4);

CREATE TABLE Specializations (
    SpecializationID INT AUTO_INCREMENT PRIMARY KEY,
    DoctorID INT,
    Specialization VARCHAR(50),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

INSERT INTO Specializations VALUES
(1, 1, 'Cardiology'),
(2, 2, 'Orthopedics'),
(3, 3, 'Dermatology'),
(4, 4, 'Neurology');

SELECT * FROM Specializations;
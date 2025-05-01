create database SISDB;
use SISDB;
CREATE TABLE Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    address VARCHAR(255)
);

CREATE TABLE Teacher (
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    department VARCHAR(100)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    course_description TEXT,
    credits INT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id)
);

CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    amount DECIMAL(10,2),
    payment_date DATE,
    payment_method ENUM('Cash', 'Card', 'Online'),
    FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

INSERT INTO Students (first_name, last_name, date_of_birth, gender, email, phone, address) VALUES
('Dee', 'Diya', '2000-01-15', 'Female', 'deediya@gmail.com', '1234567890', 'Chennai'),
('Will', 'Smith', '2001-05-22', 'Male', 'will.smith@gmail.com', '1234567891', 'Mumbai'),
('Vidya', 'Janani', '1999-11-02', 'Female', 'vj.11@gmail.com', '1234567892', 'Delhi'),
('Vasan', 'Babu', '2002-04-17', 'Male', 'vasan@gmail.com', '1234567893', 'Hyderabad'),
('Tom', 'Holland', '2003-07-30', 'Male', 'tom@gamail.com', '1234567894', 'Bangalore'),
('Sakthi', 'Samyuktha', '2000-10-10', 'Female', 'sakthi@gmail.com', '1234567895', 'Pune'),
('Raj', 'Kumari', '2001-12-12', 'Female', 'raj.kumari@yahoo.com', '1234567896', 'Kolkata'),
('Nani', 'nani', '2002-08-08', 'Male', 'nani.nani@yahoo.com', '1234567897', 'Cochin'),
('Poorvaja', 'Wilson', '1999-03-05', 'FeMale', 'poorvaja.wilson@outlook.com', '1234567898', 'Chandigarh'),
('Loghitha', 'Taylor', '2001-09-19', 'Female', 'loghitha.taylor@outlook.com', '1234567899', 'Indore');

INSERT INTO Teacher (first_name, last_name, email, department) VALUES
('Michael', 'Scott', 'michael.scott@school.com', 'Management'),
('Dwight', 'Schrute', 'dwight.schrute@school.com', 'Agriculture'),
('Jim', 'Halpert', 'jim.halpert@school.com', 'Marketing'),
('Pam', 'Beesly', 'pam.beesly@school.com', 'Arts'),
('Stanley', 'Hudson', 'stanley.hudson@school.com', 'Finance'),
('Angela', 'Martin', 'angela.martin@school.com', 'Accounting'),
('Oscar', 'Martinez', 'oscar.martinez@school.com', 'Mathematics'),
('Kevin', 'Malone', 'kevin.malone@school.com', 'Culinary'),
('Kelly', 'Kapoor', 'kelly.kapoor@school.com', 'Fashion'),
('Ryan', 'Howard', 'ryan.howard@school.com', 'IT');

INSERT INTO Courses (course_name, course_description, credits, teacher_id) VALUES
('Mathematics', 'Basic mathematics course', 3, 7),
('Physics', 'Fundamentals of Physics', 4, 3),
('Chemistry', 'Introduction to Chemistry', 3, 2),
('Computer Science', 'Programming basics', 4, 10),
('Biology', 'General biology course', 3, 4),
('History', 'World History overview', 2, 5),
('English', 'English Literature', 3, 4),
('Economics', 'Intro to Economics', 3, 1),
('Psychology', 'Basic Psychology', 2, 6),
('Sociology', 'Intro to Sociology', 2, 8);

INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2024-01-01'),
(2, 2, '2024-01-02'),
(3, 3, '2024-01-03'),
(4, 4, '2024-01-04'),
(5, 5, '2024-01-05'),
(6, 6, '2024-01-06'),
(7, 7, '2024-01-07'),
(8, 8, '2024-01-08'),
(9, 9, '2024-01-09'),
(10, 10, '2024-01-10');

INSERT INTO Payments (student_id, amount, payment_date, payment_method) VALUES
(1, 500.00, '2024-01-11', 'Online'),
(2, 450.00, '2024-01-12', 'Card'),
(3, 300.00, '2024-01-13', 'Cash'),
(4, 600.00, '2024-01-14', 'Online'),
(5, 350.00, '2024-01-15', 'Card'),
(6, 400.00, '2024-01-16', 'Cash'),
(7, 550.00, '2024-01-17', 'Online'),
(8, 700.00, '2024-01-18', 'Card'),
(9, 480.00, '2024-01-19', 'Cash'),
(10, 510.00, '2024-01-20', 'Online');
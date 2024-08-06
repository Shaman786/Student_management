-- Drop existing tables if they exist
DROP TABLE IF EXISTS student_subject;
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS SUBJECT;

-- Create tables
CREATE TABLE SUBJECT (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE STUDENT (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE student_subject (
    student_id BIGINT,
    subject_id BIGINT,
    PRIMARY KEY (student_id, subject_id),
    FOREIGN KEY (student_id) REFERENCES STUDENT(id),
    FOREIGN KEY (subject_id) REFERENCES SUBJECT(id)
);

-- Insert subjects
INSERT INTO SUBJECT (name) VALUES ('Mathematics');
INSERT INTO SUBJECT (name) VALUES ('Science');
INSERT INTO SUBJECT (name) VALUES ('History');

-- Insert students
INSERT INTO STUDENT (name, address) VALUES ('John Doe', '123 Main St');
INSERT INTO STUDENT (name, address) VALUES ('Jane Smith', '456 Oak St');

-- Insert student-subject relationships
INSERT INTO student_subject (student_id, subject_id) VALUES (1, 1);
INSERT INTO student_subject (student_id, subject_id) VALUES (1, 2);
INSERT INTO student_subject (student_id, subject_id) VALUES (2, 3);

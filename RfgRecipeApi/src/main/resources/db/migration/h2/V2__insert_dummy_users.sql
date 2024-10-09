-- V2__insert_dummy_users.sql

-- 관리자 계정 4개 삽입
INSERT INTO users (username, email, password, nickname, profile_image, phone_number, gender, birthdate, address, role, status, bio)
VALUES 
('admin1', 'admin1@example.com', '1234', '관리자돌돌이1', '/images/admin1.png', '010-1234-5671', 'M', '1980-01-01', 'Seoul', 'ADMIN', 'Y', 'System Administrator 1'),
('admin2', 'admin2@example.com', '1234', '관리자돌돌이2', '/images/admin2.png', '010-1234-5672', 'F', '1985-05-15', 'Busan', 'ADMIN', 'Y', 'System Administrator 2'),
('admin3', 'admin3@example.com', '1234', '관리자돌돌이3', '/images/admin3.png', '010-1234-5673', 'M', '1975-09-20', 'Daegu', 'ADMIN', 'Y', 'System Administrator 3'),
('admin4', 'admin4@example.com', '1234', '관리자돌돌이4', '/images/admin4.png', '010-1234-5674', 'O', '1990-12-12', 'Incheon', 'ADMIN', 'Y', 'System Administrator 4');

-- 일반 사용자 계정 6개 삽입
INSERT INTO users (username, email, password, nickname, profile_image, phone_number, gender, birthdate, address, role, status, bio)
VALUES 
('user1', 'user1@example.com', '1234', '사용자돌돌이1', '/images/user1.png', '010-5678-1231', 'F', '1995-03-21', 'Seoul', 'USER', 'Y', 'Regular User 1'),
('user2', 'user2@example.com', '1234', '사용자돌돌이2', '/images/user2.png', '010-5678-1232', 'M', '1992-07-18', 'Busan', 'USER', 'Y', 'Regular User 2'),
('user3', 'user3@example.com', '1234', '사용자돌돌이3', '/images/user3.png', '010-5678-1233', 'O', '1998-11-11', 'Daegu', 'USER', 'Y', 'Regular User 3'),
('user4', 'user4@example.com', '1234', '사용자돌돌이4', '/images/user4.png', '010-5678-1234', 'F', '1997-05-25', 'Incheon', 'USER', 'Y', 'Regular User 4'),
('user5', 'user5@example.com', '1234', '사용자돌돌이5', '/images/user5.png', '010-5678-1235', 'M', '1991-10-08', 'Gwangju', 'USER', 'Y', 'Regular User 5'),
('user6', 'user6@example.com', '1234', '사용자돌돌이6', '/images/user6.png', '010-5678-1236', 'F', '1993-06-30', 'Daejeon', 'USER', 'Y', 'Regular User');

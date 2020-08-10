-- Creating a database hb_student_tracker
CREATE DATABASE `hb_student_tracker`;

-- Creating table student
CREATE TABLE `hb_student_tracker`.`student`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name`  VARCHAR(45) NOT NULL,
    `email`      VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;


-- Load table with sample data
INSERT INTO `hb_student_tracker`.`student` (`first_name`, `last_name`, `email`)
VALUES ('Kirill', 'Dremin', 'kirya@mail.ru');
INSERT INTO `hb_student_tracker`.`student` (`first_name`, `last_name`, `email`)
VALUES ('Victor', 'Vasilev', 'vitya@gmail.com');
INSERT INTO `hb_student_tracker`.`student` (`first_name`, `last_name`, `email`)
VALUES ('Andrew', 'Podnik', 'drew@yahoo.com');
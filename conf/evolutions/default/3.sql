# Task schema

# --- !Ups

CREATE TABLE Task (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    startDate varchar(255) NOT NULL,
    dueDate varchar(255) NOT NULL,
    person_id bigint(20) NOT NULL,
    taskType_id bigint(20) NOT NULL,
    description varchar(255) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES Person(id),
    FOREIGN KEY (taskType_id) REFERENCES TaskType(id),
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE User;
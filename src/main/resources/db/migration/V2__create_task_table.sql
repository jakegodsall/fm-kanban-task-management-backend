DROP TABLE IF EXISTS task;

CREATE TABLE task (
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT NOT NULL,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    status TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

ALTER TABLE sub_task
ADD COLUMN task_id BIGINT,
ADD FOREIGN KEY (task_id) REFERENCES task(id);
DROP TABLE IF EXISTS sub_task;

CREATE TABLE sub_task (
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT NOT NULL,
    title VARCHAR(200) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);


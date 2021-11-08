CREATE TABLE TODOLIST2 (
    tl_num  INTEGER NOT NULL,
    tl_date DATE,
    tl_work VARCHAR(48),
    tl_who VARCHAR(24),
    tl_priority INTEGER NOT NULL
);


ALTER TABLE TODOLIST2
   ADD CONSTRAINT tl_num_pk
   PRIMARY KEY (tl_num);
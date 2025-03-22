
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS userinfo;  -- 如果表名是大写的 "User" 保持不变，否则可以修改为 user



CREATE TABLE userinfo (
                        id SERIAL PRIMARY KEY,
                        email VARCHAR(255),
                        password VARCHAR(255)
);

CREATE TABLE trips (
                        id SERIAL PRIMARY KEY,
                        user_id INT,
                        city VARCHAR(255),
                        country VARCHAR(255),
                        start_date VARCHAR(255),
                        end_date VARCHAR(255),
                        trip_detail VARCHAR(255),  -- 新增 trip_detail 列
                        FOREIGN KEY (user_id) REFERENCES UserInfo(id)
    );



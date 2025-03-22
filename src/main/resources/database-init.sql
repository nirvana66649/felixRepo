-- DROP TABLE IF EXISTS FavoritePlans;
-- DROP TABLE IF EXISTS Trips_POIS;
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS userinfo;  -- 如果表名是大写的 "User" 保持不变，否则可以修改为 user

-- DROP TABLE IF EXISTS POI;

-- CREATE TABLE POI (
--                      id SERIAL PRIMARY KEY,
--                      name VARCHAR(255),
--                      category VARCHAR(255),
--                      description VARCHAR(255),
--                      latitude VARCHAR(255),
--                      longitude VARCHAR(255),
--                      address VARCHAR(255),
--                      city VARCHAR(255)
-- );

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


-- CREATE TABLE Trips_POIS (
--                             id SERIAL PRIMARY KEY,
--                             trip_id INT,
--                             poi_id INT,
--                             visit_date VARCHAR(255),
--                             FOREIGN KEY (trip_id) REFERENCES Trips(id),
--                             FOREIGN KEY (poi_id) REFERENCES POI(id)
-- );
--
-- CREATE TABLE FavoritePlans (
--                                id SERIAL PRIMARY KEY,
--                                user_id INT,
--                                poi_trip_id INT,
--                                FOREIGN KEY (user_id) REFERENCES "User"(id),
--                                FOREIGN KEY (poi_trip_id) REFERENCES Trips_POIS(id)
-- );

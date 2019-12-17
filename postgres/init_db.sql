CREATE TABLE users(
id bigserial primary key,
username varchar(255) not null
);

CREATE TABLE filters(
user_id bigint primary key references users(id) on delete cascade,
area varchar(255),
min_total_price money,
max_total_price money,
min_size int,
max_size int,
n_bedrooms int,
owner_type varchar(255));

CREATE OR REPLACE FUNCTION insert_filter_with_user_id()
  RETURNS trigger AS
$BODY$
BEGIN
  INSERT INTO filters (user_id) values (NEW.id);
  RETURN NEW;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE;

CREATE TRIGGER create_filter_on_user_insert
AFTER INSERT
ON users
FOR EACH ROW
EXECUTE PROCEDURE insert_filter_with_user_id();

INSERT INTO users(username) values ('boligsoker');



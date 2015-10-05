
    -- Table: roles

-- DROP TABLE roles;

CREATE TABLE IF NOT EXISTS roles
(
  name character varying(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (name)
)
WITH (
  OIDS=FALSE
);

--ALTER TABLE roles   OWNER TO postgres;
  
  INSERT INTO roles(
            name)
    VALUES ('ROLE_ADMIN');

    
    INSERT INTO roles(
            name)
    VALUES ('ROLE_SELLER');

  -- Table: user_roles

-- DROP TABLE user_roles;

CREATE TABLE  IF NOT EXISTS user_roles
(
  user_role_id integer NOT NULL,
  "user" character varying(45) NOT NULL,
  role character varying(45) NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id),
  CONSTRAINT fk_username FOREIGN KEY ("user")
      REFERENCES users (name) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
--ALTER TABLE user_roles
--  OWNER TO postgres;
  
  INSERT INTO user_roles(user_role_id, "user", role)
    	         VALUES (1, "admin", "ROLE_ADMIN");

  INSERT INTO user_roles(user_role_id, "user", role)
                 VALUES (2, "seller", "ROLE_SELLER");
    
    
  -- Table: users

-- DROP TABLE users;

CREATE TABLE IF NOT EXISTS users
(
  name character varying(255) NOT NULL,
  password character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (name)
)
WITH (
  OIDS=FALSE
);
--ALTER TABLE users   OWNER TO postgres;
  
  
  INSERT INTO users(
            name, password)
    VALUES ( "admin",  "admin");

    INSERT INTO users(
            name, password)
    VALUES ("seller", "seller");

    
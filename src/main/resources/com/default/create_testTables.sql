
    -- Table: roles

-- DROP TABLE roles;

CREATE TABLE IF NOT EXISTS roles 
(
  role_id serial NOT NULL,
  role_descriptions character varying(255),
  role_name character varying(255) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (role_id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE roles   OWNER TO postgres;
  
INSERT INTO roles (role_name) SELECT 'ROLE_ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE role_name = 'ROLE_ADMIN');

--INSERT INTO roles(  role_name)     VALUES ('ROLE_ADMIN');

INSERT INTO roles (role_name) SELECT 'ROLE_USER'
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE role_name = 'ROLE_USER')  ;  

--INSERT INTO roles(role_id,       role_name)    VALUES ('ROLE_USER');


    
  -- Table: users

-- DROP TABLE users;

CREATE TABLE IF NOT EXISTS users
(
  user_id serial NOT NULL,
  blocked boolean,
  user_email character varying(255) NOT NULL,
  user_login character varying(255) NOT NULL,
  user_name character varying(255),
  user_password character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (user_id)

)
WITH (
  OIDS=FALSE
);
ALTER TABLE users   OWNER TO postgres;
  
INSERT INTO users ( user_name, user_password,user_email,user_login) SELECT 'admin',  'admin','admin@admin','admin'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE user_name = 'admin')      ;

INSERT INTO users ( user_name, user_password,user_email,user_login) SELECT 'user',  'user','user@user','user'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE user_name = 'user')      ;

  --INSERT INTO users( user_name, user_password,user_email,user_login)    VALUES ( 'admin',  'admin','admin@admin','admin');

   --INSERT INTO users( user_name, user_password,user_email,user_login)  VALUES ('user', 'user','user@user','user');

    
      -- Table: user_roles

-- DROP TABLE user_roles;

CREATE TABLE IF NOT EXISTS users_roles
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_roles FOREIGN KEY (role_id)
      REFERENCES roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_users FOREIGN KEY (user_id)
      REFERENCES users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users_roles
  OWNER TO postgres;
  
  INSERT INTO users_roles (user_id,role_id) SELECT 1, 1
WHERE NOT EXISTS (SELECT 1 FROM users_roles WHERE user_id = 1);
  
 INSERT INTO users_roles (user_id,role_id) SELECT 2, 2
WHERE NOT EXISTS (SELECT 1 FROM users_roles WHERE user_id = 2);

 
    
    
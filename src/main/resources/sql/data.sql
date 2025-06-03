INSERT INTO
    AppUser (username, email, password)
VALUES
    ('darknbolt', 'test@email.com', '{noop}1234');

INSERT INTO
    UserRole(name)
VALUES
    ('Explorer'),
    ('Reporter'),
    ('Developer'),
    ('Admin'),
    ('Owner');


INSERT INTO
    User_UserRole (user_ID, user_Role_ID)
VALUES
    (1, 5);
INSERT INTO
    AppUser (username, email, password)
VALUES
    ('darknbolt', '1234', 'test@email.com');

INSERT INTO
    UserRole(name)
VALUES
    ('Unregistered User'),
    ('Reader'),
    ('Publisher'),
    ('Librarian'),
    ('Administrator');


INSERT INTO
    User_UserRole (user_ID, user_Role_ID)
VALUES
    (1, 5);
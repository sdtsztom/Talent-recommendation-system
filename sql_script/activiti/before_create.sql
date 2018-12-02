create database activiti
GO

-- add user in database activiti
use activiti
GO

create user u_dev for login u_dev with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_dev'
create user u_sys for login u_sys with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_sys'
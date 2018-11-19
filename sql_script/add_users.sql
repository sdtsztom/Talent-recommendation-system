use tal_rec_sys
GO

-- user develop，测试开发可以临时使用的用户
create login develop with password='123', default_database=tal_rec_sys
create user develop for login develop with default_schema=dbo
exec sp_addrolemember 'db_owner', 'develop'

-- user sys，系统操作使用的账户
create login u_sys with password='123', default_database=tal_rec_sys
create user u_sys for login u_sys with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_sys'

-- user stuff
create login u_stuff with password='123', default_database=tal_rec_sys
create user u_stuff for login u_stuff with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_stuff'

-- user admin
create login u_admin with password='123', default_database=tal_rec_sys
create user u_admin for login u_admin with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_admin'

-- user HR
create login u_HR with password='123', default_database=tal_rec_sys
create user u_HR for login u_HR with default_schema=dbo
exec sp_addrolemember 'db_owner', 'u_HR'
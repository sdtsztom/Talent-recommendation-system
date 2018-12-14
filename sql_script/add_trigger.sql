use tal_rec_sys
GO

-- recommendAdd 检验recommend的有效性
create trigger recommendAdd on recommend for insert as
BEGIN
	IF (select count(*) from recommend where rec_rp_id=(select rec_rp_id from inserted) and rec_recsta_id>1)>1
		delete from recommend where rec_rp_id=(select rec_id from inserted)
	ELSE IF (select rp_vali from recommend_people where rp_id=(select rec_rp_id from inserted))='否'
		delete from recommend where rec_id=(select rec_id from inserted)
END
use tal_rec_sys
GO

-- rp2stuff ���Ƽ���Ա��ע���Ϊ��Ա��
CREATE PROCEDURE rp2stuff(@rp_id int,@username char(40),@pwd char(40)) AS
BEGIN
	DECLARE @name char(40),@sex char(2),@age tinyint,@tel_num char(40),@email char(40),@job_id smallint,@dpt_id smallint,@stuff_id smallint
	select @job_id=ri_job_id,@dpt_id=ri_dpt_id from requirements_common_info where ri_id=
		(select rr_ri_id from recruitment_requirements where rr_id=
		(select rec_rr_id from recommend where rec_rp_id=@rp_id and rec_recsta_id=5)) --5�ǵȴ�offerȷ��

	if @job_id is NULL
		RETURN -1
	else
		select @name=rp_name,@sex=rp_sex,@age=rp_age,@tel_num=rp_tel_num,@email=rp_email from recommend_people where
		rp_id=@rp_id
		/* for check
		print @tel_num
		print @email
		print @job_id
		print @dpt_id
		*/
		-- �����Ƽ����ж�Ӧ�е�״̬������
		update recommend set rec_recsta_id=1,rec_recres_id=4 where rec_rp_id=@rp_id and rec_recsta_id=5;
		-- �����Ƽ��˵���Ч״̬
		update recommend_people set rp_vali='��' where rp_id=@rp_id
		-- �����Ա��
		insert into stuff values(@job_id,@dpt_id,@name,@age,@sex,@username,@pwd,@email,0,@tel_num)
		-- �����ӦȨ��
		select @stuff_id=stf_id from stuff where stf_name=@username
		insert into role_grant values(@stuff_id,2)
END
GO
-- EXECUTE rp2stuff 1,'h','hh'

-- pointsReward ���ֽ���
CREATE PROCEDURE pointsReward(@rec_id int,@rule_id tinyint) AS
BEGIN
	DECLARE @rec_recstf_id char(40)
	select @rec_recstf_id=rec_recstu_id from recommend where rec_id=@rec_id
	insert into points_change values(@rule_id,@rec_recstf_id,GETDATE())
	update stuff set stf_pts=stf_pts+(select ptchr_change from points_change_rule) where stf_id=@rec_recstf_id
END
GO

-- put2talents
CREATE PROCEDURE put2talents(@rec_id int,@from_id tinyint) AS
BEGIN
	DECLARE @rec_recstf_id char(40),@rec_dealHR_id char(40)
	select @rec_recstf_id=rec_recstu_id,@rec_dealHR_id=rec_dealHR_id from recommend where rec_id=@rec_id
	insert into talents values(@rec_recstf_id,@rec_dealHR_id,@from_id)
	update recommend set rec_recsta_id=1,rec_recres_id=1 where rec_id=@rec_id
END
GO

-- put2otherneed
CREATE PROCEDURE put2otherneed(@rec_id int,@otherneed_id int,@from_id tinyint) AS
BEGIN
	DECLARE @newHR_id char(40),@rec_dealHR_id char(40),@rpid char(40)
	select @rpid=rec_rp_id,@rec_dealHR_id=rec_dealHR_id from recommend where rec_id=@rec_id
	select @newHR_id=rr_hr_id from recruitment_requirements where rr_id=@otherneed_id
	insert into recommend values(@otherneed_id,@rec_dealHR_id,@rpid,@from_id,2,@newHR_id,6)
	update recommend set rec_recsta_id=1,rec_recres_id=2 where rec_id=@rec_id
END
GO
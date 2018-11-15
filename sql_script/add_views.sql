use tal_rec_sys
GO

-- veiw SRM_OPEN
create view SRM_OPEN as select rec_id,rec_rr_id,stf_name as rec_stf_name,rp_name as rec_rp_name,recf_desc as rec_from_desc 
from recommend inner join stuff on recommend.rec_recstu_id=stuff.stf_id
inner join recommend_people on recommend.rec_rp_id =recommend_people.rp_id
inner join recommend_from on recommend.rec_from_id=recommend_from.recf_id
GO

-- view stuff_job_type
create view stuff_job_type as select stf_id,jt_name as stf_jt_name from stuff
inner join job on stuff.stf_job_id=job.jb_id
inner join job_type on job.jb_jt_id=job_type.jt_id
GO
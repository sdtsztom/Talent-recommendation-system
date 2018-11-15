use tal_rec_sys
GO

-- veiw SRM_OPEN
create view SRM_OPEN as select rec_id,rec_rp_id,rec_rr_id,stf_name as rec_stf_name,rp_name as rec_rp_name,recf_desc as rec_from_desc 
from recommend inner join stuff on recommend.rec_recstu_id=stuff.stf_id
inner join recommend_people on recommend.rec_rp_id =recommend_people.rp_id
inner join recommend_from on recommend.rec_from_id=recommend_from.recf_id
GO

-- view stuff_job_type
create view stuff_job_type as select stf_id,jt_name as stf_jt_name from stuff
inner join job on stuff.stf_job_id=job.jb_id
inner join job_type on job.jb_jt_id=job_type.jt_id
GO

-- view recommend_person_details
create view recommend_person_details as select rp_id,rp_name,rp_sex,rp_age,rp_tel_num,rp_email,rp_job,deg_name as rp_deg_name,
uni_name as rp_uni_name,rp_stu,rp_grt,rp_maj,rp_abi,rp_res_path,rp_vali from recommend_people
inner join degree on recommend_people.rp_deg=degree.deg_id
inner join university on recommend_people.rp_uni=university.uni_id
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
GO

-- view requirement_details
create view requirement_details as select rr_id,rr_hr_id,rr_num,ed_name,st_name,st_desc,wp_name,
wp_detail,jb_name,jb_desc,jb_sal,jt_name,jt_desc,dp_name,dp_contact,rr_spreq
from recruitment_requirements inner join  work_place on recruitment_requirements.rr_wp_id = work_place.wp_id
inner join stuff_type on recruitment_requirements.rr_st_id = stuff_type.st_id
inner join requirements_common_info on recruitment_requirements.rr_ri_id = requirements_common_info.ri_id
inner join emergency_degree on recruitment_requirements.rr_ed_id = emergency_degree.ed_id
inner join departments on requirements_common_info.ri_dpt_id = departments.dp_id
inner join job on requirements_common_info.ri_job_id = job.jb_id
inner join job_type on job.jb_jt_id = job_type.jt_id
GO

-- view requirement_info_view
create view requirement_info_view as select ri_id,jb_name,jt_name,jb_sal,dp_name
from requirements_common_info inner join job on requirements_common_info.ri_job_id = job.jb_id
inner join job_type on job.jb_jt_id = job_type.jt_id
inner join departments on requirements_common_info.ri_dpt_id = departments.dp_id
GO

-- view requirement_list
create view requirement_list as select rr_id,rr_hr_id,rr_num,rr_ed_id,ed_name,wp_name,jb_name,rr_el,rr_sta_id
from recruitment_requirements inner join  work_place on recruitment_requirements.rr_wp_id = work_place.wp_id
inner join emergency_degree on recruitment_requirements.rr_ed_id = emergency_degree.ed_id
inner join requirements_common_info on recruitment_requirements.rr_ri_id = requirements_common_info.ri_id
inner join job on requirements_common_info.ri_job_id = job.jb_id
GO
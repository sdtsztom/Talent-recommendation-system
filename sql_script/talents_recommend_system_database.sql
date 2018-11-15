/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2016                    */
/* Created on:     2018/11/15 21:13:10                          */
/*==============================================================*/
--create database tal_rec_sys
GO
use tal_rec_sys
GO

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('departments') and o.name = 'FK_DEPARTME_DP_COR_CO_STUFF')
alter table departments
   drop constraint FK_DEPARTME_DP_COR_CO_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview') and o.name = 'FK_INTERVIE_INT_COR_R_RECRUITM')
alter table interview
   drop constraint FK_INTERVIE_INT_COR_R_RECRUITM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview') and o.name = 'FK_INTERVIE_IP_IN_ITV_INTERVIE')
alter table interview
   drop constraint FK_INTERVIE_IP_IN_ITV_INTERVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview') and o.name = 'FK_INTERVIE_ITV_COR_H_STUFF')
alter table interview
   drop constraint FK_INTERVIE_ITV_COR_H_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview') and o.name = 'FK_INTERVIE_ITV_COR_I_INTERVIE')
alter table interview
   drop constraint FK_INTERVIE_ITV_COR_I_INTERVIE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview') and o.name = 'FK_INTERVIE_ITV_COR_R_RECOMMEN')
alter table interview
   drop constraint FK_INTERVIE_ITV_COR_R_RECOMMEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('interview_place') and o.name = 'FK_INTERVIE_WP_IN_IP_WORK_PLA')
alter table interview_place
   drop constraint FK_INTERVIE_WP_IN_IP_WORK_PLA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('job') and o.name = 'FK_JOB_TYPE_IN_JOB')
alter table job
   drop constraint FK_JOB_TYPE_IN_JOB
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('points_change') and o.name = 'FK_POINTS_C_PCH_COR_R_POINTS_C')
alter table points_change
   drop constraint FK_POINTS_C_PCH_COR_R_POINTS_C
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('points_change') and o.name = 'FK_POINTS_C_PCH_COR_S_STUFF')
alter table points_change
   drop constraint FK_POINTS_C_PCH_COR_S_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_H_STUFF')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_H_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_D_RECOMMEN')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_D_RECOMMEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_R_RECRUITM')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_R_RECRUITM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_RECFROM')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_RECFROM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_RECP')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_RECP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_R_STUFF')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_R_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend') and o.name = 'FK_RECOMMEN_REC_COR_S_RECOMMEN')
alter table recommend
   drop constraint FK_RECOMMEN_REC_COR_S_RECOMMEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend_people') and o.name = 'FK_RECOMMEN_RP_COR_DE_DEGREE')
alter table recommend_people
   drop constraint FK_RECOMMEN_RP_COR_DE_DEGREE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recommend_people') and o.name = 'FK_RECOMMEN_RP_COR_UN_UNIVERSI')
alter table recommend_people
   drop constraint FK_RECOMMEN_RP_COR_UN_UNIVERSI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_HRID_IN_R_STUFF')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_HRID_IN_R_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_EM_IN_REC_EMERGENC')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_EM_IN_REC_EMERGENC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_REC_COR_D_REQUIREM')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_REC_COR_D_REQUIREM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_RR_COR_ST_RECRUITM')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_RR_COR_ST_RECRUITM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_STUFF_TYP_STUFF_TY')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_STUFF_TYP_STUFF_TY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('recruitment_requirements') and o.name = 'FK_RECRUITM_WORKPLACE_WORK_PLA')
alter table recruitment_requirements
   drop constraint FK_RECRUITM_WORKPLACE_WORK_PLA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('requirements_common_info') and o.name = 'FK_REQUIREM_DP_IN_REC_DEPARTME')
alter table requirements_common_info
   drop constraint FK_REQUIREM_DP_IN_REC_DEPARTME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('requirements_common_info') and o.name = 'FK_REQUIREM_JOB_IN_RE_JOB')
alter table requirements_common_info
   drop constraint FK_REQUIREM_JOB_IN_RE_JOB
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('role_grant') and o.name = 'FK_ROLE_GRA_ROLE_GRAN_STUFF')
alter table role_grant
   drop constraint FK_ROLE_GRA_ROLE_GRAN_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('role_grant') and o.name = 'FK_ROLE_GRA_ROLE_GRAN_ROLE')
alter table role_grant
   drop constraint FK_ROLE_GRA_ROLE_GRAN_ROLE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('stuff') and o.name = 'FK_STUFF_HAVE_JOB_JOB')
alter table stuff
   drop constraint FK_STUFF_HAVE_JOB_JOB
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('stuff') and o.name = 'FK_STUFF_STF_COR_D_DEPARTME')
alter table stuff
   drop constraint FK_STUFF_STF_COR_D_DEPARTME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('talents') and o.name = 'FK_TALENTS_DEAL_HR_I_STUFF')
alter table talents
   drop constraint FK_TALENTS_DEAL_HR_I_STUFF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('talents') and o.name = 'FK_TALENTS_FROM_IN_T_TALENTS_')
alter table talents
   drop constraint FK_TALENTS_FROM_IN_T_TALENTS_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('talents') and o.name = 'FK_TALENTS_RP_ID_IN _RECOMMEN')
alter table talents
   drop constraint "FK_TALENTS_RP_ID_IN _RECOMMEN"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('degree')
            and   type = 'U')
   drop table degree
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('departments')
            and   name  = 'dp_cor_contacts_FK'
            and   indid > 0
            and   indid < 255)
   drop index departments.dp_cor_contacts_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('departments')
            and   type = 'U')
   drop table departments
go

if exists (select 1
            from  sysobjects
           where  id = object_id('emergency_degree')
            and   type = 'U')
   drop table emergency_degree
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview')
            and   name  = 'itv_cor_hr_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview.itv_cor_hr_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview')
            and   name  = 'int_cor_rrid_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview.int_cor_rrid_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview')
            and   name  = 'itv_cor_rp_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview.itv_cor_rp_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview')
            and   name  = 'itv_cor_itv_result_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview.itv_cor_itv_result_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview')
            and   name  = 'ip_in_itv_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview.ip_in_itv_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('interview')
            and   type = 'U')
   drop table interview
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('interview_place')
            and   name  = 'wp_in_ip_FK'
            and   indid > 0
            and   indid < 255)
   drop index interview_place.wp_in_ip_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('interview_place')
            and   type = 'U')
   drop table interview_place
go

if exists (select 1
            from  sysobjects
           where  id = object_id('interview_results')
            and   type = 'U')
   drop table interview_results
go

if exists (select 1
            from  sysobjects
           where  id = object_id('job')
            and   type = 'U')
   drop table job
go

if exists (select 1
            from  sysobjects
           where  id = object_id('job_type')
            and   type = 'U')
   drop table job_type
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('points_change')
            and   name  = 'pch_cor_stuff_FK'
            and   indid > 0
            and   indid < 255)
   drop index points_change.pch_cor_stuff_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('points_change')
            and   name  = 'pch_cor_rule_FK'
            and   indid > 0
            and   indid < 255)
   drop index points_change.pch_cor_rule_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('points_change')
            and   type = 'U')
   drop table points_change
go

if exists (select 1
            from  sysobjects
           where  id = object_id('points_change_rule')
            and   type = 'U')
   drop table points_change_rule
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_recfrom_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_recfrom_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_recstf_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_recstf_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_rec_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_stage_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_stage_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_result_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_result_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_HRid_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_HRid_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend')
            and   name  = 'rec_cor_rp_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend.rec_cor_rp_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recommend')
            and   type = 'U')
   drop table recommend
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recommend_from')
            and   type = 'U')
   drop table recommend_from
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend_people')
            and   name  = 'rp_cor_uni_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend_people.rp_cor_uni_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recommend_people')
            and   name  = 'rp_cor_deg_FK'
            and   indid > 0
            and   indid < 255)
   drop index recommend_people.rp_cor_deg_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recommend_people')
            and   type = 'U')
   drop table recommend_people
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recommend_results')
            and   type = 'U')
   drop table recommend_results
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recommend_stage')
            and   type = 'U')
   drop table recommend_stage
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'HRid_in_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.HRid_in_rec_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'stuff_type_in_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.stuff_type_in_rec_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'rr_cor_sta_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.rr_cor_sta_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'rec_cor_detail_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.rec_cor_detail_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'em_in_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.em_in_rec_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('recruitment_requirements')
            and   name  = 'workplace_in_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index recruitment_requirements.workplace_in_rec_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recruitment_requirements')
            and   type = 'U')
   drop table recruitment_requirements
go

if exists (select 1
            from  sysobjects
           where  id = object_id('recruitment_requirements_stage')
            and   type = 'U')
   drop table recruitment_requirements_stage
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('requirements_common_info')
            and   name  = 'dp_in_rec_FK'
            and   indid > 0
            and   indid < 255)
   drop index requirements_common_info.dp_in_rec_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('requirements_common_info')
            and   name  = 'job_in_req_info_FK'
            and   indid > 0
            and   indid < 255)
   drop index requirements_common_info.job_in_req_info_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('requirements_common_info')
            and   type = 'U')
   drop table requirements_common_info
go

if exists (select 1
            from  sysobjects
           where  id = object_id('role')
            and   type = 'U')
   drop table role
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('role_grant')
            and   name  = 'role_grant_FK'
            and   indid > 0
            and   indid < 255)
   drop index role_grant.role_grant_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('role_grant')
            and   name  = 'role_grant2_FK'
            and   indid > 0
            and   indid < 255)
   drop index role_grant.role_grant2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('role_grant')
            and   type = 'U')
   drop table role_grant
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('stuff')
            and   name  = 'stf_cor_dp_FK'
            and   indid > 0
            and   indid < 255)
   drop index stuff.stf_cor_dp_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('stuff')
            and   name  = 'have_job_FK'
            and   indid > 0
            and   indid < 255)
   drop index stuff.have_job_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('stuff')
            and   type = 'U')
   drop table stuff
go

if exists (select 1
            from  sysobjects
           where  id = object_id('stuff_type')
            and   type = 'U')
   drop table stuff_type
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('talents')
            and   name  = 'rp_id_in _talents_FK'
            and   indid > 0
            and   indid < 255)
   drop index talents."rp_id_in _talents_FK"
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('talents')
            and   name  = 'from_in_talents_FK'
            and   indid > 0
            and   indid < 255)
   drop index talents.from_in_talents_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('talents')
            and   name  = 'deal_HR_in_talents_FK'
            and   indid > 0
            and   indid < 255)
   drop index talents.deal_HR_in_talents_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('talents')
            and   type = 'U')
   drop table talents
go

if exists (select 1
            from  sysobjects
           where  id = object_id('talents_from')
            and   type = 'U')
   drop table talents_from
go

if exists (select 1
            from  sysobjects
           where  id = object_id('university')
            and   type = 'U')
   drop table university
go

if exists (select 1
            from  sysobjects
           where  id = object_id('work_place')
            and   type = 'U')
   drop table work_place
go

if exists(select 1 from systypes where name='dm_if')
   execute sp_unbindrule dm_if
go

if exists(select 1 from systypes where name='dm_if')
   drop type dm_if
go

if exists(select 1 from systypes where name='dm_sex')
   execute sp_unbindrule dm_sex
go

if exists(select 1 from systypes where name='dm_sex')
   drop type dm_sex
go

if exists (select 1 from sysobjects where id=object_id('R_dm_if') and type='R')
   drop rule  R_dm_if
go

if exists (select 1 from sysobjects where id=object_id('R_dm_sex') and type='R')
   drop rule  R_dm_sex
go

create rule R_dm_if as
      @column in ('ÊÇ','·ñ')
go

create rule R_dm_sex as
      @column in ('ÄĞ','Å®')
go

/*==============================================================*/
/* Domain: dm_if                                                */
/*==============================================================*/
create type dm_if
   from char(2)
go

execute sp_bindrule R_dm_if, dm_if
go

/*==============================================================*/
/* Domain: dm_sex                                               */
/*==============================================================*/
create type dm_sex
   from char(2)
go

execute sp_bindrule R_dm_sex, dm_sex
go

/*==============================================================*/
/* Table: degree                                                */
/*==============================================================*/
create table degree (
   deg_id               tinyint              identity,
   deg_name             char(40)             not null,
   constraint PK_DEGREE primary key (deg_id)
)
go

/*==============================================================*/
/* Table: departments                                           */
/*==============================================================*/
create table departments (
   dp_id                smallint             identity,
   stf_id               smallint             null,
   dp_name              char(40)             not null,
   constraint PK_DEPARTMENTS primary key (dp_id)
)
go

/*==============================================================*/
/* Index: dp_cor_contacts_FK                                    */
/*==============================================================*/




create nonclustered index dp_cor_contacts_FK on departments (stf_id ASC)
go

/*==============================================================*/
/* Table: emergency_degree                                      */
/*==============================================================*/
create table emergency_degree (
   ed_id                tinyint              identity,
   ed_name              char(40)             not null,
   ed_desc              varchar(Max)         null,
   constraint PK_EMERGENCY_DEGREE primary key (ed_id)
)
go

/*==============================================================*/
/* Table: interview                                             */
/*==============================================================*/
create table interview (
   itv_id               int                  identity,
   itv_pl_id            smallint             not null,
   itv_res_id           tinyint              not null,
   itv_rp_id            int                  not null,
   itv_dealHR_id        smallint             not null,
   itv_rr_id            int                  null,
   itv_rnd              tinyint              not null,
   itv_time             datetime             not null,
   itv_exmer_id         varchar(Max)         not null,
   itv_detals           text                 null,
   constraint PK_INTERVIEW primary key (itv_id)
)
go

/*==============================================================*/
/* Index: ip_in_itv_FK                                          */
/*==============================================================*/




create nonclustered index ip_in_itv_FK on interview (itv_pl_id ASC)
go

/*==============================================================*/
/* Index: itv_cor_itv_result_FK                                 */
/*==============================================================*/




create nonclustered index itv_cor_itv_result_FK on interview (itv_res_id ASC)
go

/*==============================================================*/
/* Index: itv_cor_rp_FK                                         */
/*==============================================================*/




create nonclustered index itv_cor_rp_FK on interview (itv_rp_id ASC)
go

/*==============================================================*/
/* Index: int_cor_rrid_FK                                       */
/*==============================================================*/




create nonclustered index int_cor_rrid_FK on interview (itv_rr_id ASC)
go

/*==============================================================*/
/* Index: itv_cor_hr_FK                                         */
/*==============================================================*/




create nonclustered index itv_cor_hr_FK on interview (itv_dealHR_id ASC)
go

/*==============================================================*/
/* Table: interview_place                                       */
/*==============================================================*/
create table interview_place (
   ip_id                smallint             identity,
   ip_wp_id             tinyint              not null,
   ip_detail            varchar(Max)         not null,
   constraint PK_INTERVIEW_PLACE primary key (ip_id)
)
go

/*==============================================================*/
/* Index: wp_in_ip_FK                                           */
/*==============================================================*/




create nonclustered index wp_in_ip_FK on interview_place (ip_wp_id ASC)
go

/*==============================================================*/
/* Table: interview_results                                     */
/*==============================================================*/
create table interview_results (
   ir_id                tinyint              identity,
   ir_desc              char(40)             not null,
   constraint PK_INTERVIEW_RESULTS primary key (ir_id)
)
go

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job (
   jb_id                smallint             identity,
   jb_jt_id             tinyint              not null,
   jb_name              char(40)             not null,
   jb_desc              varchar(256)         null,
   jb_sal               smallint             not null,
   constraint PK_JOB primary key (jb_id)
)
go

/*==============================================================*/
/* Table: job_type                                              */
/*==============================================================*/
create table job_type (
   jt_id                tinyint              identity,
   jt_name              char(40)             not null,
   jt_desc              varchar(Max)         null,
   constraint PK_JOB_TYPE primary key (jt_id)
)
go

/*==============================================================*/
/* Table: points_change                                         */
/*==============================================================*/
create table points_change (
   pch_id               int                  identity,
   pch_from_id          tinyint              not null,
   pch_stf_id           smallint             not null,
   pch_time             datetime             not null,
   constraint PK_POINTS_CHANGE primary key (pch_id)
)
go

/*==============================================================*/
/* Index: pch_cor_rule_FK                                       */
/*==============================================================*/




create nonclustered index pch_cor_rule_FK on points_change (pch_from_id ASC)
go

/*==============================================================*/
/* Index: pch_cor_stuff_FK                                      */
/*==============================================================*/




create nonclustered index pch_cor_stuff_FK on points_change (pch_stf_id ASC)
go

/*==============================================================*/
/* Table: points_change_rule                                    */
/*==============================================================*/
create table points_change_rule (
   ptchr_id             tinyint              identity,
   ptchr_desc           varchar(Max)         not null,
   ptchr_change         smallint             not null,
   constraint PK_POINTS_CHANGE_RULE primary key (ptchr_id)
)
go

/*==============================================================*/
/* Table: recommend                                             */
/*==============================================================*/
create table recommend (
   rec_id               int                  identity,
   rec_rp_id            int                  not null,
   rec_recstu_id        smallint             not null,
   rec_recres_id        tinyint              not null,
   rec_recsta_id        tinyint              not null,
   rec_rr_id            int                  not null,
   rec_dealHR_id        smallint             not null,
   rec_from_id          tinyint              not null,
   constraint PK_RECOMMEND primary key (rec_id)
)
go

/*==============================================================*/
/* Index: rec_cor_rp_FK                                         */
/*==============================================================*/




create nonclustered index rec_cor_rp_FK on recommend (rec_rp_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_HRid_FK                                       */
/*==============================================================*/




create nonclustered index rec_cor_HRid_FK on recommend (rec_recstu_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_result_FK                                     */
/*==============================================================*/




create nonclustered index rec_cor_result_FK on recommend (rec_recres_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_stage_FK                                      */
/*==============================================================*/




create nonclustered index rec_cor_stage_FK on recommend (rec_recsta_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_rec_FK                                        */
/*==============================================================*/




create nonclustered index rec_cor_rec_FK on recommend (rec_rr_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_recstf_FK                                     */
/*==============================================================*/




create nonclustered index rec_cor_recstf_FK on recommend (rec_dealHR_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_recfrom_FK                                    */
/*==============================================================*/




create nonclustered index rec_cor_recfrom_FK on recommend (rec_from_id ASC)
go

/*==============================================================*/
/* Table: recommend_from                                        */
/*==============================================================*/
create table recommend_from (
   recf_id              tinyint              identity,
   recf_desc            char(40)             not null,
   constraint PK_RECOMMEND_FROM primary key (recf_id)
)
go

/*==============================================================*/
/* Table: recommend_people                                      */
/*==============================================================*/
create table recommend_people (
   rp_id                int                  identity,
   rp_deg               tinyint              not null,
   rp_uni               tinyint              not null,
   rp_name              char(40)             not null,
   rp_sex               dm_sex               not null,
   rp_age               tinyint              not null,
   rp_tel_num           char(40)             not null,
   rp_email             char(40)             not null,
   rp_stu               dm_if                not null,
   rp_grt               datetime             not null,
   rp_maj               char(40)             not null,
   rp_abi               varchar(Max)         not null,
   rp_res_path          varchar(Max)         not null,
   rp_vali              dm_if                not null,
   rp_job               char(40)             not null,
   constraint PK_RECOMMEND_PEOPLE primary key (rp_id)
)
go

/*==============================================================*/
/* Index: rp_cor_deg_FK                                         */
/*==============================================================*/




create nonclustered index rp_cor_deg_FK on recommend_people (rp_deg ASC)
go

/*==============================================================*/
/* Index: rp_cor_uni_FK                                         */
/*==============================================================*/




create nonclustered index rp_cor_uni_FK on recommend_people (rp_uni ASC)
go

/*==============================================================*/
/* Table: recommend_results                                     */
/*==============================================================*/
create table recommend_results (
   rec_res_id           tinyint              identity,
   rec_desc             char(40)             not null,
   constraint PK_RECOMMEND_RESULTS primary key (rec_res_id)
)
go

/*==============================================================*/
/* Table: recommend_stage                                       */
/*==============================================================*/
create table recommend_stage (
   rec_sta_id           tinyint              identity,
   rec_sta_desc         char(40)             not null,
   constraint PK_RECOMMEND_STAGE primary key (rec_sta_id)
)
go

/*==============================================================*/
/* Table: recruitment_requirements                              */
/*==============================================================*/
create table recruitment_requirements (
   rr_id                int                  identity,
   rr_wp_id             tinyint              not null,
   rr_ed_id             tinyint              not null,
   rr_st_id             tinyint              not null,
   rr_hr_id             smallint             not null,
   rr_ri_id             int                  not null,
   rr_sta_id            tinyint              not null,
   rr_num               smallint             not null,
   rr_el                datetime             not null,
   rr_ept               tinyint              null,
   rr_spreq             text                 null,
   constraint PK_RECRUITMENT_REQUIREMENTS primary key (rr_id)
)
go

/*==============================================================*/
/* Index: workplace_in_rec_FK                                   */
/*==============================================================*/




create nonclustered index workplace_in_rec_FK on recruitment_requirements (rr_wp_id ASC)
go

/*==============================================================*/
/* Index: em_in_rec_FK                                          */
/*==============================================================*/




create nonclustered index em_in_rec_FK on recruitment_requirements (rr_ed_id ASC)
go

/*==============================================================*/
/* Index: rec_cor_detail_FK                                     */
/*==============================================================*/




create nonclustered index rec_cor_detail_FK on recruitment_requirements (rr_ri_id ASC)
go

/*==============================================================*/
/* Index: rr_cor_sta_FK                                         */
/*==============================================================*/




create nonclustered index rr_cor_sta_FK on recruitment_requirements (rr_sta_id ASC)
go

/*==============================================================*/
/* Index: stuff_type_in_rec_FK                                  */
/*==============================================================*/




create nonclustered index stuff_type_in_rec_FK on recruitment_requirements (rr_st_id ASC)
go

/*==============================================================*/
/* Index: HRid_in_rec_FK                                        */
/*==============================================================*/




create nonclustered index HRid_in_rec_FK on recruitment_requirements (rr_hr_id ASC)
go

/*==============================================================*/
/* Table: recruitment_requirements_stage                        */
/*==============================================================*/
create table recruitment_requirements_stage (
   rrs_id               tinyint              identity,
   rrs_desc             char(40)             not null,
   constraint PK_RECRUITMENT_REQUIREMENTS_ST primary key (rrs_id)
)
go

/*==============================================================*/
/* Table: requirements_common_info                              */
/*==============================================================*/
create table requirements_common_info (
   ri_id                int                  identity,
   ri_job_id            smallint             not null,
   ri_dpt_id            smallint             not null,
   ri_desc              text                 not null,
   ri_req               text                 not null,
   constraint PK_REQUIREMENTS_COMMON_INFO primary key (ri_id)
)
go

/*==============================================================*/
/* Index: job_in_req_info_FK                                    */
/*==============================================================*/




create nonclustered index job_in_req_info_FK on requirements_common_info (ri_job_id ASC)
go

/*==============================================================*/
/* Index: dp_in_rec_FK                                          */
/*==============================================================*/




create nonclustered index dp_in_rec_FK on requirements_common_info (ri_dpt_id ASC)
go

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role (
   role_id              tinyint              identity,
   role_desc            varchar(Max)         not null,
   constraint PK_ROLE primary key (role_id)
)
go

/*==============================================================*/
/* Table: role_grant                                            */
/*==============================================================*/
create table role_grant (
   stf_id               smallint             not null,
   role_id              tinyint              not null,
   constraint PK_ROLE_GRANT primary key (stf_id, role_id)
)
go

/*==============================================================*/
/* Index: role_grant2_FK                                        */
/*==============================================================*/




create nonclustered index role_grant2_FK on role_grant (role_id ASC)
go

/*==============================================================*/
/* Index: role_grant_FK                                         */
/*==============================================================*/




create nonclustered index role_grant_FK on role_grant (stf_id ASC)
go

/*==============================================================*/
/* Table: stuff                                                 */
/*==============================================================*/
create table stuff (
   stf_id               smallint             identity,
   stf_job_id           smallint             not null,
   stf_dp_id            smallint             not null,
   stf_name             char(40)             not null,
   stf_age              tinyint              not null,
   stf_sex              dm_sex               not null,
   stf_username         char(40)             null,
   stf_pwd              char(40)             null,
   stf_email            char(40)             not null,
   stf_pts              smallint             not null,
   stf_tel              char(40)             not null,
   constraint PK_STUFF primary key (stf_id)
)
go

/*==============================================================*/
/* Index: have_job_FK                                           */
/*==============================================================*/




create nonclustered index have_job_FK on stuff (stf_job_id ASC)
go

/*==============================================================*/
/* Index: stf_cor_dp_FK                                         */
/*==============================================================*/




create nonclustered index stf_cor_dp_FK on stuff (stf_dp_id ASC)
go

/*==============================================================*/
/* Table: stuff_type                                            */
/*==============================================================*/
create table stuff_type (
   st_id                tinyint              identity,
   st_name              char(20)             not null,
   st_desc              varchar(Max)         null,
   constraint PK_STUFF_TYPE primary key (st_id)
)
go

/*==============================================================*/
/* Table: talents                                               */
/*==============================================================*/
create table talents (
   tal_id               int                  identity,
   tal_from_id          tinyint              not null,
   tal_rp_id            int                  not null,
   tal_dealHR_id        smallint             not null,
   constraint PK_TALENTS primary key (tal_id)
)
go

/*==============================================================*/
/* Index: deal_HR_in_talents_FK                                 */
/*==============================================================*/




create nonclustered index deal_HR_in_talents_FK on talents (tal_dealHR_id ASC)
go

/*==============================================================*/
/* Index: from_in_talents_FK                                    */
/*==============================================================*/




create nonclustered index from_in_talents_FK on talents (tal_from_id ASC)
go

/*==============================================================*/
/* Index: "rp_id_in _talents_FK"                                */
/*==============================================================*/




create nonclustered index "rp_id_in _talents_FK" on talents (tal_rp_id ASC)
go

/*==============================================================*/
/* Table: talents_from                                          */
/*==============================================================*/
create table talents_from (
   tf_id                tinyint              identity,
   tf_desc              varchar(Max)         not null,
   constraint PK_TALENTS_FROM primary key (tf_id)
)
go

/*==============================================================*/
/* Table: university                                            */
/*==============================================================*/
create table university (
   uni_id               tinyint              identity,
   uni_name             char(40)             not null,
   constraint PK_UNIVERSITY primary key (uni_id)
)
go

/*==============================================================*/
/* Table: work_place                                            */
/*==============================================================*/
create table work_place (
   wp_id                tinyint              identity,
   wp_name              char(40)             not null,
   wp_detail            varchar(Max)         not null,
   constraint PK_WORK_PLACE primary key (wp_id)
)
go

alter table departments
   add constraint FK_DEPARTME_DP_COR_CO_STUFF foreign key (stf_id)
      references stuff (stf_id)
go

alter table interview
   add constraint FK_INTERVIE_INT_COR_R_RECRUITM foreign key (itv_rr_id)
      references recruitment_requirements (rr_id)
go

alter table interview
   add constraint FK_INTERVIE_IP_IN_ITV_INTERVIE foreign key (itv_pl_id)
      references interview_place (ip_id)
go

alter table interview
   add constraint FK_INTERVIE_ITV_COR_H_STUFF foreign key (itv_dealHR_id)
      references stuff (stf_id)
go

alter table interview
   add constraint FK_INTERVIE_ITV_COR_I_INTERVIE foreign key (itv_res_id)
      references interview_results (ir_id)
go

alter table interview
   add constraint FK_INTERVIE_ITV_COR_R_RECOMMEN foreign key (itv_rp_id)
      references recommend_people (rp_id)
go

alter table interview_place
   add constraint FK_INTERVIE_WP_IN_IP_WORK_PLA foreign key (ip_wp_id)
      references work_place (wp_id)
go

alter table job
   add constraint FK_JOB_TYPE_IN_JOB foreign key (jb_jt_id)
      references job_type (jt_id)
go

alter table points_change
   add constraint FK_POINTS_C_PCH_COR_R_POINTS_C foreign key (pch_from_id)
      references points_change_rule (ptchr_id)
go

alter table points_change
   add constraint FK_POINTS_C_PCH_COR_S_STUFF foreign key (pch_stf_id)
      references stuff (stf_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_H_STUFF foreign key (rec_recstu_id)
      references stuff (stf_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_D_RECOMMEN foreign key (rec_recres_id)
      references recommend_results (rec_res_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_R_RECRUITM foreign key (rec_rr_id)
      references recruitment_requirements (rr_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_RECFROM foreign key (rec_from_id)
      references recommend_from (recf_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_RECP foreign key (rec_rp_id)
      references recommend_people (rp_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_R_STUFF foreign key (rec_dealHR_id)
      references stuff (stf_id)
go

alter table recommend
   add constraint FK_RECOMMEN_REC_COR_S_RECOMMEN foreign key (rec_recsta_id)
      references recommend_stage (rec_sta_id)
go

alter table recommend_people
   add constraint FK_RECOMMEN_RP_COR_DE_DEGREE foreign key (rp_deg)
      references degree (deg_id)
go

alter table recommend_people
   add constraint FK_RECOMMEN_RP_COR_UN_UNIVERSI foreign key (rp_uni)
      references university (uni_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_HRID_IN_R_STUFF foreign key (rr_hr_id)
      references stuff (stf_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_EM_IN_REC_EMERGENC foreign key (rr_ed_id)
      references emergency_degree (ed_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_REC_COR_D_REQUIREM foreign key (rr_ri_id)
      references requirements_common_info (ri_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_RR_COR_ST_RECRUITM foreign key (rr_sta_id)
      references recruitment_requirements_stage (rrs_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_STUFF_TYP_STUFF_TY foreign key (rr_st_id)
      references stuff_type (st_id)
go

alter table recruitment_requirements
   add constraint FK_RECRUITM_WORKPLACE_WORK_PLA foreign key (rr_wp_id)
      references work_place (wp_id)
go

alter table requirements_common_info
   add constraint FK_REQUIREM_DP_IN_REC_DEPARTME foreign key (ri_dpt_id)
      references departments (dp_id)
go

alter table requirements_common_info
   add constraint FK_REQUIREM_JOB_IN_RE_JOB foreign key (ri_job_id)
      references job (jb_id)
go

alter table role_grant
   add constraint FK_ROLE_GRA_ROLE_GRAN_STUFF foreign key (stf_id)
      references stuff (stf_id)
go

alter table role_grant
   add constraint FK_ROLE_GRA_ROLE_GRAN_ROLE foreign key (role_id)
      references role (role_id)
go

alter table stuff
   add constraint FK_STUFF_HAVE_JOB_JOB foreign key (stf_job_id)
      references job (jb_id)
go

alter table stuff
   add constraint FK_STUFF_STF_COR_D_DEPARTME foreign key (stf_dp_id)
      references departments (dp_id)
go

alter table talents
   add constraint FK_TALENTS_DEAL_HR_I_STUFF foreign key (tal_dealHR_id)
      references stuff (stf_id)
go

alter table talents
   add constraint FK_TALENTS_FROM_IN_T_TALENTS_ foreign key (tal_from_id)
      references talents_from (tf_id)
go

alter table talents
   add constraint "FK_TALENTS_RP_ID_IN _RECOMMEN" foreign key (tal_rp_id)
      references recommend_people (rp_id)
go


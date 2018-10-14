-- table role
insert into role values(0,'Admin，拥有最高权限')
insert into role values(1,'stuff')
insert into role values(2,'HR')

-- table degree
insert into degree values(0,'本科')

-- table department
insert into departments values(0,NULL,'技术部门')
insert into departments values(1,NULL,'人事部门')
insert into departments values(2,NULL,'管理部门')

-- table emergency_degree
insert into emergency_degree values(0,'一级','最高级紧急度')

-- table work_place
insert into work_place values(0,'杭州','江干区杭州电子科技大学')

-- table university
insert into university values(0,'杭州电子科技大学')

-- table interview_place
insert into interview_place values(0,0,'一楼面试大厅')

-- table interview_results
insert into interview_results values(0,'通过')
insert into interview_results values(1,'不通过')
insert into interview_results values(2,'安排其它需求')

-- table job_type
insert into job_type values(0,'开发人员','开发人员')
insert into job_type values(1,'人事人员','人事人员')
insert into job_type values(2,'管理人员','管理人员')

-- table job
insert into job values(0,0,'C++程序员','C++程序员',5000)
insert into job values(1,1,'HR','HR',2000)
insert into job values(2,2,'项目经理','项目经理',7000)

-- table points_change_rule
insert into points_change_rule values(0,'通过筛选加分',1)
insert into points_change_rule values(1,'通过初次面试等待终面',2)
insert into points_change_rule values(2,'通过终面',2)
insert into points_change_rule values(3,'入职',2)

-- table recommend_from
insert into recommend_from values(0,'员工推荐')
insert into recommend_from values(1,'筛选后推荐')
insert into recommend_from values(2,'通过初级面试后推荐')

-- table recommend_results ，当stage为结束时，result才会有值
insert into recommend_results values(0,'放入人才库')
insert into recommend_results values(1,'安排其它需求')
insert into recommend_results values(2,'不发放offer')
insert into recommend_results values(3,'拒绝offer')
insert into recommend_results values(4,'接受offer并入职')

-- table recommend_stage
insert into recommend_stage values(0,'结束')
insert into recommend_stage values(1,'等待筛选')
insert into recommend_stage values(2,'等待初轮面试')
insert into recommend_stage values(3,'等待最终面试')
insert into recommend_stage values(4,'等待offer确认')
insert into recommend_stage values(5,'等待入职')

-- table talents_from
insert into talents_from values(0,'未通过筛选放入')
insert into talents_from values(1,'通过筛选后放入')
insert into talents_from values(2,'通过初级面试后放入')

-- table stuff_type
insert into stuff_type values(0,'FTE','Full Time Employee')
insert into stuff_type values(1,'PTE','Part Time Employee')

-- table stuff
insert into stuff values(0,0,0,'小明',20,'男','h','123','xm@163.com',0,'18711111111')
insert into stuff values(1,1,1,'小红',20,'女','hh','123','xh@163.com',0,'18711111111')
insert into stuff values(2,2,2,'小白',20,'男','hhh','123','xb@163.com',0,'18711111111')
use tal_rec_sys
GO

-- dbcc checkident(interview,reseed,0)

-- table role
insert into role values('Admin，拥有最高权限')
insert into role values('stuff')
insert into role values('HR')

-- table degree
insert into degree values('本科')
insert into degree values('高中')
insert into degree values('专科')
insert into degree values('硕士')
insert into degree values('博士')
insert into degree values('社会人士')

-- table department
insert into departments values(NULL,'技术部门')
insert into departments values(NULL,'人事部门')
insert into departments values(NULL,'管理部门')

-- table emergency_degree
insert into emergency_degree values('一级','最高级紧急度')
insert into emergency_degree values('二级','')
insert into emergency_degree values('三级','')

-- table work_place
insert into work_place values('杭州','江干区杭州电子科技大学')

-- table university
insert into university values('杭州电子科技大学')

-- table interview_place
insert into interview_place values(1,'一楼面试大厅')

-- table interview_results
insert into interview_results values('通过')
insert into interview_results values('不通过')
insert into interview_results values('安排其它需求')

-- table job_type
insert into job_type values('开发人员','开发人员')
insert into job_type values('人事人员','人事人员')
insert into job_type values('管理人员','管理人员')

-- table job
insert into job values(1,'C++程序员','C++程序员',5000)
insert into job values(2,'HR','HR',2000)
insert into job values(3,'项目经理','项目经理',7000)

-- table points_change_rule
insert into points_change_rule values('通过筛选加分',1)
insert into points_change_rule values('通过初次面试等待终面',2)
insert into points_change_rule values('通过终面',2)
insert into points_change_rule values('入职',2)

-- table interview_results
insert into interview_results values('暂无')
insert into interview_results values('通过')
insert into interview_results values('不通过')

-- table recommend_from
insert into recommend_from values('员工推荐')
insert into recommend_from values('筛选后推荐')
insert into recommend_from values('通过初级面试后推荐')

-- table recommend_results ，当stage为结束时，result才会有值
insert into recommend_results values('放入人才库')
insert into recommend_results values('安排其它需求')
insert into recommend_results values('不发放offer')
insert into recommend_results values('拒绝offer')
insert into recommend_results values('接受offer并入职')
insert into recommend_results values('暂无')
insert into recommend_results values('确认超时')

-- table recommend_stage
insert into recommend_stage values('结束')
insert into recommend_stage values('等待筛选')
insert into recommend_stage values('等待安排(筛选后)')
insert into recommend_stage values('等待初轮面试')
insert into recommend_stage values('等待最终面试')
insert into recommend_stage values('等待offer确认')
insert into recommend_stage values('等待入职')


-- table recruitment_requirement_stage
insert into recruitment_requirements_stage values('结束')
insert into recruitment_requirements_stage values('开放')
insert into recruitment_requirements_stage values('暂时关闭')
insert into recruitment_requirements_stage values('等待筛选')
insert into recruitment_requirements_stage values('等待安排(筛选后)')
insert into recruitment_requirements_stage values('等待初轮面试')
insert into recruitment_requirements_stage values('等待最终面试')
insert into recruitment_requirements_stage values('等待offer确认')
insert into recruitment_requirements_stage values('等待入职')

-- table talents_from
insert into talents_from values('未通过筛选放入')
insert into talents_from values('通过筛选后放入')
insert into talents_from values('通过初级面试后放入')

-- table stuff_type
insert into stuff_type values('FTE','Full Time Employee')
insert into stuff_type values('PTE','Part Time Employee')

-- table stuff
insert into stuff values(1,1,'小明',20,'男','h','123','sdtsztom@163.com',0,'18711111111')
insert into stuff values(2,2,'小红',20,'女','hh','123','sdtsztom@163.com',0,'18711111111')
insert into stuff values(3,3,'小白',20,'男','hhh','123','sdtsztom@163.com',0,'18711111111')

-- table recommend_people
insert into recommend_people values(1,1,'小推','男',22,'13701111111','sdtsztom@163.com','否','2017/06/25','软件工程','java','./xiaotui.pdf','是','测试人员')
insert into recommend_people values(1,1,'小推2','男',22,'13701111111','sdtsztom@163.com','否','2017/06/25','软件工程','java','./xiaotui.pdf','是','测试人员')
insert into recommend_people values(1,1,'小推3','男',22,'13701111111','sdtsztom@163.com','否','2017/06/25','软件工程','java','./xiaotui.pdf','是','测试人员')

-- table requirements_common_info
insert into requirements_common_info values(1,1,'C++开发岗位','熟练掌握C++，优秀应届毕业生')

-- table recruitment_requirements
insert into recruitment_requirements values(1,1,1,2,1,1,1,'2018/12/30',0,'无')
insert into recruitment_requirements values(1,2,1,2,1,2,1,'2019/1/1',0,'无')
insert into recruitment_requirements values(1,3,1,2,1,2,1,'2018/11/10',0,'无')
insert into recruitment_requirements values(1,3,1,2,1,2,1,'2019/1/20',0,'无')
insert into recruitment_requirements values(1,1,1,2,1,2,1,'2019/1/20',0,'无')
insert into recruitment_requirements values(1,2,1,2,1,4,1,'2019/1/1',0,'无')

-- table recommend
insert into recommend values(1,1,6,2,2,2,1)
insert into recommend values(2,1,6,2,2,2,1)
insert into recommend values(3,1,6,2,2,2,1)
insert into recommend values(1,1,6,2,6,2,1)
insert into recommend values(2,1,6,2,6,2,1)
insert into recommend values(3,1,6,2,6,2,1)
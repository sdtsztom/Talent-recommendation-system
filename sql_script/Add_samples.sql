use tal_rec_sys
GO

-- dbcc checkident(interview,reseed,0)

-- table role
insert into role values('Admin��ӵ�����Ȩ��')
insert into role values('stuff')
insert into role values('HR')

-- table degree
insert into degree values('����')
insert into degree values('����')
insert into degree values('ר��')
insert into degree values('˶ʿ')
insert into degree values('��ʿ')
insert into degree values('�����ʿ')

-- table department
insert into departments values(NULL,'��������')
insert into departments values(NULL,'���²���')
insert into departments values(NULL,'������')

-- table emergency_degree
insert into emergency_degree values('һ��','��߼�������')
insert into emergency_degree values('����','')
insert into emergency_degree values('����','')

-- table work_place
insert into work_place values('����','���������ݵ��ӿƼ���ѧ')

-- table university
insert into university values('���ݵ��ӿƼ���ѧ')

-- table interview_place
insert into interview_place values(1,'һ¥���Դ���')

-- table interview_results
insert into interview_results values('ͨ��')
insert into interview_results values('��ͨ��')
insert into interview_results values('������������')

-- table job_type
insert into job_type values('������Ա','������Ա')
insert into job_type values('������Ա','������Ա')
insert into job_type values('������Ա','������Ա')

-- table job
insert into job values(1,'C++����Ա','C++����Ա',5000)
insert into job values(2,'HR','HR',2000)
insert into job values(3,'��Ŀ����','��Ŀ����',7000)

-- table points_change_rule
insert into points_change_rule values('ͨ��ɸѡ�ӷ�',1)
insert into points_change_rule values('ͨ���������Եȴ�����',2)
insert into points_change_rule values('ͨ������',2)
insert into points_change_rule values('��ְ',2)

-- table interview_results
insert into interview_results values('����')
insert into interview_results values('ͨ��')
insert into interview_results values('��ͨ��')

-- table recommend_from
insert into recommend_from values('Ա���Ƽ�')
insert into recommend_from values('ɸѡ���Ƽ�')
insert into recommend_from values('ͨ���������Ժ��Ƽ�')

-- table recommend_results ����stageΪ����ʱ��result�Ż���ֵ
insert into recommend_results values('�����˲ſ�')
insert into recommend_results values('������������')
insert into recommend_results values('������offer')
insert into recommend_results values('�ܾ�offer')
insert into recommend_results values('����offer����ְ')
insert into recommend_results values('����')
insert into recommend_results values('ȷ�ϳ�ʱ')

-- table recommend_stage
insert into recommend_stage values('����')
insert into recommend_stage values('�ȴ�ɸѡ')
insert into recommend_stage values('�ȴ�����(ɸѡ��)')
insert into recommend_stage values('�ȴ���������')
insert into recommend_stage values('�ȴ���������')
insert into recommend_stage values('�ȴ�offerȷ��')
insert into recommend_stage values('�ȴ���ְ')


-- table recruitment_requirement_stage
insert into recruitment_requirements_stage values('����')
insert into recruitment_requirements_stage values('����')
insert into recruitment_requirements_stage values('��ʱ�ر�')
insert into recruitment_requirements_stage values('�ȴ�ɸѡ')
insert into recruitment_requirements_stage values('�ȴ�����(ɸѡ��)')
insert into recruitment_requirements_stage values('�ȴ���������')
insert into recruitment_requirements_stage values('�ȴ���������')
insert into recruitment_requirements_stage values('�ȴ�offerȷ��')
insert into recruitment_requirements_stage values('�ȴ���ְ')

-- table talents_from
insert into talents_from values('δͨ��ɸѡ����')
insert into talents_from values('ͨ��ɸѡ�����')
insert into talents_from values('ͨ���������Ժ����')

-- table stuff_type
insert into stuff_type values('FTE','Full Time Employee')
insert into stuff_type values('PTE','Part Time Employee')

-- table stuff
insert into stuff values(1,1,'С��',20,'��','h','123','sdtsztom@163.com',0,'18711111111')
insert into stuff values(2,2,'С��',20,'Ů','hh','123','sdtsztom@163.com',0,'18711111111')
insert into stuff values(3,3,'С��',20,'��','hhh','123','sdtsztom@163.com',0,'18711111111')

-- table recommend_people
insert into recommend_people values(1,1,'С��','��',22,'13701111111','sdtsztom@163.com','��','2017/06/25','�������','java','./xiaotui.pdf','��','������Ա')
insert into recommend_people values(1,1,'С��2','��',22,'13701111111','sdtsztom@163.com','��','2017/06/25','�������','java','./xiaotui.pdf','��','������Ա')
insert into recommend_people values(1,1,'С��3','��',22,'13701111111','sdtsztom@163.com','��','2017/06/25','�������','java','./xiaotui.pdf','��','������Ա')

-- table requirements_common_info
insert into requirements_common_info values(1,1,'C++������λ','��������C++������Ӧ���ҵ��')

-- table recruitment_requirements
insert into recruitment_requirements values(1,1,1,2,1,1,1,'2018/12/30',0,'��')
insert into recruitment_requirements values(1,2,1,2,1,2,1,'2019/1/1',0,'��')
insert into recruitment_requirements values(1,3,1,2,1,2,1,'2018/11/10',0,'��')
insert into recruitment_requirements values(1,3,1,2,1,2,1,'2019/1/20',0,'��')
insert into recruitment_requirements values(1,1,1,2,1,2,1,'2019/1/20',0,'��')
insert into recruitment_requirements values(1,2,1,2,1,4,1,'2019/1/1',0,'��')

-- table recommend
insert into recommend values(1,1,6,2,2,2,1)
insert into recommend values(2,1,6,2,2,2,1)
insert into recommend values(3,1,6,2,2,2,1)
insert into recommend values(1,1,6,2,6,2,1)
insert into recommend values(2,1,6,2,6,2,1)
insert into recommend values(3,1,6,2,6,2,1)
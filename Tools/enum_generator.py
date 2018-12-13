# -*- coding: utf-8 -*-

import pymssql
import argparse
import csv
import os.path as path

#parser = argparse.ArgumentParser()
#parser.add_argument('-p', '--pass_num',type=int,required=True)
#parser.add_argument('-t', '--table_name',required=True)
#parser.add_argument('-c', '--class_name',required=True)
#args=parser.parse_args()

## receive args
#pass_num=args.pass_num
#tablename=args.table_name
#class_name=args.class_name

# for test
pass_num=2
tablename='recommend_from'
class_name='RecommendFrom'

# config
package_name='ienum'

def gen_csv():
    sql='select * from %s'%(tablename)
    
    conn=pymssql.connect(server='localhost',user='u_dev',password='12345678a',database='tal_rec_sys')
    cur=conn.cursor()
    cur.execute(sql)
    rs=cur.fetchall()
    row_num=cur.rowcount
    conn.close()

    #data=[[0,''] for i in range(row_num)]   # 分配位置，加快速度

    csv_data=''
    
    for i,line in enumerate(rs):
        csv_data+=',%d,%s\n'%(line[0],line[1].rstrip())
        
    filename='%s.csv'%(class_name)
    
    if path.exists(filename):
        confirm=input('file exists,do you want to overwrite?(y/n)')
        assert confirm in ['y','n'],'invalid option'
        if confirm=='n':
            return
    
    with open(filename,'w') as f:
        f.write(csv_data)
    
    print('output successfully!')
    

def gen_enum():
    data=[]
    enum_name=[]
    with open('%s.csv'%(class_name),'r') as f:
        csvf=csv.reader(f)
        for row in csvf:
            data.append(row)
            enum_name.append(row[0])
       
    enum_content=gen_enum_content(data,enum_name)
    
    filename='%s.java'%(class_name)
    
    if path.exists(filename):
        confirm=input('file exists,do you want to overwrite?(y/n)')
        assert confirm in ['y','n'],'invalid option'
        if confirm=='n':
            return
        
    with open('%s.java'%(class_name),'w') as f:
        f.write(enum_content)
        
    print('output successfully!')
    
def gen_enum_content(data,enum_name):
    pkg='package %s;\n'%(package_name)
    
    cls_prefix='public enum %s{\n'%(class_name)
    cls_postfix='}'
    enum_name_line='\t'+','.join(enum_name)+';\n'
    func_toStr=gen_toStr(data)
    func_toId=gen_toId(data)
    
    enum_content=pkg+'\n'+cls_prefix+enum_name_line+'\n'+func_toStr+'\n'+func_toId+'\n'+cls_postfix
    
    return enum_content
    
def gen_toStr(data):
    s='\t@Override\n\tpublic String toString(){\n'+\
        '\t\tString s=null;\n'+'\t\tswitch(this){\n'
    
    for i in range(len(data)):
        s+='\t\t\tcase %s:{s=\"%s\";break;}\n'%(data[i][0],data[i][2])
        
    s+='\t\t}\n\t\treturn s;\n\t}\n'
    return s
    
def gen_toId(data):
    s='\tpublic int toId(){\n'+\
        '\t\tint id=-1;\n'+'\t\tswitch(this){\n'
    
    for i in range(len(data)):
        s+='\t\t\tcase %s:{id=%s;break;}\n'%(data[i][0],data[i][1])
        
    s+='\t\t}\n\t\treturn id;\n\t}\n'
    return s
    
if pass_num==1:
    gen_csv()
elif pass_num==2:
    gen_enum()
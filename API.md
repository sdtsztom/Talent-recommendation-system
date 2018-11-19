# 记录格式
- 二级标题：分类
- 三级标题：网页名
- author:$(your_username)
- Param(method in which parameters should be passed to your page)

# PAGES API
## 积分查询
### view_points
- author:tsz
- Param
|name|value|
|----|-----|
|user|LoginUser class|extract from session|

## 入职确认
### confirm_offer
- author:tsz
- Param(GET)
|name|value|comment|
|----|-----|-------|
|confirm_user|ConfirmUser class|extract from session|
|u|id of recommended person|**used in filter**|
|v|verification info|md5 encrypted phone number;**used in filter**|
注：由于confirm_offer的链接信息为公开，出于安全性的考虑，因此参数的name比较并不使用比较具体的命名

### register
- author:tsz
- Param
|name|value|comment|
|----|-----|-------|
|confirm_user|ConfirmUser class|extract from session|

### exec_register(servlet)
### refuse_offer(servlet)

## Single Recruitment Management
### Single_Rec_vOpen
- author:tsz
- Param(GET)
|name|value|comment|
|----|-----|-------|
|user|LoginUser class|extract from session|
|rrid|recruitment id|-|

## 杂
### util_server(servlet)
|name|value|comment|
|----|-----|-------|
|type|type name|-|
|...|...|depend on what type you choose|

## SUCCESS PAGES
### refuse_offer_success
- author:tsz
- Param
|name|value|comment|
|----|-----|-------|
|confirm_user|ConfirmUser class|extract from session|

### register_success
- author:tsz
- Param
|name|value|comment|
|----|-----|-------|
|confirm_user|ConfirmUser class|extract from session|
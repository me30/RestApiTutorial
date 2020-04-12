# RestApiTutorial


# Crud operation list..

get - readAll   - with paggination
get - read      - by id
get - search     - with paggination - base on string and date fields...
POST - create
PUT - updte
Delete - delete - hard or soft


Above are list of crud for apis which need to create for testing purpose.
Must follow spring boot respose in rest controller for example ResponseEntity [response entity class]

# Exercise 1 :: single table API crud


employee
--------
id      - long
name    -  string
designation - string [CEO, Admin, Project Manager, Accountant, Developer, Team Leader]
joing date - Date

Note :
------
1)use enum class for designation no need master table


# Exercise 2 :: One to Many or Many to One  API crud

employee
--------
id      - long
name    -  string
designation - string [CEO, Admin, Project Manager, Accountant, Developer, Team Leader]
joing date - Date

account
-------
id      - long
acc_number    -  string
employe_id - long

Note:
-----
1) api for account and employee both.. but you can consider excerise 1 api as employee....
2) one to many reverse is many to one so study once api done ..

# Exercise 3 :: Many to Many  API crud

users
-----
id      - long
username - string
password - string
email   - string

groups
------

id - long
name - string

user_groups
-----------
userid - long
groupid - long
activated - tiny int
registrationdate - datetime

Note:
-----
1) User Api - search base on username also return groups which that user belong.
2) groups Api - also return user list for that groups
3)            - in this group api will search registrationdate wise group and return list of data.



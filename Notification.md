# On Top
## About database
Before you write you web pages,you need a correspoding database first.We have provided you a database creating sql script under $(root)/powerdesigner_work
- use `talents_recommend_system_database.sql` to create the database
- use `Add_samples.sql` to add some necessary samples.However,there is little samples.**If you need more samples,we encourage you to add samples in the following way:**
	1. open script Add_sample.sql and and sql statement to add your samples in the script
	2. save the script and just run the statements you added to add your samples
	2. use git to update the script in the github so that every member can keep pace with your work.
- use `add_user.sql add_procedure.sql` to add necessary database roles
- use `Procedures.sql` to add necessary procedures.

## About CommonConnection Class
- For query methods, they'll return null pointer if any Exception threw out.So it's necessary for you to check the returned value whether it is null when you got value from these functions.
- If you are using makeQuery method,there two things you should remember:
	1. Don't forget to close the returned ResultSet
	2. If you use getString() method to get data from ResultSet,than you must need String.trim()to cut off the extra blankspace.

## About API.md
provide your web page API in API.md!
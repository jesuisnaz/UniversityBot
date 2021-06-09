## UniversityBot

#### About
This progam provides an interface to access university database.
Developed with Spring Boot.

#### How to Use
- Provide your database credentials in the `application.properties` file.
- Run the application for the first time to let Hibernate generate needed tables automatically.
- Fill in database data manually.
- Run the application again. Test the functions.

#### Commands
 1. `Who is head of department {department_name}` - Show the head of given department,
 2. `Show {department_name} statistics` - Show statistics for given department,
 3. `Show the average salary for the department {department_name}` - Show the average salary for the given department,
 4. `Show count of employee for {department_name}` - Show count of employees for the given department, and
 6. `Global search by {template}` - Search for employees with the given pattern.


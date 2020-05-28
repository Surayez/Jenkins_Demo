# BlogSpring JENKINS CI
This is a simple SpringBoot application demonstrating a backend prototype for a personal blogging system, with a local H2 database. This application is running with CI via Jenkins pipeline.

## Features and Design
Three important components of the system are: Users, Blog and Comments. The idea of this application is such that anyone can add a blog or comment to this system, but if a user is already registered, 
they do not need to enter the user details when writing a blog or comment, those information would be autofilled.

### Users
The application allows users to be stored with email, first-name and last-name. Users are managed using some of the following APIs:
- /user [POST] - New users can be created with email, first-name and last-name.
- /user/{id} - User details can be modified
- /userBlogs/{id} - Get API to retrieve all the blog written by a user with given userID.
- /user/{id} - To delete a user. 

### Blog
A Blog can be created by either a user, or anyone else if they include their email, first-name and last-name. 
- /blog [POST] - This API can be used to insert a new blog with blogText and user details. If the query field UserID is provided, the code will perform a check if a valid user with that ID is available.
If available, the blog will be stored with that user details. Otherwise the app will take the input email and names given with this API call as blog author details.

#### Voting
Anyone can up-vote or down-vote each blog using the following APIs:
- /blogUp/{id} - Up-votes the blog with given id.
- /blogDown/{id} - Down-vote the blog with given id.

#### Pagination
This application also includes a paginated API, such that all blog can be returned as pages. Two specific API as described below will handle pagination of blog:
- /blogPaginated/{size} - This API can be used to know the number of pages that will be needed to display all the blog based on the given number of blog per page.
- /blogPaginated/{size}/{page} - This API returns a list of blog for the given page number and considering the given number of blog per page.

### Comments
Comments can be made on every blog and these comments can be threaded comments. Anyone can up-vote or down-vote each comment. 

#### Threaded Comments
Comments for each blog is threaded using the following APIs. 
- /comment [POST] - When saving a comment, users are prompted with a query field called "parent". If ignored, this comment will be added as a primary comment for the blog. If a parent comment is mentioned,
the code will perform a check to see that such a parent exists and if so, it will add this comment as a child to that existing comment.
- /commentByBlogId/{id} - All the comments for a specific blog can be returned using this API. This is useful when the UI will show the blog and its corresponding comments for this blog.
- /comment/{id} [DELETE] - When deleting a comment, the code will recursively check all the child comments and delete them in a CASCADING manner.

#### Voting
Anyone can up-vote or down-vote each comment using the following APIs:
- /commentUp/{id} - Up-votes the comment with given id.
- /commentDown/{id} - Down-vote the comment with given id.

## Running the application

Please download the complete repository, build the gradle project and run the SpringBoot Application.
\
Once the Springboot is running, Swagger UI would be available at: http://localhost:8080/swagger-ui.html and local database would be available at http://localhost:8080/h2-console/.
Credentials for the database are set to default since it is local, and the database is cleared every time the application is stopped.
\
\
CONFIG: For SpringBoot configurations, please set the main class to be: com.example.demo.DemoApplication

## Further Improvements
Ability of the application to handle images and the way to store them would be through the use of blobs. 
This application should work absolutely fine storing each blog as HTML and that way, authors are given the flexibility to design their blog.
JUnit tests can be written for each of the methods implemented within this system to ensure each part of the app works as expected.


# Start the Application 
### Step 1 : Build it :
1> docker build -t spring-boot-backend . --no-cache=true

### Step 2: Run it
2> docker run -it -p 8080:8080 spring-boot-backend

#OR ( if you prefer old maven way):

### Step 1 : ./buildNRun.sh


**Note : I have commited the jar artifact for ease of installation & execution.

# Using the Application
1. visit https://localhost:8080 and you will be redirected to login page
2. Login as normal user ( user/password) 
3. You will be on search query form or page .
4. Please enter the weights as described and hit submit
5. You will be preseneted with list of github repositories based on score calculated based on your weight ( Descending order of score).
6. You can Search Again
7. Hit Log out
8. Login now as administrator ( admin/admin)
9. Repeat Step 3 to 7 above
10. You will a link to Metrics page on top .
11. Click that link to visit the metrics page where you can see the metrics data.
12. Log out 
13. Thank you !





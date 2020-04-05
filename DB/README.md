#Steps to set up JV5 data base on windows
*Notice that this will need to change slightly once we migrate to a linux based deployment*

1. Download mongo db from this link https://www.mongodb.com/download-center/community
    1a. Make sure that you get mongo compass included in your download

2. After downloading create this folder structure on your local "C:\data\db\"

3. Run the command "mongod" in your terminal of choice
    3a. This will create a mongo instance that youre connected to on your pc

4. Open up a different terminal and run the command "mongo <path to jv_db_setup.js>"
    4a. This should create the db on your local if it is not already there
    4b. You can see what is being created in the terminal so make sure something is happening

5. After running the setup open up mongo compass and connect to the running databse
    5a. The DB will by default be running on "localhost:27017"

6. Open up the jv5 db that should have been created from the setup file and make sure that you see data populated


//connect to the db and create a jv5 db
var db = connect('localhost:27017/jv5')

var today = new Date();
var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();

var data = [{
    "id": "12345",
    "username": "PudgyPanda",
    "password": "password1",
    "email": "10mvasta@gmail.com",
    "userMetaData": {
        "country": "US",
        "state": "NJ",
        "dateCreated": date,
        "firstName": "Michael",
        "lastName": "Serpico"
    },
    "playerMetaData": {
        "player": true,
        "commentator": false,
        "teamOwner": false,
        "onTeam": false,
        "currentTeam": "",
        "mainGame": "Super Smash Bros Melee",
        "secondaryGame": "P+",
        "tirtiaryGame": "Poker"
    }
}, {
    "id": "23456",
    "username": "Jordank",
    "password": "password2",
    "email": "JStandig@gmail.com",
    "userMetaData": {
        "country": "US",
        "state": "NJ",
        "dateCreated": date,
        "firstName": "Jordan",
        "lastName": "Standig"
    },
    "playerMetaData": {
        "player": true,
        "commentator": true,
        "teamOwner": true,
        "onTeam": true,
        "currentTeam": "JV5",
        "mainGame": "Super Smash Bros Melee",
        "secondaryGame": "OnlyFans",
        "tirtiaryGame": "Eating Ass"
    }
}, {
    "id": "34567",
    "username": "Kerblaster",
    "password": "password3",
    "email": "kerblaster@yahoo.com",
    "userMetaData": {
        "country": "US",
        "state": "NJ",
        "dateCreated": date,
        "firstName": "Renard",
        "lastName": "Tumbokon"
    },
    "playerMetaData": {
        "player": false,
        "commentator": true,
        "teamOwner": false,
        "onTeam": false,
        "currentTeam": "",
        "mainGame": "Starcraft 2",
        "secondaryGame": "League Of Legends",
        "tirtiaryGame": "Super Smash Bros Melee"
    }
}, {
    "id": "45678",
    "username": "Llamuh",
    "password": "password4",
    "email": "llamuh@chad.com",
    "userMetaData": {
        "country": "US",
        "state": "NJ",
        "dateCreated": date,
        "firstName": "Aziz",
        "lastName": "Rahman"
    },
    "playerMetaData": {
        "player": true,
        "commentator": false,
        "teamOwner": false,
        "onTeam": true,
        "currentTeam": "Rutgers Overwatch",
        "mainGame": "Overwatch",
        "secondaryGame": "Halo",
        "tirtiaryGame": "Super Smash Bros Melee"
    }
}]

db.users.insertMany(data);
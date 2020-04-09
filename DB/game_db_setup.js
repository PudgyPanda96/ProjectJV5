//connect to the db and create a jv5 db
var db = connect('localhost:27017/jv5')

var data = [{
        "gameId": "12345",
        "gameTitle": "Super Smash Bros Melee"
    },
    {
        "gameId": "23456",
        "gameTitle": "StarCraft: Brood War"
    },
    {
        "gameId": "34567",
        "gameTitle": "Overwatch"
    },
    {
        "gameId": "45678",
        "gameTitle": "Halo 3"
    },
    {
        "gameId": "56789",
        "gameTitle": "Ass Eating"
    }
];

db.games.insertMany(data);
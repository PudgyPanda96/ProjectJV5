//connect to the db and create a jv5 db
var db = connect('localhost:27017/jv5')

var data = [{
        "userId": "12345",
        "experiences": [{
                "expId": "12345",
                "game": "melee",
                "description": "beat axe",
                "year": "2019",
                "event": "super smash con"
            },
            {
                "expId": "12346",
                "game": "valorant",
                "description": "out fragged renard easily",
                "year": "2020",
                "event": "online"
            }
        ]
    },
    {
        "userId": "23456",
        "experiences": [{
                "expId": "12347",
                "game": "melee",
                "description": "beat nation",
                "year": "2019",
                "event": "fireside"
            },
            {
                "expId": "12348",
                "game": "booty eater sim",
                "description": "ate that booty like groceries",
                "year": "2020",
                "event": "booty eating con"
            }
        ]
    },
    {
        "userId": "34567",
        "experiences": [{
            "expId": "12349",
            "game": "valorant",
            "description": "got plat",
            "year": "2020",
            "event": "online"
        }]
    },
    {
        "userId": "45678",
        "experiences": [{
                "expId": "22345",
                "game": "Overwatch",
                "description": "Coached rutgers esl team",
                "year": "2018",
                "event": "ESL"
            },
            {
                "expId": "32345",
                "game": "Halo",
                "description": "fucked some nerds",
                "year": "2020",
                "event": "online"
            }
        ]
    }
];
db.experience.insertMany(data);
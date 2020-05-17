//connect to the db and create a jv5 db
var db = connect('localhost:27017/jv5')

var data = [{
        "userId": "12345",
        "experiences": [{
                "game": "melee",
                "description": "beat axe",
                "year": "2019",
                "event": "super smash con"
            },
            {
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
                "game": "melee",
                "description": "beat nation",
                "year": "2019",
                "event": "fireside"
            },
            {
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
            "game": "valorant",
            "description": "got plat",
            "year": "2020",
            "event": "online"
        }]
    },
    {
        "userId": "45678",
        "experiences": [{
                "game": "Overwatch",
                "description": "Coached rutgers esl team",
                "year": "2018",
                "event": "ESL"
            },
            {
                "game": "Halo",
                "description": "fucked some nerds",
                "year": "2020",
                "event": "online"
            }
        ]
    }
]
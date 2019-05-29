package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/items'
    }

    response {
        status 200
        body("""
        [
            {
                "id": 1,
                "title": "PC 486 66MHz 8MB",
                "store": {
                    "name": "eBay"
                }
            },
            {
                "id": 2,
                "title": "Nintendo NES 8 bits",
                "store": {
                    "name": "ACME"
                }
            },
            {
                "id": 3,
                "title": "Hammer",
                "store": {
                    "name": "eBay"
                }
            },
            {
                "id": 4,
                "title": "Chainsaw",
                "store": {
                    "name": "eBay"
                }
            },
            {
                "id": 5,
                "title": "The Count of Monte Cristo",
                "store": {
                    "name": "The Neverland Bookshop"
                }
            }
        ]
        """)
    }
}

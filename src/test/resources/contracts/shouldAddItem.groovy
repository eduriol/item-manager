package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/item'
        body("""
        {
            "id": 6,
            "title": "Grays Sports Almanac",
            "store": {
                "name": "Blast from the Past"
            }
        }
        """)
        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status 200
    }
}
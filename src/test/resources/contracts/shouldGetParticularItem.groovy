package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/item/1'
    }

    response {
        status 200
        body("""
        {
            "id": 1,
            "title": "PC 486 66MHz 8MB",
            "store": {
                "name": "eBay"
            }
        }
        """)
    }
}

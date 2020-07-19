   # Simple Order Service

Overview

Treez is building a service that allows customers to place orders via a REST API. We would like to be able to model the current inventory, deducting from inventory as orders are created, and adding inventory back if orders are canceled.

Inventory records should include the following attributes:

●	Name
●	Description
●	Price
●	Quantity available

Order records should include the following attributes:

●	Customer email address
●	Date order placed
●	Order status

For the purposes of this exercise, there are some design and implementation details that are intentionally left out. You should decide what to do in these cases, and be prepared to explain why you made these decisions during the interview.
Requirements

The service should include the following:

1.	Support CRUD operations for inventory
2.	Support CRUD operations for orders
a.	When creating, updating, or canceling an order, inventory should be adjusted accordingly.
b.	When a request to create an order is made, it will include a list of inventories to include in the order
c.	If inventory levels are insufficient, a request to create an order should be denied.
3.	Tests should be included for both the inventory and order endpoints
4.	Authorization/authentication is NOT required for this service. It is safe to assume that all calls to the service should be processed
5.	Database models should be created based on your assessment of what’s necessary for the service. At minimum, you’ll likely want a model for inventory and a model for orders; you may choose to include additional models as necessary.

For your implementation:

●	Language: you can choose any language you would like to implement the service, though Java, Javascript, or Typescript are preferred.
●	Database: you can choose any database you prefer
●	Framework: you can choose any framework (or none at all)
Deliverables

Please send us the code that you develop so we can review what you’ve written. We will be evaluating you on the following, in approximate order:

1.	Correctness
2.	Cleanliness and clarity
3.	Efficiency

Please include high-level installation instructions. Your code should cleanly compile, tests should run without failures, and we should be able to make requests against your service.

ER diagrams and similar design elements are not required. Your code should make it sufficiently clear how models are defined and related.
Expected request endpoints

1.	Create inventory item
a.	POST http://localhost:3000/inventories
```
{  "name": "anasuya",   "description": "books",    "quantityAvailable": 700, "price":5454   }

```
2.	Read all inventory items
a.	GET http://localhost:3000/inventories
```
{ "id":1 "name": "anasuya",   "description": "books",    "quantityAvailable": 700, "price":5454   }
```
3.	Read single inventory item
a.	GET http://localhost:3000/inventories/1

```
{ "id":1 "name": "anasuya",   "description": "books",    "quantityAvailable": 700, "price":5454   }
```

4.	Update inventory item
a.	PUT http://localhost:3000/inventories/1
```
{ "id":1 "name": "anasuya",   "description": "testbooks",    "quantityAvailable": 700, "price":5454   }
```
5.	Delete inventory item
a.	DELETE http://localhost:3000/inventories/1


6.	Create order
a.	POST http://localhost:3000/orders

```
{     "emailid": "test@gmail.com",   "description": "ARC",    "status": "active",    "orderCreated": "2020-07-19", "inventory":
    {  "name": "anasuya"}
    }

```
7.	Read all orders
a.	GET http://localhost:3000/orders
```
[
    {
        "id": 1,
        "emailid": "test@gmail.com",
        "status": "active",
        "orderCreated": "2020-07-19 00:00:00",
        "inventory": {
            "id": 1,
            "name": "anasuya",
            "description": "books",
            "price": 5454,
            "quantityAvailable": 699
        }
    }
]
```
8.	Read single order
a.	GET http://localhost:3000/orders/1

```
[
    {
        "id": 1,
        "emailid": "test@gmail.com",
        "status": "active",
        "orderCreated": "2020-07-19 00:00:00",
        "inventory": {
            "id": 1,
            "name": "anasuya",
            "description": "books",
            "price": 5454,
            "quantityAvailable": 699
        }
    }
]
```

9.	Update order
a.	PUT http://localhost:3000/orders/1

```
{      "emailid": "test@gmail.com",   "description": "ARC",    "status": "active",    "orderCreated": "2020-07-19", "inventory":
    {  "name": "test"}
    }

```

```
[
    {
        "id": 1,
        "emailid": "test@gmail.com",
        "status": "active",
        "orderCreated": "2020-07-19 00:00:00",
        "inventory": {
            "id": 2,
            "name": "test",
            "description": "test",
            "price": 5454,
            "quantityAvailable": 699
        }
    }
]
```


10.	Delete order
a.	DELETE http://localhost:3000/orders/1

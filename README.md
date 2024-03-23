API Description
Overview
This project implements a series of APIs for managing orders within a delivery system. These APIs offer functions for creating, updating, retrieving, and deleting orders. Moreover, they grant users with specific roles the ability to carry out particular actions, like order creation.

APIs
Create Order API: This API empowers users to generate a fresh order in the system. It mandates users to input details such as sender and recipient addresses, package dimensions, and other pertinent information. Users with specific roles (e.g., Admin or Creator) possess the authority to create orders.

Update Order API: This API empowers users to modify an existing order. Users can adjust various attributes of the order, such as sender or recipient addresses, package dimensions, order status, etc. The update process is contingent upon permissions based on user roles.

Retrieve Order API: This API enables users to access details of a specific order by providing its unique identifier (order ID). Users can peruse information like sender and recipient addresses, package dimensions, order status, estimated delivery time, etc.

Delete Order API: This API enables users to remove an existing order from the system. Users with suitable permissions can commence the deletion of an order by specifying its order ID.

Permissions
The APIs implement role-based access control to guarantee that only authorized users can execute specific actions. Users with roles such as Admin or Creator possess elevated privileges to create or modify orders, while regular users may encounter restricted access.

Usage
To utilize these APIs, clients must authenticate themselves and include the requisite authorization headers in their requests. Additionally, clients must comply with the API documentation and furnish valid input parameters in accordance with the specified formats.




For more details check the Documentation of the project, which has complete flow of the project

Thankyou.

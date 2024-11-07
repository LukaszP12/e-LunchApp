GET /delivery-addressess/ - lista adresów\
GET /delivery-addressess/uuid - konkretny adres\
PUT /delivery-addressess/uuid - dodanie nowego adresu lub aktualizacja istniejącego\
DELETE /delivery-addressess/uuid - usuwanie adresu dostawy

GET /ingredients/ - lista adresów\
GET /ingredients/uuid - konkretny adres\
PUT /ingredients/uuid - dodanie nowego adresu lub aktualizacja istniejącego\
DELETE /ingredients/uuid - usuwanie adresu dostawy

GET /open-times/ - lista czasów otwarcia\
GET /open-times/uuid - konkretny czas otwarcia\
PUT /open-times/uuid - dodanie nowego czasu otwarcia lub aktualizacja istniejącego\
DELETE /open-times/uuid - usuwanie adresu czasu otwarcia

GET /orders/ - lista zamówień\
GET /orders/ (params= {"user"}) - lista zamówień dla danego użytkownika
GET /orders/ (params= {"deliverer"}) - lista zamówień dla danego dostawcy
GET /orders/uuid - konkretne zamówienie\
PUT /orders/uuid - dodanie nowego zamówienie lub aktualizacja istniejącego\
DELETE /orders/uuid - usuwanie zamówienie\
PATCH /orders/uuid/paid - ustawia status zamówienia na opłacone\
PATCH /orders/uuid/given-out - ustawia status zamówienia na wydane\
PATCH /orders/uuid/delivered - ustawia status zamówienia na dostarczone

GET /users/ - lista zamówień\
GET /users/uuid - konkretne zamówienie\
POST /users/uuid/new-operation (User + jedno elementowa lista z ewidencją operacji) - 
dodawanie nowej operacji\
PUT /users/uuid - dodanie nowego użytkownika\
DELETE /users/uuid - usunięcie użytkownika\
GET /users/uuid/delivery-addresses - adresy dostawy dla użytkownika

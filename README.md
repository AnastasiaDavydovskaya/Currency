Запускается по http://localhost:8080/swagger-ui/index.html 
Было реализовано два запроса.
1. Добавить ежедневные курсы валют за заданный период в БД. Пользователь указывает 
тип валюты (например USD), начальную и конечную дату периода. В качестве ответа 
получает массив курсов валют, которые были добавлены в БД.
 Корректный запрос /api/currencies
   {
   "abbreviation": "USD",
   "start": "2022-12-01",
   "end": "2022-12-05"
   }
2. Вывести все курсы по заданному типу валюты, имеющиеся в базе данных. Пользователь 
указывает тип валюты. В качестве ответа получает список курсов валют имеющихся в базе 
данных.
  Корректный запрос /api/currencies/abbreviation
   {
   "abbreviation": "USD"
   }
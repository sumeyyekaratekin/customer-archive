
## Table of Contents
- [Table of Contents](#table-of-contents)
- [Technologies](#technologies)
- [Layers And Files](#layers-and-files)
- [Database](#database)
- [Er Diagram](#er-diagram)
- [SQL Query](#sql-query)
- [Endpoints](#endpoints)
- [Example Output](#example-output)

## Technologies
* Java
* SpringBoot
* Maven
  
## Layers And Files
![layers](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/layers.png)


## Database

![database](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/database.png) 

## Er Diagram
&nbsp;&nbsp;&nbsp;&nbsp; 📃 [er-veri-modeli.mwb](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/er-veri-modeli.mwb)


## SQL Query
&nbsp;&nbsp;&nbsp;&nbsp; 📃 [SQLQueryDataBase.sql](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/SQLQueryDataBase.sql)


## Endpoints

`http://localhost:8080`


`GET` :     `/cutomers` &nbsp;&nbsp;&nbsp;&nbsp;<i>get List of Customers</i>

`GET` :     `customers/[id]`  &nbsp;&nbsp;&nbsp; <i>get Customer by id</i>

`POST`:    `/customers/`      &nbsp;&nbsp;&nbsp; <i>add Customer</i>

`PUT` :    `/customers/[id]`   &nbsp;&nbsp;&nbsp; <i>update Customer</i>

`DELETE`:   `/customers/[id]`  &nbsp;&nbsp;&nbsp; <i>delete Customer</i>

--------------------------------------------------------------------------
`GET` :     `/files` &nbsp;&nbsp;&nbsp;&nbsp;<i>get List of Files</i>

`GET` :     `/files/[id]`  &nbsp;&nbsp;&nbsp; <i>get Files by id</i>

`POST` :    `/upload`      &nbsp;&nbsp;&nbsp; <i>upload File (customerId) </i>

`DELETE`:   `/files/[id]`  &nbsp;&nbsp;&nbsp; <i>delete file</i>

--------------------------------------------------------------------------

## Example Output
![fileupload](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/upload.png)

![fileuploadget](https://github.com/sumeyyekaratekin/customer-archive/blob/main/res/uploadGet.png)

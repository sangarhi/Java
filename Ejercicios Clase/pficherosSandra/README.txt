Esta practica tiene dos partes:
* Generacion del fichero Departamentos.txt: Se extrae la información de todos los
departamentos de la BBDD y por cada uno de ellos se genera una línea con el siguiente formato:
Id;Nombre;Identificador Direccion;Identificador Manager

* Procesado del fichero DepartamentosLoad.txt: es el proceso contrario a la otra operacion,
vamos a leer el fichero que tendrá el mismo formato que "Departamentos.txt", con una modificación
al final de cada linea, el departamento puede estar marcado con una:
		* C, de creación, es la información de un departamento nuevo para crear
		* M, de modificar, el departamento ha sufrido algún cambio
		* E, el departamento se debe eliminar
Estas operaciones se deben consolidar en BBDD.

Pistas:
* Las clases Path y Files hacen el acceso a ficheros extremadamente facil
* El uso de arrays y la utilidad split de String 
* El uso de listas para las diferentes operaciones a consolidar
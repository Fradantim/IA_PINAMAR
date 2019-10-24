# IA_PINAMAR Proyecto Gimnasio

### Enunciado
- Crear un socio con pase diario y otro con pase mensual.
- Crear empleados administrativos y profesores
- Liquidar sueldos empleados
- Facturar abonos de los clientes

El sistema abarca las siguientes funciones:
- Administracion de socios:  datos personales y medicos de los socios
- Administracion de servicios: clases con profesor, uso de instalaciones, etc.
- Administracion de empleados: registrar los datos de los empleados administrativos y profesores del establecimiento.
- Liquidacion de sueldos a sus empleados.
- Administracion de abonos: existen pases diarios, semanales, quincenales, mensuales, semestrales y anuales
- Facturacion y cobranza: registracion de los abonos contratados por cada socio y su cobro.

---

### Script creacion BBDD SQL SERVER

	CREATE DATABASE IA_TMI;
	CREATE LOGIN IA_TMI WITH password='IA_TMI', default_database= IA_TMI, check_policy=OFF;
	USE IA_TMI;
	--sp_helpdb IA_TMI;
	exec sp_changedbowner IA_TMI;

---

### Endpoints definidos

#### Consulta Tipo Empleado
	Endpoint: /api/tiposEmpleado
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de TipoEmpleadoDTO

#### Consulta Clases.
	Endpoint: /api/clases
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de ClaseDTO

#### Consulta Socios
	Endpoint: /api/socios
	TIPO: GET
	Parametros: N/A
	Retorno: **WSReturn** contenido de un Array de **PersonaDTO**

#### Consulta Empleados
	Retorna los Empleado de todos los tipos (Administrativos y profesores)
	Endpoint: /api/empleados
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de PersonaDTO

#### Consulta Profesores
	Retorna los Empleado solo del tipo Profesor 
	Endpoint: /api/profesores
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de PersonaDTO

#### Consulta Liquidacion
	Retorna: personas que no fueron liquidadas en el mes y anio 
	Endpoint: /api/liquidacion
	TIPO: GET
	Parametros OBLIGATORIOS URL:
		anio entero
		mes entero
	Retorno: WSReturn contenido de un Array de PersonaDTO

#### Consulta Abono/Pases
	Endpoint: /api/pases
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de PaseDTO

#### Consulta Medios De Pago
	Endpoint: /api/mediosDePago
	TIPO: GET
	Parametros: N/A
	Retorno: WSReturn contenido de un Array de MedioDePagoDTO

#### Consulta Movimientos
	Retorna Pagos y Facturas de un Socio
	Endpoint: /api/movimientos
	TIPO: GET
	Parametros OBLIGATORIOS URL:
		idSocio entero
	Retorno: WSReturn contenido de un Array de MovimientoDTO

#### Carga Socio
	Endpoint: /api/socios
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		PersonaDTO
	Retorno: WSReturn contenido de la PersonaDTO creada

#### Carga Empleado
	Endpoint: /api/empleados
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		AltaEmpleadoRequest
	Retorno: WSReturn contenido de la PersonaDTO creada

#### Pagar Factura
	Endpoint: /api/movimientos
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		PagoFacturaRequest
	Retorno: WSReturn con contenido vacio.

#### Asociar nuevo Pase
	Endpoint: /api/pases
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		AgregarPaseRequest
	Retorno: WSReturn contenido la FacturaDTO creada	

#### Asociar Nueva Ficha Medica
	Endpoint: /api/socios7FM
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		AgregarFichaMedicaRequest
	Retorno: WSReturn con contenido vacio.

#### Imputar Liquidacion
	Endpoint: /api/liquidacion
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		LiquidacionRequest
	Retorno: WSReturn con contenido vacio.

#### Fichar Ingreso
	Endpoint: /api/fichero/ingreso
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		FichadoRequest
	Retorno: WSReturn con contenido vacio.	

#### Fichar Egreso
	Endpoint: /api/fichero/egreso
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		FichadoRequest
	Retorno: WSReturn con contenido vacio.	

---

### Objetos manejados por los endpoint

### Date
	Formato ISO8601
	Ejemplo de Date usado: "2019-10-23T14:22:22.763+0000" 

#### WSReturn
	Objeto que encierra una respuesta
	{
		"message": String,
		"successful": Boolean,
		"content": Object
	}
	
### TipoEmpleadoDTO
	{
		"id": Integer,
		"descripcion": String,
		"activo": Boolean
	}

### ClaseDTO
	{
		"id": Integer,
		"nombre": String
	}
	
### PersonaDTO
	{
		"id": Integer,
		"nombre": String,
		"apellido": String,
		"dni": String,
		"email": String,
		"sexo": String,
		"fechaNacimiento": Date,
		"fechaAlta": Date,
		"roles": String[] ("SOCIO" | "EMPLEADO"),
		"cbu": String,
		"cuit": String
	}
	
### PaseDTO
	{
		"id": Integer,
		"nombre": String,
		"precio": Float
	}

### MedioDePagoDTO
	{
		"id": Integer,
		"nombre": String
	}

### MovimientoDTO
	{
		"id": Integer,
		"tipo": String ("FACTURA" | "PAGO"),
		"monto": Float
	}

### FacturaDTO
	{
        "id": Integer,
        "monto": Float,
        "facturaDetalles": FacturaDetalleDTO[]
    }

### FacturaDetalleDTO
	{
		"id": Integer,
		"pase": PaseDTO,
		"montoParcial": Float
	}

### FichaMedicaDTO
	{
		"fechaAlta": Date,
		"nombreMedico": String,
		"telefono": String,;
		"obraSocial": String
	}

### AltaEmpleadoRequest
	{
		"persona": PersonaDTO,
		"sueldoBasicoCostoHora": Float,
		"idTipoEmpleado": Integer
	}
	
### PagoFacturaRequest
	{
		"idFactura": Integer,
		"idMedioDePago": Integer,
		"nroTarjeta": String,
		"fechaVencimiento": String ("MM/YYYY"),
		"codSeguridad": String,
		"DNI": String
	}
	
### AgregarPaseRequest
	{
		"idPersona": Integer,
		"idPase": Integer
	}
	
### AgregarFichaMedicaRequest
	{
		"fichaMedica": FichaMedicaDTO,
		"idPersona": Integer
	}
	
### LiquidacionRequest
	{
		"idEmpleado": Integer,
		"anio": Integer,
		"mes": Integer
	}
	
### FichadoRequest
	{
		"idPersona" Integer,
		"idRol" String
	}
	
---

### Ejemplos de llamado

#### Request
	URL: /api/socios
	TIPO:POST
	BODY:
	{
		"nombre": "Pepe",
		"apellido": "Argento",
		"dni": "12345678",
		"email": "racingMiVida@campeones.net",
		"sexo": "Masculino",
		"fechaNacimiento": "1953-11-22T19:49:44.408205"
	}

#### Response
	BODY:
	{
		"message": "Alta exitosa.",
		"successful": true,
		content": {
			"id": 252,
			"nombre": "Pepe",
			"apellido": "Argento",
			"dni": "12345678",
			"email": "racingMiVida@campeones.net",
			"sexo": "Masculino",
			"fechaNacimiento": "1953-11-22T19:49:44.408+0000",
			"fechaAlta": "2019-10-23T18:31:12.132+0000",
			"roles": [
				"SOCIO"
			]
		}
	}


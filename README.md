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
  sp_helpdb IA_TMI;
  exec sp_changedbowner IA_TMI;

____________________________________________________________________________


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
		(“socio” del tipo PersonaDTO)
	Retorno: WSReturn contenido de la PersonaDTO creada

#### Carga Empleado
	Endpoint: /api/empleados
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo AltaEmpleadoRequest)
	Retorno: WSReturn contenido de la PersonaDTO creada

#### Pagar Factura
	Endpoint: /api/movimientos
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo PagoFacturaRequest)
	Retorno: WSReturn con contenido vacio.

#### Asociar nuevo Pase
	Endpoint: /api/pases
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo AgregarPaseRequest)
	Retorno: WSReturn contenido la FacturaDTO creada	

#### Asociar Nueva Ficha Medica
	Endpoint: /api/socios7FM
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo AgregarFichaMedicaRequest)
	Retorno: WSReturn con contenido vacio.

#### Imputar Liquidacion
	Endpoint: /api/liquidacion
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo LiquidacionRequest)
	Retorno: WSReturn con contenido vacio.

#### Fichar Ingreso
	Endpoint: /api/fichero/ingreso
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo FichadoRequest)
	Retorno: WSReturn con contenido vacio.	

#### Fichar Egreso
	Endpoint: /api/fichero/egreso
	TIPO: POST
	Parametros OBLIGATORIOS BODY:
		"request" (del tipo FichadoRequest)
	Retorno: WSReturn con contenido vacio.	

---

### Objetos manejados por los endpoint

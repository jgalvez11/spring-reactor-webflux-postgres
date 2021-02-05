# spring-reactor-webflux-postgres

Ejemplo sencillo de Programación reactiva con CRUD REST con conexión a base de datos relacional (postgreSQL) implementando R2DBC y programación funcional.

## PROGRAMACIÓN REACTIVA

Paradigma enfocado en el trabajo con flujos de datos finitos o infinitos de forma asincróna.

## WebFlux

Módulo asíncrono con soporte para clientes HTTP, WebSockets, reactivo, REST y navegador HTML. Usa Netty como servidor por defecto.
Admite 2 modelos de programación:

1. Basado en anotaciones
2. Enrutamiento y manejo funcional, estilo Lambda java 8

La principal diferencia es que los RouterFunctions no son bloqueantes debidoa  que usan ServerHttpRequest y ServerHttpResponse en vez 
de HttpServletRequest y HttpServletResponse.

## R2DBC

Es una incubadora para integrar bases de datos relacionales mediante un controlador reactivo. No ofrece almacenamiento en caché, Carga diferida, 
escritura subyacente entre otras características de ORM.
Actualmente solo está disponible para base de datos relacionales como: PostgreSQL, H2 y SQLServer.

### Descripción proyecto

Implementación de un CRUD usando programación reactiva y usando los dos métodos posibles, mediante anotaciones y rutas funcionales. Uso de base de
datos relacionales (postgreSQL) mediante R2DBC.

### Installation

1. Clonar el repo
2. Descargar la imagen de Docker
2. Crear un container de postgreSQL
3. maven clean install
4. Run

Disfruta!

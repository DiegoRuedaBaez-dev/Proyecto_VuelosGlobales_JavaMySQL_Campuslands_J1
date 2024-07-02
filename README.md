# Proyecto Vuelos Globales - Java & MySQL

## Introducción

En el mundo actual, el desarrollo de software es fundamental para el funcionamiento eficiente y seguro de una aerolínea. La tecnología ha revolucionado la forma en que las aerolíneas operan, desde la gestión de vuelos y el mantenimiento de aeronaves hasta la experiencia del cliente. En una industria donde la puntualidad, la seguridad y la satisfacción del cliente son cruciales, el software se convierte en un aliado indispensable.

Las aerolíneas se enfrentan a numerosos desafíos que requieren soluciones tecnológicas avanzadas. Estos desafíos incluyen la gestión de una vasta cantidad de datos, la optimización de rutas de vuelo, el mantenimiento predictivo de aeronaves y la mejora de la experiencia del pasajero. Para abordar estos desafíos, las aerolíneas necesitan sistemas de software robustos, integrados y escalables.

## Caso Agencia Vuelos Globales

Vuelos Globales opera vuelos a nivel internacional y cuenta con una flota de aviones, tripulación variada, múltiples aerolíneas asociadas y una vasta red de aeropuertos y ciudades de destino. La empresa requiere una base de datos robusta para gestionar todos los aspectos de su operación, desde la reserva de vuelos hasta el mantenimiento de los aviones y la administración de la tripulación.

A continuación se suministra una base de datos existente de la agencia la cual debe ser analizada para determinar si se continúa usando o se reemplaza por una nueva base de datos.

## Requerimientos de la Base de Datos

1. *Gestión de Aviones y Modelos:*
   - Registrar información sobre los aviones, incluyendo número de matrícula, capacidad, fecha de fabricación, estado, aerolínea, modelo y fabricante.
   - Realizar un seguimiento del historial de revisiones de cada avión.

2. *Mantenimiento y Revisiones:*
   - Mantener un registro detallado de todas las revisiones realizadas a los aviones, incluyendo la fecha, el empleado responsable y los detalles específicos de cada revisión.

3. *Gestión de Tripulación:*
   - Administrar los datos de los empleados, sus roles, fechas de ingreso y asignaciones a aerolíneas y aeropuertos específicos.
   - Gestionar la asignación de la tripulación a diferentes trayectos y escalas.

4. *Gestión de Rutas y Escalas:*
   - Registrar información sobre los trayectos, incluyendo la fecha del trayecto, valor, ciudad de origen y destino.
   - Gestionar las escalas asociadas a cada trayecto, incluyendo el aeropuerto y número de vuelo correspondiente.

5. *Reservas y Clientes:*
   - Gestionar la información de las reservas de vuelos, incluyendo la fecha y trayecto asociado.
   - Mantener un registro detallado de los clientes, sus edades y tipos de documentos.
   - Registrar detalles específicos de cada reserva, incluyendo el cliente, tarifa y valor de la tarifa.

6. *Tarifas y Tipos de Documentos:*
   - Administrar los diferentes tipos de tarifas de vuelo y sus valores asociados.
   - Gestionar los tipos de documentos de identidad aceptados para los clientes.

## Problemas y Desafíos Específicos

- *Optimización de Consultas SQL:*
  - Para reportes de vuelos, estados de revisión y asignaciones de tripulación.
- *Integridad y Consistencia de los Datos:*
  - Relacionados con las múltiples relaciones entre entidades como aviones, tripulación y rutas.
- *Seguridad de los Datos:*
  - Mantenimiento de la seguridad de los datos sensibles de los clientes y la tripulación.
- *Escalabilidad:*
  - La base de datos debe manejar un creciente volumen de datos debido a la expansión de la empresa.

## Objetivos

1. *Desarrollo de Consultas SQL Eficientes:*
   - Crear consultas SQL optimizadas para obtener reportes de estado de aviones, historial de revisiones, asignaciones de tripulación y detalles de reservas.

2. *Mejora de la Estructura de la Base de Datos:*
   - Revisar y mejorar el diseño de la base de datos para asegurar integridad referencial y optimización del rendimiento.

3. *Automatización de Procesos:*
   - Implementar procedimientos almacenados y triggers para automatizar tareas comunes como la actualización de estados de revisión y notificaciones de reservas.

4. *Análisis de Datos:*
   - Desarrollar vistas y reportes que permitan a la administración tomar decisiones informadas sobre la operación y expansión de la empresa.

## Soluciones Propuestas

- *Normalización de Datos:*
  - Asegurar que la base de datos esté correctamente normalizada para evitar redundancias y mejorar la eficiencia.
  
- *Índices y Claves Foráneas:*
  - Implementar índices adecuados y claves foráneas para mejorar el tiempo de respuesta de las consultas.

- *Seguridad:*
  - Implementar medidas de seguridad para proteger los datos sensibles, incluyendo cifrado y control de acceso basado en roles.

## Propósito del Proyecto

El propósito de este proyecto es crear una aplicación que permita a los diferentes usuarios administrar la agencia Vuelos Globales. Se utilizará una arquitectura hexagonal y vertical slicing para asegurar un diseño modular y escalable que pueda evolucionar conforme a las necesidades de la empresa.

---

¡Gracias por tu interés en el Proyecto Vuelos Globales!

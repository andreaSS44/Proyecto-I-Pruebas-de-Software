# Informe final grupal

## Estrategia de automatización

### Persona 1 (RF-01, RF-02)

- Se automatizaron 4 de los 8 casos: los dos flujos positivos (CP-001 registro, CP-007 login y logout) y los dos negativos de mayor prioridad (CP-002 campos vacíos, CP-008 clave incorrecta).
- CP-003 a CP-006 quedaron como manuales: validan mensajes de un solo campo y cubren la misma lógica que CP-002.
- Cada prueba abre un navegador limpio y, si necesita un usuario, registra el suyo con un correo único. Así ninguna prueba depende de otra ni de una cuenta fija en un sitio compartido.
- Las páginas no tienen aserciones ni datos fijos. Los métodos que navegan devuelven la página siguiente (`registrar()` devuelve `RegisterResultPage` y `cerrarSesion()` devuelve `HomePage`).
- Localizadores: se prefirieron `id` (`register-button`, `Email`) y CSS por atributo (`[data-valmsg-for='FirstName']`); no se usó XPath absoluto.

### Persona 2

<!-- Incorporar aquí el aporte de la Persona 2. -->

### Persona 3

<!-- Incorporar aquí el aporte de la Persona 3. -->

### Persona 4 (RF-09, RF-10, RF-11)

Se elaboraron ocho casos de prueba, CP-025 a CP-032. Se automatizaron cuatro: CP-025 (compra completa como invitado), CP-026 (compra sin aceptar los términos y condiciones), CP-027 (modificación de información personal) y CP-028 (suscripción válida al boletín).

Los otros cuatro casos se ejecutaron manualmente: CP-029 (correo inválido en boletín), CP-030 (cambio de contraseña), CP-031 (historial de pedidos vacío) y CP-032 (votación sin seleccionar una respuesta).

Se utilizó Page Object Model con Page Factory para organizar las acciones de las páginas y mantener las pruebas separadas.

## Retos y soluciones

### Persona 1 (RF-01, RF-02)

| Reto | Solución |
|---|---|
| El sitio rechaza correos repetidos y lo usan muchas personas | Correo `p1_<hora_ms>@test.com` generado en cada ejecución |
| El resumen de errores del servidor solo existe cuando hay error | Se mapea como `List<WebElement>` y se revisa si está vacía, en lugar de capturar `NoSuchElementException` |
| Los mensajes de validación siempre están en el DOM, aunque vacíos | Se lee el texto del `span` de cada campo: vacío significa válido |
| Login y logout necesitan un usuario existente | Método auxiliar en la prueba que registra un usuario y cierra la sesión antes de empezar |

### Persona 2

<!-- Incorporar aquí el aporte de la Persona 2. -->

### Persona 3

<!-- Incorporar aquí el aporte de la Persona 3. -->

### Persona 4

| Reto | Solución |
| --- | --- |
| El proceso de compra tenía varios pasos | Se organizaron las acciones en `CheckoutPage` para ejecutar el flujo completo |
| La validación de términos no se comportaba como una alerta tradicional | Se verificó el mensaje que muestra la página |
| Era necesario conocer los mensajes exactos del sitio | Se realizaron pruebas manuales para comprobarlos antes de documentarlos |

## Hallazgos

### Persona 1 (RF-01, RF-02)

<!-- Completar con lo observado en la ejecución manual de CP-003 a CP-006. Cada hallazgo: pasos, resultado esperado, resultado real. -->

### Persona 2

<!-- Incorporar aquí el aporte de la Persona 2. -->

### Persona 3

<!-- Incorporar aquí el aporte de la Persona 3. -->

### Persona 4

- CP-025: Se completó correctamente la compra como invitado.
- CP-026: El sistema impidió continuar sin aceptar los términos y condiciones.
- CP-027: Se verificó la modificación de información personal.
- CP-028: Se verificó la suscripción con un correo válido.
- CP-029: El sistema mostró `Enter valid email` al ingresar un correo inválido.
- CP-030: El sistema mostró `Password was changed` después de cambiar la contraseña.
- CP-031: El historial de una cuenta sin compras mostró `No orders`.
- CP-032: La encuesta mostró `Please select an answer` al intentar votar sin seleccionar una opción.

## Aprendizajes

### Persona 1 (RF-01, RF-02)

<!-- Completar con aprendizajes propios. -->

### Persona 2

<!-- Incorporar aquí el aporte de la Persona 2. -->

### Persona 3

<!-- Incorporar aquí el aporte de la Persona 3. -->

### Persona 4

- Aprendí a automatizar un proceso de compra que requiere varios pasos.
- Reforcé el uso de Selenium, JUnit 5 y Page Factory.
- Comprendí la importancia de verificar los mensajes reales que muestra el sitio.
- Aprendí a combinar pruebas manuales y automatizadas para cubrir diferentes funcionalidades.

# Aporte al informe: Persona 1 (RF-01, RF-02)

## Estrategia de automatización

- Se automatizaron 4 de los 8 casos: los dos flujos positivos (CP-001 registro, CP-007 login y logout) y los dos negativos de mayor prioridad (CP-002 campos vacíos, CP-008 clave incorrecta).
- CP-003 a CP-006 quedaron como manuales: validan mensajes de un solo campo y cubren la misma lógica que CP-002.
- Cada prueba abre un navegador limpio y, si necesita un usuario, registra el suyo con un correo único. Así ninguna prueba depende de otra ni de una cuenta fija en un sitio compartido.
- Las páginas no tienen aserciones ni datos fijos. Los métodos que navegan devuelven la página siguiente (`registrar()` devuelve `RegisterResultPage` y `cerrarSesion()` devuelve `HomePage`).
- Localizadores: se prefirieron `id` (`register-button`, `Email`) y CSS por atributo (`[data-valmsg-for='FirstName']`); no se usó XPath absoluto.

## Retos y soluciones

| Reto | Solución |
|---|---|
| El sitio rechaza correos repetidos y lo usan muchas personas | Correo `p1_<hora_ms>@test.com` generado en cada ejecución |
| El resumen de errores del servidor solo existe cuando hay error | Se mapea como `List<WebElement>` y se revisa si está vacía, en lugar de capturar `NoSuchElementException` |
| Los mensajes de validación siempre están en el DOM, aunque vacíos | Se lee el texto del `span` de cada campo: vacío significa válido |
| Login y logout necesitan un usuario existente | Método auxiliar en la prueba que registra un usuario y cierra la sesión antes de empezar |

## Hallazgos

<!-- Completar con lo observado en la ejecución manual de CP-003 a CP-006. Cada hallazgo: pasos, resultado esperado, resultado real. -->

## Aprendizajes

<!-- Completar con aprendizajes propios. -->

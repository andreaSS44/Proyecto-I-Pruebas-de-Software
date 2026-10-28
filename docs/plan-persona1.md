# Plan de trabajo — Persona 1: Registro y autenticación

**Integrante:** Joselyn Segura
**Alcance:** RF-01 Registro de usuario (Alta) y RF-02 Inicio y cierre de sesión (Alta)
**Entrega:** 3 de noviembre de 2026
**Sitio bajo prueba:** https://demowebshop.tricentis.com (no se crea ningún sitio; se prueba el existente)

---

## 1. Exploración manual

Recorrer el sitio a mano y anotar los mensajes **exactos** que muestra. Estas notas son la base de los resultados esperados.

### Registro (RF-01)
- [ ] Todos los campos válidos: texto del mensaje de éxito y a dónde lleva "Continue".
- [ ] Enviar todo vacío: qué campos muestran error y con qué texto.
- [ ] Correos inválidos (`abc`, `abc@`, `abc@test`): cuáles se rechazan.
- [ ] Correo ya registrado: mensaje que aparece.
- [ ] Contraseña de 5 y de 6 caracteres: cuál es el mínimo real.
- [ ] Contraseña y confirmación distintas: mensaje que aparece.
- [ ] Sin seleccionar género: ¿es obligatorio?

### Inicio y cierre de sesión (RF-02)
- [ ] Login válido: qué muestra el encabezado (correo, enlace "Log out").
- [ ] Contraseña incorrecta, correo no registrado y campos vacíos: ¿el mensaje cambia?
- [ ] Logout: ¿vuelven a aparecer "Register" y "Log in"?

Cualquier diferencia entre el requerimiento y el sitio real se anota como **hallazgo** para el informe.

---

## 2. Casos de prueba escritos (CP-001 a CP-008)

| ID | RF | Título | Tipo | Prioridad | Automatizable |
|---|---|---|---|---|---|
| CP-001 | RF-01 | Registro exitoso con datos válidos | Positivo | Alta | Sí |
| CP-002 | RF-01 | Registro con campos obligatorios vacíos | Negativo | Alta | Sí |
| CP-003 | RF-01 | Registro con correo de formato inválido | Negativo | Media | No |
| CP-004 | RF-01 | Registro con correo ya registrado | Negativo | Alta | No |
| CP-005 | RF-01 | Contraseña con un carácter menos del mínimo | Límite | Media | No |
| CP-006 | RF-01 | Contraseña y confirmación no coinciden | Negativo | Media | No |
| CP-007 | RF-02 | Login válido muestra la cuenta y permite cerrar sesión | Positivo | Alta | Sí |
| CP-008 | RF-02 | Login con contraseña incorrecta | Negativo | Alta | Sí |

- 6 de 8 casos son Negativo o Límite (aporta a los 10 mínimos del equipo).
- Casos extra si el equipo los necesita: login con campos vacíos (Negativo), contraseña con exactamente el mínimo (Límite), logout como caso separado.
- **Datos:** escribir valores concretos o el patrón, por ejemplo `p1_<timestamp>@test.com` y contraseña `Test123`.
- **Resultado esperado:** copiar el mensaje real anotado en la exploración.

---

## 3. Clases de página (Page Factory)

| Página | Responsabilidad (métodos de negocio) |
|---|---|
| HomePage (compartida) | ir a Registro, ir a Login, cerrar sesión, leer la cuenta del encabezado, saber si hay sesión iniciada |
| RegisterPage | llenar el formulario y enviarlo; leer los errores de los campos |
| RegisterResultPage (opcional) | leer el mensaje de éxito; continuar |
| LoginPage | iniciar sesión con credenciales; leer el mensaje de error |
| Utilidad de correo único | generar un correo distinto en cada ejecución (hora en milisegundos) |

Reglas:
- Usar `@FindBy` y `PageFactory.initElements`.
- Los métodos que navegan devuelven la página siguiente.
- Sin aserciones ni datos de prueba fijos en las páginas.
- Preferir localizadores `id`, `name` y CSS; evitar XPath absolutos.
- No usar `Thread.sleep`.

---

## 4. Pruebas automatizadas (JUnit 5)

| Prueba | Caso | Tipo |
|---|---|---|
| 1 | CP-001 Registro exitoso con datos válidos | Positivo |
| 2 | CP-002 Registro con campos obligatorios vacíos | Negativo |
| 3 | CP-007 Login válido y cierre de sesión | Positivo |
| 4 | CP-008 Login con contraseña incorrecta | Negativo |

- Cada prueba lleva el ID en `@DisplayName`, por ejemplo `"CP-008 Login con contraseña incorrecta"`.
- CP-007 y CP-008 necesitan un usuario existente: cada prueba registra su propio usuario nuevo primero (no depender de una cuenta fija, el sitio es compartido).
- Cada prueba inicia con un navegador limpio.
- Sin `By`, `@FindBy` ni `driver.findElement` dentro de las pruebas; las aserciones van en las pruebas.

---

## 5. Cronograma

| Fecha | Tarea |
|---|---|
| 28 oct | Explorar el sitio y anotar mensajes. Acordar IDs y nombres de métodos de HomePage con el equipo. |
| 29 oct | Escribir CP-001 a CP-008 en la plantilla de Excel. |
| 30 oct | Construir HomePage, RegisterPage y LoginPage. |
| 31 oct | Utilidad de correo único y las 4 pruebas. |
| 1 nov | Ejecutar todo junto y corregir pruebas inestables. Apoyar a Persona 4 con el login antes del checkout. |
| 2 nov | Hallazgos y retos para el informe, sección del README, evidencia de ejecución. |
| 3 nov | Revisión final y entrega. |

---

## 6. Git

- Un commit pequeño por paso: cada página, la utilidad, cada prueba, los casos del Excel.
- El historial debe mostrar el trabajo propio.

## 7. Preparación para la defensa

- Explicar por qué se eligió cada localizador.
- Justificar por qué se automatizaron esos 4 casos y no los otros.
- Explicar cómo se logra que las pruebas sean independientes.

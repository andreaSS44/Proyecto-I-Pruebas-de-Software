ISW-622 · Pruebas de Software \| UTN \| III cuatrimestre 2026

Proyecto: Automatización de pruebas de una tienda en línea · Sitio: Demo
Web Shop · Entrega: 3 de noviembre de

2026 · Valor: 20%.

Propuesta de distribución basada en los requerimientos y los cinco
entregables del enunciado. Cada persona explora

manualmente su área, documenta sus casos, implementa sus páginas y
automatiza sus pruebas. Los números

siguientes son una asignación interna sugerida, no cuotas impuestas por
el docente.

  -----------------------------------------------------------------------
  Integrante        Requerimientos    Casos escritos    Pruebas
                                                        automáticas
  ----------------- ----------------- ----------------- -----------------
  Persona 1         RF-01, RF-02      8                 4

  Persona 2         RF-03, RF-04,     8                 4
                    RF-08                               

  Persona 3         RF-05, RF-06,     8                 4
                    RF-07                               

  Persona 4         RF-09, RF-10,     8                 4
                    RF-11                               

  TOTAL             11 requerimientos 32                16
  -----------------------------------------------------------------------

## PERSONA 1 --- Registro y autenticación

Alcance: RF-01 Registro de usuario (alta) y RF-02 Inicio y cierre de
sesión (alta).

Casos y automatización: Crear 8 casos escritos, incluyendo registro
exitoso, campos obligatorios, correo inválido o

duplicado, contraseñas y autenticación válida/inválida; incluir límites
tras explorar el sitio. Automatizar 4 casos, con al

menos 1 negativo.

Page Factory / POM: Responsable de RegisterPage y LoginPage; colaborar
en HomePage y utilidades de correo

único. Verificar inicio/cierre de sesión y mensajes.

Resultado individual: Entregar casos CP propios, clases de página,
pruebas JUnit 5 y evidencias de ejecución.

## PERSONA 2 --- Búsqueda y catálogo

Alcance: RF-03 Búsqueda de productos (alta), RF-04 Catálogo (media) y
RF-08 Comparación (media).

Casos y automatización: Crear 8 casos: búsqueda con/sin resultados,
texto corto, filtros avanzados, ordenamiento,

visualización y comparación; registrar comportamiento real. Automatizar
4, con al menos 1 negativo.

Page Factory / POM: Responsable de SearchResultsPage, CatalogPage y, si
se automatiza comparación,

CompareProductsPage. Coordinar navegación con HomePage.

Resultado individual: Entregar casos CP propios, páginas, pruebas y
observaciones de catálogo dinámico.

## PERSONA 3 --- Productos y carrito

Alcance: RF-05 Carrito de compras (alta), RF-06 Productos con opciones
(alta) y RF-07 Lista de deseos (media).

Casos y automatización: Crear 8 casos: agregar/quitar productos,
modificar cantidad, recalcular subtotal, carrito vacío,

cantidades inválidas, opciones obligatorias y lista de deseos.
Automatizar 4, con al menos 1 negativo.

Page Factory / POM: Responsable de ProductPage, CartPage y, si
corresponde, WishlistPage. Preparar productos y

operaciones reutilizables para el checkout.

Resultado individual: Entregar casos CP propios, páginas, pruebas y
evidencia de actualización del carrito.

## PERSONA 4 --- Compra e integración

Alcance: RF-09 Proceso de compra (alta), RF-10 Cuenta del usuario
(media) y RF-11 Boletín y encuesta (baja).

Casos y automatización: Crear 8 casos: compra completa como invitado o
registrado, validación de campos y pasos,

cuenta, suscripción y encuesta. Automatizar 4, con al menos 1 negativo y
obligatoriamente 1 compra completa

RF-09.

Page Factory / POM: Responsable de CheckoutPage y, según selección de
pruebas, AccountPage o

NewsletterPage. Integrar carrito, sesión, dirección, envío, pago y
confirmación con apoyo de Personas 1 y 3.

Resultado individual: Coordinar README, ejecución global y consolidación
del informe, sin asumir en solitario el

trabajo del equipo.

## ACTIVIDADES Y ENTREGABLES COMPARTIDOS

- Antes de programar: los cuatro exploran el sitio manualmente,
  documentan mensajes y límites reales y acuerdan

identificadores CP únicos. No utilizar datos personales reales ni
pruebas de carga.

- Excel: consolidar 32 casos en la plantilla oficial, con ID, RF,
  título, tipo, prioridad, precondiciones, datos, pasos,

resultado esperado y automatizable; hoja de trazabilidad con conteos.
Garantizar al menos 10 casos negativos o de

límite (30% de 32 redondeado hacia arriba).

- Java: mínimo 6 clases con \@FindBy y PageFactory.initElements, métodos
  de negocio, sin aserciones ni datos fijos.

Usar Java 17, Maven, Selenium 4 y JUnit 5; estructura base/pages/tests.

- JUnit: mínimo 15 pruebas; el plan propone 16, cubriendo al menos 6 RF
  y al menos 4 negativas. Cada prueba lleva

\@DisplayName con CP. Sin By, \@FindBy ni driver.findElement dentro de
las pruebas. Pruebas independientes y

repetibles.

- Git: cada integrante realiza commits frecuentes y verificables en su
  rama; integrar sin romper el proyecto. README

con instrucciones mvn test y organización; guardar
target/surefire-reports o captura de la ejecución.

- Informe PDF (2--3 páginas): todos aportan estrategia de
  automatización, retos/soluciones, hallazgos reproducibles y

aprendizajes; Persona 4 consolida y los otros tres revisan.

## ORDEN RECOMENDADO DE TRABAJO

1\. Explorar y definir casos → 2. Acordar páginas compartidas y nombres
de métodos → 3. Implementar Page Factory →

4\. Automatizar e integrar → 5. Ejecutar mvn test, completar
trazabilidad, evidencia e informe.

## NOTAS IMPORTANTES DEL ENUNCIADO

El documento contiene una inconsistencia: en la portada indica que no se
permite IA para generar código y que no hay

defensa; en reglas técnicas admite IA como apoyo y contempla
interrogación o defensa. Para evitar riesgos, consultar

al docente y desarrollar el código personalmente. No usar Thread.sleep
como solución. La rúbrica asigna 25 puntos

a casos, 25 a páginas, 30 a pruebas, 10 a repositorio/evidencia y 10 a
informe.

La Persona 4 tiene un flujo de compra más complejo: Personas 1 y 3 deben
prestarle apoyo de integración. Las clases

indicadas son propuestas de diseño, no nombres obligatorios del
enunciado.

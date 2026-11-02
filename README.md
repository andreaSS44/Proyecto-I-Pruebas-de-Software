# Proyecto-I-Pruebas-de-Software

Proyecto de automatización de pruebas de una tienda en línea (Demo Web Shop), utilizando Java, Selenium, JUnit 5 y el patrón Page Object Model (POM).

**Integrantes:** Andrea Salazar, Shauney Argüello, Joselyn Segura y Daniela Rodríguez.

**Universidad Técnica Nacional | ISW-622 Pruebas de Software | III Cuatrimestre 2026**

## Requisitos

- Java 17 o superior
- Maven 3.9 o superior
- Google Chrome (Selenium Manager descarga el driver automáticamente)

## Ejecución

```bash
mvn test                                  # todas las pruebas, con pausas visuales de 700 ms
mvn test -Dritmo=0                        # sin pausas
mvn test -Dheadless=true -Dritmo=0        # sin abrir la ventana de Chrome
mvn test -Dtest=RegistroLoginTest         # solo una clase de pruebas
```

Los resultados quedan en `target/surefire-reports`.

## Organización

```text
src/test/java/cr/ac/utn/proyecto1/
├── base/    BaseTest (abre y cierra Chrome), DatosPrueba, Visual
├── pages/   Clases de página con Page Factory (@FindBy + PageFactory.initElements)
└── tests/   Pruebas JUnit 5; el ID del caso va en @DisplayName

docs/
├── Plantilla_Casos_de_Prueba_S7.xlsx   Casos de prueba y trazabilidad
└── evidencia/                          Copia de los reportes de ejecución
```

## Persona 1: Registro y autenticación (RF-01, RF-02)

| Elemento | Detalle |
|---|---|
| Casos escritos | CP-001 a CP-008 (6 de 8 son Negativo o Límite) |
| Páginas | `HomePage` (compartida), `RegisterPage`, `RegisterResultPage`, `LoginPage` |
| Utilidad | `DatosPrueba.correoUnico()`: correo distinto en cada ejecución |
| Pruebas | `RegistroLoginTest`: CP-001, CP-002, CP-007, CP-008 |
| Evidencia | `docs/evidencia/persona1` (4 pruebas, 0 fallos) |

## Persona 2: Búsqueda y catálogo (RF-03, RF-04, RF-08)

| Elemento | Detalle |
|---|---|
| Casos escritos | 8 casos asignados, pendientes de consolidar en el Excel grupal |
| Páginas | `SearchResultsPage`, `CatalogPage`, `CompararProducto` |
| Pruebas | `SearchTest`: CP-009 y CP-010; `CatalogoTest`: CP-011; `CompararProductoTest`: CP-012 |
| Total automatizadas | 4 pruebas |

Se trabajaron las funcionalidades de búsqueda de productos, catálogo y comparación. Se incluyeron pruebas de búsqueda con resultados y sin resultados.

## Persona 3: Productos y carrito (RF-05, RF-06, RF-07)

| Elemento | Detalle |
|---|---|
| Casos escritos | 8 casos asignados, pendientes de consolidar en el Excel grupal |
| Páginas | `ProductPage`, `CartPage`, `WishlistPage` |
| Pruebas | `ProductosCarritoTest`: CP-013, CP-014, CP-015 y CP-016 |
| Total automatizadas | 4 pruebas |

Se trabajaron funcionalidades relacionadas con los productos, el carrito de compras y la lista de deseos.

## Persona 4: Proceso de compra, cuenta de usuario y boletín (RF-09, RF-10, RF-11)

| Elemento | Detalle |
|---|---|
| Casos escritos | CP-025 a CP-032 (8 casos) |
| Páginas | `CheckoutPage`, `AccountPage`, `NewsletterPage` y ajustes en `CartPage` |
| Pruebas | `CheckoutTest`, `AccountTest`, `NewsletterTest` |
| Total automatizadas | 4 pruebas |
| Total manuales | 4 pruebas |
| Resultado | 8 casos aprobados |

## Resultados de ejecución

Se realizó una ejecución general de las pruebas automatizadas utilizando Maven y JUnit 5.

| Resultado | Cantidad |
|---|---:|
| Pruebas ejecutadas | 16 |
| Pruebas aprobadas | 16 |
| Fallos | 0 |
| Errores | 0 |
| Pruebas omitidas | 0 |

**Resultado final: BUILD SUCCESS**

Los reportes se generan en `target/surefire-reports`.

## Casos de prueba y trazabilidad

Los casos de prueba se documentan en la plantilla Excel proporcionada por el profesor.

Cada caso contiene su identificador, requerimiento, título, tipo, prioridad, precondiciones, datos de prueba, pasos, resultado esperado, automatizable y estado.

La consolidación del Excel grupal está pendiente de completar con los casos de las cuatro integrantes. Una vez integrados, se debe verificar que existan al menos 30 casos escritos y que al menos el 30 % sean negativos o de límite.

Los identificadores de los casos automatizados deben coincidir con los utilizados en `@DisplayName` de las pruebas JUnit 5.

## Evidencias

Las evidencias del proyecto incluyen:

- Reportes de ejecución de Maven y JUnit 5.
- Capturas de las pruebas manuales.
- Archivo Excel de casos de prueba y trazabilidad.
- Informe final del proyecto en PDF.

Los reportes generados por Maven se encuentran en `target/surefire-reports`. Las evidencias que se seleccionen para la entrega se organizan en `docs/evidencia/`.

## Conclusión

Este proyecto permitió poner en práctica la automatización de pruebas utilizando Selenium WebDriver, JUnit 5 y Page Object Model.

Durante el desarrollo fue importante explorar el sitio manualmente, comprobar los mensajes reales y organizar el código para que las pruebas fueran más fáciles de mantener.

También se utilizó Git y GitHub para integrar el trabajo de las cuatro integrantes en una sola rama principal.

La ejecución de las 16 pruebas automatizadas finalizó correctamente, sin fallos ni errores.

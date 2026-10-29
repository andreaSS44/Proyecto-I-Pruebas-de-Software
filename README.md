# Proyecto-I-Pruebas-de-Software
Proyecto de automatización de pruebas de una tienda en línea (Demo Web Shop), utilizando Java, Selenium, JUnit 5 y el patrón Page Object Model (POM).  Integrantes: Andrea Salazar, Shauney Argüello, Joselyn Segura y Daniela Rodríguez.  Universidad Técnica Nacional | ISW-622 Pruebas de Software | III Cuatrimestre 2026

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

```
src/test/java/cr/ac/utn/proyecto1/
├── base/    BaseTest (abre y cierra Chrome), DatosPrueba, Visual
├── pages/   Clases de página con Page Factory (@FindBy + PageFactory.initElements)
└── tests/   Pruebas JUnit 5; el ID del caso va en @DisplayName
docs/
├── Plantilla_Casos_de_Prueba_S7.xlsx   Casos de prueba y trazabilidad
└── evidencia/                          Copia de los reportes de ejecución
```

## Persona 1: Registro y autenticación (RF-01, RF-02)

**Responsable:** Joselyn Segura

| Elemento | Detalle |
|---|---|
| Casos escritos | CP-001 a CP-008 (6 de 8 son Negativo o Límite) |
| Páginas | `HomePage` (compartida), `RegisterPage`, `RegisterResultPage`, `LoginPage` |
| Utilidad | `DatosPrueba.correoUnico()`: correo distinto en cada ejecución |
| Pruebas | `RegistroLoginTest`: CP-001, CP-002, CP-007, CP-008 |
| Evidencia | `docs/evidencia/persona1` (4 pruebas, 0 fallos) |

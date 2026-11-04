# Automatización de pruebas - Demo Web Shop

Universidad Técnica Nacional | ISW-622 Pruebas de Software | III cuatrimestre 2026

**Integrantes:** Andrea Salazar, Shauney Argüello, Joselyn Segura y Daniela Rodríguez.

Este proyecto contiene casos de prueba escritos y pruebas automatizadas para [Demo Web Shop](https://demowebshop.tricentis.com/), usando Java 17, Maven, Selenium 4, JUnit 5 y Page Object Model (POM) con Page Factory.

## Requisitos

- JDK 17
- Apache Maven
- Google Chrome
- Conexión a internet para acceder a Demo Web Shop y, si es necesario, obtener el controlador mediante Selenium Manager.

## Cómo ejecutar

1. Descomprimir el proyecto.
2. Abrir una terminal en la carpeta que contiene `pom.xml`.
3. Ejecutar:

```bash
mvn test
```

Para ejecutar sin las pausas visuales configuradas en el proyecto:

```bash
mvn test -Dritmo=0
```

Para ejecutar una clase específica:

```bash
mvn test -Dtest=SearchTest
```

Maven genera los resultados en `target/surefire-reports/`. La ejecución depende de que el sitio de práctica esté disponible y de las condiciones del navegador.

## Organización del proyecto

```text
pom.xml                          Dependencias y configuración de Maven
src/test/java/cr/ac/utn/proyecto1/
  base/                          Preparación del navegador y utilidades
  pages/                         Páginas Page Object con Page Factory
  tests/                         Pruebas automatizadas JUnit 5
docs/
  Plantilla_Casos_de_Prueba_S7.xlsx  Casos escritos y trazabilidad
  Informe_Final.pdf              Informe breve del entregable 5
  evidencia/                     Reportes de ejecución conservados
```

## Entregables

1. **Casos escritos:** `docs/Plantilla_Casos_de_Prueba_S7.xlsx`.
2. **Páginas con Page Factory:** clases de `src/test/java/cr/ac/utn/proyecto1/pages/`.
3. **Pruebas JUnit 5:** clases de `src/test/java/cr/ac/utn/proyecto1/tests/`.
4. **Repositorio y evidencia:** este README y los reportes incluidos en `docs/evidencia/`; los reportes de una nueva ejecución aparecen en `target/surefire-reports/`.
5. **Informe breve:** `docs/Informe_Final.pdf`.

**Nota:** Los reportes incluidos en `docs/evidencia/` corresponden únicamente a las ejecuciones guardadas en el proyecto. Para obtener evidencia actualizada de toda la suite, ejecutar `mvn test` y conservar su reporte.

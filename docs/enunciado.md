+-----------------------------------------------------------------+
| **UNIVERSIDAD TÉCNICA NACIONAL**                                |
|                                                                 |
| ISW-622 Pruebas de Software --- III Cuatrimestre 2026           |
+=================================================================+

  -----------------------------------------------------------------
  **ENUNCIADO --- PROYECTO: AUTOMATIZACIÓN DE PRUEBAS DE UNA TIENDA
  EN LÍNEA**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  ---------------------------------------------------------------------
  **Curso:**         ISW-622 Pruebas de Software
  ------------------ --------------------------------------------------
  **Modalidad:**     Grupos de 4 estudiantes

  **Valor:**         20% de la nota final

  **Entrega:**       3 de noviembre en el campus virtual y repositorio
                     https://github.com/UTN-Estudiantes/proyecto1.git

  **Defensa:**       No hay defensa. No se permite el uso de la IA para
                     generar código.

  **Sitio bajo       https://demowebshop.tricentis.com (Demo Web Shop,
  prueba:**          tienda de práctica pública)

  **Docente:**       Jose David Carvajal Jiménez
  ---------------------------------------------------------------------

  -----------------------------------------------------------------
  **1. DESCRIPCIÓN DEL PROYECTO**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

Cada grupo asume el rol de equipo de QA de una tienda en línea. A partir
de los requerimientos de este documento deberán diseñar los casos de
prueba por escrito, construir las páginas de automatización con Page
Factory en Java y programar las pruebas automáticas con el patrón Page
Object Model. Todo se ejecuta contra el sitio público Demo Web Shop.

  -----------------------------------------------------------------
  *Lo importante no es automatizar todo, sino decidir bien qué
  automatizar, escribir casos de prueba claros y construir una base
  de automatización que se pueda mantener.*
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  -----------------------------------------------------------------
  **2. RESULTADOS DE APRENDIZAJE**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  -----------------------------------------------------------------
  **Al finalizar el proyecto, el estudiante será capaz de...**
  -----------------------------------------------------------------
  Derivar casos de prueba escritos (positivos, negativos y de
  límite) a partir de requerimientos, con trazabilidad.

  Construir clases de página con Page Factory (@FindBy) en Java
  siguiendo las reglas de POM.

  Programar pruebas automatizadas legibles y mantenibles que usen
  esas páginas, sin localizadores en las pruebas.

  Decidir qué casos conviene automatizar y justificar la decisión.

  Resolver retos reales de automatización web: elementos dinámicos,
  opciones obligatorias, listas desplegables, datos únicos y flujos
  de varios pasos.
  -----------------------------------------------------------------

  -----------------------------------------------------------------
  **3. EL SITIO BAJO PRUEBA Y SUS REGLAS DE USO**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

> • Demo Web Shop es un sitio público y compartido: otras personas lo
> usan al mismo tiempo, por lo que los datos y el catálogo pueden
> cambiar.
>
> • No ingresen datos personales reales. Usen correos y nombres de
> prueba propios.
>
> • El registro exige un correo único: generen uno distinto en cada
> ejecución (por ejemplo, con la hora en milisegundos).
>
> • No hagan pruebas de carga, ataques ni acciones que afecten el
> funcionamiento del sitio.
>
> • Antes de escribir los casos, EXPLOREN el sitio a mano: anoten el
> comportamiento y los mensajes reales. Los casos deben basarse en lo
> que el sitio hace, y los desajustes con los requerimientos se reportan
> como hallazgos.

  -----------------------------------------------------------------
  **4. REQUERIMIENTOS**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

Los requerimientos describen lo que el sitio debe hacer. Los criterios
de aceptación son el punto de partida para derivar los casos de prueba;
ustedes deben completar los datos, los límites y los casos negativos.

  -----------------------------------------------------------------------------
  **ID**   **Requerimiento**     **Criterios de aceptación**       **Prior.**
  -------- --------------------- --------------------------------- ------------
  RF-01    Registro de usuario   El visitante crea una cuenta con  Alta
                                 género, nombre, apellido, correo, 
                                 contraseña y confirmación.        
                                 Nombre, apellido, correo,         
                                 contraseña y confirmación son     
                                 obligatorios. El correo debe      
                                 tener formato válido y no estar   
                                 registrado. La contraseña tiene   
                                 un mínimo de caracteres y debe    
                                 coincidir con la confirmación. Si 
                                 el registro es exitoso, el sitio  
                                 lo confirma.                      

  RF-02    Inicio y cierre de    Con credenciales válidas se       Alta
           sesión                inicia sesión y el encabezado     
                                 muestra la cuenta y la opción de  
                                 salir. Con credenciales inválidas 
                                 o vacías se muestra un mensaje de 
                                 error y no se inicia sesión. Al   
                                 cerrar sesión se vuelve a ser     
                                 visitante.                        

  RF-03    Búsqueda de productos La búsqueda por texto lista los   Alta
                                 productos coincidentes. Sin       
                                 coincidencias se informa. Un      
                                 texto demasiado corto se rechaza  
                                 con un aviso. La búsqueda         
                                 avanzada permite filtrar por      
                                 categoría y rango de precio.      

  RF-04    Catálogo: categorías, Se navega por categorías y        Media
           orden y paginación    subcategorías. Se puede ordenar   
                                 el listado (por ejemplo, nombre y 
                                 precio), cambiar la cantidad de   
                                 productos por página y la vista.  
                                 El resultado refleja la opción    
                                 elegida.                          

  RF-05    Carrito de compras    Se agregan productos desde el     Alta
                                 listado o la página del producto  
                                 y el indicador del carrito se     
                                 actualiza. Se puede cambiar la    
                                 cantidad, recalcular, quitar      
                                 productos y ver el subtotal. El   
                                 carrito vacío muestra un mensaje. 
                                 Se verifican cantidades no        
                                 válidas.                          

  RF-06    Productos con         Los productos configurables (por  Alta
           opciones (reto)       ejemplo, Build your own computer) 
                                 exigen elegir las opciones        
                                 obligatorias antes de agregarse   
                                 al carrito. El precio cambia      
                                 según las opciones elegidas. Si   
                                 falta una opción obligatoria se   
                                 informa y el producto no se       
                                 agrega.                           

  RF-07    Lista de deseos       Se agregan productos a la lista   Media
                                 de deseos, se consulta la lista,  
                                 se mueven al carrito y se quitan. 

  RF-08    Comparación de        Se agregan productos a comparar,  Media
           productos             se muestra la tabla comparativa,  
                                 se quita un producto y se limpia  
                                 la lista.                         

  RF-09    Proceso de compra     Un usuario registrado o invitado  Alta
           (reto)                completa la compra: términos de   
                                 servicio, dirección de            
                                 facturación, envío, método de     
                                 envío, método de pago y           
                                 confirmación. Los datos           
                                 obligatorios se validan en cada   
                                 paso. Al finalizar se informa que 
                                 la orden fue procesada.           

  RF-10    Cuenta del usuario    El usuario ve y edita su          Media
                                 información, cambia la            
                                 contraseña, administra            
                                 direcciones y consulta su         
                                 historial de pedidos.             

  RF-11    Boletín y encuesta    Se puede suscribir al boletín con Baja
                                 un correo válido (con el aviso    
                                 correspondiente) y rechazar uno   
                                 inválido. Se puede votar en la    
                                 encuesta de la comunidad.         
  -----------------------------------------------------------------------------

  -----------------------------------------------------------------
  **5. ENTREGABLES**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

**Entregable 1 --- Casos de prueba escritos (Excel)**

> • Use la plantilla Plantilla_Casos_de_Prueba_S7.xlsx.
>
> • Mínimo 30 casos, que cubran obligatoriamente RF-01, RF-02, RF-03,
> RF-05 y RF-09, y al menos otros dos requerimientos.
>
> • Cada caso tiene ID, requerimiento, título, tipo (positivo, negativo
> o límite), prioridad, precondiciones, datos, pasos, resultado esperado
> y si es automatizable.
>
> • Al menos el 30% de los casos deben ser negativos o de límite.
>
> • La hoja de trazabilidad debe mostrar la cantidad de casos por
> requerimiento.

**Entregable 2 --- Páginas con Page Factory (Java)**

> • Mínimo 6 clases de página con \@FindBy y PageFactory.initElements
> (por ejemplo, inicio, registro, inicio de sesión, resultados de
> búsqueda, producto, carrito y pago).
>
> • Los métodos tienen nombres de negocio y devuelven la página
> siguiente cuando hay navegación.
>
> • Las páginas no contienen aserciones ni datos de prueba fijos.
>
> • Se permite combinar \@FindBy con driver.findElement + By cuando el
> localizador lleva un parámetro; deben justificarlo con un comentario.

**Entregable 3 --- Pruebas automatizadas con POM (Java, JUnit 5)**

> • Mínimo 15 pruebas automáticas elegidas entre los casos escritos;
> cada una identifica su caso con \@DisplayName (por ejemplo, "CP-012
> Login con clave incorrecta").
>
> • Deben cubrir al menos 6 requerimientos, incluir al menos 4 casos
> negativos y al menos un flujo completo de compra (RF-09).
>
> • Ninguna prueba contiene By, \@FindBy ni driver.findElement. Las
> aserciones están en las pruebas.
>
> • Las pruebas son independientes y repetibles: no dependen del orden
> ni de datos que otra ejecución haya dejado.

**Entregable 4 --- Repositorio y evidencia**

> • Repositorio Git (GitHub o GitLab) con historial real: commits
> frecuentes y participación de todos los integrantes. Un único commit
> de entrega se penaliza.
>
> • README con cómo ejecutar el proyecto (mvn test) y cómo está
> organizado.
>
> • Evidencia de una ejecución completa: el reporte de surefire (carpeta
> target/surefire-reports) o una captura del resultado de mvn test.

**Entregable 5 --- Informe breve (2 a 3 páginas, PDF)**

> • Estrategia: qué automatizaron y qué no, y por qué.
>
> • Retos de automatización que encontraron y cómo los resolvieron.
>
> • Hallazgos: diferencias entre los requerimientos y el comportamiento
> real del sitio, o defectos encontrados, con pasos para reproducirlos.
>
> • Aprendizajes y mejoras posibles.

  -----------------------------------------------------------------
  **6. RETOS DE AUTOMATIZACIÓN QUE ENCONTRARÁN**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  ------------------------------------------------------------------
  **Reto**                **Por qué es difícil**
  ----------------------- ------------------------------------------
  Datos únicos            El registro rechaza correos repetidos:
                          cada ejecución necesita datos nuevos.

  Localizadores con       Los botones de agregar al carrito dependen
  parámetro               del producto: \@FindBy no acepta
                          parámetros.

  Opciones obligatorias y Productos configurables, países y estados
  listas desplegables     exigen manejar listas y botones de opción.

  Mensajes y avisos       Aparecen y desaparecen en la página; hay
  dinámicos               que leerlos en el momento correcto.

  Flujo de compra de      Cada paso se carga de forma dinámica; hay
  varios pasos            que esperar a que el siguiente paso esté
                          listo.

  Estado del carrito y de Las pruebas deben empezar siempre con un
  la sesión               navegador limpio para no depender unas de
                          otras.
  ------------------------------------------------------------------

  -----------------------------------------------------------------
  *Las esperas explícitas se verán en clase antes de la entrega.
  Mientras tanto, no usen Thread.sleep como solución: ayúdense de
  las esperas que el docente indique.*
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  -----------------------------------------------------------------
  **7. REGLAS TÉCNICAS**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

> • Java 17, Maven, JUnit 5 y Selenium 4. Se entrega un proyecto base
> con la estructura (Proyecto_Base_S7.zip).
>
> • Estructura de paquetes: base, pages y tests.
>
> • Preferir localizadores id, name y CSS; evitar XPath absolutos y los
> que dependen de la posición.
>
> • No usar Thread.sleep (la clase Visual del proyecto base es la única
> pausa permitida y solo para observar).
>
> • El uso de IA generativa como apoyo está permitido; el código y los
> casos deben ser entendidos y defendidos por el equipo. Cualquier
> integrante puede ser interrogado en la defensa.

  -----------------------------------------------------------------
  **8. RÚBRICA (100 puntos)**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  ---------------------------------------------------------------------
  **Criterio**             **Qué se revisa**                  **Pts**
  ------------------------ ---------------------------------- ---------
  Casos de prueba escritos Claridad, trazabilidad, variedad   25
                           (positivos, negativos, límite),    
                           cobertura de los requerimientos    
                           obligatorios                       

  Páginas con Page Factory \@FindBy bien usado, métodos de    25
                           negocio, navegación fluida, sin    
                           aserciones, localizadores robustos 

  Pruebas automatizadas    Cantidad, cobertura,               30
  con POM                  independencia, legibilidad, sin    
                           localizadores en las pruebas,      
                           pruebas que pasan                  

  Repositorio y evidencia  Historial de commits, README,      10
                           ejecución reproducible, reporte    

  Informe                  Estrategia, retos, hallazgos y     10
                           dominio individual del trabajo     
  ---------------------------------------------------------------------

  -----------------------------------------------------------------
  *En caso de que se detecte fraude o uso de la IA se hará una
  defensa y el trabajo que el equipo no pueda explicar en la
  defensa se califica con 0 para los implicados y se reporta según
  el reglamento institucional.*
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  -----------------------------------------------------------------
  **9. RUTA DE TRABAJO SUGERIDA**
  -----------------------------------------------------------------

  -----------------------------------------------------------------

  -------------------------------------------------------------------
  **Etapa**     **Qué hacer**
  ------------- -----------------------------------------------------
  1\. Explorar  Recorrer el sitio, anotar el comportamiento real y
                los mensajes de cada requerimiento.

  2\. Diseñar   Escribir los casos de prueba y marcar cuáles se
                automatizarán.

  3\. Construir Crear las clases con Page Factory, empezando por
  páginas       registro e inicio de sesión.

  4\.           Programar las pruebas, de las más simples a los
  Automatizar   flujos completos.

  5\. Cerrar    Revisar la trazabilidad, ejecutar todo junto,
                redactar el informe y preparar la defensa.
  -------------------------------------------------------------------

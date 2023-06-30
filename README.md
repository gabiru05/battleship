<h1 align="center">
  <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/BingAi/Ship-png.png" alt="Takoizu bot " width="150">
  <br>
  Battleship Game
</h1>
<a name="readme-top"></a>

<h4 align="center">

Created Using Java and JavaSwing for the Interface

</h4>

<img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/1pxRainbowLine.gif" width= "300000" alt="horizontal super thin rainbow RGB line">

#### <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/accepted.gif" width= "30" alt="Green icon denoting validation"> Para uso Publico o Personal

<img src="https://github.com/HotCakeX/Harden-Windows-Security/raw/main/images/Gifs/1pxRainbowLine.gif" width= "300000" alt="horizontal super thin rainbow RGB line">

<br>

## Funcionamiento y estructura del programa![Rainbow Cat gif](https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/Nyan%20cat.gif)

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy">Se inicia desde el **game.java** donde se crea una instancia de la clase de **battle**, se llama al constructor. Esto configura el tablero de juego y crea la Interfaz.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> El método **LoadTablero** se llama desde el constructor para crear y agregar los botones al tablero de juego.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> El método **setFuente** se llama desde el constructor y el método **LoadTablero** para establecer la fuente de los botones y el campo de texto.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> Cuando se hace clic en un botón, se llama al método **actionPerformed**. Este método maneja la lógica del juego y actualiza la pantalla en consecuencia.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> Si los barcos aún no se han colocado, se llama al método de configuración de **setbarcos** desde el método de acción **actionPerformed** para colocar un barco en el tablero.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> El método **setbarcos** llama al método **actualizarMatriz** para actualizar la matriz del juego con la ubicación del barco.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy">El método **setbarcos** también llama al método **actualizarBotones** para actualizar los botones en el tablero de juego para mostrar dónde se colocan los barcos.

-    <img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/bluemark.gif" width="25" alt="Blue Check mark denoting Group Policy"> El método **About_boats_Location** se llama desde varios lugares del código con fines de depuración. Imprime información sobre la ubicación de los barcos.

<br>
<img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/1pxRainbowLine.gif" width= "300000" alt="horizontal super thin rainbow RGB line">
<h2 align="center">The workspace contains two folders by default, where:</h2>

-    `src`: the folder to maintain sources
-    `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

<br>

> **Note** If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

<br>

<h2 align="center">Dependency Management</h2>

<img src="https://github.com/gabiru05/Gaby_Resource/blob/master/images/Gifs/1pxRainbowLine.gif" width= "300000" alt="horizontal super thin rainbow RGB line">

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

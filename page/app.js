import * as producto from "./js/productos.js"
document.getElementById("todos").addEventListener("click", function() {
   producto.getAllProductos();
});
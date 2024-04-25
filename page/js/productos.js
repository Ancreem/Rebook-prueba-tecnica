export function getAllProductos() {
    const token = localStorage.getItem('jwtToken');
    const searchInput = document.getElementById('search-input');

    fetch('http://localhost:8080/producto', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(response => response.json())
    .then(data => {
        const officeCardsContainer = document.querySelector('.info-data');
        const point = document.querySelector('#point').textContent = "productos";
        const statement = document.querySelector('#statement').textContent = "Aqui se mostraran todos los productos existentes en nuestra base de datos";

        let productos = data; // Almacenar todos los productos originalmente recibidos

        // Función para renderizar los productos en el contenedor
        const renderProductos = (productos) => {
            let html = '';
            productos.forEach(product => { 
                const id = product.id;
                const nombre = product.nombre; 
                const precio = product.precio; 

                html += `
                    <div class="card">
                        <div class="head">
                            <div>
                                <h1>ID: ${id}</h1> 
                                <br>
                                <h2><strong>Nombre: </strong> ${nombre}</h2>
                                <br>
                                <li><strong>Precio: </strong> ${precio}</li> 
                            </div>
                        </div>
                    </div>
                `;
            });
            officeCardsContainer.innerHTML = html;
        };

        // Inicialmente renderizar todos los productos
        renderProductos(productos);

        // Evento de escucha para el input de búsqueda
        searchInput.addEventListener('input', () => {
            const searchTerm = searchInput.value.toLowerCase();
            const filteredProductos = productos.filter(producto => {
                return producto.nombre.toLowerCase().includes(searchTerm);
            });
            renderProductos(filteredProductos); // Renderizar solo los productos filtrados
        });
    })
    .catch(error => console.error('Error:', error));
}

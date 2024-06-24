document.addEventListener('DOMContentLoaded', () => {
    const categoryButtons = document.querySelectorAll('.category-button');
    const dishList = document.getElementById('dish-list');
    const popup = document.getElementById('popup');
    const popupTitle = document.getElementById('popup-title');
    const popupDescription = document.getElementById('popup-description');
    const popupQuantity = document.getElementById('popup-quantity');
    const popupSize = document.getElementById('popup-size');
    const popupAddButton = document.getElementById('popup-add-button');
    const popupCancelButton = document.getElementById('popup-cancel-button');
    const orderList = document.getElementById('order-list');
    const buyButton = document.createElement('button');
    buyButton.id = 'buy-button';
    buyButton.textContent = 'Comprar';
    buyButton.disabled = true;
    document.querySelector('.right-section').appendChild(buyButton);

    let cart = [];

    categoryButtons.forEach(button => {
        button.addEventListener('click', async () => {
            const categoryId = button.getAttribute('data-id');
            try {
                const response = await fetch(`/api/platillos/categoria/${categoryId}`);
                if (!response.ok) {
                    throw new Error('Error en la solicitud');
                }
                const platillos = await response.json();
                displayDishes(platillos);
            } catch (error) {
                console.error('Error fetching platillos:', error);
            }
        });
    });

    function displayDishes(platillos) {
        dishList.innerHTML = '';
        platillos.forEach(platillo => {
            const dishItem = document.createElement('div');
            dishItem.classList.add('dish-item');

            const dishTitle = document.createElement('h3');
            dishTitle.textContent = platillo.nombre;

            const dishDescription = document.createElement('p');
            dishDescription.textContent = platillo.descripcion;

            const dishPrice = document.createElement('span');
            dishPrice.classList.add('dish-price');
            dishPrice.textContent = `$${platillo.precio}`;

            const addButton = document.createElement('button');
            addButton.classList.add('add-to-cart');
            addButton.textContent = 'Agregar';
            addButton.addEventListener('click', () => {
                showPopup(platillo);
            });

            dishItem.appendChild(dishTitle);
            dishItem.appendChild(dishDescription);
            dishItem.appendChild(dishPrice);
            dishItem.appendChild(addButton);

            dishList.appendChild(dishItem);
        });
    }

    function showPopup(platillo) {
        popupTitle.textContent = platillo.nombre;
        popupDescription.textContent = platillo.descripcion;
        popupQuantity.value = 1;
        popupSize.value = 'regular';
        popup.style.display = 'block';

        popupAddButton.onclick = () => {
            addToCart(platillo, popupQuantity.value, popupSize.value);
            closePopup();
            buyButton.disabled = false;
        };
    }

    function closePopup() {
        popup.style.display = 'none';
    }

    function addToCart(platillo, quantity, size) {
        const adjustedPrice = size === 'grande' ? platillo.precio * 1.2 : platillo.precio;

        const existingItem = cart.find(item => item.platillo.id === platillo.id && item.tamaño === size);

        if (existingItem) {
            existingItem.cantidad += parseInt(quantity);
        } else {
            cart.push({
                platillo: { ...platillo, precio: adjustedPrice },
                cantidad: parseInt(quantity),
                tamaño: size
            });
        }

        updateOrderSummary();
    }

    function updateOrderSummary() {
        orderList.innerHTML = '';
        let total = 0;

        cart.forEach(item => {
            const orderItem = document.createElement('div');
            orderItem.classList.add('order-item');

            const orderItemName = document.createElement('h4');
            orderItemName.textContent = `${item.platillo.nombre} (${item.tamaño})`;

            const orderItemDetails = document.createElement('p');
            orderItemDetails.textContent = `${item.cantidad} x $${item.platillo.precio.toFixed(2)}`;

            orderItem.appendChild(orderItemName);
            orderItem.appendChild(orderItemDetails);
            orderList.appendChild(orderItem);

            total += item.cantidad * item.platillo.precio;
        });

        if (cart.length > 0) {
            buyButton.disabled = false;
            buyButton.textContent = `Comprar - Total: $${total.toFixed(2)}`;
        } else {
            buyButton.disabled = true; // Deshabilitar el botón "Comprar" si el carrito está vacío
        }
    }

    async function sendOrder(order) {
        try {
            const response = await fetch('/api/orders', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(order)
            });
            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }
            const result = await response.json();
            return result.orderId;
        } catch (error) {
            console.error('Error sending order:', error);
            return null;
        }
    }

    buyButton.addEventListener('click', async () => {
        if (cart.length === 0) {
            alert('Debe agregar al menos un platillo a la orden antes de comprar.');
            return;
        }

        const orderId = await sendOrder(cart);
        if (orderId !== null) {
            alert(`Orden procesada con éxito. Número de orden: ${orderId}`);
            cart = [];
            updateOrderSummary();
        } else {
            alert('Hubo un error al procesar su orden. Por favor, inténtelo de nuevo.');
        }
    });

    popupCancelButton.addEventListener('click', closePopup);
    closeBtn.addEventListener('click', closePopup);

    window.addEventListener('click', (event) => {
        if (event.target === popup) {
            closePopup();
        }
    });
});




var initialResponse;

$(document).ready(function(){
    $('.header').height($(window).height());

    const urlParams = new URLSearchParams(window.location.search);
    const orderID = urlParams.get('orderID');
        var url = "http://localhost:8081/orderservice/orders/" + orderID;
        axios.get(url)
        .then(response =>{
            initialResponse = response;
            document.getElementById("thanks").innerHTML = "Order received. Your order number is " + response.data.Order.orderID + ".";
            document.getElementById("customerName").innerHTML = "Ship to: " + response.data.Order.customer.firstName + " " + response.data.Order.customer.lastName;
            document.getElementById("productName").innerHTML = "Product: " + response.data.Order.product.productName;
            document.getElementById("address").innerHTML = "Shipment address: " + response.data.Order.shipmentAddress.streetAddress + " " + response.data.Order.shipmentAddress.unitNumber + ", " + response.data.Order.shipmentAddress.city + " " + response.data.Order.shipmentAddress.state + " " + response.data.Order.shipmentAddress.zipCode;
            document.getElementById("invoice").innerHTML = "Order invoice: " + response.data.Order.product.productCost + " was charged to " + response.data.Order.payment.cardNumber;
            document.getElementById("status").innerHTML = "Order status: " + response.data.Order.status;
        })
        .catch(error =>{
            console.log(error);
        }); 

});

function performReview(){
    const reviewURL = initialResponse.data.Order.link[2].url;
    axios.post(reviewURL, (
        {
            'ReviewRequest': {
                'customerID': initialResponse.data.Order.customer.customerID,
                'productID': initialResponse.data.Order.product.productID,
                'reviewScore': document.getElementById("score").value,
                'reviewBody': document.getElementById("body").value
            }
        }))
        .then(response => {
            console.log(response.status);
            $('#score').val('')
            $('#body').val('')
             window.location.href = "http://localhost:8082/product.html?prodID=" + initialResponse.data.Order.product.productID;
        })
        .catch(error =>{
            console.log(error);
        })
}

function performOrderDelete(){
    const deleteURL = initialResponse.data.Order.link[0].url;
    axios.delete(deleteURL)
    .then(response =>{
        console.log(response.status);
        window.location.href = "http://localhost:8082/products.html";
    })
}
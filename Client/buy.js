function performCustomerBuy(){
    let url = "http://localhost:8080/addressservice/addresses"
    const urlParams = new URLSearchParams(window.location.search);
    const prodID = urlParams.get('prodID');
    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var customerIDString = cookie[0].split("=");
    var customerID = customerIDString[1];
    console.log(customerID);
    axios.post(url, (
        {
            'AddressRequest': {
                'customerID': customerID,
                'streetAddress': document.getElementById("street").value,
                'unitNumber': document.getElementById("unit-number").value,
                'zipCode': document.getElementById("zip-code").value,
                'city': document.getElementById("city").value,
                'state': document.getElementById("state").value
            }
        }))
        .then(response => {
            console.log('response status', response.status);
            const addressID = response.data.Address.addressID;
            url = "http://localhost:8080/paymentservice/payments";
            axios.post(url, (
                {
                    'PaymentRequest': {
                        'customerID': customerID,
                        'cardNumber': document.getElementById("card-number").value,
                        'securityCode': document.getElementById("security-code").value,
                        'addressID': addressID,
                        'expirationDate': document.getElementById("expiration").value
                    }
                }))
            .then(response => {
                console.log('payment response', response);
                const url = "http://localhost:8080/orderservice/orders"
                console.log(prodID);
                axios.post(url, (
                    {
                        'OrderRequest': {
                            'customerID': customerID,
                            'productID': prodID,
                            'paymentID': response.data.Payment.paymentID,
                            'addressID': addressID,
                            'status': 'Ordered'
                        }
                    }))
                    .then(response => {
                        console.log('response status', response.status);
                        window.location.href = "http://localhost:8081/order.html?orderID=" + response.data.Order.orderID;
                    })
                    .catch(error => {
                        console.log('error', error);
                    }); 
            })
            .catch(error => {
                console.log('error', error);
            }); 
        })
        .catch(error => {
            console.log('error', error);
        }); 



    
}
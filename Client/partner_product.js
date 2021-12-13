function performProductAdd(){
    const productURL = "http://localhost:8080/productservice/products";
    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var partnerIDString = cookie[0].split("=");
    partnerID = partnerIDString[1];
    console.log(productURL);
    axios.post(productURL, {
        'ProductRequest': {
            'partnerID': partnerID,
            'productName': document.getElementById("product-name").value,
            'productDescription': document.getElementById("product-description").value,
            'productCost': document.getElementById("product-cost").value
        }
    })
    .then(response =>{
        console.log(response.status);
        window.location.href = "http://localhost:8080/partner_products.html";
    })
}

$(document).ready(function(){
    $('.header').height($(window).height());
});
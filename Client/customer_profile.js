var initialResponse;
var customerID;

$(document).ready(function(){
    $('.header').height($(window).height());

    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var customerIDString = cookie[0].split("=");
    customerID = customerIDString[1];
    var url = "http://localhost:8081/customerservice/customer"
    axios.get(url)
    .then(response =>{
        initialResponse = response;
        document.getElementById("thanks").innerHTML = "Thanks for signing up, " + response.data.Customer.firstName;
        document.getElementById("firstName").innerHTML = "First name: " + response.data.Customer.firstName;
        document.getElementById("lastName").innerHTML = "Last name: " + response.data.Customer.lastName;
        document.getElementById("phoneNumber").innerHTML = "Phone number: " + response.data.Customer.phoneNumber;
    })
    .catch(error =>{
        console.log(error);
    }); 
});

function performCustomerFirstNameUpdate(){
    const firstNameURL = initialResponse.data.Customer.link[1].url;
    console.log(firstNameURL);
    axios.put(firstNameURL, {
        'CustomerRequest': {
            'customerID': customerID,
            'firstName': document.getElementById("first-name").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("firstName").innerHTML = "First name: " + response.data.Customer.firstName;
        $('#first-name').val('')
    })
}

function performCustomerLastNameUpdate(){
    const lastNameURL = initialResponse.data.Customer.link[2].url;
    console.log(lastNameURL);
    axios.put(lastNameURL, {
        'CustomerRequest': {
            'customerID': customerID,
            'lastName': document.getElementById("last-name").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("lastName").innerHTML = "Last name: " + response.data.Customer.lastName;
        $('#last-name').val('')
    })
}

function performCustomerPhoneNumberUpdate(){
    const phoneNumberURL = initialResponse.data.Customer.link[3].url;
    console.log(phoneNumberURL);
    axios.put(phoneNumberURL, {
        'CustomerRequest': {
            'customerID': customerID,
            'phoneNumber': document.getElementById("phone-number").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("phoneNumber").innerHTML = "Phone number: " + response.data.Customer.phoneNumber;
        $('#phone-number').val('')
    })
}

function performCustomerDelete(){
    const deleteURL = initialResponse.data.Customer.link[0].url;
    axios.delete(deleteURL)
    .then(response =>{
        console.log("aaaah im deleted");
        console.log(response.status);
        window.location.href = "http://localhost:8082/index.html";
    })
}
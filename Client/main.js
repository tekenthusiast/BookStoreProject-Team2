$(document).ready(function(){
    $('.header').height($(window).height());
});

function performCustomerPost() {
    const url = 'http://localhost:8080/customerservice/customers';
    const config = {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    };
    axios.post(url, (
        {
            'CustomerRequest': {
                'firstName': document.getElementById("first-name").value,
                'lastName': document.getElementById("last-name").value,
                'phoneNumber': document.getElementById("phone-number").value
            }
        }))
        .then(response => {
            console.log('response status', response.status);
            console.log(response);
            document.cookie = "customerID=" + response.data.Customer.customerID;
            console.log(document.cookie);
            window.location.href = "http://localhost:8080/customer_profile.html";
        })
        .catch(error => {
            console.log('error', error);
        }); 
}

function performPartnerPost() {
    const url = 'http://localhost:8080/partnerservice/partners';
    const config = {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    };
    axios.post(url, (
        {
            'PartnerRequest': {
                'partnerName': document.getElementById("partner-name").value,
                'partnerType': document.getElementById("partner-type").value,
                'partnerDetails': document.getElementById("details").value
            }
        }))
        .then(response => {
            console.log('response status', response.status);
            console.log(response);
            document.cookie = "partnerID=" + response.data.Partner.partnerID;
            console.log(document.cookie);
            window.location.href = "http://localhost:8080/partner_profile.html";
        })
        .catch(error => {
            console.log('error', error);
        }); 
}
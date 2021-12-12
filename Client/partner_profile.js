var initialResponse;
var partnerID;

$(document).ready(function(){
    $('.header').height($(window).height());

    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var partnerIDString = cookie[0].split("=");
    partnerID = partnerIDString[1];
    var url = "http://localhost:8080/partnerservice/partner/" + partnerID;
    axios.get(url)
    .then(response =>{
        initialResponse = response;
        console.log(response);
        document.getElementById("thanks").innerHTML = "Thanks for signing up, " + response.data.Partner.partnerName;
        document.getElementById("partnerName").innerHTML = "Partner name: " + response.data.Partner.partnerName;
        document.getElementById("details").innerHTML = "Details: " + response.data.Partner.partnerDetails;
    })
    .catch(error =>{
        console.log(error);
    }); 
});

function performPartnerNameUpdate(){
    const partnerNameURL = initialResponse.data.Partner.link[0].url;
    console.log(partnerNameURL);
    axios.put(partnerNameURL, {
        'PartnerRequest': {
            'partnerID': partnerID,
            'partnerName': document.getElementById("partner-name").value
        }
    })
    .then(response =>{
        console.log(response.status);
        document.getElementById("partnerName").innerHTML = "Partner name: " + response.data.Partner.partnerName;
        $('#partner-name').val('');
    })
}


function performPartnerDetailsUpdate(){
    const detailsURL = initialResponse.data.Partner.link[1].url;
    console.log(detailsURL);
    axios.put(detailsURL, {
        'PartnerRequest': {
            'partnerID': partnerID,
            'partnerDetails': document.getElementById("partner-details").value
        }
    })
    .then(response =>{
        console.log(response.status);
        console.log(response);
        console.log(document.getElementById("partner-details").value);
        document.getElementById("details").innerHTML = "Details: " + response.data.Partner.partnerDetails;
        $('#partner-details').val('');
    })
}

function performPartnerDelete(){
    const deleteURL = initialResponse.data.Partner.link[2].url;
    axios.delete(deleteURL)
    .then(response =>{
        console.log("aaaah im deleted");
        console.log(response.status);
        window.location.href = "http://localhost:8080/index.html";
    })
}
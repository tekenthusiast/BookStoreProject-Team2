$(document).ready(function(){
    $('.header').height($(window).height());

    var decodedCookie = decodeURIComponent(document.cookie);
    var cookie = decodedCookie.split(';');
    var partnerIDString = cookie[0].split("=");
    partnerID = partnerIDString[1];
    var table = new Tabulator("#product-display", {        //load row data from array
        layout:"fitColumns",      //fit columns to width of table
        responsiveLayout:"hide",  //hide columns that dont fit on the table
        tooltips:true,            //show tool tips on cells
        addRowPos:"top",          //when adding a new row, add it to the top of the table
        history:true,             //allow undo and redo actions on the table
        pagination:"local",       //paginate the data
        paginationSize:7,         //allow column order to be changed
        resizableRows:true, 
        placeholder:"No Products Available",
        ajaxURL:"http://localhost:8080/productservice/"+ partnerID +"/partner_products" ,
        ajaxConfig:"GET",
        ajaxResponse: function(url, params, response){
            return Object.values(response.Product);
        },
        columns:[       
            {title:"Product", field:"productName"},
            {title:"Description", field:"productDescription", width:450},
            {title:"Cost", field:"productCost", formatter:"money", formatterParams:{
                symbol:"$",
                precision:false,
            }},
            {title:"Sold by", field:"partner.partnerName"}
        ],
    });
});
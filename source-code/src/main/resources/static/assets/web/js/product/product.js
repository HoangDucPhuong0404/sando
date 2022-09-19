
let tempProduct = $.validator.format($.trim($('#tempProduct').val()));

function prependProduct() {
    $("#main-content").prepend($(tempProduct(product.title, product.productSizeColors)));
}

function getProductBySlug(){
    webAPI.product.findBySlug(slug, (data)=>{
        alert("du lieu tra ve: " + data.textData);
        prependProduct()
    }, (jqXHR) =>{
        alert("du lieu tra ve LOI" + jqXHR.textData)
    })

}

getProductBySlug()
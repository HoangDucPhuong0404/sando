
// let tempRowProduct = $.trim($('#tempRowProduct').val());


// function replaceRowProduct(product) {
//     $().replaceWith($(tempRowProduct(product.id, product.title, product.image, product.slug, product.createAt)));
// }
//
//
// function addRowProduct(product) {
//     $("#tbListProduct tbody").prepend($(tempRowProduct(product.id, product.title, product.image, product.slug, product.createAt)));
// }

function getAllProduct() {
    api.product.findAll((data) => {
        $('#tbListProduct tbody').html('');

        $.each(data, (i, item) => {
            product = item;
            addRowProduct(product);
        })
    },
        (jqXHR) =>{
            App.SweetAlert.showErrorAlert(jqXHR.message)
        })

}

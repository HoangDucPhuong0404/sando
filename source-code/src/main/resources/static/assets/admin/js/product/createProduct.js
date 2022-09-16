let tempRowProduct =  $.validator.format($.trim($('#tempRowProduct').val()));


let tempTablePick =  $.validator.format($.trim($('#tempTablePick').val()));

// function replaceRowPick(){
//     $().replaceWith($(tempTablePick(nameProduct, sizeName,colorName)));
// }

function replaceRowProduct() {
    $().replaceWith($(tempRowProduct(product.id, product.title, product.image, product.slug, product.createAt)));
}


function addRowProduct() {
    $("#tbListProduct tbody").prepend($(tempRowProduct(product.id, product.title, product.image, product.slug, product.createAt)));
}

function addTempTablePick(){
    // let colorSizeParam = new ColorSizeParam()
    // let nameProduct = $('#nameCr').val();
    let sizeName = $('#sizeCr').find(":selected").text();
    let colorName = $('#colorCr').find(":selected").text();
    $("#tablePick tbody").prepend($(tempTablePick( sizeName,colorName)));
}



    $('#btnAdd').on('click', () => {
        $('#tablePick tbody').html('')
        addTempTablePick();
        // replaceRowPick();
    })




$(document).ready(function () {
    console.log("ready!");
    api.category.findAll((data) => {
            $.each(data, (i, item) => {
                let str = ` <option data-id="${item.slug}" value="${item.id}">${item.title}</option>
`;
                $("#categoryCr").prepend(str);
                $("#categoryUp").prepend(str);
            })
        }, (jqXHR) => {
            App.SweetAlert.showErrorAlert(jqXHR.message)
        }
    )
    api.size.findAll((data) => {
            $.each(data, (i, item) => {
                let str = ` <option data-id="${item.id}" value="${item.code}">${item.title}</option>`;
                $("#sizeCr").prepend(str);
                $("#sizeUp").prepend(str);
            })
        }, (jqXHR) => {
            App.SweetAlert.showErrorAlert(jqXHR.message)
        }
    )
    api.color.findAll((data) => {
            $.each(data, (i, item) => {
                let str = ` <option data-id="${item.id}" value="${item.code}">${item.title}</option>`;
                $('#colorCr').prepend(str);
                $('#colorUp').prepend(str);
            })
        }, (jqXHR) => {
            App.SweetAlert.showErrorAlert(jqXHR.message)
        }
    )
    // api.product.findById(id,(data) => {
    //         $.each(data, (i, item) => {
    //             let str = ` <option data-id="${item.id}" value="${item.code}">${item.title}</option>`;
    //             $('#colorCr').prepend(str);
    //             $('#colorUp').prepend(str);
    //         })
    //     }, (jqXHR) => {
    //         App.SweetAlert.showErrorAlert(jqXHR.message)
    //     }
    // )


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

});

$('#btnCreateProduct').on('click', () => {
    let product = new Product();
    let colorSizeParam = new ColorSizeParam();


    colorSizeParam.sizeId = $('#sizeCr').attr("data-id");
    colorSizeParam.colorId = $('#colorCr').attr("data-id");
    colorSizeParam.price = $('#priceCr').val();
    colorSizeParam.quantity = $('#quantityCR').val();

     product.title = $('#nameCr').val();
     product.slug = $('#slugCr').val();
     product.image = $('#imageCr').val();
     product.categoryId = $('#categoryCr').val();
     product.description =  $('#descriptionCr').val();
     product.colorSizeParam = colorSizeParam;
    // let status = $('#statusCr').val();

    return $.ajax({
        type: "POST",
        headers: {
            "Content-type": "application/json",
            "Accept": "application/json"
        },
        url: "http://localhost:8091/api/products/create",
        data: JSON.stringify(product)
    })
        .done(function (data) {
            product = data;
            addRowProduct();

            $('#createGeneralPr')[0].reset();
            $('#createAddPr').trigger('reset');

            App.SweetAlert.showSuccessAlert("Create product successful !")

        })
        .fail(function (jqXHR) {
            App.SweetAlert.showErrorAlert("Can not create product !!!")
        })

})


$('#exportFilePr').on('click', () => {
    console.log('aaa')
    $("#exportModalPr").modal("show");
});

$('#importFilePr').on('click', () => {
    $("#importModalPr").modal("show");
})

$('#addCategory').on('click', () => {
    $("addCategoryModal").modal("show");
})
//
// function findProductById(id) {
//     return $.ajax({
//         type: "GET",
//         headers: {
//             "Content-type": "application/json",
//             "Accept": "application/json"
//         },
//         url: "http://localhost:8091/api/products/" + id
//     })
//         .done((data) => {
//             product = data
//         })
//         .fail((jqXHR) => {
//             App.SweetAlert.showErrorAlert("Fail to find product !");
//         })
// }
let drawTotalRevenue = () => {

}



let drawTotalProduct = () => {

    api.product.countAll((data) => {
        let str = `<h2>${data}</h2>`;
        $('#totalProduct').prepend(str);
    })
}

function handleShowUpdate() {
    $('button.edit').on('click', () => {
        let id = $(this).data("id");
        api.product.findById((id),(data) =>{
            product = data;


            $('#fullNameUp').val(product.name);
            $('#imageUp').val(product.image);
            $('#titleUp').val(product.title);
            $('#priceUp').val(product.price);
            $('#quantityUp').val(product.quantity);
            $('#sizeUp').val(product.size);
            $('#categoryUp').val(product.category);
            $('#descriptionUp').val(product.description);
            $('#statusUp').val(product.status);

        },(jqXHR) =>{
            App.SweetAlert.showErrorAlert(jqXHR.message);
        })
    })
}

function handleShowDeleteModal() {
    $('button.delete').on('click', () => {
        let id = $(this).data("id");
        $('deleteModal').modal('show').then(function () {
            doDeleteProduct(id);
        })

    })
}


function handleShowViewProduct() {
    $('button.view').on('click', () => {
        let id = $(this).data("id");
        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            type: 'GET',
            url: "http://localhost:8091/api/products/" + id
        })
            .done((data) => {
                product = data;
                $('#viewModal').modal('show');


            })
    })
}

// $('#btnCreateProduct').on('click', () =>{
//
//     drawInformation();
//
//     productSizeColor.sizeId = $('#sizeCr').val();
//     productSizeColor.sizeTitle = $('#sizeCr :selected').text();
//     productSizeColor.colorId = $('#colorCr').val();
//     productSizeColor.colorTitle = $('#colorCr :selected').text();
//     productSizeColor.quantity = $('#quantityCR').val();
//     productSizeColor.price = $('#priceC').val();
//
//
//     product.title = $('#nameCr').val();
//     product.image = $('#imageCr').val();
//     product.price = $('#priceCR').val();
//     product.category = $('#categoryCr').val();
//     product.description = $('#descriptionCr').val();
//     product.status = $('#statusCr').val();
//     product.productSizeColor = productSizeColor;
//
//
//     $.ajax({
//         headers:{
//             "accept":"application/json",
//             "type-content":"application/json"
//         },
//         type:"POST",
//         url:"http://localhost:8091/api/products/create",
//         data:JSON.stringify(product)
//     })
//         .done((data) =>{
//             product = data;
//             productSizeColor = product.productSizeColor;
//
//             addRowProduct();
//
//             $("#createProductForm").trigger('reset');
//
//             App.SweetAlert.showSuccessAlert("Create product successful !")
//
//
//         })
//         .fail((jqXHR) =>{
//             $('#createModal .modal-alert-danger').html('').removeClass('hide').addClass('show');
//             if (jqXHR.responseJSON.message){
//                 let msg = jqXHR.responseJSON.message;
//
//                 let str = `<label id ="message-error" class = "error" for="message">${msg}</label>`;
//
//                 $('#createModal .modal-alert-danger').append(str);
//             }
//             else if (jqXHR.responseJSON){
//                 $.each(jqXHR.responseJSON, (key, item) =>{
//                     let str = `<label id="${key}-error" class="error" for="${key}">${item}</label>`;
//                     $("#" + key).addClass("error");
//
//                     $('#createModal .modal-alert-danger').append(str);
//                 })
//             }
//         })
// })

function doUpdate() {

    $('#btnUpdate').on('click', () => {
        product.name = $('#nameUp').val();
        product.image = $('#imageUp').val();
        product.title = $('#titleUp').val();
        product.price = $('#priceUp').val();
        product.quantity = $('#quantityUp').val();
        product.size = $('#sizeUp').val();
        product.category = $('#categoryUp').val();
        product.description = $('#descriptionUp').val();

        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            type: "PUT",
            url: "http://localhost:8091/api/products/update",
            data: JSON.stringify(product)
        })
            .done((data) => {
                product = data;

                replaceRowProduct();

                $('#createModal').modal('hide');

                App.SweetAlert.showSuccessAlert('Update product success !');


            })
            .fail((jqXHR) => {
                $('#modalEdit .modal-alert-danger').html('').removeClass('hide').addClass('show');

                if (jqXHR.responseJSON.message) {
                    let msg = jqXHR.responseJSON.message;

                    let str = `<label id="message-error" class="error" for="message">${msg}</label>`;

                    $('#modalEdit .modal-alert-danger').append(str);
                } else if (jqXHR.responseJSON) {
                    $.each(jqXHR.responseJSON, (key, item) => {
                        let str = `<label id="${key}-error" class="error" for="${key}">${item}</label>`;
                        $("#" + key).addClass("error");

                        $('#modalUpdateCustomer .modal-alert-danger').append(str);
                    })
                }
            })
    })
}

function doDeleteProduct(id) {
    $('#btnDelete').on('click', () => {


        api.product.deleteById((id), (data) => {
                App.SweetAlert.showSuccessAlert("Delete product success !")
                $('deleteModal').modal('hide');
            },
            (jqXHR) => {
                App.SweetAlert.showErrorAlert(jqXHR.message);
            })
    })
}








function handleImportModal() {
    $('#importFile').on('click', () => {
        $('#importModal').modal('show')
    })
}


function handleExportModal() {
    $('#exportFile').on('click', () => {
        $('#exportModal').modal('show')
    })
}

function getAllProduct() {
    api.product.findAll((data) => {
            $('#tbListProduct tbody').html('');

            $.each(data, (i, item) => {
                product = item;
                addRowProduct();
            })
        },
        (jqXHR) =>{
            App.SweetAlert.showErrorAlert(jqXHR.message)
        })

}


// $("#createGeneralPr").validate({
//     rules: {
//         nameCr:{
//             required: true
//         },
//         slugCr:{
//             required: true
//         },
//         priceCr:{
//             required: true,
//
//             min: 0,
//
//             max:100000
//         },
//         categoryCr:{
//             required:true
//         }
//     },
//     message:{
//         nameCr:{
//             required: "Name product can not be empty "
//         },
//         slugCr:{
//             required: "Slug product can not be empty "
//         },
//         priceCr:{
//             required: "Price product can not be empty ",
//
//             min: "Price must be bigger than 0",
//
//             max: "Too expensive"
//         },
//         categoryCr:{
//             required: "Pick one Category please "
//         }
//     },
//     submitHandler: function (){
//
//     }
// })
//
// $("#createAddPr").validate({
//     rules: {
//         sizeCr: {
//             required: true
//         },
//         quantityCr:{
//             required:true,
//
//             min:0,
//
//             max: 1000
//         },
//         colorCr:{
//             required:true
//         }
//     },
//     message: {
//         sizeCr: {
//             required: "Size can not be empty please !"
//         },
//         quantityCr:{
//             required:"Quantity can not be empty please !",
//
//             min: "Quantity must bigger than 0",
//
//             max: "Too much product couldn't be sold off !"
//         },
//         colorCr:{
//             required:"Pick a one color please !"
//         }
//     },
//     submitHandler: function (){
//
//     }
// })



let product = new Product();

let category = new Category();



// let tempRowProduct = $.trim($('#tempRowProduct').val());
//
//
//
// let tempViewProduct = $.validator.format($.trim($('#tempViewProduct').val()));


function replaceRowProduct(){
    $('#tr_' + product.id).replaceWith($(tempRowProduct(product.id, product.name,product.price,product.quantity,product.title,product.size,product.category,product.status)));
}


function addRowProduct(){
    $("#tbListProduct tbody").prepend($(tempRowProduct(product.id, product.name,product.price, product.quantity, product.createAt, product.size,product.category,product.status)));
}

// drawTotalProduct();


// let btnShowCreateModal = $('#btnCreateModal')
// btnShowCreateModal.on('click', () => {
//     drawCategory();
//     drawColor();
//     drawSize();
//
// });
console.log('aaa')
$('#exportFilePr').on('click', () =>{
    console.log('aaa')
    $("#exportModalPr").modal("show");
});

$('#importFilePr').on('click', () =>{
    $("#importModalPr").modal("show");
})

function findProductById(id) {
    return $.ajax({
        type:"GET",
        headers:{
            "Content-type":"application/json",
            "Accept":"application/json"
        },
        url:"http://localhost:8091/api/product/" +id
    })
        .done((data) =>{
            product = data
        })
        .fail( (jqXHR) =>{
            App.SweetAlert.showErrorAlert("fail to find product !");
        })
}



let drawTotalProduct = () => {
    return $.ajax({
        "headers":{
            "accept":"application/json",
            "content-type":"application/json"
        },
        "type":"GET",
        "url":"http://localhost:8091/api/product/count"
    })
        .done((data) =>{
            let str = `<h2>${data}</h2>`;
            $('#totalProduct').prepend(str);
        })
}


let drawColor = () => {
    return $.ajax({
        "headers":{
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type": "GET",
        "url": "http://localhost:8091/api/product/color",
    })
        .done((data) => {
            $.each(data,color, (i,item) => {
                let str = ` <label class="btn btn-round btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                    <input type="radio" id="category" name="category" value="${item.id}"> &nbsp; ${item.color} &nbsp;
                                                </label>`;
                $('#colorCr').prepend(str);
                $('#colorUp').prepend(str);
            })
        }).fail((jqXHR) =>{
            App.SweetAlert.showErrorAlert("Something wrong !");
        })
}

let drawSize = () => {
    return $.ajax({
        "headers":{
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type":"GET",
        "url": "http://localhost:8091/api/product/size",
    })
        .done((data) =>{
            $.each(data, size, (i,item) =>{
                let str = `<label class="btn btn-primary active">
                                                    <input type="radio" class="sr-only"  name="aspectRatio" value="${item.id}">
                                                    <span class="docs-tooltip" data-toggle="tooltip" title="aspectRatio: 16 / 9">
                            ${item.size}
                          </span>
                                                </label>`;

                $("#sizeCr").prepend(str);
                $("#sizeUp").prepend(str);
            })

        })
        .fail((jqXHR) =>{
            App.SweetAlert.showErrorAlert("Get data fail !")
        })
}

let drawCategory = () =>{
    return $.ajax({
        headers:{
            "accept": "application/json",
            "content-type":"application/json"
        },
        type:"GET",
        url:"http://localhost:8091/api/product/category",
    })
        .done((data) =>{
            $.each(data, category, (i,item) =>{
                let str = ` <label class="btn btn-round btn-danger" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                        <input type="radio" name="category" value="${item.id}"> &nbsp; ${item.title} &nbsp;
                                                                    </label>`;
                $("#categoryCr").prepend(str);
                $("#categoryUp").prepend(str);
            })
        })
        .fail((jqXHR) =>{
            App.SweetAlert.showErrorAlert("Get data fail !")
        })
}
function handleShowUpdate(){
    $('button.edit').on('click', () =>{
        let id = $(this).data("id");
        findProductById(id).then(function (){
            drawSize();
            drawColor();
            drawCategory();
            $('#fullNameUp').val(product.name);
            $('#imageUp').val(product.image);
            $('#titleUp').val(product.title);
            $('#priceUp').val(product.price);
            $('#quantityUp').val(product.quantity);
            $('#sizeUp').val(product.size);
            $('#categoryUp').val(product.category);
            $('#descriptionUp').val(product.description);
            $('#statusUp').val(product.status);
        }).then(function (){

        })
    })
}
function handleShowDeleteModal(){
    $('button.delete').on('click', () =>{
        let id = $(this).data("id");
        $('deleteModal').modal('show').then(function (){
            doDeleteProduct(id);
        })

    })
}


function handleShowViewProduct(){
    $('button.view').on('click', () => {
        let id = $(this).data("id");
        $.ajax({
            headers:{
                "accept":"application/json",
                "content-type":"application/json"
            },
            type:'GET',
            url:"http://localhost:8091/api/product/"+ id
        })
            .done((data) =>{
                product = data;
                $('#viewModal').modal('show');


            })
    })
}

$('#btnCreate').on('click', () =>{
    product.name = $('#name').val();
    product.image = $('#image').val();
    product.title = $('#title').val();
    product.price = $('#price').val();
    product.quantity = $('#quantity').val();
    product.size = $('#size').val();
    product.category = $('#category').val();
    product.description = $('#description').val();
    product.status = $('#status').val();

    $.ajax({
        headers:{
            "accept":"application/json",
            "type-content":"application/json"
        },
        type:"POST",
        url:"http://localhost:8091/api/product/create",
        data:JSON.stringify(product)
    })
        .done((data) =>{
            product = data;

            addRowProduct();

            $("#createProductForm").trigger('reset');

            App.SweetAlert.showSuccessAlert("Create product successful !")


        })
        .fail((jqXHR) =>{
            $('#createModal .modal-alert-danger').html('').removeClass('hide').addClass('show');
            if (jqXHR.responseJSON.message){
                let msg = jqXHR.responseJSON.message;

                let str = `<label id ="message-error" class = "error" for="message">${msg}</label>`;

                $('#createModal .modal-alert-danger').append(str);
            }
            else if (jqXHR.responseJSON){
                $.each(jqXHR.responseJSON, (key, item) =>{
                    let str = `<label id="${key}-error" class="error" for="${key}">${item}</label>`;
                    $("#" + key).addClass("error");

                    $('#createModal .modal-alert-danger').append(str);
                })
            }
        })
})

function doUpdate(){
$('#btnUpdate').on('click', () =>{
    product.name = $('#nameUp').val();
    product.image = $('#imageUp').val();
    product.title = $('#titleUp').val();
    product.price = $('#priceUp').val();
    product.quantity = $('#quantityUp').val();
    product.size = $('#sizeUp').val();
    product.category = $('#categoryUp').val();
    product.description = $('#descriptionUp').val();

    $.ajax({
        "headers":{
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type":"PUT",
        "url": "http://localhost:8091/api/product/update",
        "data": JSON.stringify(product)
    })
        .done((data) =>{
            product = data;

            replaceRowProduct();

            $('#createModal').modal('hide');

            App.SweetAlert.showSuccessAlert('Update product success !');


        })
        .fail((jqXHR) =>{
            $('#modalEdit .modal-alert-danger').html('').removeClass('hide').addClass('show');

            if (jqXHR.responseJSON.message){
                let msg = jqXHR.responseJSON.message;

                let str = `<label id="message-error" class="error" for="message">${msg}</label>`;

                $('#modalEdit .modal-alert-danger').append(str);
            }
            else if (jqXHR.responseJSON){
                $.each(jqXHR.responseJSON, (key,item) =>{
                    let str = `<label id="${key}-error" class="error" for="${key}">${item}</label>`;
                    $("#" +key).addClass("error");

                    $('#modalUpdateCustomer .modal-alert-danger').append(str);
                })
            }
        })
})
}

function doDeleteProduct(id) {
    $('#btnDelete').on('click', () => {


        return $.ajax({
            type: "DELETE",
            headers: {
                "Content-Type": "application/json",
                "accept": "application/json"
            },
            url: "http://localhost:8091/api/product/delete/" + id,

        })
            .done((data) => {
                App.SweetAlert.showSuccessAlert("Delete product success !")
                $('deleteModal').modal('hide');
            })
            .fail((jqXHR) => {
                App.SweetAlert.showErrorAlert("Something wrong !")
            })
    })
}


function handleImportModal() {
    $('#importFile').on('click', ()=>{
        $('#importModal').modal('show')
    })
}


function handleExportModal(){
    $('#exportFile').on('click', () =>{
        $('#exportModal').modal('show')
    })
}






function getAllProduct() {
    $.ajax({
        "headers":{
            "accept":"application/json",
            "content-type":"application/json"
        },
        "type":"GET",
        url:"http://localhost:8091/api/product/"
    })
        .done((data) =>{
            $('#tbListProduct tbody').html('');

            $.each(data, (i,item) =>{
                product = item;
                addRowProduct();

            });

        }).fail((jqXHR) =>{

    })

}

$(() => {
    getAllProduct();
})
$("#createGeneralPr").validate({
    rules: {
        nameCr:{
            required: true
        },
        slugCr:{
            required: true
        },
        priceCr:{
            required: true,

            min: 0,

            max:100000
        },
        categoryCr:{
            required:true
        }
    },
    message:{
        nameCr:{
            required: "Name product can not be empty "
        },
        slugCr:{
            required: "Slug product can not be empty "
        },
        priceCr:{
            required: "Price product can not be empty ",

            min: "Price must be bigger than 0",

            max: "Too expensive"
        },
        categoryCr:{
            required: "Pick one Category please "
        }
    },
    submitHandler: function (){

    }
})

$("#createAddPr").validate({
    rules: {
        sizeCr: {
            required: true
        },
        quantityCr:{
            required:true,

            min:0,

            max: 1000
        },
        colorCr:{
            required:true
        }
    },
    message: {
        sizeCr: {
            required: "Size can not be empty please !"
        },
        quantityCr:{
            required:"Quantity can not be empty please !",

            min: "Quantity must bigger than 0",

            max: "Too much product couldn't be sold off !"
        },
        colorCr:{
            required:"Pick a one color please !"
        }
    },
    submitHandler: function (){

    }
})
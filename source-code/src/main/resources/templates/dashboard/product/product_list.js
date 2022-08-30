let product = new Product();

let category = new Category();



let tempRowProduct = $.trim($('#tempRowProduct').val());

let tempViewProduct = $.validator.format($.trim($('#tempViewProduct').val()));


function replaceRowProduct(){
    $('#tr_' + product.id).replaceWith($(tempRowProduct(product.id, product.name,product.price,product.quantity,product.title,product.size,product.category,product.status)));
}


function addRowProduct(){
    $("#tbListProduct tbody").prepend($(tempRowProduct(product.id, product.name,product.price, product.quantity, product.title, product.size,product.category,product.status)));
}



let btnShowCreateModal = $('#btnCreateModal')
btnShowCreateModal.on('click', () => {
    $('createModal').modal("show");
});


let drawColor = () => {
    return $.ajax({
        "headers":{
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type": "GET",
        "url": "http://localhost:5050/api/product/color",
    })
        .done((data) => {
            $.each(data,color, (i,item) => {
                let str = `<option value = "${item.id}">${item.name}</option>`
            })
        }).fail((jqXHR) =>{
            App.showErrorAlert("Something wrong !");
        })
}

let drawSize = () => {
    return $.ajax({
        "headers":{
            "accept": "application/json",
            "content-type": "application/json"
        },
        "type":"GET",
        "url": "http://localhost:5050/api/product/size",
    })
        .done((data) =>{
            $.each(data, size, (i,item) =>{
                let str = `<option value = "${item.id}">${item.number}</option>`
            })
        })
        .fail((jqXHR) =>{
            App.showErrorAlert("Get data fail !")
        })
}

let drawCategory = () =>{
    return $.ajax({
        headers:{
            "accept": "application/json",
            "content-type":"application/json"
        },
        type:"GET",
        url:"http://localhost:5050/api/product/category",
    })
        .done((data) =>{
            $.each(data, category, (i,item) =>{
                let str = `<option value = "${item.id}">${item.name}</option>`
            })
        })
        .fail((jqXHR) =>{
            App.showErrorAlert("Get data fail !")
        })
}
function handleShowUpdate(){
    $('button.edit').on('click', () =>{
        let id = $(this).data("id");

        $.ajax({
            headers:{
                "accept":"application/json",
                "content-type": "application/json"
            },
            type:'GET',
            url:"http://localhost:5050/api/product/"+ id
        }).done((data) =>{
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

            $('#editModal').modal('show');
        }).fail((jqXHR) =>{
          App.showErrorAlert(jqXHR.responseJSON.message);

        })

    })
}
function handleShowDeleteModal(){
    $('button.delete').on('click', () =>{
        let id = $(this).data("id");
        $.ajax({
            headers:{
                "accept":"application/json",
                "content-type": "application/json"
            },
            type: 'GET',
            url:"http://localhost:5050/api/product/"+ id
        })
            .done((data) =>{
                $('deleteModal').modal('show');
                App.showSuccessAlert("Product deleted !")

            })
            .fail((jqXHR) =>{
                App.showErrorAlert("Fail to delete");
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
            url:"http://localhost:5050/api/product/"+ id
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
        url:"http://localhost:5050/api/product/create",
        data:JSON.stringify(product)
    })
        .done((data) =>{
            product = data;

            addRowProduct();

            $('#createModal').modal('hide');

            App.showSuccessAlert("Create product successful !")
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
        "url": "http://localhost:5050/api/product/update",
        "data": JSON.stringify(product)
    })
        .done((data) =>{
            product = data;

            replaceRowProduct();

            $('#createModal').modal('hide');

            App.showSuccessAlert('Update product success !');


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

$('#btnDelete').on('click', () =>{
    let id = $(this).data("id");

    return $.ajax({
        type: "DELETE",
        headers: {
            "Content-Type": "application/json",
            "accept":"application/json"
        },
        url:"http://localhost:5050/api/product/delete/" +id,

    })
        .done((data) =>{
            App.showSuccessAlert("Delete product success !")
        })
        .fail((jqXHR) =>{
            App.showErrorAlert("Can't delete product")
        })
})
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
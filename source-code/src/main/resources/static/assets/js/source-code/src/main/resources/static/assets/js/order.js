

let order = new Order();


$("#exportFileOd").on('click', () =>{
    $("#exportModalOd").modal("show");
});

$("#importFileOd").on('click', () =>{
    $("#importModalOd").modal("show");
})

$(document).ready(function (){
    $('#tbListOrder').DataTable({
        ajax:"http://localhost:8091/api/order",
        columns: [
            {order: 'id'},
            {order: 'user'},
            {order: 'createAt'},
            {order: 'status'},
            {order: 'content'},
            {order: 'total'}
        ]
    });

});

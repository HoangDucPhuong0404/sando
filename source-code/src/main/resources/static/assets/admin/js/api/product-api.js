function ProductAPI() {
    this.findAll = (done, fail) => {
        $.ajax({
            headers: {
                    "accept": "application/json",
                    "content-type": "application/json"
            },
            type: "GET",
            url: `${location.origin}/api/products`,
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }
    this.findById = (id, done, fail) => {
        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            type: "GET",
            url: `${location.origin}/api/products/${id}`,
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }
    this.countAll = (done, fail) => {
        $.ajax({
            type: "GET",
            url: `${location.origin}/api/products/count`,
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }

    this.deleteById = (id, done, fail) => {
        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type":"application/json"
            },
            type:"DELETE",
            url:`${location.origin}/api/products/delete/${id}`
        })
            .done((data) =>{
                done(data);
            })
            .fail((jqXHR) =>{
                fail(jqXHR);
            })
    }

}

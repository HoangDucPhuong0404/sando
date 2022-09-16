function ColorAPI() {
    this.findAll = (done, fail) => {
        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            type: "GET",
            url: `${location.origin}/api/products/colors`,
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }
}

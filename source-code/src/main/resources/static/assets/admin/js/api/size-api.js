function SizeAPI() {
    this.findAll = (done, fail) => {
        $.ajax({
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            type: "GET",
            url: `${location.origin}/api/products/sizes`,
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }
}

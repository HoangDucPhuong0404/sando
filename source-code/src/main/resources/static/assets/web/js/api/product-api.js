function ProductAPI() {
    this.findBySlug = (slug, done, fail) => {
        $.ajax({
            type: "GET",
            headers: {
                "accept": "application/json",
                "content-type": "application/json"
            },
            url: `${location.origin}/web/api/products/${slug}`
        })
            .done((data) => {
                done(data);
            })
            .fail((jqXHR) => {
                fail(jqXHR);
            })
    }
}
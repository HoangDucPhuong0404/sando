class App {
    static IziToast = class  {
        static showSuccessAlert(m) {
            iziToast.success({
                title: 'Success',
                position: 'topRight',
                timeout: 2500,
                message: m,
            });
        }

        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 2500,
                message: m,
            });
        }
    }


    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }




    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

    static removeFormatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "")
    }

    static formatTooltip() {
        $('[data-toggle="tooltip"]').tooltip();
    }
}



class Product {
    constructor(id,name,image, category, size, color ,title,price,quantity,status,description, createAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.category = category;
        this.size = size;
        this.color = color;
        this.image = image;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.status = status
        this.description = description;
        this.createAt = createAt;
    }
}




class Order {
    constructor(id ,country, city, email, full_name, address,mobile,content ,user,status,createAt, total) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.email = email;
        this.full_name = full_name;
        this.address = address;
        this.mobile = mobile;
        this.content = content;
        this.user = user;
        this.status = status;
        this.createAt = createAt;
        this.total = total;
    }
}
class User{
    constructor(id, userName, password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}







class Cart {
    constructor(id, sessionId, token, content, email, fullName, mobile, status, totalBill, user) {
        this.id = id;
        this.sessionId = sessionId;
        this.token = token;
        this.content = content;
        this.email = email;
        this.fullName = fullName;
        this.mobile = mobile;
        this.status = status;
        this.totalBill = totalBill;
        this.user = user;
    }










}



class Category {
    constructor(id, title) {
        this.id = id;
        this.title = title;
    }
}

class Size {
    constructor(id, size) {
        this.id = id;
        this.size = size;
    }
}

class Color {
    constructor(id, color) {
        this.id = id;
        this.color = color;
    }
}






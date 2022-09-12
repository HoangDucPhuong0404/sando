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

<<<<<<< HEAD
    static DOMAIN = location.origin;

    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";
    static BASE_URL_PRODUCT = this.DOMAIN + "/api/products";
    static BASE_URL_CATEGORY = this.DOMAIN + "/api/categories";
    static BASE_URL_SIZE = this.DOMAIN + "/api/sizes";
    static BASE_URL_COLOR = this.DOMAIN + "/api/colors";

    static BASE_URL_CLOUD_IMAGE = "https://res.cloudinary.com/ngocbich/image/upload";
    static BASE_SCALE_IMAGE = "c_limit,w_150,h_100,q_100";

    static showSuspendedConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure to suspend the selected customer ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, please suspend this client !',
            cancelButtonText: 'Cancel',
        })
=======
        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 2500,
                message: m,
            });
        }
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35
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

<<<<<<< HEAD
// class LocationRegion {
//     constructor(id, provinceId, provinceName, districtId, districtName, wardId, wardName, address) {
//         this.id = id;
//         this.provinceId = provinceId;
//         this.provinceName = provinceName;
//         this.districtId = districtId;
//         this.districtName = districtName;
//         this.wardId = wardId;
//         this.wardName = wardName;
//         this.address = address;
//     }
// }


=======


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





>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35

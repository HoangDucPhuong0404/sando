class App {

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
    }

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

    static showError401() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'Invalid credentials!',
        })
    }

    static showError403() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'You are not authorized to perform this function!',
        })
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ');
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
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

class LocationRegion {
    constructor(id, provinceId, provinceName, districtId, districtName, wardId, wardName, address) {
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
        this.address = address;
    }
}

class Product {
    constructor(id,name, category, size, color,image ,title,price,quantity,status,description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.image = image;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.status = status
        this.description = description;
    }
}

class Order {
    constructor(id ,user,fullName, email, phone, locationRegion,description, total) {
        this.id = id;
        this.user = user
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.description = description;
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

class Recipient {
    constructor(id, fullName, email, phone, locationRegion, balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion;
        this.balance = balance;
    }
}

class Category {
    constructor(id, category_name) {
        this.id = id;
        this.category_name = category_name;
    }
}

class Color {
    constructor(id, color_name) {
        this.id = id;
        this.color_name = color_name;

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

    static DOMAIN = location.origin;

    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";
    static BASE_URL_PRODUCT = this.DOMAIN + "/api/products";
    static BASE_URL_CATEGORY = this.DOMAIN + "/api/categories";
    static BASE_URL_SIZE = this.DOMAIN + "/api/sizes";
    static BASE_URL_COLOR = this.DOMAIN + "/api/colors";

    static BASE_URL_CLOUD_IMAGE = "https://res.cloudinary.com/ngocbich/image/upload";
    static BASE_SCALE_IMAGE = "c_limit,w_150,h_100,q_100";

    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                title: t,
                showConfirmButton: false,
                timer: 2500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                position: 'middle',
                icon: 'error',
                title: t,
                showConfirmButton: false,
                timer: 2500
            })
        }

        static ShowConfirmSuspend(t) {
            return Swal.fire({
                position: 'middle',
                icon: 'warning',
                title: t,
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel!',
                reverseButtons: true
            });
        }
    }

    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.show({
                title: 'Success',
                message: t,
                position: 'topRight',
                color: 'green',
                timeout: 2500,
            });
        }

        static showErrorAlert(t) {
            iziToast.show({
                title: 'Error',
                message: t,
                position: 'topRight',
                color: 'red',
                timeout: 2500,
            });
        }
    }

}

class Product {
    constructor(id, name, title, price, material, quantity, hot, bestseller, status,
                sizeId, size,
                colorId, color,
                categoryId, nameCategory, description,
                fileId, fileName, fileFolder) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.material = material;
        this.quantity = quantity;
        this.hot = hot;
        this.bestseller = bestseller;
        this.status = status;
        this.sizeId = sizeId;
        this.size = size;
        this.colorId = colorId;
        this.color = color;
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.description = description;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
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

class ColorJS {
    constructor(id, color) {
        this.id = id;
        this.color = color;
    }
}




>>>>>>> 484a574 (tan commit)

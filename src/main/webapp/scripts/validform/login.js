function validformlogin() {

        var a = document.forms["my-form"]["username"].value;
        var b = document.forms["my-form"]["password"].value;

        if (a==null || a=="")
        {
            alert("Введите ваш логин");
            return false;
        }else if (b==null || b=="")
        {
            alert("Введите ваш пароль");
            return false;
        }

    }
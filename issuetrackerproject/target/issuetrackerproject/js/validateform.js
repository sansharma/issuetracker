var user_exist = false;
function checkUserExist(){
                var data = {};
                var validate_space = document.getElementById("username").value;
                var length = validate_space.length;
                data["username"] = document.getElementById("username").value;
                for(var i = 0; i < length; i++){
                    if(validate_space[i] === " "){
                            document.getElementById("checkspacelabel").style.display= 'block';
                            return;
                    }
                    else{
                        document.getElementById("checkspacelabel").style.display= 'none';
                    }
                }

                $.ajax({
                    type : "POST",
                    contentType : "application/json",
                    url : "http://localhost:8080/checkuserexist",
                    data : JSON.stringify(data),
                    dataType : 'json',
                    timeout : 100000,
                    success : function(data) {
                        console.log("SUCCESS: ", data);
                        var data = JSON.stringify(data);
                        var result = JSON.parse(data);
                        if(result.user_exist){
                            user_exist = true;
                            document.getElementById("checkuserlabel").style.display= 'block';
                        }else{
                            user_exist=false;
                            document.getElementById("checkuserlabel").style.display= 'none';
                        }

                    },
                    error : function(e) {
                        console.log("ERROR: ", e);
                        display(e);
                    },
                    done : function(e) {
                        console.log("DONE");
                    }
                });
}

function validateRegistrationForm() {
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;

    if(password === confirm_password){
        document.getElementById("passwordmismatch").style.display= 'none';
        if(!user_exist) {
            alert("Successfully Signed Up! ");
            return true;
        }
        else
            return false;
    }

    else{
        document.getElementById("passwordmismatch").style.display= 'block';
        return false;
    }

}
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


// var modal = document.getElementById("bg-modal");
// var modal1 = document.getElementById("bg-modal-1");
//
// //var modalBtn = document.getElementById("addprojectbutton");
// //var modaladduserBtn = document.getElementById("adduserbutton");
// //var modaladdroleBtn = document.getElementById("addrolebutton");
// var modaladduserprojectBtn = document.getElementById("adduserprojectbutton");
//
//
// var closeBtn = document.getElementById("closeBtn");
// //var closeBtn1= document.getElementById("closeBtn1");
//
// //modalBtn.addEventListener('click', openModal);
// //modaladduserBtn.addEventListener('click',openModal);
// /*modaladduserBtn.addEventListener("click",function(){
//     openModal(3);
// },false);
//
// modaladdroleBtn.addEventListener("click",function(){
//     openModal(4);
// },false);
// */
// modaladduserprojectBtn.addEventListener("click",function () {
//     openModal(5);
// })
//
// closeBtn.addEventListener("click",closeModal);
// //closeBtn1.addEventListener("click",closeModal1);
// window.addEventListener("click", outsideClick);
// //window.addEventListener("click", outsideClick1);
//
// function openModal(num){
//     if(num === 1){
//         alert("hello1");
//         data={};
//         data["id"] =document.getElementById("company_id").value;
//         alert(data);
//         $.ajax({
//             type : "POST",
//             contentType : "application/json",
//             url : "http://localhost:8080/getProjectforPopUp",
//             data : JSON.stringify(data),
//             dataType : 'json',
//             timeout : 100000,
//             success : function(data) {
//                 console.log("SUCCESS: ", data);
//                 var data = JSON.stringify(data);
//                 var result = JSON.parse(data);
//                 var select = document.getElementById('project_id');
//
//                 for(var i = 0; i < result.length; i++) {
//                     var obj = result[i];
//                     var opt = document.createElement('option');
//                     opt.value = obj.id;
//                     opt.innerHTML = obj.project_name;
//                     select.appendChild(opt);
//                 }
//                 modal.style.display = 'block';
//                 },
//             error : function(e) {
//                 console.log("ERROR: ", e);
//                 display(e);
//             },
//             done : function(e) {
//                 console.log("DONE");
//             }
//         });
//     }else if(num === 3){
//         alert(num);
//        modal.style.display='block';
//        return;
//     }else if(num === 5){
//         setUserDropDown()
//         modal.style.display='block';
//     } else{
//         setUserDropDown();
//         modal1.style.display='block';
//     }
//
//
// }
//
// function closeModal(){
//     modal.style.display = 'none';
// }
// function closeModal1(){
//     modal1.style.display='none';
// }
//
// window.addEventListener('click', outsideClick);
//
//
// function outsideClick(e){
//     if(e.target == modal){
//         modal.style.display='none';
//     }
// }
// function outsideClick1(e){
//     if(e.target == modal1){
//         modal1.style.display='none';
//     }
// }
//
// function openTicketModal(){
//     alert("hello1");
//     modal.style.display='block';
// }
// function closeTicketModal(){
//     alert("hello2");
// }
//
//
// // function addProjectDialogue() {
// //     $(function () {
// //         $("#dialog").dialog();
// //     });
// // }
//
//
// function setUserDropDown(){
//     alert("hello1");
//     data={};
//     data["id"] =document.getElementById("company_id").value;
//     alert(data);
//     $.ajax({
//         type : "POST",
//         contentType : "application/json",
//         url : "http://localhost:8080/getUserforPopUp",
//         data : JSON.stringify(data),
//         dataType : 'json',
//         timeout : 100000,
//         success : function(data) {
//             console.log("SUCCESS: ", data);
//             alert(data);
//             var data = JSON.stringify(data);
//             var result = JSON.parse(data);
//             var select = document.getElementById('user_id');
//
//             for(var i = 0; i < result.length; i++) {
//                 var obj = result[i];
//                 var opt = document.createElement('option');
//                 opt.value = obj.id;
//                 opt.innerHTML = obj.username;
//                 select.appendChild(opt);
//             }
//         },
//         error : function(e) {
//             console.log("ERROR: ", e);
//             display(e);
//         },
//         done : function(e) {
//             console.log("DONE");
//         }
//     });
// }
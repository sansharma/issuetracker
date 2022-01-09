var modal;
var modal1;
var closeBtn;
var closeBtn1;

function openModal(num){
    closeBtn = document.getElementById("closeBtn");
    closeBtn.addEventListener("click",closeModal);
    window.addEventListener("click", outsideClick);
    if(num === 1){
        modal = document.getElementById("bg-modal");
        modal.style.display='block';
    }else if(num === 2){
        closeBtn1 = document.getElementById("closeBtn1");
        closeBtn1.addEventListener("click",closeModal1)
        modal = document.getElementById("bg-modal-1");
        setUserDropDown();
        modal.style.display='block';
    } else if(num === 3){
        modal = document.getElementById("bg-modal");
        modal.style.display = 'block';
    } else if(num === 4){
        modal = document.getElementById("bg-modal");
        setProjectDropDown();
        modal.style.display='block';
    } else if(num === 5){
        modal = document.getElementById("bg-modal");
        setUserDropDown();
        modal.style.display='block';
    }
}



function setUserDropDown(){
    alert("hello1");
    data={};
    data["id"] =document.getElementById("company_id").value;
    alert(data);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "http://localhost:8080/getUserforPopUp",
        data : JSON.stringify(data),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            alert(data);
            var data = JSON.stringify(data);
            var result = JSON.parse(data);
            var select = document.getElementById('user_id');

            for(var i = 0; i < result.length; i++) {
                var obj = result[i];
                var opt = document.createElement('option');
                opt.value = obj.id;
                opt.innerHTML = obj.username;
                select.appendChild(opt);
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

function setProjectDropDown(){
    data={};
    data["id"] =document.getElementById("company_id").value;
    alert(data);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "http://localhost:8080/getProjectforPopUp",
        data : JSON.stringify(data),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            var data = JSON.stringify(data);
            var result = JSON.parse(data);
            var select = document.getElementById('project_id');

            for(var i = 0; i < result.length; i++) {
                var obj = result[i];
                var opt = document.createElement('option');
                opt.value = obj.id;
                opt.innerHTML = obj.project_name;
                select.appendChild(opt);
            }
            modal.style.display = 'block';
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

function closeModal(){
    modal.style.display = 'none';
}

function  closeModal1(){
    modal1.style.display = 'none';
}



function outsideClick(e){
    if(e.target == modal || e.target==modal1){
        modal.style.display='none';
        modal1.style.display='none';
    }
}
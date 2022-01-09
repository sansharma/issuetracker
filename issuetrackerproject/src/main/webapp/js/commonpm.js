function openPMModal(id){
    var ticket_id = document.getElementById("id");
    var ticket_name = document.getElementById("ticket_name");
    var ticket_description = document.getElementById("ticket_description");
    var ticket_priority = document.getElementById("ticket_priority");
    var ticket_status = document.getElementById("ticket_status");
    var assigned_to = document.getElementById("assigned_to");
    var modal = document.getElementById("bg-modal");
    var closeBtn = document.getElementById("closeBtn");
    closeBtn.addEventListener("click",closeModal);
    alert("hello1");
    data={};
    data["id"] =id;
    alert(data);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "http://localhost:8080/getTicketForPopUp",
        data : JSON.stringify(data),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            alert("success");
            var data = JSON.stringify(data);
            var result = JSON.parse(data);
            alert(result.id);
            setDeveloperDropDown(result.project_id, result.assigned_to);
            ticket_name.value = result.ticket_name;
            ticket_description.value = result.ticket_description;
            ticket_priority.value = result.ticket_priority;
            ticket_status.value = result.status;
            ticket_id.value = id;
            modal.style.display='block';
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

function setDeveloperDropDown(project_id, assigned_to){
    alert("hello1");
    data={};
    data["id"] = project_id;
    alert(data);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "http://localhost:8080/getDeveloperForPopUp",
        data : JSON.stringify(data),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            alert("success");
            var data = JSON.stringify(data);
            var result = JSON.parse(data);
            var select = document.getElementById("assigned_to");
            for(var i = 0; i < result.length; i++) {
                var obj = result[i];
                var opt = document.createElement('option');
                opt.value = obj.id;
                opt.innerHTML = obj.username;
                select.appendChild(opt);
            }

            select.value=assigned_to;
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
    modal.style.display='none';
}
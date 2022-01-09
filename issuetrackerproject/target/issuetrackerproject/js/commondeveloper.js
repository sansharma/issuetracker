function openDeveloperModal(id, status){
    alert("hello");
    var ticket_status = document.getElementById("ticket_status");
    var modal = document.getElementById("bg-modal");
    var ticket_id = document.getElementById("ticket_id");
    ticket_id.value = id;
   // alert(status);
    ticket_status.value = status;
    modal.style.display='block';
}
$(document).ready(function(){
    $(".button-collapse").sideNav();
    $('.datepicker').pickadate();
    $('select').material_select();
    $('#taskList').tablesorter({
        headers:{ 4: {sorter: false},5: {sorter:false}, 6: {sorter:false}}});
    $('.collapsible').collapsible({
        accordion : false
    });
});

function launchFlippedCard(desc){

    var decodeDesc = decodeURIComponent(desc);
    var html= '<div class="section"><div class="container"><div class="row"><div class="cols12">' +
              '<h5 class="text-whiteboldMe">Description</h5><p></div><div class="cols12"><p>' + decodeDesc +
              '</p></div></div></div></div>';

    new $.flavr({
        modal: false,
        animateEntrance : 'flipInY',
        animateClosing  : 'flipOutY',
        content      : html,
        closeOverlay : true,
        closeEsc     : true,
        opacity: 0
    });
}

function toggleTaskDone(taskId) {
    var XHR = new XMLHttpRequest();
    var FD  = new FormData();
    FD.append("id", taskId);
    XHR.open('POST', '/task/toggleDone');
    XHR.send(FD);
}